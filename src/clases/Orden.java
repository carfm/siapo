/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.TrayIcon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//agregado al proyecto Iteracion2ssss el 11 de nov 2013 la funcion obtener cantidadTipoDeOrdenes
/**
 *
 * @author Administrador
 */
public class Orden extends Sistema {

    private String specimen;
    private String codigoLocation;
    private int tipoOrden;
    private String comentarioAgente;
    private String comentarioAuditor;
    private ArrayList<Razon> razones;
    private ArrayList<Error> errores;
    private boolean errorLab;
    private ResultSet res;
    private String user;
    private String codError;
    private String nomError;
    private String fecha;
    private String horaInicio;
    private String horaFin;

    public Orden(String specimen, boolean errorLab, String user, String codError, String nomError) {
        this.specimen = specimen;
        this.errorLab = errorLab;
        this.user = user;
        this.codError = codError;
        this.nomError = nomError;
    }

    public Orden() {
    }

    public boolean ingresarOrden() {
        String s = "'" + getSpecimen() + "','" + getCodigoLocation() + "'," + getTipoOrden() + ",'" + getComentarioAgente() + "',' '";
        return insertar("orden", s);
    }

    public boolean actualizarOrden() {
        String campos = " codigolocation='" + codigoLocation + "',tipoOrden=" + tipoOrden + ",comentarioAgente='" + comentarioAgente + "'";
        String condicion = " specimen = '" + specimen + "'";
        return actualizar("orden", campos, condicion);
    }

    public boolean cambiarLocationOrden(String specimen) {
        return actualizar("orden", "codigolocation='" + codigoLocation + "'", " specimen = '" + specimen + "'");
    }

    public Boolean ingresarRegistro(String user, TrayIcon trayIcon) {

        Boolean registrada = true;
        try {
            ResultSet r;
            boolean esteDia = true;
            if (!tieneRegistros()) {
                // NO HAY REGISTRO DEL SPECIMEN
                                        /* tipo orden
                 * 1: completa
                 * 2: incompleta
                 * 3: sin hacer nada
                 */
                ingresarOrden();
                registrada = false;
                /* tipo operacion
                 * 1: ingreso de orden
                 * 2: auditoria de orden
                 */
            } else {
                // YA HAY REGISTROS 
                //comprobaremos que los registros sean de estos dias 
                r = seleccionar("user", "procesa_audita", "specimen = '" + getSpecimen() + "' and fecha = curdate( ) and tipoOperacion=1");
                if (!r.last()) {
                    esteDia = false; // no son de este dia asi que no se le agrega el registro
                    trayIcon.displayMessage("Orden de otro dia", this.getSpecimen(), TrayIcon.MessageType.INFO);
                }
                r.close();
                this.cerrarConexionBase();
            }
            if (esteDia) {
                insertar("procesa_audita(specimen,user,tipoOperacion,fecha,horaInicio)", "'" + getSpecimen() + "','" + user + "',1,CURDATE(),CURTIME()");
                trayIcon.displayMessage("Nuevo registro de specimen", this.getSpecimen(), TrayIcon.MessageType.INFO);
            }
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "No se pudo procesar la orden ");
            registrada = null;
        }
        return registrada;
    }

    public boolean tieneRegistros() {
        ResultSet r;
        boolean tiene = true;
        try {
            r = seleccionar("specimen", "orden", "specimen = '" + getSpecimen() + "'");
            if (!r.last()) {
                // NO HAY REGISTRO DEL SPECIMEN
                tiene = false;
            }
            r.close();
            this.cerrarConexionBase();
        } catch (SQLException ex) {
            Logger.getLogger(Orden.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tiene;
    }

    public Boolean noMismoUser(String user) {
        ResultSet r;
        Boolean nomismo = false;
        try {
            r = seleccionar("user", "procesa_audita", "specimen = '" + getSpecimen() + "' and user = '" + user + "' and tipoOperacion=1");
            if (!r.last()) {
                // solo el tiene el registro de esa orden
                nomismo = true;
            }
            this.cerrarConexionBase();
        } catch (SQLException ex) {
            Logger.getLogger(Orden.class.getName()).log(Level.SEVERE, null, ex);
            nomismo = null;
        }
        return nomismo;
    }

    public boolean contieneErrores() {
        ResultSet r;
        boolean errores = true;
        try {
            r = seleccionar("specimen", "puede_tener", "specimen = '" + getSpecimen() + "'");
            if (!r.last()) {
                errores = false;
            }
            getSentencia().close();
            this.cerrarConexionBase();
        } catch (SQLException ex) {
            Logger.getLogger(Orden.class.getName()).log(Level.SEVERE, null, ex);
        }
        return errores;
    }

    public boolean estaAuditada() {
        ResultSet r;
        boolean auditada = true;
        try {
            r = seleccionar("specimen", "procesa_audita", "specimen = '" + getSpecimen() + "' and tipoOperacion = 2");
            if (!r.last()) {
                auditada = false;
            }
            getSentencia().close();
            this.cerrarConexionBase();
        } catch (SQLException ex) {
            Logger.getLogger(Orden.class.getName()).log(Level.SEVERE, null, ex);
        }
        return auditada;
    }
/// revisar

    public boolean agregarError(boolean aproErrorlab) {
        boolean exito = false;
        try {
            res = seleccionar("aprobado", "error", "codigoError='" + codError + "'");
            if (res.getString("aprobado").equals("1")) {
                java.sql.Date fechaDeOrden;
                cerrarConexionBase();
                res = seleccionar("fecha", "procesa_audita", "specimen='" + specimen + "' and tipoOperacion=1 order by fecha asc");
                fechaDeOrden = res.getDate("fecha");
                if (!this.errorLab) {
                    int recurrenciaActual, diasActuales, diasMaximo, recurrenciaError, recurrencia;
                    java.sql.Date fechaInicioRecurrencia, fecha;
                    float tolerancia, factorError;
                    //select recurrencia,fecha as primererror from puede_tener a,error b,tipoError c where  a.codigoError =b.codigoError and b.codigoTipo=c.codigoTipo and c.codigoTipo= (select codigoTipo from error where codigoError ='IOR02') and a.user= 'enajarro' and recurrencia != 0 order by fecha desc, recurrencia desc
                    cerrarConexionBase();
                    res = seleccionar("recurrencia,fecha as primererror", "puede_tener a,error b,categoriaError c", "a.codigoError =b.codigoError and b.codigoCategoria=c.codigoCategoria and c.codigoCategoria= (select codigoCategoria from error where codigoError ='" + codError + "') and user= '" + getUser() + "' and recurrencia != 0 order by fecha desc, recurrencia desc limit 1");
                    res.beforeFirst();
                    if (res.next()) {
                        recurrenciaActual = res.getInt("recurrencia");
                    } else {
                        recurrenciaActual = 0;
                        cerrarConexionBase();
                        res = seleccionar("fecha as primererror", "procesa_audita", "specimen='" + specimen + "' and tipoOperacion=1 order by fecha asc");
                    }
                    fechaInicioRecurrencia = res.getDate("primererror");
                    cerrarConexionBase();
                    res = seleccionar("diasLimite,recurrenciaSoportada", "categoriaError, error", "error.codigoCategoria = categoriaError.codigoCategoria AND error.codigoError ='" + codError + "'");
                    diasMaximo = res.getInt("diasLimite");
                    recurrenciaError = res.getInt("recurrenciaSoportada");
                    res.close();
                    this.cerrarConexionBase();
                    diasActuales = restarFechas(fechaInicioRecurrencia, fechaDeOrden);
                    tolerancia = Float.parseFloat(Integer.toString(recurrenciaError)) / Float.parseFloat(Integer.toString(diasMaximo));
                    if (recurrenciaActual == 0 || (diasActuales > (recurrenciaError * diasMaximo))) {
                        fecha = fechaDeOrden;
                        recurrencia = 1;
                    } else {
                        fecha = fechaInicioRecurrencia;
                        recurrencia = recurrenciaActual + 1;
                    }
                    if (diasActuales == 0) {
                        if (recurrenciaActual <= 0) {
                            factorError = 0;// primeraVez
                        } else {
                            factorError = Float.parseFloat(Integer.toString(recurrencia)) / 1;//repetido el mismo dia
                        }
                    } else {
                        factorError = Float.parseFloat(Integer.toString(recurrencia)) / Float.parseFloat(Integer.toString(diasActuales));
                    }
//                    System.out.println("Factor de error:" + factorError + "\nTolerancia:" + tolerancia
//                            + "\nDias Actuales:" + diasActuales + "\nRecurrencia:"
//                            + (recurrenciaActual + 1) + "\nFecha inicio:"
//                            + fechaInicioRecurrencia + "\nfecha:" + fecha);
                    if (factorError > tolerancia) {
                        //Advertencia //Modificar despues
                        insertar("mensaje", "NULL,2,"
                                + "'Se le ha encontrado el error: " + codError + ": " + nomError
                                + " en el specimen: " + specimen + " ingresado el dia " + fechaDeOrden
                                + "\nRecurrencia soportada de este error:" + recurrenciaError
                                + "\nCantidad de Dias Maximo: " + diasMaximo + "\nRecurrencia Actual: " + recurrencia + "\n"
                                + "Ha sobrepasado la recurrencia sobre los dias limite por lo que se le advierte a "
                                + "no seguir cometiendo este error; de lo contrario sera citado por el Gerente."
                                + "\n\nFin del Mensaje', 'Error Encontrado (ADVERTENCIA!!!)',NOW()");
                        insertar("gestiona", "null,(SELECT MAX(idMensaje) FROM mensaje),'" + getUser() + "',0,0,1");
                        // System.out.println("Advertencia");
                    } else {
                        //No Advertencia
                        insertar("mensaje", "NULL,2,"
                                + "'Se le ha encontrado el error: " + codError + ": " + nomError
                                + " en el specimen: " + specimen + " ingresado el dia " + fechaDeOrden
                                + "\nRecurrencia soportada de este error:" + recurrenciaError
                                + "\nCantidad de Dias Maximo: " + diasMaximo + "\nRecurrencia Actual: " + recurrencia + "\n"
                                + "\n\nFin del Mensaje', 'Error Encontrado',NOW()");
                        insertar("gestiona", "null,(SELECT MAX(idMensaje) FROM mensaje),'" + getUser() + "',0,0,0");
                        //  System.out.println("No Advertencia");
                    }
                    //select recurrencia,fecha from puede_tener a,error b,tipoError c where a.codigoError =b.codigoError and b.codigoTipo=c.codigoTipo and c.codigoTipo= (select codigoTipo from error where codigoError ='IOR01')
                   /* res = seleccionar("a.codigoError", "puede_tener a,error b,tipoError c", "a.codigoError =b.codigoError and b.codigoTipo=c.codigoTipo and c.codigoTipo=(select codigoTipo from error where codigoError ='" + codError + "') and user= '" + getUser() + "'  order by fecha desc");
                     res.beforeFirst();
                     while (res.next()) {
                     actualizar("puede_tener", "recurrencia=" + recurrencia + ",fecha='" + fecha.toString() + "'", "user='" + getUser() + "' AND codigoError='" + res.getString("a.codigoError") + "'");
                     }*/
                    exito = insertar("puede_tener", "NULL, '" + codError + "', '" + specimen + "', '" + getUser() + "',(SELECT MAX(idMensaje) FROM mensaje), " + recurrencia + ", 0,'" + fecha + "'");
                } else {
                    if (aproErrorlab) {
                        insertar("mensaje", "NULL,2,"
                                + "'Se le ha encontrado el error: " + codError + ": " + nomError
                                + "\nen el specimen: " + specimen + " ingresado el dia " + fechaDeOrden
                                + "\n(No afecta su recurrencia actual)"
                                + "\nEste error fue encontrado en el Laboratorio por lo que se le advierte a ser mas cuidadoso\n"
                                + "\n\nFin del Mensaje', 'Error Encontrado en Laboratorio',NOW()");
                        exito = insertar("gestiona", "null,(SELECT MAX(idMensaje) FROM mensaje),'" + getUser() + "',0,0,1");
                        this.actualizar("puede_tener", "idMensaje = (SELECT MAX(idMensaje) FROM mensaje)", "codigoError = '' and specimen = '' and user = '' and errorLaboratorio = 1");
                    } else {
                        // se ingresa previamente la notificacion de error de laboratorio esta  no afecta la recurrencia pero si tiene una advertencia
                        exito = insertar("puede_tener", "NULL, '" + codError + "', '" + specimen + "', '" + getUser() + "',NULL, 0, 1,NULL");
                        System.out.println("No Advertencia");
                    }
                }
            } else {
                insertar("puede_tener", "NULL, '" + codError + "', '" + specimen + "', '" + getUser() + "',NULL, 0, 0,NULL");
            }
        } catch (Exception e) {
            Logger.getLogger(Orden.class.getName()).log(Level.SEVERE, null, e);
            exito = false;
        }
        return exito;
    }

    public static int restarFechas(Date fechaInicial, Date fechaFinal) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaInicioString = df.format(fechaInicial);
        try {
            fechaInicial = df.parse(fechaInicioString);
        } catch (ParseException ex) {
        }
        String fechaFinalString = df.format(fechaFinal);
        try {
            fechaFinal = df.parse(fechaFinalString);
        } catch (ParseException ex) {
        }
        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ((int) dias);
    }

    public int[] cantidadTipoOrdenes(String user, String periodo) {
        try {
            int t[];
            /*
             * 0:completas
             * 1:incompletas
             * 2:sin hacer nada
             * 3 poner el total
             */
            t = new int[4];
            t[0] = t[1] = t[2] = 0;
            ResultSet r;
            r = seleccionar("tipoOrden, COUNT( * ) as totales",
                    "orden a, procesa_audita b",
                    "user = '" + user + "' AND a.specimen = b.specimen and " + periodo + " and tipoOperacion = 1 GROUP BY tipoOrden");
            r.beforeFirst();
            while (r.next()) {
                if (Integer.parseInt(r.getString("tipoOrden")) == 1) { // completas
                    t[0] = Integer.parseInt(r.getString("totales"));
                } else {
                    if (Integer.parseInt(r.getString("tipoOrden")) == 2) {//incompletas
                        t[1] = Integer.parseInt(r.getString("totales"));
                    } else {
                        t[2] = Integer.parseInt(r.getString("totales")); // sin hacer nada
                    }
                }
            }
            t[3] = t[0] + t[1] + t[2];
            r.close();
            this.cerrarConexionBase();
            return t;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public int[] cantidadOrdenesAuditadas(String user, String periodo) {
        try {
            int t[];
            /*
             * 0:auditadas sin error
             * 1:auditadas con error
             * 2:total
             */
            t = new int[3];
            t[0] = t[1] = t[2] = 0;
            ResultSet r;
            //SELECT COUNT( * ) FROM procesa_audita WHERE TIPOPROCESAAUDITA =2 AND IDEMPLEADO = id AND FECHAPROCESAAUDITA BETWEEN fechaInicio AND fechaFin
            r = seleccionar("COUNT( * ) as totales",
                    "procesa_audita a",
                    "user = '" + user + "' and " + periodo + " and tipoOperacion = 2 limit 1");
            //r.beforeFirst();
            t[2] = r.getInt("totales");
            cerrarConexionBase();
            //select count(distinct b.specimen) as totalError from procesa_audita a inner join puede_tener b on a.specimen=b.specimen where tipoOperacion=2 and a.user='cfuentes' and fecha
            r = seleccionar("count(distinct b.specimen) as totalError",
                    "procesa_audita a inner join puede_tener b on a.specimen=b.specimen",
                    "a.user = '" + user + "' and " + periodo + " and tipoOperacion = 2 limit 1");
            //r.beforeFirst();
            t[1] = r.getInt("totalError");
            t[0] = t[2] - t[1];
            r.close();
            cerrarConexionBase();
            return t;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public int[] cantidadCategoriaErrores(String user, String periodo) {
        try {
            int t[];
            /*
             * 0:graves
             * 1:medios
             * 2:leves
             * 3 poner el total
             */
            t = new int[4];
            t[0] = t[1] = t[2] = 0;
            ResultSet r;
            //SELECT nombreTipo, count( * ) AS total FROM ((puede_Tener c LEFT JOIN error b ON c.codigoError =b.codigoError) RIGHT JOIN tipoError a ON a.codigoTipo = b.codigoTipo) LEFT JOIN procesa_audita d ON d.specimen = c.specimen WHERE tipoOperacion =1 AND c.user = 'cfuentes' AND errorLaboratorio = 0 AND date( fecha ) BETWEEN '2013-10-01' AND '2013-10-31' GROUP BY nombreTipo
            r = seleccionar("a.codigoCategoria, count( * ) AS total",
                    "((puede_Tener c LEFT JOIN error b ON c.codigoError =b.codigoError) RIGHT JOIN categoriaError a ON a.codigoCategoria = b.codigoCategoria) LEFT JOIN procesa_audita d ON d.specimen = c.specimen",
                    "tipoOperacion =1 AND c.user = '" + user + "' AND errorLaboratorio = 0 AND " + periodo + " GROUP BY nombreCategoria");
            r.beforeFirst();
            while (r.next()) {
                if (Integer.parseInt(r.getString("a.codigoCategoria")) == 1) { // graves
                    t[0] = Integer.parseInt(r.getString("total"));
                } else {
                    if (Integer.parseInt(r.getString("a.codigoCategoria")) == 2) {//medios
                        t[1] = Integer.parseInt(r.getString("total"));
                    } else {
                        t[2] = Integer.parseInt(r.getString("total")); // leves
                    }
                }
            }
            t[3] = t[0] + t[1] + t[2];
            getSentencia().close();
            this.cerrarConexionBase();
            return t;
        } catch (SQLException ex) {
            System.out.println(ex);

            return null;
        }
    }

    public void encontrarOrden(JTable listaOrdenes) {
        boolean encontrado = false;
        boolean numero = true;
        if (!this.getSpecimen().equals("")) {
            if (this.getSpecimen().length() == 7 || this.getSpecimen().length() == 8) {
                try {
                    Integer.parseInt(this.getSpecimen());
                } catch (Exception ex) {
                    numero = false;
                }
                if (numero) {
                    String ele = this.getSpecimen();
                    for (int i = 0; i < listaOrdenes.getRowCount(); i++) {
                        if (listaOrdenes.getValueAt(i, 0).equals(ele)) {
                            listaOrdenes.changeSelection(i, 0, false, false);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        JOptionPane.showMessageDialog(null, "No hay registro de esa orden en sus ordenes procesadas", "Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Verifique el numero de specimen a buscar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Verifique el numero de specimen a buscar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay registro que buscar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<Orden> obtenerOrdenes(String user, String fechaInicio, String fechaFin) {
        ArrayList<Orden> ordenes = new ArrayList();
        try {
            String periodo;
            if (fechaInicio.equals("") && fechaFin.equals("")) {
                periodo = "= curdate()";
            } else {
                periodo = "between '" + fechaInicio + "' and '" + fechaFin + "'";
            }
            ResultSet r = seleccionar("b.specimen,nombreLocation,comentarioAgente,tipoOrden,fecha,horaInicio,horaFin",
                    "procesa_audita a inner join orden b on a.specimen = b.specimen and tipoOperacion=1 and user = '" + user
                    + "' inner join location c  on c.codigoLocation = b.codigoLocation",
                    "  fecha " + periodo + " ORDER BY horaInicio desc");
            r.beforeFirst();
            while (r.next()) {
                Orden o = new Orden();
                o.setSpecimen(r.getString("specimen"));
                o.setCodigoLocation(r.getString("nombreLocation"));
                o.setTipoOrden(Integer.parseInt(r.getString("tipoOrden")));
                o.setComentarioAgente(r.getString("comentarioAgente"));
                o.setFecha(this.fechaReves(r.getString("fecha")));
                o.setHoraInicio(r.getString("horaInicio"));
                o.setHoraFin(r.getString("horaFin"));
                ordenes.add(o);
            }
            this.cerrarConexionBase();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pueden cargar las ordenes");
            ordenes = null;
            //System.exit(1);
        }
        return ordenes;
    }

    public void llenarTablaOrdenes(JTable listaOrdenes, String user, String fechaInicio, String fechaFin) {
        limpiarTabla(listaOrdenes);
        try {
            String periodo;
            if (fechaInicio.equals("") && fechaFin.equals("")) {
                periodo = "= curdate()";
            } else {
                periodo = "between '" + fechaInicio + "' and '" + fechaFin + "'";
            }
            ResultSet r = seleccionar("b.specimen,nombreLocation,(SELECT CASE WHEN tipoOrden =1 THEN 'Completa' WHEN tipoOrden =2 THEN 'Regresada Incompleta' WHEN tipoOrden =3 THEN 'Regresada sin hacer nada' END) AS nombreTipo,horaInicio,horaFin,comentarioAgente",
                    "procesa_audita a inner join orden b on a.specimen = b.specimen and tipoOperacion=1 and user = '" + user
                    + "' inner join location c  on c.codigoLocation = b.codigoLocation",
                    "  fecha " + periodo + " ORDER BY horaInicio desc");
            r.beforeFirst();
            while (r.next()) {
                // Se crea un array que será una de las filas de la tabla.
                Object[] fila = new Object[6]; // Hay seis columnas en la tabla
                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                for (int i = 0; i < 6; i++) {
                    fila[i] = r.getObject(i + 1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
                }
                // Se añade al modelo la fila completa.
                ((DefaultTableModel) listaOrdenes.getModel()).addRow(fila);
            }
            ((DefaultTableModel) listaOrdenes.getModel()).fireTableDataChanged();
            this.cerrarConexionBase();
        } catch (Exception e) {
            System.out.println(e);
        }
        // return ordenes;
    }

    public void mandadaPor(String specimen, String user) {
        for (Razon r : this.razones) {
            this.insertar("mandada_por", "NULL,'" + specimen + "','" + r.getCodigoRazon() + "','" + user + "'");
        }
    }

    public void obtenerMandadaPor(String user) {
        try {
            razones = new ArrayList();
            ResultSet r = seleccionar("codigoRazon", "mandada_por", "user = '" + user + "' and specimen = '" + getSpecimen() + "'");
            r.beforeFirst();
            while (r.next()) {
                Razon raz = new Razon();
                raz.setCodigoRazon(r.getString("codigoRazon"));
                razones.add(raz);
            }
            this.cerrarConexionBase();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pueden cargar las razones");
        }
    }

    public void borrarMandadaPor(String user) {
        borrar("mandada_por", "user = '" + user + "' and specimen = '" + getSpecimen() + "'");
    }

    public boolean borrarOrden(String user) {
        int cont = contadorFilas("procesa_audita", "specimen = '" + getSpecimen() + "' and tipoOperacion=1");
        boolean bien;
        if (cont > 1) {
            //si tiene mas registros solo borramos el registro del actual agente
            bien =borrar("procesa_audita", "user = '" + user + "' and specimen = '" + getSpecimen() + "' and tipoOperacion=1");
            if (this.getTipoOrden() != 1) {
                bien =borrar("mandada_por", "user = '" + user + "' and specimen = '" + getSpecimen() + "'");
            }
        } else {
            //sino borra la orden porq solo el la ha ingresado
            bien = borrar("orden", "specimen = '" + getSpecimen() + "'");
            //solo se borra el registro de manda por cuando es solamente de un agente
        }
        return bien;
    }

    public boolean actualizarOrden(boolean almacenado, String user) {
        boolean bien;
        if (!almacenado) {
            //se actualiza el registro completo 
                                                /*
             asi como esta actualmente el sistema
             no se modificara nada del procesamiento de una 
             orden ya almacenada
             Actualmente 
             */
            actualizar("orden", "comentarioAgente='" + this.getComentarioAgente() + "',codigoLocation='" + getCodigoLocation() + "'", "specimen = '" + this.getSpecimen() + "'");
        }
        if (!this.razones.isEmpty()) {
            //actualizar concatenado
            actualizar("orden", "tipoOrden=" + this.getTipoOrden() + ",comentarioAgente='" + this.getComentarioAgente() + "'", "specimen = '" + this.getSpecimen() + "'");
            //setRazones(raz);
            mandadaPor(specimen, user);
            this.razones.clear();
        }
        bien = actualizar("procesa_audita", "horaFin=CURTIME()", "specimen = '" + specimen + "'and user='" + user + "' and tipoOperacion =1");
        return bien;
    }

    public void obtenerInfoOrden(JTable historial, JComboBox nombreLocation, JComboBox tipoOrden) {
        try {
            ResultSet r;
            r = seleccionar("nombrelocation, tipoOrden,user,concat(fecha,' ',horaInicio)",
                    "procesa_audita a, orden b, location c",
                    "a.specimen = b.specimen AND a.specimen = '" + specimen + "' AND c.codigoLocation = b.codigoLocation and tipoOperacion=1 ORDER BY fecha ASC ");
            if (r.last()) {
                r.first();
                nombreLocation.setSelectedItem(r.getString("nombrelocation"));
                tipoOrden.setSelectedIndex(Integer.parseInt(r.getString("tipoOrden")) - 1);
                DefaultTableModel modelo = (DefaultTableModel) historial.getModel();
                int i;
                r.beforeFirst();
                while (r.next()) {
                    Object[] fila = new Object[2];
                    for (i = 0; i < 2; i++) {
                        fila[i] = r.getObject(i + 3);
                    }
                    modelo.addRow(fila);
                }                
                cerrarConexionBase();
            }           
            cerrarConexionBase();
        } catch (SQLException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "La orden no a podido ser procesada correctamente",
                    "Error en registro de orden", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(ex);
        }
    }

    public boolean agregarRazonOrden(String razon) {
        boolean agregado = false;
        if (!razon.isEmpty()) {
            if (razon.length() < 8) {
                JOptionPane.showMessageDialog(null, "El codigo no existe. Vuelva a escribir el codigo de la razón", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Razon r = new Razon();
                r.setCodigoRazon(razon.substring(0, 5));
                if (r.validarRazon()) {
                    JOptionPane.showMessageDialog(null, "El codigo no existe. Vuelva a escribir el codigo de la razón", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    boolean repetido = false;
                    for (Razon raz1 : getRazones()) {
                        if (raz1.getCodigoRazon().equals(r.getCodigoRazon())) {
                            repetido = true;
                        }
                    }
                    if (!repetido) {
                        agregado = true;
                        r.setNombreRazon(razon.substring(7));
                        getRazones().add(r);
                        if (comentarioAgente.isEmpty()) {
                            this.comentarioAgente = r.getNombreRazon();
                        } else {
                            comentarioAgente = comentarioAgente + "," + r.getNombreRazon();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya esta almacenada esa razón", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Escriba el codigo de la razón", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return agregado;
    }

    public void llenarTablaOrdenesAuditadas(JTable listaOrdenes, String user, String fechaInicio, String fechaFin) {
        int j = 0;
        limpiarTabla(listaOrdenes);
        try {
            String periodo;
            if (fechaInicio.equals("") && fechaFin.equals("")) {
                periodo = "= curdate()";
            } else {
                periodo = "between '" + fechaInicio + "' and '" + fechaFin + "'";
            }
            ResultSet r = seleccionar("b.specimen,(SELECT user from procesa_audita WHERE specimen = b.specimen limit 1) as agente,(SELECT specimen from puede_tener where specimen = b.specimen limit 1) as error,horaInicio,comentarioAuditor",
                    "procesa_audita a inner join orden b on a.specimen = b.specimen and tipoOperacion=2 and user = '" + user + "'",
                    "  fecha " + periodo + " ORDER BY fecha desc,horaInicio desc");
            r.beforeFirst();
            while (r.next()) {
                ((DefaultTableModel) listaOrdenes.getModel()).setRowCount(listaOrdenes.getRowCount() + 1);
                listaOrdenes.setValueAt(r.getString("specimen"), j, 0);
                listaOrdenes.setValueAt(r.getString("agente"), j, 1);
                if (r.getString("error") != null) {
                    listaOrdenes.setValueAt("Con error", j, 2);
                } else {
                    listaOrdenes.setValueAt("Sin error", j, 2);
                }
                listaOrdenes.setValueAt(r.getString("horaInicio"), j, 3);
                listaOrdenes.setValueAt(r.getString("comentarioAuditor"), j, 4);
                j++;
            }
            this.cerrarConexionBase();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * @return the specimen
     */
    public String getSpecimen() {
        return specimen;
    }

    /**
     * @param specimen the specimen to set
     */
    public void setSpecimen(String specimen) {
        this.specimen = specimen;
    }

    /**
     * @return the codigoLocation
     */
    public String getCodigoLocation() {
        return codigoLocation;
    }

    /**
     * @param codigoLocation the codigoLocation to set
     */
    public void setCodigoLocation(String codigoLocation) {
        this.codigoLocation = codigoLocation;
    }

    /**
     * @return the tipoOrden
     */
    public int getTipoOrden() {
        return tipoOrden;
    }

    /**
     * @param tipoOrden the tipoOrden to set
     */
    public void setTipoOrden(int tipoOrden) {
        this.tipoOrden = tipoOrden;
    }

    /**
     * @return the comentarioAgente
     */
    public String getComentarioAgente() {
        return comentarioAgente;
    }

    /**
     * @param comentarioAgente the comentarioAgente to set
     */
    public void setComentarioAgente(String comentarioAgente) {
        this.comentarioAgente = comentarioAgente;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
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
     * @return the horaInicio
     */
    public String getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the horaFin
     */
    public String getHoraFin() {
        return horaFin;
    }

    /**
     * @param horaFin the horaFin to set
     */
    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * @return the razones
     */
    public ArrayList<Razon> getRazones() {
        return razones;
    }

    /**
     * @param razones the razones to set
     */
    public void setRazones(ArrayList<Razon> razones) {
        this.razones = razones;
    }

    /**
     * @return the errores
     */
    public ArrayList<Error> getErrores() {
        return errores;
    }

    /**
     * @param errores the errores to set
     */
    public void setErrores(ArrayList<Error> errores) {
        this.errores = errores;
    }
}
