/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas.mensajeria;

import clases.Usuario;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author familia diaz
 */
public class NotificacionNueva extends javax.swing.JFrame implements Runnable {

    Usuario u;
    private TrayIcon trayIcon;
    private SystemTray tray;
    boolean bandera;
    Thread noti;
    ActionListener verMensajes = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {//cambiar
            mensajesActionPerformed(e);
        }
    };
    ActionListener verNotificaciones = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {//cambiar
            notificacionesActionPerformed(e);
        }
    };

    /**
     * Creates new form mensajeNuevo
     *
     * @param u
     * @param primeraVez
     */
    public NotificacionNueva(Usuario u, boolean primeraVez) {
        this.u = new Usuario();
        this.u.setNombreUsuario(u.getNombreUsuario());
        this.u.setUser(u.getUser());
        this.u.setListaTiposUsuario(u.getListaTiposUsuario());
        initComponents();
        ImageIcon im = new ImageIcon(getClass().getResource("/iconos/Apps-preferences-desktop-notification-icon.png"));
        trayIcon = new TrayIcon(im.getImage(), "Mensajes - Notificaciones", null);
        this.noti = new Thread(this, "notificaciones");
        this.bandera = true;
        noti.start();
        EstadoCambiado();
        this.setState(JFrame.ICONIFIED);
        this.setLocation(800, 500);
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mensajes = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        notificaciones = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        mensajes.setText("Ver Mensajes");
        mensajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mensajesActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mensajes);
        jPopupMenu1.add(jSeparator1);

        notificaciones.setText("Ver Notificaciones");
        notificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notificacionesActionPerformed(evt);
            }
        });
        jPopupMenu1.add(notificaciones);

        setTitle("Mensajes Nuevos");
        setBackground(new java.awt.Color(255, 255, 153));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("¡¡Tienes Nofificaciones!! ");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Apps-preferences-desktop-notification-icon.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Ver Notificaciones");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EstadoCambiado() {

        //this.setState(NORMAL);
        this.setVisible(false);

        if (SystemTray.isSupported()) {

            setTray(SystemTray.getSystemTray());

            MouseListener mouseListener = new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == e.BUTTON1) {
                        getTrayIcon().displayMessage("SIAPO", "Notificaciones de errores", TrayIcon.MessageType.INFO);
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    if (e.isPopupTrigger()) {
                        jPopupMenu1.setLocation(e.getX(), e.getY());
                        jPopupMenu1.setInvoker(jPopupMenu1);
                        jPopupMenu1.setVisible(true);
                    }
                }
            };

            getTrayIcon().setImageAutoSize(true);
            getTrayIcon().addMouseListener(mouseListener);

            try {
                getTray().add(getTrayIcon());
                if (u.getListaTiposUsuario().size() == 1) {
                    if (this.u.getListaTiposUsuario().get(0).getCodigoTipoUser() == 2) {
                        jPopupMenu1.remove(notificaciones);
                    }
                }
                // getTrayIcon().displayMessage("SIAPO", "Bienvenido a SIAPO.", TrayIcon.MessageType.INFO);
            } catch (AWTException e) {
                System.err.println("No se pudo agregar el ícono a la barra tray");
                this.setVisible(true);
            }
        } else {
            //  System Tray is not supported
        }

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Bandeja(u, "notificacion").setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void mensajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mensajesActionPerformed
        new Bandeja(u, "mensaje").setVisible(true);
    }//GEN-LAST:event_mensajesActionPerformed

    private void notificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notificacionesActionPerformed
        new Bandeja(u, "notificaciones").setVisible(true);
    }//GEN-LAST:event_notificacionesActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem mensajes;
    private javax.swing.JMenuItem notificaciones;
    // End of variables declaration//GEN-END:variables

    public void eliminarIcono() {
        getTray().remove(getTrayIcon());
    }

    public boolean notificacionesNuevas() {
        boolean existen = false;
        ResultSet r;
        String tablas = "gestiona,puede_tener";
        String condicion = "puede_tener.user='" + u.getUser() + "'  and gestiona.visto =0 AND  puede_tener.idMensaje = gestiona.idMensaje AND errorLaboratorio =0";
        try {
            //System.out.println(condicion);
            r = u.seleccionar("puede_tener.user", tablas, condicion);
            r.beforeFirst();
            existen = r.next();
            r.close();
            u.cerrarConexionBase();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se puede comprobar si tiene mensajes nuevos","", JOptionPane.INFORMATION_MESSAGE);
        }
        return existen;
    }

    public boolean MensajesNuevos() {
        boolean existen = false;
        ResultSet r;
        String tablas = "gestiona,mensaje";
        String condicion = "user='" + u.getUser() + "' AND gestiona.idMensaje = "
                + "mensaje.idMensaje AND visto =0 AND mensaje.tipoMensaje=1";
        r = u.seleccionar("user", tablas, condicion);
        try {
            r.beforeFirst();
            existen = r.next();
            r.close();
            u.cerrarConexionBase();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se puede comprobar si tiene mensajes nuevos","", JOptionPane.INFORMATION_MESSAGE);
        }
        return existen;
    }

    @Override
    public void run() {
        while (bandera) {
            try {
                Thread.sleep(2000);
            } catch (Exception ex) {
                Logger.getLogger(NotificacionNueva.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (notificacionesNuevas()) {
                getTrayIcon().displayMessage("SIAPO", "Tienes Nuevas Notificaciones. haz click aqui para verlas", TrayIcon.MessageType.INFO);
                getTrayIcon().removeActionListener(verMensajes);
                getTrayIcon().removeActionListener(verNotificaciones);
                getTrayIcon().addActionListener(verNotificaciones);
            }
            // cada 30 seg
            try {
                Thread.sleep(30000);
            } catch (Exception ex) {
                Logger.getLogger(NotificacionNueva.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (MensajesNuevos()) {
                getTrayIcon().displayMessage("SIAPO", "Tienes Nuevos Mensajes. haz click aqui para verlos", TrayIcon.MessageType.INFO);
                getTrayIcon().removeActionListener(verNotificaciones);
                getTrayIcon().removeActionListener(verMensajes);
                getTrayIcon().addActionListener(verMensajes);
            }
            // cada 2 min
            try {
                Thread.sleep(120000);
            } catch (Exception e) {
                return;
            }
        }
    }

    /**
     * @return the trayIcon
     */
    public TrayIcon getTrayIcon() {
        return trayIcon;
    }

    /**
     * @param trayIcon the trayIcon to set
     */
    public void setTrayIcon(TrayIcon trayIcon) {
        this.trayIcon = trayIcon;
    }

    /**
     * @return the tray
     */
    public SystemTray getTray() {
        return tray;
    }

    /**
     * @param tray the tray to set
     */
    public void setTray(SystemTray tray) {
        this.tray = tray;
    }
}
