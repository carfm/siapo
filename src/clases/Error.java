/*  
 * 
 *  Nombre de la clase: Error
 *  Fecha de creacion:
 *  Objetivo: Manejo de la tabla error en el sistema.
 *  Autor: Carlos Alberto Fuentes Martinez
 * 
 */
package clases;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Error extends Sistema{
    
    private String codigoError;
    private String codigoTipo;
    private int codigoCategoria;
    private String nombreError;
    private String descripcion;
    private boolean aprobado;
    /**********************INICIO ingresarError**************************/
    /*  Nombre del modulo : ingresarError()
     *  Objetivo: ordena los atributos de error para ponerlos en un query
     */
    public boolean ingresarError() {
        String s = "'"+getCodigoError()+"',"+getCodigoCategoria()+",'"+getCodigoTipo()+"',"
                + "'"+getNombreError()+"','"+getDescripcion()+"',1";
        return insertar("error", s);
    }
    
/**********************FIN ingresarError**************************/
    
    /**
     * FIN ingresarError
     * @return
     */
    public ArrayList<Error> obtenerErrores() {
        ArrayList<Error> errores = new ArrayList();
        try {

            ResultSet r = seleccionar("codigoError,codigoTipo,codigoCategoria,nombreError,descripcionError", "error", "");
            r.beforeFirst();
            while (r.next()) {
                //codigoCategoria
                Error e = new Error();
                e.setCodigoError(r.getString("codigoError"));
                e.setCodigoTipo(r.getString("codigoTipo"));
                e.setNombreError(r.getString("nombreError"));
                e.setCodigoCategoria(r.getInt("codigoCategoria"));
                e.setDescripcion(r.getString("descripcionError"));
                errores.add(e);
            }
            this.cerrarConexionBase();
        } catch (Exception e) {
            ErroresSiapo.agregar(e, "codigo 16");
            JOptionPane.showMessageDialog(null, "No se pueden cargar los errores");
            //System.exit(1);
        }
        return errores;
    }
    
    public Error buscarError(ArrayList<Error> errores,String codigoError){
        for (Error error : errores) {
            if(error.getCodigoError().equals(codigoError)){
                return error;
            }
        }
        return null;
    }
    /**
     * @return the codigoError
     */
    public String getCodigoError() {
        return codigoError;
    }

    /**
     * @param codigoError the codigoError to set
     */
    public void setCodigoError(String codigoError) {
        this.codigoError = codigoError;
    }

    /**
     * @return the codigoTipo
     */
    public String getCodigoTipo() {
        return codigoTipo;
    }

    /**
     * @param codigoTipo the codigoTipo to set
     */
    public void setCodigoTipo(String codigoTipo) {
        this.codigoTipo = codigoTipo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the nombreError
     */
    public String getNombreError() {
        return nombreError;
    }

    /**
     * @param nombreError the nombreError to set
     */
    public void setNombreError(String nombreError) {
        this.nombreError = nombreError;
    }

    /**
     * @return the aprobado
     */
    public boolean isAprobado() {
        return aprobado;
    }

    /**
     * @param aprobado the aprobado to set
     */
    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    /**
     * @return the codigoCategoria
     */
    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    /**
     * @param codigoCategoria the codigoCategoria to set
     */
    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }
}
