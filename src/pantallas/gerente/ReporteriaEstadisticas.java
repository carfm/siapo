package pantallas.gerente;

import clases.ErroresSiapo;
import clases.Reporte;
import clases.Usuario;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import net.sf.jasperreports.view.JasperViewer;
import pantallas.general.MenuPpal;
import pantallas.mensajeria.NotificacionNueva;
import pantallas.mensajeria.errorNuevo;

public class ReporteriaEstadisticas extends javax.swing.JFrame {

    String q;
    ButtonGroup g = new ButtonGroup();
    public Calendar c;
    private Usuario u;
    public NotificacionNueva n;
    public errorNuevo e;
    public int valorBarra;
    Thread hiloCargando, hiloEjecutando;
    private long inicioDeEnvio;
    private long finDeEnvio;

    public ReporteriaEstadisticas(Usuario u, NotificacionNueva n, errorNuevo e) {
        c = Calendar.getInstance();
        this.u = new Usuario();
        this.u.setUser(u.getUser());
        this.u.setUser(u.getUser());
        this.u.setNombreUsuario(u.getNombreUsuario());
        this.u.setListaTiposUsuario(u.getListaTiposUsuario());
        this.e = e;
        this.n = n;
        //g.add(rb_mensual);
        //g.add(rb_quincenal);
        //g.add(rb_diario);
        // this.add(g);
        initComponents();
        setSize(1024, 680);
        setLocationRelativeTo(null);
        cargando.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        randon = new javax.swing.ButtonGroup();
        randon2 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        listaTipoReporte = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        inicio = new com.toedter.calendar.JDateChooser();
        jLabel26 = new javax.swing.JLabel();
        fin = new com.toedter.calendar.JDateChooser();
        jPanel6 = new javax.swing.JPanel();
        rb_diario = new javax.swing.JRadioButton();
        rb_quincenal = new javax.swing.JRadioButton();
        rb_mensual = new javax.swing.JRadioButton();
        mes2 = new javax.swing.JLabel();
        cb_mes = new javax.swing.JComboBox();
        usuario2 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        individual = new javax.swing.JCheckBox();
        dia = new com.toedter.calendar.JDateChooser();
        jLabel28 = new javax.swing.JLabel();
        primera = new javax.swing.JRadioButton();
        segunda = new javax.swing.JRadioButton();
        jLabel27 = new javax.swing.JLabel();
        reporte = new javax.swing.JComboBox();
        cargando = new javax.swing.JLabel();
        crearReporte = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reporteria y Estadisticas - Generacion de Reportes - SIAPO");
        setBackground(new java.awt.Color(236, 236, 236));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(94, 112, 144));
        jPanel4.setForeground(new java.awt.Color(94, 112, 144));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Universidad de El Salvador ©Copyright 2013 ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(60, 117, 207));

        jPanel2.setBackground(new java.awt.Color(47, 63, 79));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));

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
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jLabel12))
        );

        jPanel3.setBackground(new java.awt.Color(94, 112, 144));
        jPanel3.setForeground(new java.awt.Color(94, 112, 144));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Reporteria y Estadisticas - Generacion de Reportes ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Logo HMCR.jpg"))); // NOI18N

        jButton12.setBackground(new java.awt.Color(60, 117, 207));
        jButton12.setForeground(new java.awt.Color(60, 117, 207));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1378460112_home.png"))); // NOI18N
        jButton12.setBorderPainted(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Menú principal");

        jButton10.setBackground(new java.awt.Color(60, 117, 207));
        jButton10.setForeground(new java.awt.Color(60, 117, 207));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/custom-reports-icon.png"))); // NOI18N
        jButton10.setBorderPainted(false);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Generar Reportes");

        jButton6.setBackground(new java.awt.Color(60, 117, 207));
        jButton6.setForeground(new java.awt.Color(60, 117, 207));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/estadisticas.png"))); // NOI18N
        jButton6.setBorderPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Graficos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Generar nuevo Reporte", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Tipo de reporte:");

        listaTipoReporte.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ordenes Procesadas", "Ordenes Auditadas", "Errores encontrados", "Analisis de Eficiencia", "Razones de Envio" }));
        listaTipoReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaTipoReporteActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Reporte por rango de fechas"));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Fecha inicio:");

        inicio.setDateFormatString("dd-MM-yyyy");
        inicio.setEnabled(false);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Fecha fin:");

        fin.setDateFormatString("dd-MM-yyyy");
        fin.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fin, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Reporte Predeterminado"));

        randon.add(rb_diario);
        rb_diario.setText("diario");
        rb_diario.setEnabled(false);
        rb_diario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_diarioActionPerformed(evt);
            }
        });

        randon.add(rb_quincenal);
        rb_quincenal.setText("quincenal");
        rb_quincenal.setEnabled(false);
        rb_quincenal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_quincenalActionPerformed(evt);
            }
        });

        randon.add(rb_mensual);
        rb_mensual.setText("mensual");
        rb_mensual.setEnabled(false);
        rb_mensual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_mensualActionPerformed(evt);
            }
        });

        mes2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mes2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mes2.setText("Mes:");

        cb_mes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        cb_mes.setEnabled(false);

        usuario2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        usuario2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        usuario2.setText("Usuario:");

        usuario.setEnabled(false);

        individual.setText("Individual");
        individual.setEnabled(false);

        dia.setDateFormatString("dd-MM-yyyy");
        dia.setEnabled(false);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Dia:");

        randon2.add(primera);
        primera.setText("Primera Quincena");
        primera.setEnabled(false);

        randon2.add(segunda);
        segunda.setText("Segunda Quincena");
        segunda.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(mes2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_mes, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(individual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(primera)
                        .addGap(8, 8, 8)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(segunda)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(usuario2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(rb_diario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_quincenal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_mensual)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb_mensual)
                    .addComponent(rb_diario)
                    .addComponent(rb_quincenal))
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(primera)
                        .addComponent(segunda)))
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(usuario2)
                        .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(individual))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mes2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Reporte:");

        reporte.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Predeterminado", "Rango de fechas" }));
        reporte.setEnabled(false);
        reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteActionPerformed(evt);
            }
        });

        cargando.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/loading.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(listaTipoReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(110, 110, 110))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cargando)
                .addGap(215, 215, 215))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listaTipoReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cargando)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        crearReporte.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        crearReporte.setText("Crear Reporte");
        crearReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearReporteActionPerformed(evt);
            }
        });

        cancelar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cancelar.setText("Cancelar Operacion");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(273, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(crearReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelar)
                        .addGap(352, 352, 352))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(258, 258, 258))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearReporte)
                    .addComponent(cancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        new MenuPpal(u, false, this.n, this.e).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        new GenerarGraficas(u, n, e, false).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void listaTipoReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaTipoReporteActionPerformed
        // TODO add your handling code here:
        this.listaTipoReporte.setEnabled(false);
        this.reporte.setEnabled(true);
    }//GEN-LAST:event_listaTipoReporteActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        desabilitarPredeterminados();
        desabilitarFechas();
        desabilitarRadioButtons();
        reporte.setEnabled(false);
        this.listaTipoReporte.setEnabled(true);
    }//GEN-LAST:event_cancelarActionPerformed

    private void reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteActionPerformed
        // TODO add your handling code here:
        desabilitarPredeterminados();
        desabilitarFechas();
        desabilitarRadioButtons();
        switch (this.reporte.getSelectedIndex()) {
            case 0:
                if (this.listaTipoReporte.getSelectedIndex() != 3) {
                    habilitarPredeterminados();
                    if (this.listaTipoReporte.getSelectedIndex() == 2) {
                        this.rb_quincenal.setEnabled(false);
                    }
                } else {
//                    this.cb_año.setEnabled(true);
                    this.cb_mes.setEnabled(true);
                }
                break;
            case 1:
                habilitarFechas();
                break;
        }

    }//GEN-LAST:event_reporteActionPerformed

    private void rb_diarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_diarioActionPerformed
        // TODO add your handling code here:
        desabilitarPredeterminados();
        if (!(this.listaTipoReporte.getSelectedIndex() == 0 || this.listaTipoReporte.getSelectedIndex() == 1)) {
            this.individual.setEnabled(true);
            usuario.setEnabled(true);
        }
        this.dia.setEnabled(true);
    }//GEN-LAST:event_rb_diarioActionPerformed

    private void rb_quincenalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_quincenalActionPerformed
        // TODO add your handling code here:
        desabilitarPredeterminados();
        primera.setEnabled(true);
        segunda.setEnabled(true);
        //       this.cb_año.setEnabled(true);
        this.cb_mes.setEnabled(true);
    }//GEN-LAST:event_rb_quincenalActionPerformed

    private void rb_mensualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_mensualActionPerformed
        // TODO add your handling code here:
        desabilitarPredeterminados();
//        this.cb_año.setEnabled(true);
        this.cb_mes.setEnabled(true);
    }//GEN-LAST:event_rb_mensualActionPerformed

    private void crearReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearReporteActionPerformed
        botonDeGenerar();
        iconParpadeoDeEnvio();
    }//GEN-LAST:event_crearReporteActionPerformed

    public void habilitarFechas() {
        this.inicio.setEnabled(true);
        this.fin.setEnabled(true);
    }

    public void desabilitarFechas() {
        this.inicio.setEnabled(false);
        this.dia.setCalendar(null);
        inicio.setCalendar(null);
        fin.setCalendar(null);
        this.fin.setEnabled(false);
    }

    public void habilitarPredeterminados() {
        this.rb_diario.setEnabled(true);
        this.rb_mensual.setEnabled(true);
        this.rb_quincenal.setEnabled(true);
    }

    public void desabilitarPredeterminados() {
        dia.setEnabled(false);
        cb_mes.setEnabled(false);
        this.randon2.clearSelection();
        primera.setEnabled(false);
        segunda.setEnabled(false);
        individual.setSelected(false);
        this.individual.setEnabled(false);
        this.usuario.setText("");
        this.usuario.setEnabled(false);
        this.dia.setEnabled(false);
    }

    public void desabilitarRadioButtons() {
        this.rb_diario.setEnabled(false);
        this.rb_mensual.setEnabled(false);
        this.rb_quincenal.setEnabled(false);
        this.randon.clearSelection();
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

    public String mes(int mes) {
        switch (mes) {
            case 1:
                return "Enero";
            case 2:
                return "Febrero";
            case 3:
                return "Marzo";
            case 4:
                return "Abril";
            case 5:
                return "Mayo";
            case 6:
                return "Junio";
            case 7:
                return "Julio";
            case 8:
                return "Agosto";
            case 9:
                return "Septiembre";
            case 10:
                return "Octubre";
            case 11:
                return "Noviembre";
            case 12:
                return "Diciembre";
        }
        return "";
    }
    /**
     * **********************FIN
     * cancelarActionPerformed**************************
     */
    /**
     *
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel cargando;
    private javax.swing.JComboBox cb_mes;
    private javax.swing.JButton crearReporte;
    private com.toedter.calendar.JDateChooser dia;
    private com.toedter.calendar.JDateChooser fin;
    private javax.swing.JCheckBox individual;
    private com.toedter.calendar.JDateChooser inicio;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JComboBox listaTipoReporte;
    private javax.swing.JLabel mes2;
    private javax.swing.JRadioButton primera;
    private javax.swing.ButtonGroup randon;
    private javax.swing.ButtonGroup randon2;
    private javax.swing.JRadioButton rb_diario;
    private javax.swing.JRadioButton rb_mensual;
    private javax.swing.JRadioButton rb_quincenal;
    private javax.swing.JComboBox reporte;
    private javax.swing.JRadioButton segunda;
    private javax.swing.JTextField usuario;
    private javax.swing.JLabel usuario2;
    // End of variables declaration//GEN-END:variables

    

    private void crearReporte() {
        medirTiempoDeEnvio();
        SimpleDateFormat variableFecha = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        String dia = String.valueOf(cal.get(cal.DATE));
        String mes = String.valueOf(cal.get(cal.MONTH) + 1);
        String año = String.valueOf(cal.get(cal.YEAR));
        String fechainicio;
        String fechafin;
        Map parametro = new HashMap();
        cargando.setVisible(true);
        try {
            JasperViewer v;
            switch (listaTipoReporte.getSelectedIndex()) {
                case 0:
                    if (rb_diario.isSelected() || this.reporte.getSelectedIndex() == 1) {
                        if (this.reporte.getSelectedIndex() == 1) {
                            fechafin = u.fechaCorrecta(variableFecha.format(this.fin.getDate()));
                            fechainicio = u.fechaCorrecta(variableFecha.format(this.inicio.getDate()));
                            parametro.put("fecha",fechainicio+" al "+fechafin);
                        } else {
                            fechainicio = u.fechaCorrecta(variableFecha.format(this.dia.getDate()));
                            fechafin = fechainicio;
                            parametro.put("fecha"," dia "+fechainicio);
                        }
                        
                        String p = "('" + fechainicio + "','" + fechafin + "')";
                        if (u.ejecutarSP(p, "ordenes_procesadas_diarias")) {
                            v = u.runReporte("reporte_ordenes_procesadas_diario", parametro);
                            v.setTitle("Reporte de ordenes procesadas");
                            v.setVisible(true);
                        } else {
                            System.out.println("mal");
                        }
                    } else {
                        int mess = cb_mes.getSelectedIndex();
                        mess = mess + 1;
                        if (rb_mensual.isSelected()) {
                            int dia2 = numero(mess);
                            String fechanueva1 = año + "-" + mess + "-" + "01";
                            String fechai1 = año + "-" + mess + "-" + "15";
                            String fechai2 = año + "-" + mess + "-" + "16";
                            String fechaf1 = año + "-" + mess + "-" + dia2;
                            //-----------------------------     ojo son 4 fechas finico-ffinal1 y  fechafinal2 -a fechafinal2
                            // String fechainicio = u.fechaCorrecta(variableFecha.format(jDateChooser1.getDate()));
                            //  String f = u.fechaCorrecta(variableFecha.format(jDateChooser2.getDate()));
                            //  String fechafin =fechainicio;
                            String p = "('" + fechanueva1 + "','" + fechai1 + "','" + fechai2 + "','" + fechaf1 + "')";
                            if (u.ejecutarSP(p, "ordenes_procesadas_mensual")) {
                                v = u.runReporte("reporte_ordenes_procesadas_mensual", parametro);
                                v.setTitle("Reporte mensual de ordenes procesadas");
                                v.setVisible(true);
                            } else {
                                System.out.println("mal");
                            }
                        } else {
                            Reporte r = new Reporte();
                            String nombreReporte = "";
                            if (this.primera.isSelected()) {
                                r.reporteQuincena(Integer.toString(mess), "2014", 1);
                                parametro.put("periodo", "De la primera quincena del mes de " + mes(mess));
                                nombreReporte = "procesadasQuincena";
                            } else {
                                if (this.segunda.isSelected()) {
                                    r.reporteQuincena(Integer.toString(mess), "2014", 2);
                                    parametro.put("periodo", "De la segunda quincena del mes de " + mes(mess));
                                    nombreReporte = "procesadasQuincenaSegunda";
                                }
                            }
                            v = u.runReporte(nombreReporte, parametro);
                            v.setTitle("Reporte quincenal de ordenes procesadas");
                            v.setVisible(true);
                            u.ejecutarSQL("DROP TABLE IF EXISTS temporal1");
                        }
                    }
                    break;
                case 1:
                    //RordeAuditada
                    if (rb_mensual.isSelected()) {
                        int mess = cb_mes.getSelectedIndex();
                        mess = mess + 1;
                        int dia2 = numero(mess);
                        String fechanueva = año + "-" + mess + "-" + "01"; //calcular el anho
                        String fechai = año + "-" + mess + "-" + "15";
                        String fechaf = año + "-" + mess + "-" + dia2;
                        String p1 = "('" + fechanueva + "','" + fechai + "','" + fechaf + "')";
                        if (u.ejecutarSP(p1, "Raudita_mensual")) {
                            parametro.put("fecha", fechanueva);
                            parametro.put("fecha_p", fechai);
                            parametro.put("fecha_s", fechaf);
                            parametro.put("año", año);
                            parametro.put("mes", mes);
                            v = u.runReporte("report7", parametro);
                            v.setTitle("Reporte mensual de ordenes auditadas");
                            v.setVisible(true);
                        } else {
                            System.out.println("mal");
                        }

                    }
                    if (rb_diario.isSelected() || this.reporte.getSelectedIndex() == 1) {
                        if (this.reporte.getSelectedIndex() == 1) {
                            fechafin = u.fechaCorrecta(variableFecha.format(this.fin.getDate()));
                            fechainicio = u.fechaCorrecta(variableFecha.format(this.inicio.getDate()));
                        } else {
                            fechainicio = u.fechaCorrecta(variableFecha.format(this.dia.getDate()));
                            fechafin = fechainicio;
                            parametro.put("fecha1", "Del dia " + fechainicio);
                        }
                        String p = "('" + fechainicio + "','" + fechafin + "')";
                        if (u.ejecutarSP(p, "reporteJoel")) {
                            v = u.runReporte("RordeAuditada", parametro);
                            v.setTitle("Reporte diario de ordenes auditadas");
                            v.setVisible(true);
                        } else {
                            System.out.println("mal");
                        }
                    }
                    if (rb_quincenal.isSelected()) {
                        int mess = cb_mes.getSelectedIndex();
                        mess = mess + 1;
                        String ms = mes(mess);
                        if (this.primera.isSelected()) {
                            q = "Primera";
                            String p = "('" + (año + "-" + mess + "-" + "01") + "','" + (año + "-" + mess + "-" + "02") + "','" + (año + "-" + mess + "-" + "03") + "','" + (año + "-" + mess + "-" + "04") + "','" + (año + "-" + mess + "-" + "05") + "','" + (año + "-" + mess + "-" + "06") + "','" + (año + "-" + mess + "-" + "07") + "','" + (año + "-" + mess + "-" + "08") + "','" + (año + "-" + mess + "-" + "09") + "','" + (año + "-" + mess + "-" + "10") + "','" + (año + "-" + mess + "-" + "01") + "','" + (año + "-" + mess + "-" + "11") + "','" + (año + "-" + mess + "-" + "12") + "','" + (año + "-" + mess + "-" + "13") + "','" + (año + "-" + mess + "-" + "14") + "','" + (año + "-" + mess + "-" + "15") + "')";
                            if (u.ejecutarSP(p, "Rauditada_quincenal")) {
                                parametro.put("d1", ms);
                                parametro.put("d2", año);
                                parametro.put("q", q);
                                v = u.runReporte("Raudita_quincenal", parametro);
                                v.setTitle("Reporte quincenal de ordenes auditadas");
                                v.setVisible(true);
                            } else {
                                System.out.println("mal");
                            }
                        } else {
                            if (this.segunda.isSelected()) {
                                q = "Segunda";
                                if (mess == 2) {
                                    String p = "('" + (año + "-" + mess + "-" + "16") + "','" + (año + "-" + mess + "-" + "17") + "','" + (año + "-" + mess + "-" + "18") + "','" + (año + "-" + mess + "-" + "19") + "','" + (año + "-" + mess + "-" + "20") + "','" + (año + "-" + mess + "-" + "21") + "','" + (año + "-" + mess + "-" + "22") + "','" + (año + "-" + mess + "-" + "23") + "','" + (año + "-" + mess + "-" + "24") + "','" + (año + "-" + mess + "-" + "25") + "','" + (año + "-" + mess + "-" + "16") + "','" + (año + "-" + mess + "-" + "26") + "','" + (año + "-" + mess + "-" + "27") + "','" + (año + "-" + mess + "-" + "28") + "','" + (año + "-" + mess + "-" + "28") + "','" + (año + "-" + mess + "-" + "28") + "')";
                                    if (u.ejecutarSP(p, "Rauditada_quincenal")) {

                                        parametro.put("d1", ms);
                                        parametro.put("d2", año);

                                        parametro.put("q", q);
                                        v = u.runReporte("Raudita_quincenal", parametro);
                                        v.setTitle("Reporte quincenal de ordenes auditadas");
                                        v.setVisible(true);
                                    } else {
                                        System.out.println("mal");
                                    }
                                } else {
                                    String p = "('" + (año + "-" + mess + "-" + "16") + "','" + (año + "-" + mess + "-" + "17") + "','" + (año + "-" + mess + "-" + "18") + "','" + (año + "-" + mess + "-" + "19") + "','" + (año + "-" + mess + "-" + "20") + "','" + (año + "-" + mess + "-" + "21") + "','" + (año + "-" + mess + "-" + "22") + "','" + (año + "-" + mess + "-" + "23") + "','" + (año + "-" + mess + "-" + "24") + "','" + (año + "-" + mess + "-" + "25") + "','" + (año + "-" + mess + "-" + "16") + "','" + (año + "-" + mess + "-" + "26") + "','" + (año + "-" + mess + "-" + "27") + "','" + (año + "-" + mess + "-" + "28") + "','" + (año + "-" + mess + "-" + "29") + "','" + (año + "-" + mess + "-" + "30") + "')";
                                    if (u.ejecutarSP(p, "Rauditada_quincenal")) {
                                        parametro.put("d1", ms);
                                        parametro.put("d2", año);
                                        parametro.put("q", q);
                                        v = u.runReporte("Raudita_quincenal", parametro);
                                        v.setTitle("Reporte quincenal de ordenes auditadas");
                                        v.setVisible(true);
                                    } else {
                                        System.out.println("mal");
                                    }

                                }
                            }
                        }
                    }
                    break;
                case 2:
                    try {
                        fechainicio = u.fechaCorrecta(variableFecha.format(this.inicio.getDate()));
                        fechafin = u.fechaCorrecta(variableFecha.format(this.fin.getDate()));
                        parametro.put("fechaInicio", fechainicio);
                        parametro.put("fechaFin", fechafin);
                        v = u.runReporte("reporte_errores_diarios", parametro);
                        v.setTitle("Reporte de Errores");
                        v.setVisible(true);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "No se pudo generar el reporte", "Reporte", JOptionPane.ERROR_MESSAGE);
                        ErroresSiapo.agregar(ex, "codigo 39");
                    }
//                    int mess = cb_mes.getSelectedIndex();
//                    if (rb_mensual.isSelected()) {
//                        mess = mess + 1;
//                        int dia2 = numero(mess);
//                        String fechanueva11 = año + "-" + mess + "-" + "01";
//                        String fechaf11 = año + "-" + mess + "-" + dia2;
//                        ///-------------  ojo fechas 1 enero -31 de enero user_agent
//                        String p = "('" + fechanueva11 + "','" + fechaf11 + "')";
//                        if (u.ejecutarSP(p, "errores_globales_anual")) {
//                            v = u.runReporte("reporte_errores_mensual", parametro);
//                            v.setTitle("Reporte de errores mensuales");
//                            v.setVisible(true);
//                        } else {
//                            System.out.println("mal");
//                        }
//                    } else {
//                        if (rb_diario.isSelected()) {
//
//                            if (usuario.getText().isEmpty()) {
//                                JOptionPane.showMessageDialog(null, "Ingrese Usuario tipo Agente", "Error", JOptionPane.ERROR_MESSAGE);
//                            } else {
//                                parametro.put("periodo", "el dia ");
//                                parametro.put("user_agent", usuario.getText());
//                                v = u.runReporte("reporte_errores_diarios", parametro);
//                                v.setTitle("Reporte diario de errores");
//                                v.setVisible(true);
//                            }
//                        }
//                    }
                    break;
                case 3:
                    
                    if (this.reporte.getSelectedIndex() == 1) {
                        fechafin = u.fechaCorrecta(variableFecha.format(this.fin.getDate()));
                        fechainicio = u.fechaCorrecta(variableFecha.format(this.inicio.getDate()));
                        parametro.put("PERIODO", "Del " + u.fechaReves(fechainicio) + " al " + u.fechaReves(fechafin));
                    } else {
                        String m = Integer.toString(this.cb_mes.getSelectedIndex() + 1);
                        fechafin = año + "-" + m + "-" + numero(this.cb_mes.getSelectedIndex() + 1);
                        fechainicio = año + "-" + m + "-01";
                        parametro.put("PERIODO", "Del mes de " + mes(this.cb_mes.getSelectedIndex() + 1) + " del año " + año);
                    }
                    String p = "('" + fechainicio + "','" + fechafin + "')";
                    if (u.ejecutarSP(p, "ERRORES")) {
                        v = u.runReporte("analisisDeEficiencia", parametro);
                        v.setTitle("Reporte de Analisis de Eficiencia");
                        v.setVisible(true);
                    } else {
                        ErroresSiapo.agregar(null, "codigo 39");
                        System.out.println("mal");
                    }
                    break;
                case 4:                   
                    try {
                        fechainicio = u.fechaCorrecta(variableFecha.format(this.inicio.getDate()));
                        fechafin = u.fechaCorrecta(variableFecha.format(this.fin.getDate()));
                        parametro.put("fecha", fechainicio);
                        parametro.put("fechaFin", fechafin);
                        v = u.runReporte("reporteDiarioOrdenesRegreso", parametro);
                        v.setTitle("Reporte de Razones");
                        v.setVisible(true);
                    } catch (Exception e) {
                        ErroresSiapo.agregar(e, "codigo 38");
                        JOptionPane.showMessageDialog(null, "No se pudo generar el reporte", "Reporte", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
            }
        } catch (Exception e) {
        }

    }

    private void medirTiempoDeEnvio() {
        inicioDeEnvio = System.currentTimeMillis();
        finDeEnvio = System.currentTimeMillis();
    }

    private void botonDeGenerar() {
        if (hiloEjecutando == null) {
            hiloEjecutando = new Thread(new Runnable() {
                @Override
                public void run() {
                    crearGrafica();
                    hiloEjecutando = null;
                    hiloCargando = null;
                }
            });
            hiloEjecutando.start();
        }
    }   
    private void crearGrafica() {
        medirTiempoDeEnvio();
        crearReporte();
        cargando.setVisible(false);
    }
    private void iconParpadeoDeEnvio() {
        cargando.setVisible(true);
        if (hiloCargando == null) {
            hiloCargando = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("inicio" + inicioDeEnvio + "\nFIN" + finDeEnvio);
                    while (inicioDeEnvio > finDeEnvio) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(GenerarGraficas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (hiloCargando.isAlive()) {
                        hiloCargando.stop();
                    }
                    hiloCargando = null;
                    cargando.setVisible(false);
                }
            });
            hiloCargando.start();
        }
    }
}
