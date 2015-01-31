/*  
 * 
 *  Nombre de la clase: Usuario
 *  Fecha de creacion:
 *  Objetivo: Manejo de la tabla usuario en el sistema.
 *  Autor: Carlos Alberto Fuentes Martinez
 * 
 */
package clases;

import pantallas.general.MenuPpal;
import pantallas.general.PantallaLogin;
import pantallas.general.cambiarPass;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Usuario extends Sistema {
//Atributos

    private String user;
    private String contraseña;
    private String userFilebound;
    private int correlativoUSA;
    private String fechaIngreso;
    private String nombre;
    private String apellido;
    private boolean usuarioActivo;
    private ArrayList<TipoUsuario> listaTiposUsuario;
    private String userAnterior;
    private String activo = " ";
    private int intentos = 0;

    final String msj1 = "Usuario no existe en el sistema. Por favor intente nuevamente o contacte"
            + " al administrador.";
    final String msj2 = "Contraseña incorrecta. Dispone de ";
//constructor con parametros

    public Usuario(int n, String us) {
        intentos = n; //guarda el valor de los intentos de inicio de sesion del usuario
        userAnterior = us;
    }
    //constructor vacio

    public Usuario() {
    }
    //metodo 

    public void ingresarUsuario() {
        String s = "'" + getUser() + "',NULL,'" + contraseña + "','" + userFilebound + "',"
                + correlativoUSA + ",'" + getFechaIngreso() + "','"
                + getNombreUsuario() + "','" + getApellido() + "',1,NULL,1,0";
        insertar("usuario", s);
    }
//metodo

    public boolean validarUsuario(boolean ingresarNuevo, boolean correlativo) {
        boolean error = false;
        String strError = "";
        ResultSet r;
        try {
            if (nombre.length() < 2 || apellido.length() < 2) {// comprueba longitud de nombre y apellido
                error = true;
                strError = strError + "- La longitud del nombre o apellido es muy pequeña\n";
            }
            if (compararFechas("", getFechaIngreso())) {
                error = true;
                strError = strError + "- La fecha de ingreso no puede ser mayor a la fecha actual \n";
            }
            if (compararFechas(getFechaIngreso(), "2008-05-01")) {// fecha de comienzo de actividad la empresa
                error = true;
                strError = strError + "- La fecha de ingreso no puede ser menor a la fecha de fundacion de la empresa \n";
            }
            if (user.length() > 8) {// comprueba longitud de user
                error = true;
                strError = strError + "- La longitud del user es mayor a la establecida (8 caracteres))\n";
            }
            if (userFilebound.length() > 8) {// comprueba longitud de user Filebound
                error = true;
                strError = strError + "- La longitud del user del Filebound es mayor a la establecida (8 caracteres))\n";
            }
            if (correlativo) {
                r = seleccionar("usuarioActivo,user", "usuario", "correlativoUSA=" + correlativoUSA);
                if (r.last()) {
                    //si no existe tiene que saber si el usuario
                    r.first();
                    while (!r.isAfterLast()) {
                        if (r.getString("usuarioActivo").equals("1")) {
                            if (!r.getString("user").equals(user)) {
                                //si es un usuario activo y es diferente al actual user no se puede ingresar
                                error = true;
                            }
                        }
                        r.next();
                    }
                    //si sale del ciclo sin error es que el numero lo ocupan pero un usuario inactivo 

                    if (error) {
                        strError = strError + "- El # correlativo asignado ya esta siendo ocupado por otro usuario\n";
                    }
                }
            }
            if (ingresarNuevo) {
                this.cerrarConexionBase();
                r = seleccionar("user,usuarioActivo", "usuario", "user='" + user + "'");
                if (r.last()) {//comprueba si no existe el user
                    if (r.getString("usuarioActivo").equals("1")) {
                        error = true;
                        strError = strError + "- El user escrito ya esta ingresado en la base de datos\n";
                    } else {
                        if (!error) {
                            actualizar("usuario", "user ='" + user + "IN'", "user='" + user + "'"); // si esta inactivo cambia el user de la DB agregandoles IN como sufijo
                        }
                    }
                }
            }
            if (error) {
                JOptionPane.showMessageDialog(null, strError, "Error", JOptionPane.ERROR_MESSAGE);
            }
            this.cerrarConexion();
            this.cerrarConexionBase();
        } catch (SQLException | HeadlessException e) {
            ErroresSiapo.agregar(e, "codigo 34");
        }
        return error;
    }
//metodo

    public void setTiposUsuario() {
        try {
            int filas, i;
            this.listaTiposUsuario = new ArrayList<>();
            seleccionar("count(*) as filas", "es", "user='" + user + "'");
            filas = Integer.parseInt(getResultado().getString("filas"));
            getResultado().close();
            this.cerrarConexionBase();
            seleccionar("codigoTipoUser", "es", "user='" + user + "'");
            getResultado().first();
            for (i = 0; i < filas; i++) {
                TipoUsuario t = new TipoUsuario();
                t.setCodigoTipoUser(Integer.parseInt(getResultado().getString("codigoTipoUser")));
                switch (t.getCodigoTipoUser()) {
                    case 1:
                        t.setNombreTipo("Agente");
                        break;
                    case 2:
                        t.setNombreTipo("Auditor");
                        break;
                    case 3:
                        t.setNombreTipo("Gerente");
                        break;
                    case 4:
                        t.setNombreTipo("Administrador");
                        break;
                }
                getListaTiposUsuario().add(t);
                getResultado().next();
            }
            getResultado().close();
            this.cerrarConexionBase();
        } catch (SQLException | NumberFormatException e) {
            System.out.println(e);
        }
    }
//metodo

    public void agregarFoto(String direccion) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            setConexion(DriverManager.getConnection(Sistema.servidor, Sistema.usu, Sistema.pass));
            PreparedStatement ps = getConexion().prepareStatement("update usuario set foto = (?) where user='" + getUser() + "'");
            getConexion().setAutoCommit(false);
            File file = new File(direccion);
            FileInputStream fis = new FileInputStream(file);
            ps.setBinaryStream(1, fis, (int) file.length());
            ps.executeUpdate();
            getConexion().commit();
            ps.close();
            this.cerrarConexionBase();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * *************************Metodo ValidarUsuario
     *
     ******************************************
     * @param user
     * @param password
     * @param u
     */
    /* Objetivo: verificar la existencia del usuario en la base de datos, verificar su contraseña
     * y su tipo de usuario para asi direccionarlo a donde es debido.
     * --Parametros--
     * user: recibe el nombre de usuario de la PantallaLogin.
     * password: recibe la contraseña del usuario.
     * cons: instancia de la clase Consultas que permite crear las conexiones con la base de datos.
     * --Atributos--
     * func: instancia de la clase Funciones. Necesario para ejecutar las consultas sql.
     */
    public void ValidarUsuario(String user, String password, Usuario u) {
        try {

            seleccionar("`user`, `contrasena`, `nombre`, `apellido`, `usuarioActivo`, `primeraVez`", "usuario", "user='" + user + "'");
            getResultado().beforeFirst();
            if (!getResultado().next()) {//si no hay registros
                JOptionPane.showMessageDialog(null, msj1);
                getResultado().close();
                new PantallaLogin(0, getUserAnterior()).setVisible(true);
            } //FIN DEL if (!getResultado().next())
            else {
                this.user = getResultado().getString("user").toLowerCase();
                if (!userAnterior.equals("nouser")) {
                    if (!userAnterior.equals(user)) {
                        setIntentos(0);
                        getResultado().close();
                        this.cerrarConexionBase();
                    }
                }
                //this.contraseña = r.getString("contrasena");
                this.contraseña = Sistema.decrypt(getResultado().getString("contrasena"));
                this.activo = getResultado().getString("usuarioActivo");
                if (!(this.contraseña.equals(password))) {//si el password no es el correcto                    
                    setIntentos(getIntentos() + 1);
                    if (getIntentos() == 5) {
                        JOptionPane.showMessageDialog(null, "¡¡Su Cuenta ha sido bloqueada!!"
                                + "\nPara desbloquear su cuenta contacte al administrador");
                        actualizar("usuario", "usuarioActivo='0'", "user='" + this.user + "'");
                        getResultado().close();
                        this.cerrarConexionBase();
                        System.exit(1);
                    } else {
                        JOptionPane.showMessageDialog(null, msj2 + (5 - getIntentos()) + " intentos mas o su cuenta sera bloqueada.");
                        getResultado().close();
                        this.cerrarConexionBase();
                        new PantallaLogin(getIntentos(), getUserAnterior()).setVisible(true);
                    } //FIN DEL else
                }//FIN DEL if (!(this.contraseña.equals(password)))
                else //Direcciona al menu principal.
                if ((Integer.parseInt(this.activo) == 1)) {
                    this.setNombreUsuario(getResultado().getString("nombre") + " " + getResultado().getString("apellido"));
                    this.setUser(user.toLowerCase());
                    if (Integer.parseInt(getResultado().getString("primeraVez")) == 1) {
                        getResultado().close();
                        this.cerrarConexionBase();
                        this.setTiposUsuario();
                        new cambiarPass(this).setVisible(true);
                        //System.exit(1);
                    } else {
                        //System.out.println();
                        this.cerrarConexionBase();
                        getResultado().close();
                        this.cerrarConexionBase();
                        this.setTiposUsuario();
                        new MenuPpal(this, true, null, null).setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Su cuenta esta inactiva. "
                            + "Debe contactar al administrador para ser reactivado.");
                    actualizar("usuario", "primeraVez=1", "user='" + user + "'");
                    getResultado().close();
                    this.cerrarConexionBase();
                    System.exit(1);
                }

            }//FIN DEL else
            // this.cerrarConexion();

        }//FIN DEL try
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay conexion a la base de datos",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e);
        }
    }

    public void notificarAgente(String user, String specimen, String codError, String nomError, boolean lab) {
        this.borrar("puede_tener", "user='" + user + "' and codigoError='" + codError + "' and specimen ='" + specimen + "' and idMensaje is null and fecha is null");
        Orden o = new Orden(specimen, lab, user, codError, nomError);
        o.agregarError(lab, "");
    }

    public void notificarAuditor(String codError, String nomError) {
        //escribo el mensaje   
        String mensaje = "Se ha aprobado un error nuevo.\n A continuacion los detalles:\n\n"
                + "Codigo del Error: " + codError + ".\nNombre del Error: " + nomError
                + "\nEste error estara disponble desde este dia.";
        String asunto = "Se Ha Aprobado Un Nuevo Error";
        insertar("mensaje", "NULL,1,'" + mensaje + "','" + asunto + "',NOW()");
        //consulto los Auditores
        ResultSet r = seleccionar("user", "es", "codigoTipoUser=2");
        try {
            r.beforeFirst();
            //envio el mensaje a los auditores.
            while (r.next()) {
                insertar("gestiona", "NULL,(SELECT MAX(idMensaje) FROM mensaje),'" + r.getString("user") + "',0,0,0");
                //idGestiona, idMensaje,user,visto,oculto,advertencia
            }
            r.close();
            this.cerrarConexionBase();
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @param userFilebound the userFilebound to set
     */
    public void setUserFilebound(String userFilebound) {
        this.userFilebound = userFilebound;
    }

    /**
     * @param correlativoUSA the correlativoUSA to set
     */
    public void setCorrelativoUSA(int correlativoUSA) {
        this.correlativoUSA = correlativoUSA;
    }

    /**
     * @param fechaIngreso the fechaIngreso to set
     */
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombreUsuario(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param usuarioActivo the usuarioActivo to set
     */
    public void setUsuarioActivo(boolean usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @return the nombre
     */
    public String getNombreUsuario() {
        return nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the listaTiposUsuario
     */
    public ArrayList<TipoUsuario> getListaTiposUsuario() {
        return listaTiposUsuario;
    }

    /**
     * @param listaTiposUsuario the listaTiposUsuario to set
     */
    public void setListaTiposUsuario(ArrayList<TipoUsuario> listaTiposUsuario) {
        this.listaTiposUsuario = listaTiposUsuario;
    }

    /**
     * @return the fechaIngreso
     */
    public String getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * @return the userAnterior
     */
    public String getUserAnterior() {
        return userAnterior;
    }

    /**
     * @param userAnterior the userAnterior to set
     */
    public void setUserAnterior(String userAnterior) {
        this.userAnterior = userAnterior;
    }

    /**
     * @return the intentos
     */
    public int getIntentos() {
        return intentos;
    }

    /**
     * @param intentos the intentos to set
     */
    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
}
