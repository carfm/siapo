/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos y Jose
 */
public class test {

    public static void main(String[] args) throws Exception
{
    JTable table = new JTable();
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.addColumn("A");
    model.addRow(new String[]{"A"});
    model.addRow(new String[]{"A"});

    JFrame f = new JFrame();
    f.add(table);
    f.pack();
    f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    f.setVisible(true);

    table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {            
        @Override
        public void valueChanged(ListSelectionEvent e)
        {
            System.out.println(e.getFirstIndex() + ":" + e.getLastIndex());                
        }
    });

    Thread.sleep(10000);
    model.setRowCount(0);
}

}
