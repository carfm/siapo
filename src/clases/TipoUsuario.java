/*  
 * 
 *  Nombre de la clase: TipoUsuario
 *  Fecha de creacion:
 *  Objetivo: Manejo de los atributos de TipoUsuario.
 *  Autor: Carlos Alberto Fuentes Martinez
 * 
 */
package clases;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoUsuario extends Sistema {

    private int codigoTipoUser;
    private String nombreTipo;
    private final int[] permiso = new int[4];
    private int i = 0;

    /**
     * *********************************METODO permisos**********************************
     * @param user
     * @return 
     */
    /*
     * Objetivo: guardar en el arreglo 'permiso' los codigos de los permisos del usuario.
     * dichos codigos son los siguientes: 1.Agente; 2.Auditor; 3.Gerente; 4.Administrador.
     * Retorna el arreglo con los datos recuperados.
     * --Atributos--
     * func: instancia de la clase Funciones. Necesario para ejecutar las consultas sql.
     */
    public int[] permisos(String user) {
        ResultSet r;       
        try {
            r = seleccionar("*", "es", "user='" + user + "' ORDER BY 'codigoTipoUser'");
            r.beforeFirst();
            while (r.next()) {//mientras hayan registros, guarda el resultado en el array permiso
                this.permiso[i] = Integer.parseInt(r.getString("codigoTipoUser"));
                i++;
            }
            r.close();
            this.cerrarConexion();
            this.cerrarConexionBase();
        }//FIN DEL try
        catch (SQLException e) {
        }
        return permiso;
    }

    /**
     * *********************************FIN METODO permisos**********************************
     */

    /**
     * @return the codigoTipoUser
     */
    public int getCodigoTipoUser() {
        return codigoTipoUser;
    }

    /**
     * @param codigoTipoUser the codigoTipoUser to set
     */
    public void setCodigoTipoUser(int codigoTipoUser) {
        this.codigoTipoUser = codigoTipoUser;
    }

    /**
     * @return the nombreTipo
     */
    public String getNombreTipo() {
        return nombreTipo;
    }

    /**
     * @param nombreTipo the nombreTipo to set
     */
    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }
}
