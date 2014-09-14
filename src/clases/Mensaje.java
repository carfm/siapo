/*
 * El objetivo de la siguiente clase es proveer a los formularios del modulo mensajeria
 * Todas las funciones necesarias para el envio y recepcion de mensajes y conexiones a la Base de datos
 * En esta clase se alberga practicamente la gestion total de mensajeria.
 */
package clases;

import pantallas.mensajeria.Bandeja;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ed
 */
public class Mensaje extends Sistema {

    private Connection conect = null;
    private ResultSet rs;
    private Statement declaracion;
    private String query;
    protected DefaultTableModel model;
    private Usuario u;
    String tipoBand;
    private int idMensaje;
    private String fecha;
    private String contenido;
    private String asunto;

    public Mensaje() {
    }

    public Mensaje(Usuario u, String tipo) {
        this.u = new Usuario();
        this.u.setNombreUsuario(u.getNombreUsuario());
        this.u.setUser(u.getUser());
        this.u.setListaTiposUsuario(u.getListaTiposUsuario());
        tipoBand = tipo;
    }

    /**
     * *********************Comienza Conexion a la
     * BD*****************************
     * @param user
     * @return 
     */
    public Statement conexion(String user) {
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection(super.getServidor(), super.getUsu(), super.getPass());
            stmt = conect.createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hubo un problema al intentar conectarse con la base de datos \n" + ex.toString(), "", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Hubo un problema al intentar conectarse con la base de datos \n" + ex.toString(), "", JOptionPane.ERROR_MESSAGE);
        }
        return stmt;

    }

    /**
     * *********************termina Coneccion a la
     * BD*****************************
     */
    /**
     * ***********************Obtener correlativo de
     * mensajes********************************
     */
    //Esta clase permite generar el idMensaje al momento de enviar un nuevo mensaje hacia la BD
    private int getCorrelativo() {
        int num = 0;
        try {
            rs = this.seleccionar("MAX(idMensaje) as id", "mensaje", "");
            num = Integer.parseInt(rs.getString("id"));
            this.cerrarConexionBase();
        } catch (SQLException ex) {
            ErroresSiapo.agregar(ex, "codigo 24");
            //JOptionPane.showMessageDialog(null, ex.toString(), null, JOptionPane.ERROR_MESSAGE);
        }
        return num;
    }

    /**
     * *************************termina correlativo de
     * mensajes**************************
     */
    /**
     * *************************Enviar
     * Mensaje***********************************
     * @param asunto
     * @param mensaje
     */
    public void enviarmensaje(String asunto, String mensaje) {     
        if(this.insertar("mensaje", "NULL,1,'"+mensaje+"','"+asunto+"',NOW()")){
           if(difundirMsj(getCorrelativo())){
               JOptionPane.showConfirmDialog(null, "¡Mensaje enviado con exito!", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
           }else{
               JOptionPane.showConfirmDialog(null, "No se pudo enviar", null, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
           }
        }else{
            JOptionPane.showConfirmDialog(null, "No se pudo enviar", null, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * *********************Termina Enviar
     * Mensaje*******************************
     */
    /**
     * *********************Eliminar un Mensaje*******************************
     * @param id
     */
    public void deleteOne(String id) {
        /*Su funcion es eliminar un mensaje de la base de datos.
         * Esta funcion solo estara disponible para el usuario gerente
         */
        if(this.borrar("mensaje", "idMensaje='" + id + "'")){
            JOptionPane.showMessageDialog(null, "Eliminado con exito");
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo borrar");
        }
//        query = "DELETE FROM mensaje WHERE ;
//        try {
//            declaracion = conexion("root");
//            declaracion.executeUpdate(query);
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error" + ex, "", JOptionPane.ERROR_MESSAGE);
//        }
        
    }

    /**
     * *********************Termina eliminar
     * Mensaje*******************************
     */
    /**
     * *********************Eliminar todos los
     * Mensaje*******************************
     */
    public void deleteAll() {
        
        if(this.borrar("mensaje", "")){
            JOptionPane.showMessageDialog(null, "Eliminado con exito");
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo borrar");
        }
//        query = "DELETE FROM mensaje";
//        try {
//            declaracion = conexion("root");
//            declaracion.executeUpdate(query);
//            new Bandeja(u, tipoBand).setVisible(true);//cambiar los null
//            cerrarConexiones();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error" + ex, "", JOptionPane.ERROR_MESSAGE);
//        }
//        JOptionPane.showMessageDialog(null, "Eliminado con exito");

    }

    /**
     * *********************Termina Eliminar todos los
     * Mensaje*******************************
     * @throws java.sql.SQLException
     */
    public void cerrarConexiones() throws SQLException {
        /*Su funcion es terminar todo tipo de conexion de la base de datos
         * para evitar cualquier error de sobrecarga a los ResultSet y Statement
         */

        rs = null;
        declaracion = null;
        conect.close();
        query = "";
    }

    public boolean difundirMsj(int idMsj) {
        ResultSet resultado;
        String consulta;
        resultado = seleccionar("DISTINCT es.user", "usuario,es", "(es.user=usuario.user AND (codigoTipoUser=1 OR codigoTipoUser=2))");
        try {
            resultado.beforeFirst();
            while (resultado.next()) {
                consulta = "NULL, " + idMsj + ", '" + resultado.getString("es.user") + "',0,0,0";
                insertar("gestiona", consulta);
            }
            this.cerrarConexion();
            this.cerrarConexionBase();
            return true;
        } catch (SQLException ex) {
            ErroresSiapo.agregar(ex, "codigo 25");
            this.cerrarConexionBase();
            return false;
            //Logger.getLogger(Mensaje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * *********************Eliminar un Mensaje*******************************
     * @param id
     * @param user
     */
    public void ocultarOne(String id, String user) {
        /*Su funcion es ocultar un mensaje de la base de datos para el user especificado.
         * Esta funcion solo estara disponible para el usuario auditor y agente
         */
        if(this.actualizar("gestiona", "oculto=1", "user='" + user + "' AND idMensaje='" + id + "'")){
            JOptionPane.showMessageDialog(null, "Eliminado con exito");
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo borrar");
        }
        
//        query = "UPDATE gestiona SET  WHERE user=\"" + user + "\" AND idMensaje='" + id + "'";
//        try {
//            declaracion = conexion("root");
//            declaracion.executeUpdate(query);
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error" + ex, "", JOptionPane.ERROR_MESSAGE);
//        }
//        JOptionPane.showMessageDialog(null, "Eliminado con exito");
    }

    /**
     * *********************Termina eliminar
     * Mensaje*******************************
     */
    /**
     * *********************Eliminar todos los
     * Mensaje*******************************
     * @param user
     */
    public void ocultarAll(String user) {
        
        if(this.actualizar("gestiona", "oculto=1", "user='" + user + "'")){
            JOptionPane.showMessageDialog(null, "Eliminado con exito");
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo borrar");
        }
//        query = "UPDATE gestiona SET oculto=\"1\" WHERE user=\"" + user + "\"";
//        try {
//            declaracion = conexion("root");
//            declaracion.executeUpdate(query);
//            new Bandeja(u, tipoBand).setVisible(true);//cambiar los parametros
//            cerrarConexiones();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error" + ex, "", JOptionPane.ERROR_MESSAGE);
//        }
//        JOptionPane.showMessageDialog(null, "Eliminado con exito");

    }

    /**
     * @return the idMensaje
     */
    public int getIdMensaje() {
        return idMensaje;
    }

    /**
     * @param idMensaje the idMensaje to set
     */
    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the contenido
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * @param contenido the contenido to set
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * @return the asunto
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * @param asunto the asunto to set
     */
    @Override
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    /**
     * *********************Termina Eliminar todos los
     * Mensaje*******************************
     */
}
