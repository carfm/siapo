/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos y Jose
 */
public class Razon extends Sistema {

    private Area a;
    private Especificacion e;
    private String codigoRazon;
    private String nombreRazon;

    public void agregarRazon() {
        insertar("razon", "'" + getCodigoRazon() + "'," + getE().getIdEspecificacion() + ",'" + getA().getCodigoArea() + "','" + getNombreRazon() + "'");
    }

    public void generarCodigoRazon() {
        String parte1 = getA().getCodigoArea();
        String parte2;
        if (getE().getIdEspecificacion() < 10) {
            parte2 = "0" + Integer.toString(getE().getIdEspecificacion());
        } else {
            parte2 = Integer.toString(getE().getIdEspecificacion());
        }
        String codigo = parte1 + parte2;
        setCodigoRazon(codigo);
    }

    public boolean comprobarRazon() {
        boolean valido = false;
        try {
            ResultSet r;
            r = seleccionar("codigoRazon", "razon", "codigoArea = '" + this.getA().getCodigoArea() + "' and idEspecificacion =" + this.getE().getIdEspecificacion());
            if (!r.last()) {
                valido = true;
            }
        } catch (Exception ex) {

        } finally {
            this.cerrarConexionBase();
        }
        return valido;
    }

    public void obtenerRazones(JTable listaRazones) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) listaRazones.getModel();
            int i;
            ResultSet r = seleccionar("codigoRazon,nombreRazon", "razon", "");
            r.beforeFirst();
            while (r.next()) {
                Object[] fila = new Object[2];
                for (i = 0; i < 2; i++) {
                    fila[i] = r.getObject(i);
                }
                modelo.addRow(fila);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pueden cargar las razones");
            //System.exit(1);
        } finally {
            this.cerrarConexionBase();
        }
    }

    public boolean validarRazon() {
        boolean valido = false;
        try {
            ResultSet r = seleccionar("codigoRazon", "razon", "codigoRazon='" + this.codigoRazon + "'");
            r.beforeFirst();
            if (!r.next()) {
                valido = true;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No existe la razón de envio");
        } finally {
            this.cerrarConexionBase();
        }
        return valido;
    }

    public void obtenerNombreRazon() {
        try {
            ResultSet r = seleccionar("nombreRazon", "razon", "codigoRazon='" + this.codigoRazon + "'");
            this.setNombreRazon(r.getString("nombreRazon"));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No existe la razón de envio");
        } finally {
            this.cerrarConexionBase();
        }
    }

    /**
     * @return the a
     */
    public Area getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(Area a) {
        this.a = a;
    }

    /**
     * @return the e
     */
    public Especificacion getE() {
        return e;
    }

    /**
     * @param e the e to set
     */
    public void setE(Especificacion e) {
        this.e = e;
    }

    /**
     * @return the codigoRazon
     */
    public String getCodigoRazon() {
        return codigoRazon;
    }

    /**
     * @param codigoRazon the codigoRazon to set
     */
    public void setCodigoRazon(String codigoRazon) {
        this.codigoRazon = codigoRazon;
    }

    /**
     * @return the nombreRazon
     */
    public String getNombreRazon() {
        return nombreRazon;
    }

    /**
     * @param nombreRazon the nombreRazon to set
     */
    public void setNombreRazon(String nombreRazon) {
        this.nombreRazon = nombreRazon;
    }
}
