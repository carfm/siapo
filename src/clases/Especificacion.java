/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos y Jose
 */
public class Especificacion extends Sistema{
    
    private int idEspecificacion;
    private String nombreEspecificacion;
    
    
    public void agregarEspecificacion() {
        insertar("especificacion", "NULL,'" + this.getNombreEspecificacion() +"'");
    }

    public void llenarComboBoxEspecificaciones(JComboBox lista,ArrayList<Especificacion> especificaciones) {
        int j = 0;
        while (j < especificaciones.size()) {
            Especificacion e = especificaciones.get(j);
            lista.addItem(e.getNombreEspecificacion());
            j++;
        } 
    }
    
    public ArrayList<Especificacion> obtenerEspecificaciones() {
        ArrayList<Especificacion> especificaciones = new ArrayList();
        try {
            ResultSet r = seleccionar("idEspecificacion,nombreEspecificacion", "especificacion", "");
            r.beforeFirst();
            while (r.next()) {
                Especificacion e = new Especificacion();
                e.setIdEspecificacion(r.getInt("idEspecificacion"));
                e.setNombreEspecificacion(r.getString("nombreEspecificacion"));
                especificaciones.add(e);
            } 
            r.close();
            this.cerrarConexion();
            this.cerrarConexionBase();
        } catch (Exception e) {
            ErroresSiapo.agregar(e, "codigo 17");
            JOptionPane.showMessageDialog(null, "No se pueden cargar las especificaciones");
            //System.exit(1);
        }
        return especificaciones;
    }
    /**
     * @return the idEspecificacion
     */
    public int getIdEspecificacion() {
        return idEspecificacion;
    }

    /**
     * @param idEspecificacion the idEspecificacion to set
     */
    public void setIdEspecificacion(int idEspecificacion) {
        this.idEspecificacion = idEspecificacion;
    }

    /**
     * @return the nombreEspecificacion
     */
    public String getNombreEspecificacion() {
        return nombreEspecificacion;
    }

    /**
     * @param nombreEspecificacion the nombreEspecificacion to set
     */
    public void setNombreEspecificacion(String nombreEspecificacion) {
        this.nombreEspecificacion = nombreEspecificacion;
    }
    
}
