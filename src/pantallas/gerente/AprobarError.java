/*  
 * 
 *  Nombre de la clase: AprobarError
 *  Fecha de creacion:
 *  Objetivo: Aprobar, desaprobar o actualizar nuevos errores.
 *  Autor: Carlos Alberto Fuentes Martinez
 * 
 */
package pantallas.gerente;

import pantallas.gerente.ActualizarError;
import clases.Usuario;
import clases.Error;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pantallas.general.MenuPpal;
import pantallas.mensajeria.NotificacionNueva;
import pantallas.mensajeria.errorNuevo;

public final class AprobarError extends javax.swing.JFrame {

    public Calendar c;
    private Usuario u;
    private boolean primeraVez;
    public NotificacionNueva n;
    public errorNuevo e;

    /**
     * **********************INICIO
     * APROBARNUEVOSERRORES**************************
     *
     * @param u
     * @param primeraVez
     * @param n
     * @param e
     */
    public AprobarError(Usuario u, boolean primeraVez, NotificacionNueva n, errorNuevo e) {
        c = Calendar.getInstance();
        this.primeraVez = primeraVez;
        this.u = new Usuario();
        this.u.setUser(u.getUser());
        this.u.setNombreUsuario(u.getNombreUsuario());
        this.u.setListaTiposUsuario(u.getListaTiposUsuario());
        this.e = e;
        this.n = n;
        initComponents();
        if (!primeraVez) {
            jButton6.setVisible(false);
            jLabel14.setVisible(false);
        }
        actualizarListaErrores(false);
        setSize(1024, 680);
        setLocationRelativeTo(null);
    }

    /**
     * **********************FIN APROBARNUEVOSERRORES**************************
     */
    /**
     * ********************INICIO CODIGO GENERADO POR
     * NETBEANS*************************
     */
    /*  Nombre del modulo : initComponents
     *  Objetivo: inicializar todos los componentes del JFrame
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lista = new javax.swing.JFrame();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
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
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        nombreError = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        tipoError = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        codigoError = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        areas = new javax.swing.JComboBox();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaErrores = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        aprobar = new javax.swing.JButton();
        desaprobar = new javax.swing.JButton();
        listaErr = new javax.swing.JButton();
        cancelar1 = new javax.swing.JButton();

        lista.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        lista.setTitle("Lista de Errores");

        jPanel6.setBackground(new java.awt.Color(60, 117, 207));

        jPanel8.setBackground(new java.awt.Color(47, 63, 79));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel18))
        );

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Lista de errores almacenados en el sistema");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Categoria", "Tipo/Area", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(420);
        }

        jPanel11.setBackground(new java.awt.Color(94, 112, 144));
        jPanel11.setForeground(new java.awt.Color(94, 112, 144));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Universidad de El Salvador ©Copyright 2013 ");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout listaLayout = new javax.swing.GroupLayout(lista.getContentPane());
        lista.getContentPane().setLayout(listaLayout);
        listaLayout.setHorizontalGroup(
            listaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(listaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        listaLayout.setVerticalGroup(
            listaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listaLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de errores - Aprobar nuevos errores - SIAPO");
        setBackground(new java.awt.Color(236, 236, 236));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

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
        jLabel2.setText("Gestión de errores - Aprobar nuevos errores ");

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
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1379420499_061.png"))); // NOI18N
        jButton10.setBorderPainted(false);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Aprobar errores");

        jButton6.setBackground(new java.awt.Color(60, 117, 207));
        jButton6.setForeground(new java.awt.Color(60, 117, 207));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1379322872_refresh.png"))); // NOI18N
        jButton6.setBorderPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Actualizar error");

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del error", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Nombre:");

        nombreError.setToolTipText("");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Categoria:");

        tipoError.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GRAVE", "MEDIANO", "LEVE" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Descripción:");

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Codigo:");

        codigoError.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        codigoError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Tipo/Area:");

        areas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DIAGNOSTICO", "DOCTOR", "EXAMENES", "HOSPITAL", "INFORMACION EN LA ORDEN", "MUESTRAS", "PACIENTE", "OTROS" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tipoError, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codigoError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel26)
                            .addGap(37, 37, 37)
                            .addComponent(areas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(codigoError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(tipoError, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(areas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevos errores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        listaErrores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Categoria", "Tipo/Area", "codigoTipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listaErrores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaErroresMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listaErrores);
        if (listaErrores.getColumnModel().getColumnCount() > 0) {
            listaErrores.getColumnModel().getColumn(0).setPreferredWidth(20);
            listaErrores.getColumnModel().getColumn(1).setPreferredWidth(100);
            listaErrores.getColumnModel().getColumn(4).setMinWidth(0);
            listaErrores.getColumnModel().getColumn(4).setPreferredWidth(0);
            listaErrores.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        aprobar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        aprobar.setText("Aprobar");
        aprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aprobarActionPerformed(evt);
            }
        });

        desaprobar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        desaprobar.setText("Desaprobar");
        desaprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desaprobarActionPerformed(evt);
            }
        });

        listaErr.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        listaErr.setText("Lista de errores");
        listaErr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaErrActionPerformed(evt);
            }
        });

        cancelar1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cancelar1.setText("Cancelar operación");
        cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(aprobar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(desaprobar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listaErr, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelar1)
                .addContainerGap(198, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cancelar1)
                        .addComponent(listaErr))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(desaprobar)
                        .addComponent(aprobar)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 247, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * ********************FIN CODIGO GENERADO POR
     * NETBEANS*************************
     */
    /**
     * **********************INICIO
     * aprobarActionPerformed************************** Nombre del modulo:
     * aprobarActionPerformed Objetivo: Realizar las validaciones necesarias en
     * la pantalla para la aprobacion de nuevo error para luego ingresarlo en la
     * Base de Datos.
     */
    private void aprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aprobarActionPerformed
        // TODO add your handling code here:
        if (!codigoError.getText().isEmpty()) {
            if (!nombreError.getText().isEmpty()) {
                try {
                    Error err = new Error();
                    ResultSet r;
                    // r = err.seleccionar("codigoCategoria", "categoriaerror", "nombreCategoria = '" tipoError.getSelectedItem().toString() + "'");
                    err.setCodigoCategoria(this.tipoError.getSelectedIndex() + 1);
                    err.setCodigoTipo(this.areas.getSelectedItem().toString());
                    err.setNombreError(nombreError.getText());
                    err.setDescripcion(jTextArea1.getText());
                    boolean bien = err.actualizar("error", "codigoCategoria=" + err.getCodigoCategoria() + ",nombreError='"
                            + err.getNombreError() + "',descripcionError='" + err.getDescripcion()
                            + "',aprobado =1,codigoTipo=(SELECT codigoTipo FROM tipoerror "
                            + "WHERE nombreTipo='" + err.getCodigoTipo() + "')", "codigoError = '" + codigoError.getText() + "'");
                    if (bien) {
                        actualizarListaErrores(false);
                        /// TIENE Q MANDARSE UN mensaje A LOS AUDITORES Q SE HA APROBADO UN NUEVO ERROR
                        u.notificarAuditor(codigoError.getText(), nombreError.getText());
                        //enviar notificacion a los agentes
                        r = u.seleccionar("user, specimen", "puede_tener", "codigoError='" + codigoError.getText() + "'");
                        r.beforeFirst();
                        while (r.next()) {
                            u.notificarAgente(r.getString("user"),
                                    r.getString("specimen"),
                                    codigoError.getText(),
                                    nombreError.getText(), false);
                        }
                        JOptionPane.showMessageDialog(null, "El error a sido aprobado", "Aprobar nuevo error", JOptionPane.INFORMATION_MESSAGE);
                        limpiar();
                    }else{
                        JOptionPane.showMessageDialog(null, "El error no pudo ser aprobado", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    u.cerrarConexionBase();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El error tiene que tener un nombre", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un error primero", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_aprobarActionPerformed
    /**
     * ********************FIN aprobarActionPerformed*************************
     */
    /**
     * **********************INICIO
     * listaErroresMouseClicked************************** Nombre del modulo:
     * listaErroresMouseClicked Objetivo: Despues de seleccionar un error de la
     * lista despliega los valores del seleccionado.
     */
    private void listaErroresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaErroresMouseClicked
        try {
            ResultSet r;
            String codigo = listaErrores.getValueAt(listaErrores.getSelectedRow(), 0).toString();
            r = u.seleccionar("codigoCategoria,codigoTipo,nombreError,descripcionError", "error", "codigoError like '" + codigo + "'");
            codigoError.setText(codigo);
            nombreError.setText(r.getString("nombreError"));
            tipoError.setSelectedIndex(Integer.parseInt(r.getString("codigoCategoria")) - 1);
            String area = String.valueOf(listaErrores.getValueAt(listaErrores.getSelectedRow(), 3));
            areas.setSelectedItem(area);
            jTextArea1.setText(r.getString("descripcionError"));
            u.getSentencia().close();
            u.cerrarConexionBase();
        } catch (SQLException | NumberFormatException e) {
        }
    }//GEN-LAST:event_listaErroresMouseClicked
    /**
     * ********************FIN
     * listaErroresMouseClicked*************************
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        new ActualizarError(u, this.n, this.e).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed
    /**
     * **********************INICIO
     * listaErrActionPerformed************************** Nombre del modulo:
     * listaErrActionPerformed Objetivo: Despliega la lista de errores
     * almacenados en el sistema.
     */
    private void listaErrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaErrActionPerformed
        // TODO add your handling code here:
        actualizarListaErrores(true);
        lista.setSize(800, 600);
        lista.setLocationRelativeTo(null);
        lista.setVisible(true);
    }//GEN-LAST:event_listaErrActionPerformed
    /**
     * ********************FIN listaErrActionPerformed*************************
     */
    /**
     * **********************INICIO
     * desaprobarActionPerformed************************** Nombre del modulo:
     * listaErrActionPerformed Objetivo: Realizar las validaciones necesarias en
     * la pantalla para la desaprobacion de nuevo error para luego borrarlo de
     * la Base de Datos
     */
    private void desaprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desaprobarActionPerformed
        if (!codigoError.getText().isEmpty()) {
            if (!nombreError.getText().isEmpty()) {
                try {
                    int resulta = JOptionPane.showConfirmDialog(null, "¿Esta seguro? Este error y"
                            + "a no se almacenara mas en el sistema", "Desaprobar nuevo error",
                            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (resulta == JOptionPane.YES_OPTION) {
                        u.borrar("error", "codigoError = '" + codigoError.getText() + "'");
                        u.borrar("puede_tener ", "codigoError='" + codigoError + "'");
                        ((DefaultTableModel) listaErrores.getModel()).removeRow(listaErrores.getRowCount() - 1);
                        actualizarListaErrores(false);
                        JOptionPane.showMessageDialog(null, "Error eliminado exitosamente",
                                "Eliminar error", JOptionPane.INFORMATION_MESSAGE);
                        codigoError.setText("");
                        nombreError.setText("");
                        jTextArea1.setText("");
                        // se envia notificacion a auditores que el error a sido desaprobado
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El error tiene que tener un nombre", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un error primero", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_desaprobarActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (primeraVez) {
            new MenuPpal(u, false, this.n, this.e).setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar1ActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_cancelar1ActionPerformed
    /**
     * ********************FIN
     * desaprobarActionPerformed*************************
     */
    /**
     * **********************INICIO
     * actualizarListaErrores************************** Nombre del modulo:
     * actualizarListaErrores Objetivo: Inicializar y actualizar las listas de
     * errores almacenados y nuevos Parametros: primeraVez(para inicializar las
     * listas) listaAprobados (para saber si es la lsita de aprobados
     *
     * @param listaAprobados o la de nuevos)
     */
    public void actualizarListaErrores(boolean listaAprobados) {
        int i, j, filas, columnas;//i fila j colummna
        JTable t;
        ResultSet r;
        try {
            if (listaAprobados) {
                r = u.seleccionar("count(*) as filas", "error", "aprobado=1");
                filas = Integer.parseInt(r.getString("filas"));
                u.cerrarConexionBase();
                r = u.seleccionar("nombreTipo,nombreCategoria,codigoError,descripcionError,nombreError", "error a "
                        + "inner join categoriaerror b "
                        + "inner join tipoerror c "
                        + "on a.codigoCategoria =b.codigoCategoria and "
                        + "a.codigoTipo = c.codigoTipo and aprobado = 1 order by codigoError asc",
                        "");
                columnas = 5;
                t = this.jTable1;

            } else {
                u.cerrarConexionBase();
                r = u.seleccionar("count(*) as filas", "error", "aprobado=0");
                filas = Integer.parseInt(r.getString("filas"));
                u.cerrarConexionBase();
                r = u.seleccionar("codigoError,nombreError,nombreTipo,nombreCategoria", "error,tipoerror,categoriaerror",
                        "error.codigoTipo = tipoerror.codigoTipo and error.codigoCategoria=categoriaerror.codigoCategoria and aprobado=0 order by codigoError asc");
                columnas = 4;
                t = this.listaErrores;
            }
            if (r.last()) {
                r.first();
                limpiarTabla(t);
                for (i = 0; i < filas; i++) {
                    ((DefaultTableModel) t.getModel()).
                            setRowCount(t.getRowCount() + 1);// agrega filas dinamicamente
                    for (j = 0; j < columnas; j++) {
                        //fila,colummna
                        switch (j) {
                            case 0:
                                t.setValueAt(r.getString("codigoError"), i, j);
                                break;
                            case 1:
                                t.setValueAt(r.getString("nombreError"), i, j);
                                break;
                            case 2:
                                t.setValueAt(r.getString("nombreCategoria"), i, j);
                                break;
                            case 3:
                                t.setValueAt(r.getString("nombreTipo"), i, j);
                                break;
                            case 4:
                                t.setValueAt(r.getString("descripcionError"), i, j);
                                break;
                        }
                    }
                    r.next();
                }
                u.getSentencia().close();
                u.cerrarConexionBase();
            }
        } catch (SQLException | NumberFormatException e) {
        }
    }

    public void limpiar() {
        codigoError.setText("");
        nombreError.setText("");
        tipoError.setSelectedIndex(0);
        jTextArea1.setText("");
    }

    public void limpiarTabla(JTable table) {
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        int filas = table.getRowCount();
        for (int i = 0; filas > i; i++) {
            modelo.removeRow(0);
        }
    }
    /**
     * ********************FIN actualizarListaErrores*************************
     */
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aprobar;
    private javax.swing.JComboBox areas;
    private javax.swing.JButton cancelar1;
    private javax.swing.JLabel codigoError;
    private javax.swing.JButton desaprobar;
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
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JFrame lista;
    private javax.swing.JButton listaErr;
    private javax.swing.JTable listaErrores;
    private javax.swing.JTextField nombreError;
    private javax.swing.JComboBox tipoError;
    // End of variables declaration//GEN-END:variables
}
