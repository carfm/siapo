/*
 * MostrarErrores: El objetivo de este modulo es el de mostrar la clasificacion de un listado con los errores que puede
 * cometer un agente al momento de ingresar una orden.
 */
package pantallas.auditor;

import clases.Sistema;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo_Alexis_Landaverde
 */
public class MostrarErrores extends javax.swing.JFrame {
    
    private ResultSet rs;
    private final Sistema sistema= new Sistema();
    protected DefaultTableModel model;

    public MostrarErrores() {
        initComponents();
        this.setLocationRelativeTo(null);
        llenarTabla(table_viewErrores);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_viewErrores = new javax.swing.JTable();
        button_aceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mostrar Errores");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(60, 117, 207));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Errores clasificados");
        jPanel1.add(jLabel18);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setBackground(new java.awt.Color(94, 112, 144));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Universidad de El Salvador Copyright ©  2013 ");
        jPanel2.add(jLabel1);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        table_viewErrores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_viewErrores);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel3.add(jScrollPane1, gridBagConstraints);

        button_aceptar.setText("Aceptar");
        button_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_aceptarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.insets = new java.awt.Insets(7, 0, 0, 0);
        jPanel3.add(button_aceptar, gridBagConstraints);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void llenarTabla(JTable tabla){
        String[] titulos = {"Codigo", "Nombre"};
        rs = null;
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        try {
            rs = sistema.seleccionar("codigoError,nombreError", "error", "");
            String[] fila = new String[2];
            rs.beforeFirst();
            while (rs.next()) {
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                modelo.addRow(fila);
                tabla.setModel(modelo);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, null, JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, null, JOptionPane.ERROR_MESSAGE);
        }finally{
            sistema.cerrarConexionBase();
        }
    }
    
    private void button_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_aceptarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_button_aceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_aceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_viewErrores;
    // End of variables declaration//GEN-END:variables
}
