/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class Location extends Sistema {

    private String codigoLocation;
    private String nombreLocation;
    private int prioridad;
    private int codigoLocationUSA;

    /**
     * @return the codigoLocation
     */
    public String getCodigoLocation() {
        return codigoLocation;
    }

    public void agregarLocation() {
        insertar("location", "'" + this.getCodigoLocation() + "',"
                + "'" + this.getNombreLocation() + "'," + this.getPrioridad() + ",1,'" + this.getCodigoLocationUSA() + "'");
    }

    public boolean generarCodigoLocation() {
        String letras = nombreLocation.toLowerCase();
        String codigo = "";
        char l[] = letras.toCharArray();
        int i = 1;
        codigo = codigo + l[0];
        while (i < l.length) {
            if (!(l[i] == 'a' || l[i] == 'e' || l[i] == 'i' || l[i] == 'o' || l[i] == 'u' || l[i] == ' ')) {
                codigo = codigo + l[i];
            } else {
                if (l[i] == ' ') {
                    codigo = codigo.substring(0, 1);
                }
            }
            i++;
        }
        codigo = codigo.substring(0, 2).toUpperCase();
        try {
            ResultSet r;
            r = seleccionar("codigoLocation", "location", "codigoLocation LIKE '" + codigo + "__' order by codigoLocation asc");
            if (!r.last()) {
                codigo = codigo + "01";
            } else {
                int valor = Integer.parseInt(r.getString("codigoLocation").substring(3)) + 1;
                if (valor < 10) {
                    codigo = codigo + "0" + Integer.toString(valor);
                } else {
                    codigo = codigo + Integer.toString(valor);
                }
            }
            if (this.getPrioridad() == 1) {
                nombreLocation = nombreLocation.toUpperCase() + " - PRIORITY";
            } else {
                nombreLocation = nombreLocation.toUpperCase() + " - REGULAR";
            }
            this.cerrarConexionBase();
            setCodigoLocation(codigo);
            return !codigoLocation.equals("");
        } catch (Exception e) {
            this.cerrarConexionBase();
            return false;
        }
    }

    public boolean verificarNombreLocation() {
        try {
            boolean esta = false;
            ResultSet r;
            r = seleccionar("nombreLocation", "location", "nombreLocation = '" + nombreLocation + "'");
            if (r.last()) {
                esta = true;
            }
            this.cerrarConexionBase();
            return esta;
        } catch (Exception e) {
            this.cerrarConexionBase();
            return false;
        }
    }

    public void setCodigoLocation() {
        ResultSet r;
        try {
            r = seleccionar("codigoLocation", "Location", " nombreLocation like '" + getNombreLocation() + "'");
            setCodigoLocation(r.getString("codigoLocation"));
            this.cerrarConexionBase();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // funcion que retorna un array con las locations y llena un jtable
    public void llenarTablaLocations(JTable listaLocation) {
        ResultSet r = seleccionar("nombreLocation,(SELECT CASE WHEN prioridad =1 THEN 'PRIORIDAD' WHEN prioridad =0 THEN 'NO PRIORIDAD' END),codigoLocationUSA,codigoLocation", "location", "LocationActivo=1");
        try {
            r.beforeFirst();
            while (r.next()) {
                Object[] fila = new Object[3]; // Hay seis columnas en la tabla
                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                for (int i = 0; i < 3; i++) {
                    fila[i] = r.getObject(i + 1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
                }
                // Se añade al modelo la fila completa.
                ((DefaultTableModel) listaLocation.getModel()).addRow(fila);
            }
            r.close();
            this.cerrarConexion();
            this.cerrarConexionBase();
        } catch (SQLException ex) {
            Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarComboBoxLocations(JComboBox lista, ArrayList<Location> locations) {
        int j = 0;
        //ArrayList<Location> locations = obtenerLocations();
        while (j < locations.size()) {
            Location l = locations.get(j);
            lista.addItem(l.getNombreLocation());
            j++;
        }
    }

    public ArrayList<Location> obtenerLocations() {
        ArrayList<Location> locations = new ArrayList();
        try {
            ResultSet r = seleccionar("nombreLocation,codigoLocationUSA,prioridad,codigoLocation", "location", "LocationActivo=1");
            r.beforeFirst();
            while (r.next()) {
                Location l = new Location();
                l.setNombreLocation(r.getString("nombreLocation"));
                l.setCodigoLocation(r.getString("codigoLocation")); // quitar despues
                l.setCodigoLocationUSA(Integer.parseInt(r.getString("codigoLocationUSA")));
                l.setPrioridad(Integer.parseInt(r.getString("prioridad")));
                locations.add(l);
            }
            this.cerrarConexionBase();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pueden cargar las locations");
            System.exit(1);
        }
        return locations;
    }

    public Location buscarLocation(ArrayList<Location> locations, String nombreLocation) {
        for (Location location : locations) {
            if (location.getNombreLocation().equals(nombreLocation)) {
                return location;
            }
        }
        return null;
    }

    /**
     * @return the nombreLocation
     */
    public String getNombreLocation() {
        return nombreLocation;
    }

    /**
     * @param nombreLocation the nombreLocation to set
     */
    public void setNombreLocation(String nombreLocation) {
        this.nombreLocation = nombreLocation;
    }

    /**
     * @return the prioridad
     */
    public int getPrioridad() {
        return prioridad;
    }

    /**
     * @param prioridad the prioridad to set
     */
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
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

    /**
     * @param codigoLocation the codigoLocation to set
     */
    public void setCodigoLocation(String codigoLocation) {
        this.codigoLocation = codigoLocation;
    }

}
