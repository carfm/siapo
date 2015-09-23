package clases;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.fill.JRFiller;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class Sistema {

    private ResultSet resultado;
    private Statement sentencia;
    private Connection conexion;
    public final static String servidor = "jdbc:mysql://localhost:44444/siapo";//10.8.40.99:3306/siapo
    public final static String usu = "root";//hmcr_siapo
    public final static String pass = "admin";//eamJpymB8nTmTVXd
    public final static String años = "2013-2015";
    private String para, asunto, mensaje;

    public boolean insertar(String tabla, String valores) {
        boolean bien = true;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            setConexion(DriverManager.getConnection(servidor, usu, pass));//Crea la conexion
            setSentencia(getConexion().createStatement());
            String insertar = "INSERT INTO " + tabla + " VALUES (" + valores + ")";
            //System.out.println(insertar);
            getSentencia().executeUpdate(insertar);
            getSentencia().close();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            bien = false;
            ErroresSiapo.agregar(ex, "codigo 1");
            //System.exit(1);
        } finally {
            cerrarConexionBase();
        }
        return bien;
    }

    public boolean actualizar(String tabla, String campos, String condicion) {
        boolean bien = true;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            setConexion(DriverManager.getConnection(servidor, usu, pass));//Crea la conexion
            String modificar;
            if (condicion.isEmpty()) {
                modificar = "UPDATE " + tabla + " SET " + campos;
            } else {
                modificar = "UPDATE " + tabla + " SET " + campos + " WHERE " + condicion;
            }
            //System.out.println(modificar);
            setSentencia(getConexion().createStatement());
            getSentencia().executeUpdate(modificar);
            getSentencia().close();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            bien = false;
            ErroresSiapo.agregar(ex, "codigo 2");
        } finally {
            cerrarConexionBase();
        }
        return bien;
    }

    public boolean borrar(String tabla, String condicion) {
        boolean bien = true;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            setConexion(DriverManager.getConnection(servidor, usu, pass));//Crea la conexion
            String modificar;
            if (condicion.isEmpty()) {
                modificar = "DELETE FROM " + tabla;
            } else {
                modificar = "DELETE FROM " + tabla + " WHERE " + condicion;
            }
            //System.out.println(modificar);
            setSentencia(getConexion().createStatement());
            getSentencia().executeUpdate(modificar);
            getSentencia().close();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            ErroresSiapo.agregar(ex, "codigo 3");
        } finally {
            cerrarConexionBase();
        }
        return bien;
    }

    public ResultSet seleccionar(String campo, String tabla, String condicion) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            setConexion(DriverManager.getConnection(servidor, usu, pass));//Crea la conexion
            String sql_str;
            if (condicion.isEmpty()) {
                sql_str = "SELECT " + campo + " FROM " + tabla;
                if (tabla.isEmpty()) {
                    sql_str = "SELECT " + campo;
                }
            } else {
                sql_str = "SELECT " + campo + " FROM " + tabla + " WHERE " + condicion;
            }
//            System.out.println(sql_str);
            setSentencia(getConexion().createStatement());
            resultado = getSentencia().executeQuery(sql_str);
            resultado.next();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            ErroresSiapo.agregar(ex, "codigo 4");
        }
        return resultado;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void cerrarConexionBase() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ignore) {
                ErroresSiapo.agregar(ignore, "codigo 5");
                JOptionPane.showMessageDialog(null, "Error con la base de datos contacte a su administrador de base de datos");
            }
        }
    }

    // numeros enteros
    public void DNI(JTextField texto) {
        texto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char a = e.getKeyChar();
                if (!((int) a >= 48 && (int) a <= 57)) {
                    e.consume();
                }
            }
        });
    }
    //numeros decimales

    public void DND(JTextField texto) {
        texto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char a = e.getKeyChar();
                if (!((int) a >= 46 && (int) a <= 57) || a == 47) {
                    e.consume();
                }
            }
        });
    }

    public boolean compararFechas(String fechaInicial, String fechaFinal) {
        SimpleDateFormat Df = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha1, fecha2;
        try {
            if (fechaInicial.isEmpty()) {
                fecha1 = new Date();//fecha del sistema
            } else {
                fecha1 = Df.parse(fechaInicial);  //fecha inicial a comparar
            }
            fecha2 = Df.parse(fechaFinal);//fecha final a comparar
            return fecha1.compareTo(fecha2) <= 0;
        } catch (ParseException ex) {
            return false;
        }
    }

    public void soloLetras(KeyEvent evt) {
        char ch = evt.getKeyChar();
        if ((ch < 'a' || ch > 'z') && (ch < 'A' || ch > 'Z')) {
            evt.consume();
        }
    }

    public void soloLetrasMin(KeyEvent evt) {
        char ch = evt.getKeyChar();
        if ((ch < 'a' || ch > 'z')) {
            evt.consume();
        }
    }

    public void soloLetrasMinNum(KeyEvent evt) {
        char ch = evt.getKeyChar();
        if ((ch < 'a' || ch > 'z')) {
            if ((!((int) ch >= 48 && (int) ch <= 57))) {
                evt.consume();
            }
        }
    }

    public static String encrypt(String cadena) {
        StandardPBEStringEncryptor s = new StandardPBEStringEncryptor();
        s.setPassword("clasificado");
        return s.encrypt(cadena);
    }

//metodo para desencriptar; en setPassword debe ir la misma string que en el metodo encrypt
//sino no va a funcionar el desencriptado.
    public static String decrypt(String cadena) {
        StandardPBEStringEncryptor s = new StandardPBEStringEncryptor();
        s.setPassword("clasificado");
        String devuelve = "";
        try {
            devuelve = s.decrypt(cadena);
        } catch (Exception e) {
        }
        return devuelve;
    }
    //la pone en el siguiente formato AAAA-mm-dd

    public String fechaCorrecta(String d) {
        String c = "";
        c = c + d.substring(6, d.length());
        c = c + "-";
        c = c + d.substring(3, 5);
        c = c + "-";
        c = c + d.substring(0, 2);
        return c;
    }
    //la pone en el siguiente formato dd-mm-AAAA

    public String fechaReves(String d) {
        String c = "";
        c = c + d.substring(8, d.length());
        c = c + "-";
        c = c + d.substring(5, 7);
        c = c + "-";
        c = c + d.substring(0, 4);
        return c;
    }

    public void cerrarConexion() {
        try {
            getSentencia().close();
        } catch (SQLException ex) {
            ErroresSiapo.agregar(ex, "codigo 7");
            System.out.println(ex);
        }
    }

    public int contadorFilas(String tabla, String condicion) {
        ResultSet r;
        int contador = 0;
        r = seleccionar("count(*) as filas", tabla, condicion);
        try {
            contador = Integer.parseInt(r.getString("filas"));
        } catch (SQLException | NumberFormatException ex) {
            ErroresSiapo.agregar(ex, "codigo 8");
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.cerrarConexionBase();
        }
        return contador;
    }

    public JasperViewer runReporte(String nombre_reporte, Map parametro) {
        try {
            URL archivo = getClass().getResource("/reportes/" + nombre_reporte + ".jasper");
            System.out.println(archivo);
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            setConexion(DriverManager.getConnection(servidor, usu, pass));//Crea la conexion
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(archivo);
            JasperPrint imprime = JRFiller.fillReport(jasperReport, parametro, conexion);
            JasperViewer v = new JasperViewer(imprime, false);
            return v;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException | JRException j) {
            System.out.println("er " + j.getMessage());
            ErroresSiapo.agregar(j, "codigo 9");
            return null;
        } finally {
            this.cerrarConexionBase();
        }
    }

    public boolean ejecutarSP(String parametros, String nombre) {
        boolean bien = true;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            setConexion(DriverManager.getConnection(servidor, usu, pass));//Crea la conexion
            setSentencia(getConexion().createStatement());
            String sql_str = "call " + nombre + parametros;
            getSentencia().executeQuery(sql_str);
            getSentencia().close();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            bien = false;
            ErroresSiapo.agregar(ex, "codigo 10");
            JOptionPane.showMessageDialog(null, "Error en la base de datos. Contacte a su administrador de base de datos.");
        } finally {
            this.cerrarConexionBase();
        }
        return bien;
    }

    public boolean ejecutarSQL(String query) {
        boolean bien = true;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            setConexion(DriverManager.getConnection(servidor, usu, pass));//Crea la conexion
            setSentencia(getConexion().createStatement());
            getSentencia().executeUpdate(query);
            getSentencia().close();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            bien = false;
            ErroresSiapo.agregar(ex, "codigo 11");
            JOptionPane.showMessageDialog(null, "Error en la base de datos. Contacte a su administrador de base de datos.");
        } finally {
            this.cerrarConexionBase();
        }
        return bien;
    }

    public String obtenerMes(int numMes) {
        String mes = "";
        switch (numMes) {
            case 0:
                mes = "Diciembre";
                break;
            case 1:
                mes = "Enero";
                break;
            case 2:
                mes = "Febrero";
                break;
            case 3:
                mes = "Marzo";
                break;
            case 4:
                mes = "Abril";
                break;
            case 5:
                mes = "Mayo";
                break;
            case 6:
                mes = "Junio";
                break;
            case 7:
                mes = "Julio";
                break;
            case 8:
                mes = "Agosto";
                break;
            case 9:
                mes = "Septiembre";
                break;
            case 10:
                mes = "Octubre";
                break;
            case 11:
                mes = "Noviembre";
                break;
            case 12:
                mes = "Diciembre";
                break;
        }
        return mes;
    }

    public boolean enviarEmail() {
        try {
            // Propiedades de la conexión
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress("henryddl@gmail.com"));

            message.addRecipients(Message.RecipientType.TO, para);
            message.setSubject(asunto);
            message.setText(mensaje);

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("henryddl@gmail.com", "FaaderVaar228");
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));

            // Cierre de la conexion.
            t.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void limpiarTabla(JTable tabla) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int a = modelo.getRowCount() - 1;
            for (int i = a; i >= 0; i--) {
                modelo.removeRow(i);
            }
        } catch (Exception e) {
            ErroresSiapo.agregar(e, "codigo 12");
            //JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }

    public String obtenerCadenaPortapapeles() {
        String texto = "";
        try {
            Clipboard cb;
            Transferable t;
            DataFlavor dataFlavorStringJava;
            cb = Toolkit.getDefaultToolkit().getSystemClipboard();
            t = cb.getContents(this);
            dataFlavorStringJava = new DataFlavor("application/x-java-serialized-object; class=java.lang.String");
            // comprueba que el contenido del portapapeles sea manejable (en este caso q sea string)
            if (t.isDataFlavorSupported(dataFlavorStringJava)) {
                texto = t.getTransferData(dataFlavorStringJava).toString();
            }
        } catch (HeadlessException | ClassNotFoundException | UnsupportedFlavorException | IOException ex) {
            // ErroresSiapo.agregar(ex, "codigo 13");
        }
        return texto;
    }

    public boolean inicializarPortapapeles(String cadena) {
        //este es nuestro objeto Transferable para trabajar con strings
        try {
            StringSelection ss = new StringSelection(cadena);
            Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
            cb.setContents(ss, null);
            return false;
        } catch (Exception ex) {
            ErroresSiapo.agregar(ex, "codigo 14");
            return inicializarPortapapeles(cadena);
        }
    }

    public boolean esNumero(String cadena) {
        boolean numero = true;
        try {
            Integer.parseInt(cadena);
        } catch (Exception ex) {
            numero = false;
        }
        return numero;
    }

    public int numero(int mes) {

        switch (mes) {
            case 1:
                return 31;
            case 2:
                return 28;
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
        }
        return 0;
    }

    // no c ocupa
    public void llenarTabla(ResultSet rs, DefaultTableModel modelo) {
        try {
            ResultSetMetaData metaDatos = rs.getMetaData();
            // Se obtiene el número de columnas.
            int numeroColumnas = metaDatos.getColumnCount();
            // Se crea un array de etiquetas para rellenar
            Object[] etiquetas = new Object[numeroColumnas];
            // Se obtiene cada una de las etiquetas para cada columna
            for (int i = 0; i < numeroColumnas; i++) {
                // Nuevamente, para ResultSetMetaData la primera columna es la 1.
                etiquetas[i] = metaDatos.getColumnLabel(i + 1);
            }
            modelo.setColumnIdentifiers(etiquetas);
        } catch (SQLException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the resultado
     */
    public ResultSet getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(ResultSet resultado) {
        this.resultado = resultado;
    }

    /**
     * @return the sentencia
     */
    public Statement getSentencia() {
        return sentencia;
    }

    /**
     * @param sentencia the sentencia to set
     */
    public void setSentencia(Statement sentencia) {
        this.sentencia = sentencia;
    }

    /**
     * @param conexion the conexion to set
     */
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
