/*
 El tipo de mensaje se clasificara de la siguiente forma:
 * 1 - si el mensaje es publico
 * 2 - si el mensaje es privado
 */
package pantallas.gerente;

import java.awt.Color;
import clases.Mensaje;
import javax.swing.JOptionPane;

/**
 *
 * @author Ed
 */
public class sendMessage extends javax.swing.JFrame {

    Mensaje gm = new Mensaje();

    public sendMessage() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.ed_text_cont.setForeground(Color.gray);
        this.ed_text_cont.setText("Escriba aqui su mensaje");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ed_jf_asunto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ed_text_cont = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        ed_button_enviar = new javax.swing.JButton();
        ed_button_clean = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Enviar Mensaje");
        setMinimumSize(new java.awt.Dimension(180, 137));
        setName("ed_frame_send_msj"); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(60, 117, 207));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Enviar Mensaje                       ");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/email-send-icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel5)
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel3))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Asunto: ");

        ed_jf_asunto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ed_jf_asunto.setPreferredSize(new java.awt.Dimension(300, 31));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        ed_text_cont.setColumns(20);
        ed_text_cont.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ed_text_cont.setRows(10);
        ed_text_cont.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ed_text_contFocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(ed_text_cont);

        ed_button_enviar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ed_button_enviar.setText("Enviar");
        ed_button_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ed_button_enviarActionPerformed(evt);
            }
        });

        ed_button_clean.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ed_button_clean.setText("Limpiar");
        ed_button_clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ed_button_cleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(ed_button_enviar)
                .addGap(5, 5, 5)
                .addComponent(ed_button_clean))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ed_button_enviar)
                    .addComponent(ed_button_clean)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8)
                        .addComponent(ed_jf_asunto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel2))
                    .addComponent(ed_jf_asunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ed_text_contFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ed_text_contFocusGained
        // TODO add your handling code here:
        this.ed_text_cont.setText(null);
        this.ed_text_cont.setForeground(Color.black);
    }//GEN-LAST:event_ed_text_contFocusGained

    private void ed_button_cleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ed_button_cleanActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_ed_button_cleanActionPerformed

    private void ed_button_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ed_button_enviarActionPerformed
        // TODO add your handling code here:
        String asunto = this.ed_jf_asunto.getText();
        String cont = this.ed_text_cont.getText();
        if (asunto.equals("") || cont.equals("") || cont.equals("Escriba aqui su mensaje")) {
            JOptionPane.showMessageDialog(null, "¡Debe llenar todos los campos!");
            limpiar();
        } else if ((asunto.length() > 100) || (cont.length() > 200)) {
            JOptionPane.showMessageDialog(null, "¡Ha excedido el limite de caracteres!\nPor favor intentelo nuevamente.", "", JOptionPane.WARNING_MESSAGE);
        } else {
            gm.enviarmensaje(asunto, cont);
            this.dispose();
        }
    }//GEN-LAST:event_ed_button_enviarActionPerformed

    private void limpiar() {
        this.ed_jf_asunto.setText(null);
        this.ed_text_cont.setForeground(Color.gray);
        this.ed_text_cont.setText("Escriba aqui su mensaje");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ed_button_clean;
    private javax.swing.JButton ed_button_enviar;
    private javax.swing.JTextField ed_jf_asunto;
    private javax.swing.JTextArea ed_text_cont;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
