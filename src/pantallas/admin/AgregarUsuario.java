/*  
 * 
 *  Nombre de la clase: AgregarUsuario
 *  Fecha de creacion:
 *  Objetivo: obtener los datos necesarios para la creacion de nuevos usuarios.
 *  Autor: Carlos Alberto Fuentes Martinez
 * 
 */
package pantallas.admin;

import clases.Usuario;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import pantallas.general.MenuPpal;
import pantallas.mensajeria.NotificacionNueva;
import pantallas.mensajeria.errorNuevo;

public class AgregarUsuario extends javax.swing.JFrame {

    public Calendar c;
    private Usuario u;
    private boolean foto;//es una variable que indica si al nuevo usuario se le a puesto una foto.
    private boolean correlativo;// es una variable que permite no ingresar este valor a los tipo de usuario gerente y administrador
    public NotificacionNueva n;
    public errorNuevo e;
    /**
     * **********************INICIO AGREGARUSUARIO**************************
     */
    public AgregarUsuario(Usuario u, NotificacionNueva n, errorNuevo e) {
        c = Calendar.getInstance();
        this.u = new Usuario();
        this.u.setUser(u.getUser());
        this.correlativo = true;
        this.u.setUser(u.getUser());
        this.u.setNombreUsuario(u.getNombreUsuario());
        this.u.setListaTiposUsuario(u.getListaTiposUsuario());
        this.e = e;
        this.n = n;
        initComponents();
        setSize(1024, 680);
        setLocationRelativeTo(null);
        u.DNI(correla_carl3);
    }

    /**
     * **********************FIN AGREGARUSUARIO**************************
     */
    /**
     * ********************INICIO CODIGO GENERADO POR NETBEANS*************************
     */
    /*  Nombre del modulo : initComponents
     *  Objetivo: inicializar todos los componentes del JFrame
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbFoto = new javax.swing.JLabel();
        buscarArchivo = new javax.swing.JButton();
        ubicacionArchivo_carl = new javax.swing.JTextField();
        cancelar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        nombre_carl1 = new javax.swing.JTextField();
        apellido_carl1 = new javax.swing.JTextField();
        user_carl1 = new javax.swing.JTextField();
        correla_carl3 = new javax.swing.JTextField();
        userF_carl1 = new javax.swing.JTextField();
        tipoUser_carl1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
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
        jButton13 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        ingresarUsuario_carl = new javax.swing.JButton();
        limpiarCampos_carl = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de usuarios - Crear nuevo usuario - SIAPO");
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

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Foto de usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        lbFoto.setBackground(new java.awt.Color(0, 153, 255));
        lbFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/defaultlarge.gif"))); // NOI18N
        lbFoto.setPreferredSize(new java.awt.Dimension(100, 80));

        buscarArchivo.setText("Buscar Archivo");
        buscarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarArchivoActionPerformed(evt);
            }
        });

        ubicacionArchivo_carl.setEditable(false);

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(ubicacionArchivo_carl)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarArchivo)
                .addGap(47, 47, 47))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(ubicacionArchivo_carl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarArchivo)
                    .addComponent(cancelar))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del nuevo usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Nombre:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Apellido:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Fecha de Ingreso:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Permiso inicial:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("user Filebound:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("user:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("# correlativo en USA:");

        nombre_carl1.setToolTipText("");
        nombre_carl1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombre_carl1KeyTyped(evt);
            }
        });

        apellido_carl1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellido_carl1KeyTyped(evt);
            }
        });

        user_carl1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                user_carl1KeyTyped(evt);
            }
        });

        userF_carl1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userF_carl1KeyTyped(evt);
            }
        });

        tipoUser_carl1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Agente", "Auditor", "Gerente", "Administrador" }));
        tipoUser_carl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoUser_carl1ActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("máximo 8 caracteres");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("máximo 8 caracteres");

        jDateChooser1.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel27))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(apellido_carl1)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(correla_carl3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(tipoUser_carl1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(user_carl1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombre_carl1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(userF_carl1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(24, 24, 24))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(nombre_carl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(apellido_carl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoUser_carl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(user_carl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(7, 7, 7)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(userF_carl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(correla_carl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
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
        jLabel2.setText("Gestión de usuarios - Crear nuevo usuario ");

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
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1378460889_personal-information.png"))); // NOI18N
        jButton10.setBorderPainted(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Actualizar usuario");

        jButton6.setBackground(new java.awt.Color(60, 117, 207));
        jButton6.setForeground(new java.awt.Color(60, 117, 207));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1378462436_004.png"))); // NOI18N
        jButton6.setBorderPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Eliminar usuario");

        jButton13.setBackground(new java.awt.Color(60, 117, 207));
        jButton13.setForeground(new java.awt.Color(60, 117, 207));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1378460637_Add-Male-User.png"))); // NOI18N
        jButton13.setBorderPainted(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Crear nuevo usuario");

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
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 351, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ingresarUsuario_carl.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        ingresarUsuario_carl.setText("Ingresar usuario");
        ingresarUsuario_carl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarUsuario_carlActionPerformed(evt);
            }
        });

        limpiarCampos_carl.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        limpiarCampos_carl.setText("Limpiar campos");
        limpiarCampos_carl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarCampos_carlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(368, 368, 368)
                .addComponent(ingresarUsuario_carl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(limpiarCampos_carl, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ingresarUsuario_carl)
                    .addComponent(limpiarCampos_carl))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * ********************FIN CODIGO GENERADO POR NETBEANS*************************
     */
    /**
     * **********************INICIO
     * ingresarUsuario_carlActionPerformed************************** Nombre del
     * modulo: ingresarUsuario_carlActionPerformed Objetivo: Realizar las
     * validaciones necesarias en la pantalla para el ingreso de un nuevo
     * usuario para despues gracias a la clase Usuario indicarles si puede o no
     * ingresarlo en la Base de Datos.
     */
    private void ingresarUsuario_carlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarUsuario_carlActionPerformed
        Usuario usuario = new Usuario();
        SimpleDateFormat variableFecha = new SimpleDateFormat("dd-MM-yyyy");        
        try {
            String fecha = variableFecha.format(jDateChooser1.getDate());
            if (user_carl1.getText().isEmpty() || userF_carl1.getText().isEmpty()
                    || fecha.isEmpty() || nombre_carl1.getText().isEmpty()
                    || apellido_carl1.getText().isEmpty() || (correla_carl3.getText().isEmpty() && correlativo)) {
                JOptionPane.showMessageDialog(null, "Campo(s) vacio(s)", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                usuario.setUser(user_carl1.getText());
                usuario.setUserFilebound(userF_carl1.getText());
                if (correlativo) {
                    // tienen que ser distintos pero solo si esta inactivo pueden ser iguales a otros usuarios 
                    usuario.setCorrelativoUSA(Integer.parseInt(correla_carl3.getText()));
                }
                usuario.setFechaIngreso(usuario.fechaCorrecta(fecha));// no mayor a la fecha actual ni menor que el año 2008
                usuario.setNombreUsuario(nombre_carl1.getText().substring(0, 1).toUpperCase()
                        + nombre_carl1.getText().substring(1).toLowerCase());//mayusculas primero luego min    
                usuario.setApellido(apellido_carl1.getText().substring(0, 1).toUpperCase()
                        + apellido_carl1.getText().substring(1).toLowerCase());
                //validaciones de usuario
                if (!usuario.validarUsuario(true, correlativo)) {
                    //ENCRIPTANDO CONTRASEÑA
                    usuario.setContraseña(Usuario.encrypt(apellido_carl1.getText().toLowerCase()));
                    usuario.ingresarUsuario();//ingresando el nuevo usuario                     
                    // ingresar tipo de usuario inicial
                    if (tipoUser_carl1.getSelectedItem().toString().equalsIgnoreCase("Agente")) {//es agente
                        usuario.insertar("es(user,codigoTipoUser)", "'" + usuario.getUser() + "',1");
                    } else {
                        if (tipoUser_carl1.getSelectedItem().toString().equalsIgnoreCase("Auditor")) {//es auditor
                            usuario.insertar("es(user,codigoTipoUser)", "'" + usuario.getUser() + "',2");
                        } else {
                            if (tipoUser_carl1.getSelectedItem().toString().equalsIgnoreCase("Gerente")) {//es gerente
                                usuario.insertar("es(user,codigoTipoUser)", "'" + usuario.getUser() + "',3");
                            } else {
                                usuario.insertar("es(user,codigoTipoUser)", "'" + usuario.getUser() + "',4");//es administrador
                            }
                        }
                    }
                    if (this.foto) {// si es verdadero le ingresa la foto
                        usuario.agregarFoto(ubicacionArchivo_carl.getText());
                    }
                    JOptionPane.showMessageDialog(null, "Usuario ingresado exitosamente\nLa contraseña inicial del nuevo usuario es su apellido : " + apellido_carl1.getText().toLowerCase(),
                            "Ingresar usuario", JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fecha Incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
        }
        // validacion de campos vacios

    }//GEN-LAST:event_ingresarUsuario_carlActionPerformed
    /**
     * **********************FIN
     * ingresarUsuario_carlActionPerformed**************************
     */
    /**
     * **********************INICIO
     * buscarArchivoActionPerformed************************** Nombre del modulo:
     * buscarArchivoActionPerformed Objetivo: permite seleccionar un archivo de
     * imagen en formato JPG desde la computadora.
     */
    private void buscarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarArchivoActionPerformed
        JFileChooser dig = new JFileChooser();
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG", "jpg");
        dig.setFileFilter(filtroImagen);
        int option = dig.showOpenDialog(this);
        String file;
        if (option == JFileChooser.APPROVE_OPTION) {
            file = dig.getSelectedFile().getPath();
            ubicacionArchivo_carl.setText(file);
            ImageIcon fot = new ImageIcon(file);
            Icon icono;
            icono = new ImageIcon(fot.getImage().getScaledInstance(lbFoto.getWidth(),
                    lbFoto.getHeight(), Image.SCALE_DEFAULT));
            lbFoto.setIcon(icono);
            this.repaint();
            this.foto = true;
        }
    }//GEN-LAST:event_buscarArchivoActionPerformed
    /**
     * **********************FIN
     * buscarArchivoActionPerformed**************************
     */
    /**
     * **********************INICIO MODULOS DE VALIDACIONES**************
     */
    private void userF_carl1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userF_carl1KeyTyped
        u.soloLetrasMinNum(evt);
    }//GEN-LAST:event_userF_carl1KeyTyped

    private void user_carl1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_user_carl1KeyTyped
        u.soloLetrasMin(evt);
    }//GEN-LAST:event_user_carl1KeyTyped

    private void apellido_carl1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellido_carl1KeyTyped
        u.soloLetras(evt);
    }//GEN-LAST:event_apellido_carl1KeyTyped

    private void nombre_carl1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre_carl1KeyTyped
        u.soloLetras(evt);

    }//GEN-LAST:event_nombre_carl1KeyTyped
    /**
     * **********************FIN MODULOS DE
     * VALIDACIONES**************************
     */
    /**
     * **********************INICIO
     * limpiarCampos_carlActionPerformed**************************
     */
    private void limpiarCampos_carlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarCampos_carlActionPerformed
        limpiar();
    }//GEN-LAST:event_limpiarCampos_carlActionPerformed
    /**
     * **********************FIN
     * limpiarCampos_carlActionPerformed**************************
     */
    public void limpiar() {

        user_carl1.setText("");
        userF_carl1.setText("");
        correla_carl3.setText("");
        nombre_carl1.setText("");
        apellido_carl1.setText("");
        jDateChooser1.setCalendar(null);
        ubicacionArchivo_carl.setText("");
        tipoUser_carl1.setSelectedIndex(0);
        lbFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/defaultlarge.gif")));
    }

    /**
     * **********************INICIO DE OPCIONES DE
     * MENU**************************
     */
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        new ActualizarUsuario(u,this.n,this.e).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        new EliminarUsuario(u,this.n,this.e).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        new AgregarUsuario(u,this.n,this.e).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton13ActionPerformed
    /**
     * **********************FIN DE OPCIONES DE MENU**************************
     */
    /**
     * **********************INICIO
     * tipoUser_carl1ActionPerformed************************** Nombre del
     * modulo: tipoUser_carl1ActionPerformed Objetivo: cuando seleccione el tipo
     * de usuario y sea Gerente o Administrador bloquea el campo correla_carl3
     * ya que no es necesario ademas de "decir" que el nuevo usuario no lo
     * necesita.
     */
    private void tipoUser_carl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoUser_carl1ActionPerformed
        correla_carl3.setEditable(true);
        correlativo = true;
        if (tipoUser_carl1.getSelectedItem().toString().equalsIgnoreCase("Gerente")
                || tipoUser_carl1.getSelectedItem().toString().equalsIgnoreCase("Administrador")) {
            correla_carl3.setEditable(false);
            correlativo = false;
        }
    }//GEN-LAST:event_tipoUser_carl1ActionPerformed
    /**
     * **********************FIN
     * tipoUser_carl1ActionPerformed**************************
     */
    /**
     * **********************INICIO
     * cancelarActionPerformed************************** Nombre del modulo:
     * cancelarActionPerformed Objetivo: dejar la imagen por default para la
     * foto de usuario.
     */
    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        lbFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/defaultlarge.gif")));
        ubicacionArchivo_carl.setText("");
        foto = false;
    }//GEN-LAST:event_cancelarActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        new MenuPpal(u,false,this.n,this.e).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton12ActionPerformed
    /**
     * **********************FIN
     * cancelarActionPerformed**************************
     */
    /**
     *
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido_carl1;
    private javax.swing.JButton buscarArchivo;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField correla_carl3;
    private javax.swing.JButton ingresarUsuario_carl;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbFoto;
    private javax.swing.JButton limpiarCampos_carl;
    private javax.swing.JTextField nombre_carl1;
    private javax.swing.JComboBox tipoUser_carl1;
    private javax.swing.JTextField ubicacionArchivo_carl;
    private javax.swing.JTextField userF_carl1;
    private javax.swing.JTextField user_carl1;
    // End of variables declaration//GEN-END:variables
}
