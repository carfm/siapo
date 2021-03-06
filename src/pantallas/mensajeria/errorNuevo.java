/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas.mensajeria;

import pantallas.gerente.AprobarError;
import clases.Usuario;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author familia diaz
 */
public class errorNuevo extends javax.swing.JFrame implements Runnable {

    Usuario u;
    private TrayIcon trayIcon;
    private SystemTray tray;
    boolean bandera = true;
    Thread errores;

    /**
     *
     * Creates new form mensajeNuevo
     * @param u
     * @param primeraVez
     */
    public errorNuevo(Usuario u, boolean primeraVez) {
        this.u = new Usuario();
        this.u.setNombreUsuario(u.getNombreUsuario());
        this.u.setUser(u.getUser());
        this.u.setListaTiposUsuario(u.getListaTiposUsuario());
        initComponents();
        bandera=true;
        ImageIcon im = new ImageIcon(getClass().getResource("/iconos/1379420499_061.png"));
        trayIcon = new TrayIcon(im.getImage(), "Nuevos Errores", null);
        this.errores = new Thread(this, "");
        errores.start();
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
        Ver = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        Ver.setText("Ver Errores");
        Ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Ver);

        setTitle("Mensajes Nuevos");
        setBackground(new java.awt.Color(255, 255, 153));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Existen mensajes nuevos ");

        jLabel2.setText("¿Desea ver los mensajes?");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1379420499_061.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Ir a bandeja de mensajes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(25, 25, 25))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EstadoCambiado() {
        //this.setState(NORMAL);
        this.setVisible(false);
        if (SystemTray.isSupported()) {
            setTray(SystemTray.getSystemTray());
            ActionListener exitListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    getTray().remove(getTrayIcon());
                }
            };

            MouseListener mouseListener = new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
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
            getTrayIcon().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    VerActionPerformed(e);
                }
            });
            try {
                getTray().add(getTrayIcon());
                //trayIcon.displayMessage("SIAPO","Existen Errores sin autorizar! Haga clcik en este mensaje para gestionarlos.", TrayIcon.MessageType.INFO);
            } catch (AWTException e) {
                System.err.println("No se pudo agregar el ícono a la barra tray");
                this.setVisible(true);
            }
        } else {
            //  System Tray is not supported
        }

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new AprobarError(u, false,null,null).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void VerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerActionPerformed
        new AprobarError(u, false,null,null).setVisible(true);
        //tray.remove(trayIcon);
    }//GEN-LAST:event_VerActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //tray.remove(trayIcon);        
    }//GEN-LAST:event_formWindowClosing
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Ver;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    // End of variables declaration//GEN-END:variables

    //---------------------------------------------------------------------------
    private boolean erroresNuevos() {
        boolean existen = false;
        ResultSet r;

        r = u.seleccionar("aprobado", "error", "aprobado='0'");
        try {
            r.beforeFirst();
            if (r.next()) {
                existen = true;
            }
        r.close();
        u.cerrarConexion();
        u.cerrarConexionBase();
        } catch (SQLException ex) {
            Logger.getLogger(errorNuevo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existen;
    }

    @Override
    public void run() {
//        if (u.getListaTiposUsuario().size() == 1) {
//            if (this.u.getListaTiposUsuario().get(0).getCodigoTipoUser() == 3) {
//                bandera = true;
//            } else {
//                bandera = false;
//            }
//        } else if (this.u.getListaTiposUsuario().get(0).getCodigoTipoUser() == 3 || this.u.getListaTiposUsuario().get(1).getCodigoTipoUser() == 3) {
//            bandera = true;
//        } else {
//            bandera = false;
//        }
        while (bandera) {
            if (erroresNuevos()) {
                getTrayIcon().displayMessage("SIAPO", "Existen Errores sin autorizar! Haga clic en este mensaje para gestionarlos.", TrayIcon.MessageType.INFO);
            }
            try {
                errores.sleep(600000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void eliminarIcono() {
        getTray().remove(getTrayIcon());
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
