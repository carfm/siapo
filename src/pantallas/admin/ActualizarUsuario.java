package pantallas.admin;

import clases.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import pantallas.general.MenuPpal;
import pantallas.mensajeria.NotificacionNueva;
import pantallas.mensajeria.errorNuevo;

public final class ActualizarUsuario extends javax.swing.JFrame {

    public Calendar c;
    private Usuario u;
    private boolean foto;
    public NotificacionNueva n;
    public errorNuevo e;

    public ActualizarUsuario(Usuario u, NotificacionNueva n, errorNuevo e) {
        c = Calendar.getInstance();
        this.u = new Usuario();
        this.u.setUser(u.getUser());
        this.u.setNombreUsuario(u.getNombreUsuario());
        this.u.setListaTiposUsuario(u.getListaTiposUsuario());
        this.foto = true;
        this.e = e;
        this.n = n;
        initComponents();
        u.DNI(correla_carl3);
        setSize(1024, 680);
        setLocationRelativeTo(null);
        actualizarListaUsuarios(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbFoto = new javax.swing.JLabel();
        cambiar = new javax.swing.JButton();
        ubicacionArchivo_carl = new javax.swing.JTextField();
        borrar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        nombre_carl1 = new javax.swing.JTextField();
        apellido_carl1 = new javax.swing.JTextField();
        correla_carl3 = new javax.swing.JTextField();
        userF_carl1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        userActivo = new javax.swing.JRadioButton();
        user_carl = new javax.swing.JTextField();
        fechaIngreso_carl1 = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaUsuarios = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        actualizarUsuario_carl = new javax.swing.JButton();
        cancelar_carl = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de usuarios - Actualizar usuario - SIAPO");
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
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jLabel2.setText("Gestión de usuarios - Actualizar usuario ");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        cambiar.setText("Cambiar");
        cambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarActionPerformed(evt);
            }
        });

        ubicacionArchivo_carl.setEditable(false);

        borrar.setText("Borrar");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(lbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ubicacionArchivo_carl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(ubicacionArchivo_carl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(borrar)
                    .addComponent(cambiar))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Nombre:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Apellido:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Fecha de Ingreso:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("user Filebound:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        userF_carl1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userF_carl1KeyTyped(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setText("user:");

        userActivo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        userActivo.setText("Usuario Activo");

        user_carl.setEditable(false);
        user_carl.setToolTipText("");
        user_carl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                user_carlKeyTyped(evt);
            }
        });

        fechaIngreso_carl1.setToolTipText("");
        fechaIngreso_carl1.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombre_carl1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(user_carl, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaIngreso_carl1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userF_carl1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(apellido_carl1)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(correla_carl3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(userF_carl1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(apellido_carl1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(correla_carl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addGap(18, 18, 18)
                        .addComponent(userActivo)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(user_carl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nombre_carl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21))
                                .addGap(6, 6, 6)
                                .addComponent(fechaIngreso_carl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de usuarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        listaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "user", "Nombre", "Apellido", "Fecha de Ingreso", "user FB", "# USA", "Activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaUsuarios);
        if (listaUsuarios.getColumnModel().getColumnCount() > 0) {
            listaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(30);
            listaUsuarios.getColumnModel().getColumn(1).setPreferredWidth(80);
            listaUsuarios.getColumnModel().getColumn(2).setPreferredWidth(80);
            listaUsuarios.getColumnModel().getColumn(4).setPreferredWidth(30);
            listaUsuarios.getColumnModel().getColumn(5).setPreferredWidth(10);
            listaUsuarios.getColumnModel().getColumn(6).setPreferredWidth(20);
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        actualizarUsuario_carl.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        actualizarUsuario_carl.setText("Actualizar usuario");
        actualizarUsuario_carl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarUsuario_carlActionPerformed(evt);
            }
        });

        cancelar_carl.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cancelar_carl.setText("Cancelar Operación");
        cancelar_carl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar_carlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(353, Short.MAX_VALUE)
                .addComponent(actualizarUsuario_carl, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelar_carl, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(352, 352, 352))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar_carl)
                    .addComponent(actualizarUsuario_carl))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarActionPerformed
        try {
            JFileChooser dig = new JFileChooser();
            FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG", "jpg");
            dig.setFileFilter(filtroImagen);
            int option = dig.showOpenDialog(this);
            String file;
            this.foto = false;
            if (option == JFileChooser.APPROVE_OPTION) {
                file = dig.getSelectedFile().getPath();
                ubicacionArchivo_carl.setText(file);
                ImageIcon fot = new ImageIcon(file);
                Icon icono;
                icono = new ImageIcon(fot.getImage().getScaledInstance(lbFoto.getWidth(), lbFoto.getHeight(), Image.SCALE_DEFAULT));
                lbFoto.setIcon(icono);
                this.repaint();
                this.foto = true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario primero", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cambiarActionPerformed

    private void listaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaUsuariosMouseClicked
        String user = listaUsuarios.getValueAt(listaUsuarios.getSelectedRow(), 0).toString();
        SimpleDateFormat Df = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha1;
        try {
            correla_carl3.setEditable(true);
            ubicacionArchivo_carl.setText("");
            ResultSet r;
            r = this.u.seleccionar("userFilebound,correlativoUSA"
                    + ",fechaIngreso,nombre,apellido,usuarioActivo,foto",
                    "usuario", "user='" + user + "'");
            user_carl.setText(user);
            nombre_carl1.setText(r.getString("nombre"));
            apellido_carl1.setText(r.getString("apellido"));
            fecha1 = Df.parse(u.fechaReves(r.getString("fechaIngreso")));
            fechaIngreso_carl1.setDate(fecha1);
            userF_carl1.setText(r.getString("userFilebound"));
            correla_carl3.setText(r.getString("correlativoUSA"));
            if (r.getString("usuarioActivo").equals("1")) {
                userActivo.setSelected(true);
            } else {
                userActivo.setSelected(false);
            }
            if (r.getString("correlativoUSA").equals("0")) {
                correla_carl3.setEditable(false);
            }
            // seleccionamos desde la base de datos la foto del usuario
            Statement sentencia = this.u.getConexion().createStatement();
            r = sentencia.executeQuery("SELECT foto FROM usuario WHERE user='" + user + "' AND foto IS NOT NULL");
            if (r.next()) {
                Image dtCat = getfoto(user);
                ImageIcon fot = new ImageIcon(dtCat);
                Icon icono;
                icono = new ImageIcon(fot.getImage().getScaledInstance(lbFoto.getWidth(), lbFoto.getHeight(), Image.SCALE_DEFAULT));
                lbFoto.setIcon(icono);
                this.repaint();
                this.foto = true;
            } else {
                lbFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/defaultlarge.gif")));
                this.foto = false;
            }
            u.cerrarConexionBase();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_listaUsuariosMouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        new ActualizarUsuario(u, this.n, this.e).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        new EliminarUsuario(u, this.n, this.e).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        new AgregarUsuario(u, this.n, this.e).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void user_carlKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_user_carlKeyTyped
        // TODO add your handling code here:
        u.soloLetrasMin(evt);
    }//GEN-LAST:event_user_carlKeyTyped

    private void userF_carl1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userF_carl1KeyTyped
        // TODO add your handling code here:
        u.soloLetrasMinNum(evt);
    }//GEN-LAST:event_userF_carl1KeyTyped

    private void apellido_carl1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellido_carl1KeyTyped
        // TODO add your handling code here:
        u.soloLetras(evt);
    }//GEN-LAST:event_apellido_carl1KeyTyped

    private void nombre_carl1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre_carl1KeyTyped
        // TODO add your handling code here:
        u.soloLetras(evt);
    }//GEN-LAST:event_nombre_carl1KeyTyped

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        lbFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/defaultlarge.gif")));
        ubicacionArchivo_carl.setText("");
        foto = false;
    }//GEN-LAST:event_borrarActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        new MenuPpal(u, false, this.n, this.e).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void actualizarUsuario_carlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarUsuario_carlActionPerformed
        Usuario usuario = new Usuario();
        SimpleDateFormat variableFecha = new SimpleDateFormat("dd-MM-yyyy");
        try {
            String fecha = variableFecha.format(fechaIngreso_carl1.getDate());
            if (user_carl.getText().isEmpty() || userF_carl1.getText().isEmpty()
                    || fecha.isEmpty() || nombre_carl1.getText().isEmpty()
                    || apellido_carl1.getText().isEmpty() || correla_carl3.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo(s) vacio(s)", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                usuario.setUser(user_carl.getText());
                usuario.setUserFilebound(userF_carl1.getText());
                usuario.setCorrelativoUSA(Integer.parseInt(correla_carl3.getText()));
                usuario.setFechaIngreso(usuario.fechaCorrecta(fecha));
                usuario.setNombreUsuario(nombre_carl1.getText().substring(0, 1).toUpperCase()
                        + nombre_carl1.getText().substring(1).toLowerCase());//mayusculas primero luego min
                usuario.setApellido(apellido_carl1.getText().substring(0, 1).toUpperCase()
                        + apellido_carl1.getText().substring(1).toLowerCase());
                boolean correlativo = true;
                if (!correla_carl3.isEditable()) {
                    correlativo = false;
                }
                if (!usuario.validarUsuario(false, correlativo)) {
                    String activo;
                    if (userActivo.isSelected()) {
                        activo = "1";
                    } else {
                        activo = "0";
                    }
                    usuario.actualizar("usuario", "nombre='" + usuario.getNombreUsuario() + "',apellido='" + usuario.getApellido() + "',fechaIngreso='"
                            + usuario.getFechaIngreso() + "',userFilebound='" + userF_carl1.getText()
                            + "',correlativoUSA=" + correla_carl3.getText() + ",user='" + user_carl.getText() + "',usuarioActivo=" + activo,
                            "user='" + listaUsuarios.getValueAt(listaUsuarios.getSelectedRow(), 0).toString() + "'");
                    if (this.foto) {
                        usuario.setUser(listaUsuarios.getValueAt(listaUsuarios.getSelectedRow(), 0).toString());
                        usuario.agregarFoto(ubicacionArchivo_carl.getText());
                    } else {
                        usuario.actualizar("usuario", "foto=NULL", "user='" + user_carl.getText() + "'");
                    }
                    actualizarListaUsuarios(false);
                    ubicacionArchivo_carl.setText("");
                    JOptionPane.showMessageDialog(null, "Usuario actualizado exitosamente",
                            "Actualizar usuario", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Fecha Incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_actualizarUsuario_carlActionPerformed

    private void cancelar_carlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar_carlActionPerformed
        // TODO add your handling code here:
        user_carl.setText("");
        userF_carl1.setText("");
        correla_carl3.setText("");
        nombre_carl1.setText("");
        apellido_carl1.setText("");
        fechaIngreso_carl1.setCalendar(null);
        ubicacionArchivo_carl.setText("");
        lbFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/defaultlarge.gif")));
        userActivo.setSelected(false);
    }//GEN-LAST:event_cancelar_carlActionPerformed

    //metodo  que dado un parametro "id" realiza una consulta y devuelve como resultado
// una imagen
    public Image getfoto(String id) {
        Image data = null;
        try {
            PreparedStatement pstm = u.getConexion().prepareStatement("SELECT "
                    + " foto "
                    + " FROM usuario "
                    + " where user ='" + id + "'");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                //se lee la cadena de bytes de la base de datos
                byte[] b = res.getBytes("foto");
                // esta cadena de bytes sera convertida en una imagen
                data = ConvertirImagen(b);
                i++;
            }
            res.close();
            u.cerrarConexionBase();
        } catch (SQLException | IOException ex) {
        }
        return data;
    }

    //metodo que dada una cadena de bytes la convierte en una imagen con extension jpeg
    private Image ConvertirImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator readers = ImageIO.getImageReadersByFormatName("jpeg");
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis; // File or InputStream
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        return reader.read(0, param);
    }

    public void actualizarListaUsuarios(boolean primeraVez) {
        int i, j, filas;//i fila j colummna        
        ResultSet r;
        try {
            r = u.seleccionar("count(*) as filas", "usuario", "");
            filas = Integer.parseInt(r.getString("filas"));
            u.cerrarConexionBase();
            r = u.seleccionar("user,nombre,apellido,correlativoUSA,userFilebound,fechaIngreso,usuarioActivo", "usuario", "");
            r.first();
            for (i = 0; i < filas; i++) {
                if (primeraVez) {
                    ((DefaultTableModel) listaUsuarios.getModel()).setRowCount(listaUsuarios.getRowCount() + 1);// agrega filas dinamicamente
                }
                for (j = 0; j < 7; j++) {
                    //fila,colummna
                    switch (j) {
                        case 0:
                            listaUsuarios.setValueAt(r.getString("user"), i, j);
                            break;
                        case 1:
                            listaUsuarios.setValueAt(r.getString("nombre"), i, j);
                            break;
                        case 2:
                            listaUsuarios.setValueAt(r.getString("apellido"), i, j);
                            break;
                        case 3:
                            listaUsuarios.setValueAt(u.fechaReves(r.getString("fechaIngreso")), i, j);
                            break;
                        case 4:
                            listaUsuarios.setValueAt(r.getString("userFilebound"), i, j);
                            break;
                        case 5:
                            listaUsuarios.setValueAt(r.getString("correlativoUSA"), i, j);
                            break;
                        case 6:
                            if (r.getString("usuarioActivo").equals("1")) {
                                listaUsuarios.setValueAt("SI", i, j);
                            } else {
                                listaUsuarios.setValueAt("NO", i, j);
                            }
                            break;
                    }
                }
                r.next();
            }
            u.getSentencia().close();
            u.cerrarConexionBase();
        } catch (SQLException | NumberFormatException e) {
        }
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarUsuario_carl;
    private javax.swing.JTextField apellido_carl1;
    private javax.swing.JButton borrar;
    private javax.swing.JButton cambiar;
    private javax.swing.JButton cancelar_carl;
    private javax.swing.JTextField correla_carl3;
    private com.toedter.calendar.JDateChooser fechaIngreso_carl1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbFoto;
    private javax.swing.JTable listaUsuarios;
    private javax.swing.JTextField nombre_carl1;
    private javax.swing.JTextField ubicacionArchivo_carl;
    private javax.swing.JRadioButton userActivo;
    private javax.swing.JTextField userF_carl1;
    private javax.swing.JTextField user_carl;
    // End of variables declaration//GEN-END:variables
}
