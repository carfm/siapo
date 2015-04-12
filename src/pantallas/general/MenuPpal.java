/*
 * Nombre de la Clase: MenuPpal
 * Fecha de Creacion:Sabado 07 de Septiembre de 2013
 * Objetivo: Interfaz que permite visualizar las opciones autorizadas a los usuarios.
 * Autor: Henry Daniel Díaz López.
 */
package pantallas.general;

import pantallas.perfiles.Perfiles;
import pantallas.mensajeria.NotificacionNueva;
import pantallas.mensajeria.Bandeja;
import pantallas.mensajeria.errorNuevo;
import pantallas.gerente.sendMessage;
import pantallas.auditor.AgregarError;
import pantallas.gerente.AprobarError;
import pantallas.gerente.AprobarErrorLaboratorio;
import pantallas.admin.AgregarUsuario;
import pantallas.admin.AgregarRazon;
import pantallas.admin.ActualizarCategoriaError;
import pantallas.admin.ActualizarTipoDeUsuario;
import pantallas.admin.AgregarLocation;
import pantallas.auditor.AuditoriaDeOrdenes;
import pantallas.agente.HistoricoOrdenes;
import pantallas.agente.RegistroDeOrdenesProcesadas;
import clases.Sistema;
import clases.TipoUsuario;
import clases.Usuario;
import java.sql.ResultSet;
import java.util.Calendar;
import pantallas.auditor.HistoricoOrdenesAuditadas;
import pantallas.gerente.ReporteriaEstadisticas;

/*
 * --Atributos--
 * c: recupera la fecha del sistema para mostrarlo en la ventana.
 * func: instancia de la clase Funciones. Necesario para ejecutar las consultas sql.
 * nombre: guarda el nombre y apellido del usuario.
 * user: guarda el nombre de usuario (con el que inicia sesion).
 * resultado: ResulSet que guarda el resultado de las consultas sql.
 */
public class MenuPpal extends javax.swing.JFrame {

    public Calendar c;
    public Sistema func = new Sistema();
    public String nombre, user;
    public NotificacionNueva n;
    public errorNuevo e;
    ResultSet resultado;
    Usuario u;
    boolean bandera = true, primeraVez;

    /**
     * ***************************Constructor
     * MenuPpal
     *
     ******************************
     * @param u
     * @param primeraVez
     * @param e
     * @param n
     */
    /*
     * --Parametros--
     * u: recibe el nombre de usuario (con el que inicia sesion).
     * 
     * Llama al metodo iniciar que inicializa todos los componentes segun los permisos del usuario.
     */
    public MenuPpal(Usuario u, boolean primeraVez, NotificacionNueva n, errorNuevo e) {
        this.u = new Usuario();
        this.u.setNombreUsuario(u.getNombreUsuario());
        this.u.setUser(u.getUser());
        this.u.setListaTiposUsuario(u.getListaTiposUsuario());
        user = this.u.getUser();
        nombre = this.u.getNombreUsuario();
        this.primeraVez = primeraVez;
        c = Calendar.getInstance();
        initComponents();
        setSize(1024, 680);
        setLocationRelativeTo(null);
        iniciar();
        if (u.getListaTiposUsuario().get(0).getCodigoTipoUser() == 3) {
            lblMensaje.setText("Enviar Mensaje");
            mensaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/email-send-icon.png")));
        } else {
            if (u.getListaTiposUsuario().get(0).getCodigoTipoUser() == 4) {
                lblMensaje.setVisible(false);
                mensaje.setVisible(false);
            }
        }
        if (primeraVez) {
            if (u.getListaTiposUsuario().get(0).getCodigoTipoUser() == 3) {
                this.e = new errorNuevo(u, primeraVez);
            }
            if (u.getListaTiposUsuario().get(0).getCodigoTipoUser() == 1 || u.getListaTiposUsuario().get(0).getCodigoTipoUser() == 2) {
                this.n = new NotificacionNueva(u, primeraVez);
            }
        } else {
            this.e = e;
            this.n = n;
        }
    }

    /**
     * ***************************FIN Constructor
     * MenuPpal******************************
     */
    /**
     * *************************Metodo
     * iniciar******************************************
     */
    /* Objetivo: Inicializa todos los componentes que debe visualizar el usuario
     * dependiendo de sus permisos activos.
     * --Atributos--
     * permisos: array de 4 elementos que guarda los codigos de los permisos del usuario.
     * per: instancia de la clase TipoUsuario necesario para recuperar los permisos
     * de la base de datos.
     */
    private void iniciar() {
        int[] permisos;
        TipoUsuario per = new TipoUsuario();
        permisos = per.permisos(user);
        for (int i = 0; i < 4; i++) {
            if ((permisos[0] != (i + 1)) && (permisos[1] != (i + 1)) && (permisos[2] != (i + 1)) && (permisos[3] != (i + 1))) {
                switch (i) {
                    case 0:
                        panelOpciones.remove(pestanaAgente);
                        break;
                    case 1:
                        panelOpciones.remove(pestanaAuditor);
                        break;
                    case 2:
                        panelOpciones.remove(pestanaGerente);
                        break;
                    case 3:
                        panelOpciones.remove(pestanaAdmin);
                        break;
                }
            }
        }
    }

    /**
     * *************************FIN Metodo
     * iniciar******************************************
     */
    /**
     * ******************CODIGO GENERADO POR NETBEANS IDE. no debe
     * editarse*******************
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInferior = new javax.swing.JPanel();
        copyrigth_label = new javax.swing.JLabel();
        panelOpciones = new javax.swing.JTabbedPane();
        pestanaAgente = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        registar = new javax.swing.JButton();
        historico = new javax.swing.JButton();
        registrar_label = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        notificacion = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        pestanaGerente = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        reporte = new javax.swing.JButton();
        errorLabGerente = new javax.swing.JButton();
        gestionMsj = new javax.swing.JButton();
        aprobarError = new javax.swing.JButton();
        perfilesGerente = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pestanaAuditor = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        gestionError = new javax.swing.JButton();
        registroAud = new javax.swing.JButton();
        perfilesAuditor = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        historico1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        pestanaAdmin = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        gestionTipoErrorr = new javax.swing.JButton();
        gestionUsuario = new javax.swing.JButton();
        gestionLocation = new javax.swing.JButton();
        gestionTipoUsuario = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        gestionTipoUsuario1 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        mensaje = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal - SIAPO");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        panelInferior.setBackground(new java.awt.Color(94, 112, 144));
        panelInferior.setForeground(new java.awt.Color(94, 112, 144));
        panelInferior.setMaximumSize(new java.awt.Dimension(1024, 36));
        panelInferior.setMinimumSize(new java.awt.Dimension(1024, 36));
        panelInferior.setPreferredSize(new java.awt.Dimension(1024, 36));
        panelInferior.setVerifyInputWhenFocusTarget(false);

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

        panelOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N
        panelOpciones.setToolTipText("");
        panelOpciones.setName(""); // NOI18N
        panelOpciones.setPreferredSize(new java.awt.Dimension(1073, 680));

        pestanaAgente.setForeground(new java.awt.Color(60, 117, 207));
        pestanaAgente.setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione Una Opción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        registar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Window-Add-icon.png"))); // NOI18N
        registar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registarActionPerformed(evt);
            }
        });

        historico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/historico.png"))); // NOI18N
        historico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historicoActionPerformed(evt);
            }
        });

        registrar_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registrar_label.setText("Registro y Gestión de Ordenes");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ver Notificaciones");

        notificacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Apps-preferences-desktop-notification-icon.png"))); // NOI18N
        notificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notificacionActionPerformed(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Histórico");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registrar_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addComponent(registar)
                .addGap(93, 93, 93))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(notificacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(historico, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(registar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registrar_label)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(notificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(historico, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pestanaAgenteLayout = new javax.swing.GroupLayout(pestanaAgente);
        pestanaAgente.setLayout(pestanaAgenteLayout);
        pestanaAgenteLayout.setHorizontalGroup(
            pestanaAgenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestanaAgenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pestanaAgenteLayout.setVerticalGroup(
            pestanaAgenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestanaAgenteLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        panelOpciones.addTab("Agente", pestanaAgente);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione Una Opción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        reporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/custom-reports-icon.png"))); // NOI18N
        reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteActionPerformed(evt);
            }
        });

        errorLabGerente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Delete-icon.png"))); // NOI18N
        errorLabGerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                errorLabGerenteActionPerformed(evt);
            }
        });

        gestionMsj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/message-already-read-icon.png"))); // NOI18N
        gestionMsj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionMsjActionPerformed(evt);
            }
        });

        aprobarError.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/delete-file-icon.png"))); // NOI18N
        aprobarError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aprobarErrorActionPerformed(evt);
            }
        });

        perfilesGerente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/profile-icon.png"))); // NOI18N
        perfilesGerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfilesGerenteActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Errores de Laboratorio");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Generar Reportes");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Ver Perfiles");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Gestionar Errores");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Gestion de Mensajes");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(reporte)
                            .addComponent(aprobarError)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(perfilesGerente)
                            .addComponent(errorLabGerente))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(gestionMsj)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reporte)
                    .addComponent(errorLabGerente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aprobarError)
                    .addComponent(perfilesGerente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(23, 23, 23)
                .addComponent(gestionMsj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pestanaGerenteLayout = new javax.swing.GroupLayout(pestanaGerente);
        pestanaGerente.setLayout(pestanaGerenteLayout);
        pestanaGerenteLayout.setHorizontalGroup(
            pestanaGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestanaGerenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pestanaGerenteLayout.setVerticalGroup(
            pestanaGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestanaGerenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        panelOpciones.addTab("Gerente", pestanaGerente);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione Una Opción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        gestionError.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/delete-file-icon.png"))); // NOI18N
        gestionError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionErrorActionPerformed(evt);
            }
        });

        registroAud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Actions-insert-table-icon.png"))); // NOI18N
        registroAud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroAudActionPerformed(evt);
            }
        });

        perfilesAuditor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/profile-icon.png"))); // NOI18N
        perfilesAuditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfilesAuditorActionPerformed(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Ver Perfiles");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Gestionar Errores");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Auditoría");

        historico1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/historico.png"))); // NOI18N
        historico1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historico1ActionPerformed(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Histórico");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(gestionError)
                .addGap(55, 55, 55)
                .addComponent(registroAud)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(perfilesAuditor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(historico1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gestionError)
                    .addComponent(registroAud))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(historico1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(perfilesAuditor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout pestanaAuditorLayout = new javax.swing.GroupLayout(pestanaAuditor);
        pestanaAuditor.setLayout(pestanaAuditorLayout);
        pestanaAuditorLayout.setHorizontalGroup(
            pestanaAuditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestanaAuditorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pestanaAuditorLayout.setVerticalGroup(
            pestanaAuditorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestanaAuditorLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        panelOpciones.addTab("Auditor", pestanaAuditor);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione Una Opción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        gestionTipoErrorr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/folder-full-delete-icon.png"))); // NOI18N
        gestionTipoErrorr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionTipoErrorrActionPerformed(evt);
            }
        });

        gestionUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/users-icon.png"))); // NOI18N
        gestionUsuario.setAlignmentY(0.0F);
        gestionUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionUsuarioActionPerformed(evt);
            }
        });

        gestionLocation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Users-icon (1).png"))); // NOI18N
        gestionLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionLocationActionPerformed(evt);
            }
        });

        gestionTipoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/app-map-icon.png"))); // NOI18N
        gestionTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionTipoUsuarioActionPerformed(evt);
            }
        });

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Gestionar Usuarios");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Gestionar Tipo de Usuarios");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Gestionar Location");

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Gestionar Categoria Error");

        gestionTipoUsuario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/razones.png"))); // NOI18N
        gestionTipoUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionTipoUsuario1ActionPerformed(evt);
            }
        });

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Gestionar Razones de envio");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(gestionTipoUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(gestionUsuario))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(gestionTipoUsuario)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(gestionLocation))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gestionTipoErrorr)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gestionLocation, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gestionUsuario, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel19))
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gestionTipoUsuario)
                    .addComponent(gestionTipoErrorr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(23, 23, 23)
                .addComponent(gestionTipoUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pestanaAdminLayout = new javax.swing.GroupLayout(pestanaAdmin);
        pestanaAdmin.setLayout(pestanaAdminLayout);
        pestanaAdminLayout.setHorizontalGroup(
            pestanaAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pestanaAdminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(324, 324, 324))
        );
        pestanaAdminLayout.setVerticalGroup(
            pestanaAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pestanaAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelOpciones.addTab("Administrador", pestanaAdmin);

        jPanel10.setBackground(new java.awt.Color(60, 117, 207));

        jPanel11.setBackground(new java.awt.Color(47, 63, 79));

        jLabel29.setForeground(new java.awt.Color(255, 255, 255));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText(Integer.toString(c.get(Calendar.DATE))+"-"+Integer.toString(c.get(Calendar.MONTH)+1)+"-"+Integer.toString(c.get(Calendar.YEAR)));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        try{
            jLabel31.setText(this.u.getNombreUsuario()+"-"+this.u.getListaTiposUsuario().get(0).getNombreTipo()+"-"+this.u.getListaTiposUsuario().get(1).getNombreTipo());
        }catch(Exception e){
            jLabel31.setText(this.u.getNombreUsuario()+"-"+this.u.getListaTiposUsuario().get(0).getNombreTipo());
        }

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel30)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel29))
        );

        jPanel12.setBackground(new java.awt.Color(94, 112, 144));
        jPanel12.setForeground(new java.awt.Color(94, 112, 144));

        jLabel32.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("Menú Principal");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Logo HMCR.jpg"))); // NOI18N

        jButton12.setBackground(new java.awt.Color(60, 117, 207));
        jButton12.setForeground(new java.awt.Color(60, 117, 207));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Log-Out-icon.png"))); // NOI18N
        jButton12.setBorderPainted(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Cerrar Sesión");

        lblMensaje.setBackground(new java.awt.Color(255, 255, 255));
        lblMensaje.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(255, 255, 255));
        lblMensaje.setText("Ver Mensajes");

        mensaje.setBackground(new java.awt.Color(60, 117, 207));
        mensaje.setForeground(new java.awt.Color(60, 117, 207));
        mensaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/new-message-icon.png"))); // NOI18N
        mensaje.setBorderPainted(false);
        mensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mensajeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addGap(18, 18, 18)
                        .addComponent(lblMensaje))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(450, 591, Short.MAX_VALUE)
                .addComponent(jLabel33)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(346, 346, 346))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(panelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aprobarErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aprobarErrorActionPerformed

        new AprobarError(u, true, this.n, this.e).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_aprobarErrorActionPerformed

    private void gestionMsjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionMsjActionPerformed
        new Bandeja(u, "mensaje").setVisible(true);
    }//GEN-LAST:event_gestionMsjActionPerformed

    private void registarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new RegistroDeOrdenesProcesadas(u, this.n, this.e);
    }//GEN-LAST:event_registarActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (this.u.getListaTiposUsuario().get(0).getCodigoTipoUser() == 3) {
            e.setBandera(false);
            e.getTray().remove(e.getTrayIcon());
        }
        if (u.getListaTiposUsuario().get(0).getCodigoTipoUser() == 1
                || u.getListaTiposUsuario().get(0).getCodigoTipoUser() == 2) {
            n.setBandera(false);
            n.getTray().remove(n.getTrayIcon());
        }
        this.setVisible(false);
        new PantallaLogin(0, "nouser").setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void gestionTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionTipoUsuarioActionPerformed
        // TODO add your handling code here:
        new AgregarLocation(u, this.n, this.e).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_gestionTipoUsuarioActionPerformed

    private void gestionLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionLocationActionPerformed

        new ActualizarTipoDeUsuario(u, this.n, this.e).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_gestionLocationActionPerformed

    private void gestionUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionUsuarioActionPerformed
        new AgregarUsuario(u, this.n, this.e).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_gestionUsuarioActionPerformed

    private void gestionTipoErrorrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionTipoErrorrActionPerformed
        new ActualizarCategoriaError(u, this.n, this.e).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_gestionTipoErrorrActionPerformed

    private void gestionErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionErrorActionPerformed
        new AgregarError(u, this.n, this.e).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_gestionErrorActionPerformed

    private void mensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mensajeActionPerformed
        // TODO add your handling code here:
        if (u.getListaTiposUsuario().get(0).getCodigoTipoUser() == 3) {
            new sendMessage().setVisible(true);
        } else {
            new Bandeja(u, "mensaje").setVisible(true);
        }
    }//GEN-LAST:event_mensajeActionPerformed

    private void registroAudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroAudActionPerformed
        // TODO add your handling code here:
        new AuditoriaDeOrdenes(u, this.n, this.e).setVisible(false);
        this.setVisible(false);
    }//GEN-LAST:event_registroAudActionPerformed

    private void errorLabGerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_errorLabGerenteActionPerformed
        // TODO add your handling code here:
        new AprobarErrorLaboratorio(u, this.n, this.e).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_errorLabGerenteActionPerformed

    private void reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteActionPerformed
        // TODO add your handling code here:
        new ReporteriaEstadisticas(u, this.n, this.e).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_reporteActionPerformed

    private void perfilesGerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfilesGerenteActionPerformed
        // TODO add your handling code here:
        new Perfiles(u, this.n, this.e).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_perfilesGerenteActionPerformed

    private void perfilesAuditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfilesAuditorActionPerformed
        // TODO add your handling code here:
        new Perfiles(u, this.n, this.e).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_perfilesAuditorActionPerformed

    private void notificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notificacionActionPerformed
        // TODO add your handling code here:
        new Bandeja(u, "notificacion").setVisible(true);
    }//GEN-LAST:event_notificacionActionPerformed

    private void historicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historicoActionPerformed
        // TODO add your handling code here:
        new HistoricoOrdenes(u, this.n, this.e).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_historicoActionPerformed

    private void gestionTipoUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionTipoUsuario1ActionPerformed
        // TODO add your handling code here:
        new AgregarRazon(u,this.n, this.e).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_gestionTipoUsuario1ActionPerformed

    private void historico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historico1ActionPerformed
        // TODO add your handling code here:
        new HistoricoOrdenesAuditadas(u, this.n, this.e).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_historico1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aprobarError;
    private javax.swing.JLabel copyrigth_label;
    private javax.swing.JButton errorLabGerente;
    private javax.swing.JButton gestionError;
    private javax.swing.JButton gestionLocation;
    private javax.swing.JButton gestionMsj;
    private javax.swing.JButton gestionTipoErrorr;
    private javax.swing.JButton gestionTipoUsuario;
    private javax.swing.JButton gestionTipoUsuario1;
    private javax.swing.JButton gestionUsuario;
    private javax.swing.JButton historico;
    private javax.swing.JButton historico1;
    private javax.swing.JButton jButton12;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JButton mensaje;
    private javax.swing.JButton notificacion;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JTabbedPane panelOpciones;
    private javax.swing.JButton perfilesAuditor;
    private javax.swing.JButton perfilesGerente;
    private javax.swing.JPanel pestanaAdmin;
    private javax.swing.JPanel pestanaAgente;
    private javax.swing.JPanel pestanaAuditor;
    private javax.swing.JPanel pestanaGerente;
    private javax.swing.JButton registar;
    private javax.swing.JLabel registrar_label;
    private javax.swing.JButton registroAud;
    private javax.swing.JButton reporte;
    // End of variables declaration//GEN-END:variables
}
/********************FIN DEL CODIGO GENERADO POR NETBEANS IDE.***************************/
