/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas.auditor;

import pantallas.agente.RegistroDeOrdenesProcesadas;
import clases.Orden;
import clases.Usuario;
import clases.Error;
import clases.ErroresSiapo;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pantallas.general.MenuPpal;
import pantallas.mensajeria.NotificacionNueva;
import pantallas.mensajeria.errorNuevo;

/**
 * Registro de ordenes auditadas El objetivo de dicho modulo es facilitar la
 * auditoria de ordenes procesadas con la ayuda de la mecanizacion de dicho
 * proceso, el cual promete optimizar sue ejecucon en funcion del tiempo.
 *
 * @author Eduardo_Alexis_Landaverde
 */
public final class AuditoriaDeOrdenes extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form OrdenesAuditadas
     */
    public String specAlmacenado;
    private final Calendar c;
    protected DefaultTableModel model;
    private final Usuario u;
    public Thread h;
    public boolean stop;
    public boolean primeraVez;
    TextAutoCompleter codigoErrorAC;
    public NotificacionNueva n;
    public errorNuevo e;
    public TrayIcon trayIcon;
    private boolean cancelar;
    private final ArrayList<Error> errores;
    SystemTray tray;

    public AuditoriaDeOrdenes(Usuario u, NotificacionNueva n, errorNuevo e) {
        c = Calendar.getInstance();
        this.u = new Usuario();
        this.u.setNombreUsuario(u.getNombreUsuario());
        this.u.setUser(u.getUser());
        this.u.setListaTiposUsuario(u.getListaTiposUsuario());
        this.e = e;
        this.n = n;
        initComponents();
        ed_comment_aud.setLineWrap(true);
        ed_comment_aud.setWrapStyleWord(true);
        ed_button_reg.setEnabled(false);
        ed_button_cancel.setEnabled(false);
        setSize(1024, 680);
        this.setLocationRelativeTo(null);
        u.inicializarPortapapeles("00000000");
        inicializarPortapapeles(true);
        this.h = new Thread(this, "");
        stop = false;
        primeraVez = true;
        this.tray = n.getTray();
        h.start();
        codigoErrorAC = new TextAutoCompleter(ed_text_codError);
        autocompletar();
        iconoBarra();
        errores = (new Error()).obtenerErrores();
        actualizarTotales();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enviarMail = new javax.swing.JFrame();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        para = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        asunto = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        mensaje = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        listaDeOrdenes = new javax.swing.JFrame("LowerRightFrame");
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        buscar = new javax.swing.JTextField();
        buscar_btn = new javax.swing.JToggleButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_auditoria = new javax.swing.JTable();
        header = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        footer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ed_table_errores = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ed_text_specimen = new javax.swing.JTextField();
        ed_text_agent = new javax.swing.JTextField();
        ed_text_location = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        ed_text_tOrden = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        ed_panel_error = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ed_label_descrip = new javax.swing.JLabel();
        ed_text_codError = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ed_comment_aud = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        ed_button_iError = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nombreError = new javax.swing.JLabel();
        resultados = new javax.swing.JCheckBox();
        errorLabo = new javax.swing.JCheckBox();
        jPanel10 = new javax.swing.JPanel();
        ed_button_verAudi = new javax.swing.JButton();
        ed_button_viewError = new javax.swing.JButton();
        ed_button_reg = new javax.swing.JButton();
        ed_button_cancel = new javax.swing.JButton();
        ed_button_audi = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        conError = new javax.swing.JLabel();
        sinError = new javax.swing.JLabel();

        enviarMail.setTitle("Enviar Email");
        enviarMail.setMinimumSize(new java.awt.Dimension(336, 440));
        enviarMail.setResizable(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 255));
        jLabel21.setText("Esta orden contiene resultados");
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel22.setText("Debe Notificar al laboratorio que esta orden contiene errores.");

        jLabel23.setText(" Se enviara el siguiente correo:");

        jLabel24.setText("Para:");

        para.setEditable(false);
        para.setMaximumSize(new java.awt.Dimension(225, 20));
        para.setMinimumSize(new java.awt.Dimension(225, 20));
        para.setPreferredSize(new java.awt.Dimension(225, 20));

        jLabel25.setText("Asunto:");

        asunto.setMaximumSize(new java.awt.Dimension(225, 20));
        asunto.setMinimumSize(new java.awt.Dimension(225, 20));
        asunto.setPreferredSize(new java.awt.Dimension(225, 20));

        jLabel26.setText("Mensaje:");

        mensaje.setEditable(false);
        mensaje.setMaximumSize(new java.awt.Dimension(281, 20));
        mensaje.setMinimumSize(new java.awt.Dimension(281, 20));
        mensaje.setPreferredSize(new java.awt.Dimension(281, 20));
        jScrollPane5.setViewportView(mensaje);

        jButton1.setText("Enviar Correo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar Envio");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout enviarMailLayout = new javax.swing.GroupLayout(enviarMail.getContentPane());
        enviarMail.getContentPane().setLayout(enviarMailLayout);
        enviarMailLayout.setHorizontalGroup(
            enviarMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enviarMailLayout.createSequentialGroup()
                .addGroup(enviarMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(enviarMailLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(enviarMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, enviarMailLayout.createSequentialGroup()
                                .addGroup(enviarMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel24))
                                .addGap(18, 18, 18)
                                .addGroup(enviarMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(asunto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(para, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(enviarMailLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel21))
                    .addGroup(enviarMailLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        enviarMailLayout.setVerticalGroup(
            enviarMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enviarMailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addGroup(enviarMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(para, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(enviarMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(asunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(enviarMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        listaDeOrdenes.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        listaDeOrdenes.setTitle("Lista de Ordenes Auditadas");
        listaDeOrdenes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listaDeOrdenes.setResizable(false);
        listaDeOrdenes.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                listaDeOrdenesWindowClosing(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(60, 117, 207));

        jPanel9.setBackground(new java.awt.Color(47, 63, 79));

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel27))
        );

        jLabel28.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Ordenes Auditadas");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(94, 112, 144));
        jPanel11.setForeground(new java.awt.Color(94, 112, 144));

        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Universidad de El Salvador ©Copyright 2013 ");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarMouseClicked(evt);
            }
        });

        buscar_btn.setText("Buscar");

        table_auditoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Specimen", "Agente", "Tipo", "Hora auditoria", "Comentario Auditor"
            }
        ));
        jScrollPane4.setViewportView(table_auditoria);

        javax.swing.GroupLayout listaDeOrdenesLayout = new javax.swing.GroupLayout(listaDeOrdenes.getContentPane());
        listaDeOrdenes.getContentPane().setLayout(listaDeOrdenesLayout);
        listaDeOrdenesLayout.setHorizontalGroup(
            listaDeOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(listaDeOrdenesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listaDeOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(listaDeOrdenesLayout.createSequentialGroup()
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE))
                .addContainerGap())
        );
        listaDeOrdenesLayout.setVerticalGroup(
            listaDeOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listaDeOrdenesLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(listaDeOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Auditorias -Auditar Ordenes - SIAPO");
        setMinimumSize(new java.awt.Dimension(1032, 681));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
        });

        header.setBackground(new java.awt.Color(60, 117, 207));

        jPanel2.setBackground(new java.awt.Color(47, 63, 79));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText(Integer.toString(c.get(Calendar.DATE))+"-"+Integer.toString(c.get(Calendar.MONTH)+1)+"-"+Integer.toString(c.get(Calendar.YEAR)));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        try{
            jLabel17.setText(this.u.getNombreUsuario()+"-"+this.u.getListaTiposUsuario().get(0).getNombreTipo()+"-"+this.u.getListaTiposUsuario().get(1).getNombreTipo());
        }catch(Exception e){
            jLabel17.setText(this.u.getNombreUsuario()+"-"+this.u.getListaTiposUsuario().get(0).getNombreTipo());
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel13))
        );

        jPanel5.setBackground(new java.awt.Color(94, 112, 144));
        jPanel5.setForeground(new java.awt.Color(94, 112, 144));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Gestión de Auditorias - Auditar Ordenes");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Logo HMCR.jpg"))); // NOI18N

        jButton12.setBackground(new java.awt.Color(60, 117, 207));
        jButton12.setForeground(new java.awt.Color(60, 117, 207));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1378460112_home.png"))); // NOI18N
        jButton12.setBorderPainted(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Menú principal");

        jButton10.setBackground(new java.awt.Color(60, 117, 207));
        jButton10.setForeground(new java.awt.Color(60, 117, 207));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/actualizarRegistroOrden.png"))); // NOI18N
        jButton10.setBorderPainted(false);
        jButton10.setEnabled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Modificar Auditoria");
        jLabel7.setEnabled(false);

        jButton6.setBackground(new java.awt.Color(60, 117, 207));
        jButton6.setForeground(new java.awt.Color(60, 117, 207));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/elimarRegistroOrden.png"))); // NOI18N
        jButton6.setBorderPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Eliminar Auditoria");

        jButton13.setBackground(new java.awt.Color(60, 117, 207));
        jButton13.setForeground(new java.awt.Color(60, 117, 207));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Actions-insert-table-icon.png"))); // NOI18N
        jButton13.setBorderPainted(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Auditar Ordenes");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(headerLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                            .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        footer.setBackground(new java.awt.Color(94, 112, 144));
        footer.setForeground(new java.awt.Color(94, 112, 144));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Universidad de El Salvador ©Copyright 2013 ");

        javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footer);
        footer.setLayout(footerLayout);
        footerLayout.setHorizontalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        footerLayout.setVerticalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Errores ingresados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        ed_table_errores.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ed_table_errores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo de Error", "Nombre de Error", "Descripcion", "Comentario", "errorLab"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ed_table_errores.setEnabled(false);
        ed_table_errores.setGridColor(new java.awt.Color(51, 204, 255));
        jScrollPane2.setViewportView(ed_table_errores);
        if (ed_table_errores.getColumnModel().getColumnCount() > 0) {
            ed_table_errores.getColumnModel().getColumn(0).setPreferredWidth(10);
            ed_table_errores.getColumnModel().getColumn(4).setMinWidth(0);
            ed_table_errores.getColumnModel().getColumn(4).setPreferredWidth(0);
            ed_table_errores.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Orden actual", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        jPanel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Specimen: ");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Agente: ");

        ed_text_specimen.setEditable(false);
        ed_text_specimen.setBackground(new java.awt.Color(255, 255, 255));
        ed_text_specimen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ed_text_specimen.setMaximumSize(new java.awt.Dimension(6, 20));
        ed_text_specimen.setMinimumSize(new java.awt.Dimension(6, 20));
        ed_text_specimen.setPreferredSize(new java.awt.Dimension(6, 20));

        ed_text_agent.setEditable(false);
        ed_text_agent.setBackground(new java.awt.Color(255, 255, 255));
        ed_text_agent.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ed_text_agent.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        ed_text_agent.setMaximumSize(new java.awt.Dimension(80, 30));
        ed_text_agent.setMinimumSize(new java.awt.Dimension(80, 30));
        ed_text_agent.setPreferredSize(new java.awt.Dimension(6, 20));

        ed_text_location.setEditable(false);
        ed_text_location.setBackground(new java.awt.Color(255, 255, 255));
        ed_text_location.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ed_text_location.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        ed_text_location.setMaximumSize(new java.awt.Dimension(80, 30));
        ed_text_location.setMinimumSize(new java.awt.Dimension(80, 30));
        ed_text_location.setPreferredSize(new java.awt.Dimension(6, 20));
        ed_text_location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ed_text_locationActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Tipo Orden: ");

        ed_text_tOrden.setEditable(false);
        ed_text_tOrden.setBackground(new java.awt.Color(255, 255, 255));
        ed_text_tOrden.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ed_text_tOrden.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        ed_text_tOrden.setMaximumSize(new java.awt.Dimension(80, 30));
        ed_text_tOrden.setMinimumSize(new java.awt.Dimension(80, 30));
        ed_text_tOrden.setPreferredSize(new java.awt.Dimension(6, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Location: ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ed_text_specimen, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(ed_text_agent, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ed_text_location, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ed_text_tOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ed_text_specimen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(ed_text_agent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(ed_text_tOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(ed_text_location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        ed_panel_error.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Error en orden", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Codigo error:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Descripcion:");

        ed_label_descrip.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        ed_text_codError.setEnabled(false);
        ed_text_codError.setMaximumSize(new java.awt.Dimension(80, 30));
        ed_text_codError.setMinimumSize(new java.awt.Dimension(80, 30));
        ed_text_codError.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ed_text_codErrorKeyReleased(evt);
            }
        });

        ed_comment_aud.setColumns(20);
        ed_comment_aud.setRows(5);
        ed_comment_aud.setEnabled(false);
        jScrollPane1.setViewportView(ed_comment_aud);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Comentario:");

        ed_button_iError.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        ed_button_iError.setText("Ingresar error");
        ed_button_iError.setEnabled(false);
        ed_button_iError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ed_button_iErrorActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        nombreError.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        resultados.setText("Tiene resultado");
        resultados.setEnabled(false);

        errorLabo.setText("Error de Laboratorio");
        errorLabo.setEnabled(false);

        javax.swing.GroupLayout ed_panel_errorLayout = new javax.swing.GroupLayout(ed_panel_error);
        ed_panel_error.setLayout(ed_panel_errorLayout);
        ed_panel_errorLayout.setHorizontalGroup(
            ed_panel_errorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ed_panel_errorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ed_panel_errorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ed_panel_errorLayout.createSequentialGroup()
                        .addGroup(ed_panel_errorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ed_panel_errorLayout.createSequentialGroup()
                                .addGroup(ed_panel_errorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ed_panel_errorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombreError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(ed_panel_errorLayout.createSequentialGroup()
                                        .addComponent(ed_text_codError, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ed_panel_errorLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ed_panel_errorLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ed_label_descrip, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ed_panel_errorLayout.createSequentialGroup()
                        .addComponent(resultados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(errorLabo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ed_button_iError)
                        .addGap(83, 83, 83))))
        );
        ed_panel_errorLayout.setVerticalGroup(
            ed_panel_errorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ed_panel_errorLayout.createSequentialGroup()
                .addGroup(ed_panel_errorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ed_text_codError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ed_panel_errorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(nombreError, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ed_panel_errorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ed_panel_errorLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addGroup(ed_panel_errorLayout.createSequentialGroup()
                        .addComponent(ed_label_descrip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(ed_panel_errorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ed_panel_errorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ed_button_iError)
                    .addComponent(resultados)
                    .addComponent(errorLabo)))
        );

        ed_button_verAudi.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        ed_button_verAudi.setText("Ver ordenes Auditadas");
        ed_button_verAudi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ed_button_verAudiActionPerformed(evt);
            }
        });

        ed_button_viewError.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        ed_button_viewError.setText("Mostrar código error");
        ed_button_viewError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ed_button_viewErrorActionPerformed(evt);
            }
        });

        ed_button_reg.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        ed_button_reg.setText("Registrar Auditoría");
        ed_button_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ed_button_regActionPerformed(evt);
            }
        });

        ed_button_cancel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        ed_button_cancel.setText("Cancelar Auditoría");
        ed_button_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ed_button_cancelActionPerformed(evt);
            }
        });

        ed_button_audi.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        ed_button_audi.setText("Lista de Auditores");
        ed_button_audi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ed_button_audiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(ed_button_verAudi, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ed_button_viewError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ed_button_reg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ed_button_cancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ed_button_audi)
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ed_button_verAudi)
                    .addComponent(ed_button_viewError)
                    .addComponent(ed_button_reg)
                    .addComponent(ed_button_cancel)
                    .addComponent(ed_button_audi))
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Totales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        jLabel30.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel30.setText("Ordenes Auditadas:");

        jLabel31.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel31.setText("Ordenes con error:");

        jLabel32.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel32.setText("Ordenes sin error:");

        total.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total.setText("0");

        conError.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        conError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        conError.setText("0");

        sinError.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sinError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sinError.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel30)
                .addGap(5, 5, 5)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31)
                .addGap(5, 5, 5)
                .addComponent(conError, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addGap(5, 5, 5)
                .addComponent(sinError, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conError, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sinError, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ed_panel_error, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(75, Short.MAX_VALUE))
            .addComponent(footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ed_panel_error, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ed_button_iErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ed_button_iErrorActionPerformed
        //Este metodo agrega los datos al JTable. Agrega los errores ingresados a la orden
        DefaultTableModel modeloDeLaTabla = (DefaultTableModel) ed_table_errores.getModel();
        //validacion de q ingrese codigos correctos.
        if (ed_text_codError.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "¡Rellene todos los campos!", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            String errorLaboratorio;
            if (errorLabo.isSelected()) {
                errorLaboratorio = "1";
            } else {
                errorLaboratorio = "0";
            }
            Object[] datosFila = {
                ed_text_codError.getText(),
                nombreError.getText(),
                ed_label_descrip.getText(),
                ed_comment_aud.getText(),
                errorLaboratorio,};
            modeloDeLaTabla.addRow(datosFila);
            ed_table_errores.setModel(modeloDeLaTabla);
            ed_text_codError.setText("");
            nombreError.setText("");
            ed_label_descrip.setText("");
            ed_comment_aud.setText("");
        }
    }//GEN-LAST:event_ed_button_iErrorActionPerformed

    private void ed_text_codErrorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ed_text_codErrorKeyReleased
        /*evento que permite la busqueda de codigo de un error y retorna en
         * un Jlabel la aproximacion o codigo que mas se asemeje al que se esta digitando
         */
        int ascii = evt.getKeyCode();
        if (ascii == 10) {
            String texto = ed_text_codError.getText();
            if (texto.isEmpty() || texto.length() < 5) {
                nombreError.setText("");
                ed_label_descrip.setText("");
                ed_text_codError.setText("");
            } else {
                Error error = new Error();
                error = error.buscarError(errores, texto.substring(0, 5));
                if (error != null) {
                    this.nombreError.setText(error.getNombreError());
                    this.ed_label_descrip.setText(error.getDescripcion());
                } else {
                    JOptionPane.showMessageDialog(null, "Codigo no registrado", "", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_ed_text_codErrorKeyReleased

    private void ed_button_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ed_button_regActionPerformed
        /* Metodo que ingresa todos los errores encontrados en una orden, por el auditor hacia la base de datos.*/
        Orden o = new Orden();
        o.setSpecimen(ed_text_specimen.getText());
        if (!o.getSpecimen().isEmpty()) {
            if (o.tieneRegistros()) { //si existe el specimen
                //o.setSpecimen(specAlmacenado);
                if (o.estaAuditada()) {// si ya esta auditada
                    JOptionPane.showMessageDialog(null, "Orden ya auditada si quiere agregar errores vaya a la opcion de modificar auditoria", "Auditoria de Orden", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    if (ingresarAuditoria()) {
                        JOptionPane.showMessageDialog(null, "Registro de auditoria ingresado exitosamente");
                    }
                    actualizarTotales();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No exite el specimen", "Auditoria de Orden", JOptionPane.INFORMATION_MESSAGE);
                //this.limpiarControles();
            }
            inicializarPortapapeles(false);
        } else {
            JOptionPane.showMessageDialog(null, "No hay registro que ingresar", "Auditoria de Orden", JOptionPane.INFORMATION_MESSAGE);
        }

        //primeraVez = true;

    }//GEN-LAST:event_ed_button_regActionPerformed

    public boolean ingresarAuditoria() {
        /* Metodo que ingresa todos los errores encontrados en una orden, por el auditor hacia la base de datos.*/
        String codError, nombreError, nSpecimen, agente, deLab, comentario;
        nSpecimen = ed_text_specimen.getText().trim();
        agente = ed_text_agent.getText();
        boolean exito = true;
        for (int i = 0; i < ed_table_errores.getRowCount(); i++) {
            deLab = ed_table_errores.getValueAt(i, 4).toString().trim();
            codError = ed_table_errores.getValueAt(i, 0).toString().trim().substring(0, 5);
            nombreError = ed_table_errores.getValueAt(i, 1).toString().trim();
            comentario = ed_table_errores.getValueAt(0, 3).toString();
            Orden o;
            //se guarda el comentario hecho por el auditor
            enviarComentarioAud(comentario, nSpecimen);
            if (deLab.equals("1")) {
                //error de laboratorio
                o = new Orden(nSpecimen, true, agente, codError, nombreError);
                exito = o.agregarError(false, comentario);
            } else {
                //error de no laboratorio
                o = new Orden(nSpecimen, false, agente, codError, nombreError);
                exito = o.agregarError(false, comentario);
            }
            
            //50000001
        }
        if (exito) {
            if (u.insertar("procesa_audita", "NULL,'" + u.getUser() + "', '" + nSpecimen + "',CURDATE(),CURTIME(),CURTIME(),2")) {
                //se reinician todos los controles del  frame.
                limpiarTabla(ed_table_errores);
                limpiarControles();
                habilitarControles(false);
                ed_button_verAudi.setEnabled(true);
                ed_button_reg.setEnabled(false);
                ed_button_cancel.setEnabled(false);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo auditar la orden.");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo auditar la orden.");
            return false;
        }
    }

    private void enviarComentarioAud(String texto, String nSpecimen) {
        //El objetivo de este modulo es guardar el comentario hecho por el auditor hacia la orden que se ha auditado
        u.actualizar("orden", "comentarioAuditor='" + texto + "'", "specimen = '" + nSpecimen + "'");
    }

    private void ed_button_verAudiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ed_button_verAudiActionPerformed
        (new Orden()).llenarTablaOrdenesAuditadas(table_auditoria, u.getUser(), "", "");
        listaDeOrdenes.setSize(800, 600);
        listaDeOrdenes.setLocationRelativeTo(null);
        listaDeOrdenes.setVisible(true);
    }//GEN-LAST:event_ed_button_verAudiActionPerformed

    private void ed_button_viewErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ed_button_viewErrorActionPerformed
        // TODO add your handling code here:
        MostrarErrores mo = new MostrarErrores();
        mo.setVisible(true);
    }//GEN-LAST:event_ed_button_viewErrorActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        detenerHilo();
        new MenuPpal(u, false, this.n, this.e).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        detenerHilo();
        new ModificarAuditoria(u, this.n, this.e).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        detenerHilo();
        new EliminarAuditoria(u, this.n, this.e).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
//        new AuditoriaDeOrdenes(u, this.n, this.e).setVisible(true);
//        dispose();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void ed_button_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ed_button_cancelActionPerformed
        // TODO add your handling code here:
         /*este metodo elimina todas los errores ingresados en la JTable
         * y reinicia todos los controles del JFrame para que el auditor comience
         * desde cero la auditoria.
         */
        if (ed_text_specimen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay registro que cancelar");
        } else {
            int i = JOptionPane.showConfirmDialog(null, "¿Esta seguro de continuar?", "Cancelar Auditoria", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                limpiarTabla(ed_table_errores);
                limpiarControles();
                habilitarControles(false);
                u.inicializarPortapapeles("00000000");
                inicializarPortapapeles(true);
                //inicializarPortapapeles(true);
                JOptionPane.showMessageDialog(null, "¡Operacion realizada con exito!");
            }
        }

    }//GEN-LAST:event_ed_button_cancelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (para.getText().equals("") || asunto.getText().equals("") || para.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos", "Error!!!", JOptionPane.ERROR_MESSAGE);
        } else {
            u.setPara(para.getText());
            u.setAsunto(asunto.getText());
            u.setMensaje(mensaje.getText());
            if (u.enviarEmail()) {
                JOptionPane.showMessageDialog(null, "Mensaje enviado!");
                enviarMail.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Por el momento NO SE PUDO ENVIAR el mensaje.");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Recuerde que debe notificar al laboratorio,"
                + "¿Esta seguro que no desea enviar el correo?\n Presione No para volver al envio del correo. presione Si para confirmar.", "Enviar Correo",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (respuesta == 0) {
            enviarMail.setVisible(false);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseClicked
        // TODO add your handling code here:
//        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
//            jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
//        }
    }//GEN-LAST:event_buscarMouseClicked

    private void listaDeOrdenesWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_listaDeOrdenesWindowClosing
        // u.limpiarTabla(listaOrdenes);
    }//GEN-LAST:event_listaDeOrdenesWindowClosing

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_formWindowIconified

    private void ed_text_locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ed_text_locationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ed_text_locationActionPerformed

    private void ed_button_audiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ed_button_audiActionPerformed
        try {
            // TODO add your handling code here:
            /*
             select
             auditor,e.user as agente
             from
             procesa_audita e join (select a.specimen,auditor from procesa_audita a join (select user as auditor,max(idProcAud) as id from procesa_audita c where c.tipooperacion = 2 and fecha = curdate() group by auditor) b on a.idProcAud = b.id) d on d.specimen = e.specimen group by auditor
             */
            String tabla = "";
            ResultSet r;
            r = u.seleccionar("auditor,e.user as agente", "procesa_audita e join "
                    + "(select a.specimen,auditor from procesa_audita a join "
                    + "(select user as auditor,max(idProcAud) as id from procesa_audita c where c.tipooperacion = 2 and fecha = curdate() group by auditor) b "
                    + "on a.idProcAud = b.id) d on d.specimen = e.specimen group by auditor",
                    "");
            r.beforeFirst();
            while (r.next()) {
                tabla = tabla + r.getString("auditor") + " audita a " + r.getString("agente") + "\n";
            }
            JOptionPane.showMessageDialog(this, tabla, "Lista de Auditores / Agentes", JOptionPane.PLAIN_MESSAGE);
            u.cerrarConexionBase();
        } catch (SQLException ex) {
            Logger.getLogger(AuditoriaDeOrdenes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_ed_button_audiActionPerformed

    private boolean recuperarDatosOrden() {
        /*Modulo que tiene por objetivo la recuperacion de los datos basicos de
         * una orden procesada a la cual se le aplicara auditoria.
         */
        boolean fallo = false;
        try {
            ResultSet r;
            r = u.seleccionar("a.user,nombreLocation,comentarioAgente,tipoOrden,horaInicio", "procesa_audita a, orden b, location c",
                    "a.specimen = b.specimen AND c.codigoLocation = b.codigoLocation AND tipoOperacion=1 and a.specimen = '" + this.specAlmacenado + "' limit 1");
            r.first();
            String tipo = "";
            switch (r.getInt("tipoOrden")) {
                case 1:
                    tipo = "Completa";
                    break;
                case 2:
                    tipo = "Incompleta";
                    break;
                case 3:
                    tipo = "Regresada sin hacer nada";
                    break;
            }
            ed_text_tOrden.setText(tipo);
            ed_text_agent.setText(r.getString("user"));
            ed_text_location.setText(r.getString("nombreLocation"));
//            ed_coment_agent.setText(r.getString("comentarioAgente"));
            habilitarControles(true);
            ed_button_reg.setEnabled(true);
            ed_button_cancel.setEnabled(true);
            errorLabo.setEnabled(true);
            resultados.setEnabled(true);
            //ed_button_verAudi.setEnabled(false);
            u.cerrarConexionBase();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un problema al cargar la informacion de la orden", "", JOptionPane.ERROR_MESSAGE);
        }
        return fallo;
    }

    private void habilitarControles(boolean accion) {
        //Este metodo permite habilitar o deshabilitar los componentes del panel Error en Orden      
        this.ed_text_codError.setEnabled(accion);
        this.ed_comment_aud.setEnabled(accion);
        this.ed_button_iError.setEnabled(accion);
    }

    public void inicializarPortapapeles(boolean noConservarN) {

        if (noConservarN) {
            specAlmacenado = "00000000";
            primeraVez = true;
        }
    }

    private void limpiarTabla(JTable tabla) {
        //Metodo que borra todas las filas insertadas en la JTable
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount() - 1;
            for (int i = filas; i >= 0; i--) {
                modelo.removeRow(i);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla." + e);
        }
    }

    private void limpiarControles() {
        this.ed_text_codError.setText("");
        this.ed_label_descrip.setText("");
        this.nombreError.setText("");
        this.ed_comment_aud.setText("");
        this.ed_text_specimen.setText("");
        this.ed_text_tOrden.setText("");
        this.ed_text_agent.setText("");
        this.ed_text_location.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField asunto;
    private javax.swing.JTextField buscar;
    private javax.swing.JToggleButton buscar_btn;
    private javax.swing.JLabel conError;
    private javax.swing.JButton ed_button_audi;
    private javax.swing.JButton ed_button_cancel;
    private javax.swing.JButton ed_button_iError;
    private javax.swing.JButton ed_button_reg;
    private javax.swing.JButton ed_button_verAudi;
    private javax.swing.JButton ed_button_viewError;
    private javax.swing.JTextArea ed_comment_aud;
    private javax.swing.JLabel ed_label_descrip;
    private javax.swing.JPanel ed_panel_error;
    private javax.swing.JTable ed_table_errores;
    private javax.swing.JTextField ed_text_agent;
    private javax.swing.JTextField ed_text_codError;
    private javax.swing.JTextField ed_text_location;
    private javax.swing.JTextField ed_text_specimen;
    private javax.swing.JTextField ed_text_tOrden;
    private javax.swing.JFrame enviarMail;
    private javax.swing.JCheckBox errorLabo;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JFrame listaDeOrdenes;
    private javax.swing.JTextPane mensaje;
    private javax.swing.JLabel nombreError;
    private javax.swing.JTextField para;
    private javax.swing.JCheckBox resultados;
    private javax.swing.JLabel sinError;
    private javax.swing.JTable table_auditoria;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        
        while (!stop) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                ErroresSiapo.agregar(ex, "codigo 37");
                Logger.getLogger(RegistroDeOrdenesProcesadas.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!cancelar) {
                try {
                    String texto = u.obtenerCadenaPortapapeles();
                    if (!texto.equals("")) {
                        // validaciones del numero de specimen
                        if ((texto.length() == 7 || texto.length() == 8) && !texto.equals("00000000")) {
                            if (u.esNumero(texto)) {
                                if (!specAlmacenado.equalsIgnoreCase(texto)) {
                                    // PROCESO DE REGISTRO DE AUDITORIA
                                    Orden o = new Orden();
                                    o.setSpecimen(texto);
                                    specAlmacenado = texto;//actualizamos el specimen almacenado
                                    if (o.tieneRegistros()) { //si existe el specimen                                         
                                        if (!ed_text_specimen.getText().equals(specAlmacenado)) {//que sea diferente al que ya esta almacenado
                                            if (!o.estaAuditada()) {//revisamos que la orden no tenga auditoria
                                                if (!ed_text_specimen.getText().isEmpty()) {//revisamos si el campo del specimen no esta vacio                                               
                                                    ingresarAuditoria();//ingresamos la auditoria para la orden anterior 
                                                    actualizarTotales();//actualizamos los totales
                                                }
                                                trayIcon.displayMessage(specAlmacenado, "Nueva auditoria de specimen", TrayIcon.MessageType.INFO);
                                                ed_text_specimen.setText(specAlmacenado);//nueva orden de auditoria
                                                recuperarDatosOrden();//recuperamos los datos de la orden
                                            } else {// la orden ya esta auditada
                                                //mensaje
                                                trayIcon.displayMessage(texto, "Orden ya auditada", TrayIcon.MessageType.INFO);
                                            }
                                        }
                                    } else {
                                        trayIcon.displayMessage(texto, "No existe el specimen", TrayIcon.MessageType.INFO);
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception ex) {
                    ErroresSiapo.agregar(ex, "codigo 36");
                }
            }
        }
    }

    private void autocompletar() {
        ResultSet r;
        r = u.seleccionar("codigoError,nombreError", "Error", "");
        try {
            r.beforeFirst();
            while (r.next()) {
                codigoErrorAC.addItem(r.getString("codigoError") + " - " + r.getString("nombreError"));
            }
            u.cerrarConexionBase();
        } catch (SQLException ex) {
            Logger.getLogger(ModificarAuditoria.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void detenerHilo() {
        stop = true;
        this.tray.remove(trayIcon);
    }

    public void iconoBarra() {
        if (SystemTray.isSupported()) {
            //tray = SystemTray.getSystemTray();
            //Se asigna la imagen que del tray icon  
            ImageIcon im = new ImageIcon(getClass().getResource("/iconos/Window-Add-icon.png"));
            //Este listener permite salir de la aplicacion  
            ActionListener exitListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    tray.remove(n.getTrayIcon());
                    tray.remove(trayIcon);
                    detenerHilo();
                    System.exit(0);
                }
            };
            //   ActionListener abrirPantalla = new ActionListener() {@Overridepublic void actionPerformed(ActionEvent e) {setVisible(true);}};
            ActionListener detener1 = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cancelar = true;
                    trayIcon.displayMessage("SIAPO - Registro de Ordenes", "Se ha detenido la automatizacion", TrayIcon.MessageType.INFO);
                }
            };
            //Ingresar auditoria
            ActionListener a1 = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ed_button_reg.doClick();
                }
            };
            //cancelar auditoria
            ActionListener a2 = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ed_button_cancel.doClick();
                }
            };
            //ver ordenes auditadas
            ActionListener a3 = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ed_button_verAudi.doClick();
                }
            };
            // Cancelar automatizacion
            ActionListener activar = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cancelar = false;
                    inicializarPortapapeles(false);
                    trayIcon.displayMessage("SIAPO - Registro de Ordenes", "Se ha activado la automatizacion", TrayIcon.MessageType.INFO);
                }
            };
            //Aquí se crea un popup menu  
            PopupMenu popup = new PopupMenu();
            //Se agrega la opción de salir  
            MenuItem defaultItem = new MenuItem("Salir de la aplicacion");
            //MenuItem maximizar = new MenuItem("Mostrar Pantalla");
            MenuItem d = new MenuItem("Detener Automatizacion");
            MenuItem a = new MenuItem("Activar Automatizacion");
            MenuItem ia = new MenuItem("Ingresar auditoria");
            MenuItem ca = new MenuItem("Cancelar auditoria");
            MenuItem va = new MenuItem("Ver ordenes auditadas");
            //Se le asigna al item del popup el listener para salir de la app  
            defaultItem.addActionListener(exitListener);
            d.addActionListener(detener1);
            a.addActionListener(activar);
            ia.addActionListener(a1);
            ca.addActionListener(a2);
            va.addActionListener(a3);
            popup.add(a);
            popup.add(d);
            popup.add(ia);
            popup.add(ca);
            popup.add(va);
            popup.add(defaultItem);
            /*Aqui creamos una instancia del tray icon y asignamos 
             La imagen, el nombre del tray icon y el popup*/
            trayIcon = new TrayIcon(im.getImage(), "SIAPO - Registro de Auditoria", popup);
            /*Creamos un acction listener que se ejecuta cuando le damos 
             doble click al try icon*/
            ActionListener actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(true);

                }
            };// es para mostrar la pantalla de registro
            trayIcon.setImageAutoSize(true);
            trayIcon.addActionListener(actionListener);
            try {
                tray.add(trayIcon);
                //trayIcon.displayMessage("SIAPO - Registro de AuditoriaDeOrdenes", "", TrayIcon.MessageType.INFO);
            } catch (AWTException exe) {
                System.out.println(exe);
            }
        } else {
            System.err.println("El sistema no soporta los iconos en la barra de tareas.");
            System.exit(1);
        }
    }

    public void actualizarTotales() {
        int t[];
        t = (new Orden()).cantidadOrdenesAuditadas(u.getUser(), "a.fecha = curdate()");
        this.total.setText(Integer.toString(t[2]));
        this.sinError.setText(Integer.toString(t[0]));
        this.conError.setText(Integer.toString(t[1]));
        trayIcon.setToolTip("AUDITADAS:" + t[2] + " SIN ERROR:" + t[0] + " CON ERROR:" + t[1]);
    }
}
