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
public class Laboratorio extends Sistema {

    private int codigoLocationUSA;
    private String nombreLaboratorio;

    public void llenarComboBoxLaboratorios(JComboBox lista) {
        int j = 0;
        ArrayList<Laboratorio> laboratorios = obtenerLaboratorios();
        while (j < laboratorios.size()) {
            Laboratorio l = laboratorios.get(j);
            lista.addItem(l.getNombreLaboratorio());
            j++;
        }
    }

    public ArrayList<Laboratorio> obtenerLaboratorios() {
        ArrayList<Laboratorio> laboratorios = new ArrayList();
        try {
            ResultSet r = seleccionar("codigoLocationUSA,nombreLaboratorio", "laboratorio", "laboratorioActivo=1");
            r.beforeFirst();
            while (r.next()) {               
                Laboratorio l = new Laboratorio();
                l.setNombreLaboratorio(r.getString("nombreLaboratorio"));
                l.setCodigoLocationUSA(Integer.parseInt(r.getString("codigoLocationUSA")));
                laboratorios.add(l);
            }
            this.cerrarConexion();
            this.cerrarConexionBase();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pueden cargar los laboratorios");
            System.exit(1);
        }
        return laboratorios;
    }

    /**
     * @return the codigoLocationUSA
     */
    public int getCodigoLocationUSA() {

        return codigoLocationUSA;
    }

    /**
     * @param codigoLocationUSA the codigoLocationUSA to set
     */
    public void setCodigoLocationUSA(int codigoLocationUSA) {
        this.codigoLocationUSA = codigoLocationUSA;
    }

    public void setCodigoLocationUSA() {
        ResultSet r;
        try {
            r = seleccionar("codigoLocationUSA", "laboratorio", "nombreLaboratorio = '" + getNombreLaboratorio() + "'");
            codigoLocationUSA = Integer.parseInt(r.getString("codigoLocationUSA"));
            this.cerrarConexionBase();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * @return the nombreLaboratorio
     */
    public String getNombreLaboratorio() {
        return nombreLaboratorio;
    }

    /**
     * @param nombreLaboratorio the nombreLaboratorio to set
     */
    public void setNombreLaboratorio(String nombreLaboratorio) {
        this.nombreLaboratorio = nombreLaboratorio;
    }
}
