/*
 * Nombre de la Clase: PantallaLogin
 * Fecha de Creacion:Sabado 07 de Septiembre de 2013
 * Objetivo: Interfaz que permite el Logueo de los usuarios en el sistema
 * Autor: Henry Daniel Díaz López.
 */
package pantallas.general;

import clases.Sistema;
import clases.Usuario;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * --Atributos--
 * c: recupera la fecha del sistema para mostrarlo en la ventana.
 * intentos: guarda el numedo de veces que un usuario ha ingresado erroneamente su contraseña.
 * userAnt: recupera la String del ultimo usuario que intento acceder al sistema
 */
public class PantallaLogin extends javax.swing.JFrame {

    public Calendar c;
    private int intentos;
    private String userAnt;
    Thread hiloCargando, hiloEjecutando;
    private long inicioDeEnvio;
    private long finDeEnvio;

    /**
     * ***************************Constructor
     * PantallaLogin******************************
     */
    /*
     * --Parametros--
     * veces: recibe el numedo de veces que un usuario ha ingresado erroneamente su contraseña.
     * anteriro: recibe el String del ultimo usuario que trato de iniciar sesion.
     * Llama al metodo initComponentes() que inicializa todos los componentes.
     */
    public PantallaLogin(int veces, String anterior) {

        intentos = veces;
        userAnt = anterior;
        c = Calendar.getInstance();
        initComponents();
        setSize(400, 470);
        setLocationRelativeTo(null);
        cargando.setVisible(false);
        if (intentos != 0) {
            advertencia_label.setVisible(true);
        }
    }

    /**
     * ***************************FIN Constructor
     * PantallaLogin******************************
     */
    /**
     * *CODIGO GENERADO POR NETBEANS IDE. pueden editarse las acciones de los
     * componentes**
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInferior = new javax.swing.JPanel();
        copyrigth_label = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        usuario_label = new javax.swing.JLabel();
        pass_lable = new javax.swing.JLabel();
        pass_textfield = new javax.swing.JPasswordField();
        iniciarSesion_boton = new javax.swing.JButton();
        limpiar_boton = new javax.swing.JButton();
        advertencia_label = new javax.swing.JLabel();
        userFormat = new javax.swing.JTextField();
        cargando = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio de Sesion - SIAPO");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(400, 400));
        setResizable(false);

        panelInferior.setBackground(new java.awt.Color(94, 112, 144));
        panelInferior.setForeground(new java.awt.Color(94, 112, 144));
        panelInferior.setMaximumSize(new java.awt.Dimension(420, 36));
        panelInferior.setMinimumSize(new java.awt.Dimension(420, 36));
        panelInferior.setPreferredSize(new java.awt.Dimension(420, 36));

        copyrigth_label.setForeground(new java.awt.Color(255, 255, 255));
        copyrigth_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyrigth_label.setText("Universidad de El Salvador ©Copyright "+Sistema.años);

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(copyrigth_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(copyrigth_label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Por Favor Ingrese Sus Datos"), "Por Favor Ingrese Sus Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(326, 366));

        usuario_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usuario_label.setText("Usuario");

        pass_lable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pass_lable.setText("Contraseña");

        iniciarSesion_boton.setText("Iniciar Sesion");
        iniciarSesion_boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarSesion_botonActionPerformed(evt);
            }
        });

        limpiar_boton.setText("Limpiar");
        limpiar_boton.setMaximumSize(new java.awt.Dimension(97, 23));
        limpiar_boton.setMinimumSize(new java.awt.Dimension(97, 23));
        limpiar_boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar_botonActionPerformed(evt);
            }
        });

        advertencia_label.setForeground(new java.awt.Color(204, 0, 0));
        advertencia_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        advertencia_label.setText("Intento "+intentos+" de 5");

        userFormat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userFormatKeyTyped(evt);
            }
        });

        cargando.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cargando.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/loading.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(advertencia_label, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(iniciarSesion_boton)
                        .addGap(21, 21, 21)
                        .addComponent(limpiar_boton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pass_lable)
                            .addComponent(usuario_label))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pass_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userFormat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44))
            .addComponent(cargando, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usuario_label, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(userFormat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pass_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pass_lable))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limpiar_boton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iniciarSesion_boton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cargando, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(advertencia_label))
        );

        advertencia_label.setVisible(false);

        jPanel10.setBackground(new java.awt.Color(60, 117, 207));

        jPanel12.setBackground(new java.awt.Color(47, 63, 79));

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText(Integer.toString(c.get(Calendar.DATE))+"-"+Integer.toString(c.get(Calendar.MONTH)+1)+"-"+Integer.toString(c.get(Calendar.YEAR)));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(23, 23, 23))
        );

        jLabel27.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Inicio de Sesión");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInferior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * *************************Metodo
     * iniciarSesion_botonActionPerformed***********************
     */
    /* Objetivo: Validar que el usuario ingreso datos a los campos del formulario y llamar al
     * metodo ValidarUsusrio de la clase VerifiacrUser.
     * --Parametros--
     * evt: recibe la accion de presionar el boton.
     */
    private void iniciarSesion_botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarSesion_botonActionPerformed
        if (userFormat.getText().equals("") || pass_textfield.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe rellenar los campos usuario y contraseña");
        } else {
            botonDeGenerar();
            iconParpadeoDeEnvio();
        }

    }//GEN-LAST:event_iniciarSesion_botonActionPerformed
    /**
     * *************************FIN Metodo
     * iniciarSesion_botonActionPerformed***********************
     */
    /**
     * *************************Metodo
     * limpiar_botonActionPerformed***********************
     */
    /* Objetivo: Limpiar los campos del formulario
     * --Parametros--
     * evt: recibe la accion de presionar el boton.
     */
    private void limpiar_botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar_botonActionPerformed
        userFormat.setText("");
        pass_textfield.setText("");
        limpiar_boton.transferFocus();
    }//GEN-LAST:event_limpiar_botonActionPerformed

    private void userFormatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userFormatKeyTyped
        char ch = evt.getKeyChar();
        if ((ch < 'a' || ch > 'z') && (ch < 'A' || ch > 'Z')) {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_userFormatKeyTyped
    /**
     * *************************FIN Metodo
     * iniciarSesion_botonActionPerformed***********************
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel advertencia_label;
    private javax.swing.JLabel cargando;
    private javax.swing.JLabel copyrigth_label;
    private javax.swing.JButton iniciarSesion_boton;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JButton limpiar_boton;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JLabel pass_lable;
    private javax.swing.JPasswordField pass_textfield;
    private javax.swing.JTextField userFormat;
    private javax.swing.JLabel usuario_label;
    // End of variables declaration//GEN-END:variables
/**
 * ******************FIN DEL CODIGO GENERADO POR NETBEANS
 * IDE.**************************
 */
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
                            Logger.getLogger(PantallaLogin.class.getName()).log(Level.SEVERE, null, ex);
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
        iniciarSesion();
        cargando.setVisible(false);
    }

    public void iniciarSesion() {
        medirTiempoDeEnvio();
        try {
            Usuario u = new Usuario(intentos, userAnt);
            u.ValidarUsuario(userFormat.getText(), pass_textfield.getText(), u);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(PantallaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}


