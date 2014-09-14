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
 *
 *
 * @author Carlos y Jose
 */
public class Area extends Sistema{
    
    private String codigoArea;
    private String nombreArea;

    public void agregarArea() {
        insertar("area", "'" + this.getCodigoArea() + "','" + this.getNombreArea() +"'");
    }
    
    
    public void llenarComboBoxAreas(JComboBox lista,ArrayList<Area> areas) {
        int j = 0;
//        ArrayList<Area> areas = obtenerAreas();
        while (j < areas.size()) {
            Area a = areas.get(j);
            lista.addItem(a.getNombreArea());
            j++;
        } 
    }
    
    public ArrayList<Area> obtenerAreas() {
        ArrayList<Area> areas = new ArrayList();
        try {
            ResultSet r = seleccionar("nombreArea,codigoArea", "area", "");
            r.beforeFirst();
            while (r.next()) {
                Area a = new Area();
                a.setCodigoArea(r.getString("codigoArea"));
                a.setNombreArea(r.getString("nombreArea"));
                areas.add(a);
            } 
            r.close();
            this.cerrarConexion();
            this.cerrarConexionBase();
        } catch (Exception e) {
            ErroresSiapo.agregar(e, "codigo 15");
            JOptionPane.showMessageDialog(null, "No se pueden cargar las areas afectadas");
            //System.exit(1);
        }
        return areas;
    }
    /**
     * @return the codigoArea
     */
    public String getCodigoArea() {
        return codigoArea;
    }

    /**
     * @param codigoArea the codigoArea to set
     */
    public void setCodigoArea(String codigoArea) {
        this.codigoArea = codigoArea;
    }

    /**
     * @return the nombreArea
     */
    public String getNombreArea() {
        return nombreArea;
    }

    /**
     * @param nombreArea the nombreArea to set
     */
    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }
}
