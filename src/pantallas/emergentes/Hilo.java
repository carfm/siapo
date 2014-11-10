/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pantallas.emergentes;

/**
 *
 * @author Carlos y Jose
 */
import com.sun.awt.AWTUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Hilo extends Thread {

    private final Ventana ventana;
    private float opacidad = 0.3f;              // opacidad inicial
    private boolean detener;
// private final int TIEMPO = 5000;         // tiempo en milisegundos que estara activa la ventana

    public Hilo() {
        ventana = new Ventana();
        detener = false;
        AWTUtilities.setWindowOpacity(ventana, 0.0f);
        ventana.setVisible(true);
    }

    public void agregarTexto(String msj, int tipoColor) {
        getVentana().agregarTexto(msj, tipoColor);
    }

    public void cambiarColor(int tipoColor) {
        switch(tipoColor){
            case 1:// normal no se ha tenido la automatizacion,orden completa
                getVentana().getTextoPane().setBackground(Color.white);
                break;
            case 2:// se ha detenido la automatizacion
                getVentana().getTextoPane().setBackground(new Color(203, 41, 41));
                break;
            case 3:// se ha mandado un orden de regreso
                getVentana().getTextoPane().setBackground(Color.yellow);
                break;
            case 4:// la orden ya esta siendo/ha sido ingresada por otra persona
                getVentana().getTextoPane().setBackground(Color.green);
                break;
                         
        }
//        if (tipoColor == 1) {
//            ventana.getTextoPane().setBackground(Color.white);
//        } else {
//            ventana.getTextoPane().setBackground(new Color(203, 41, 41));
//        }

        //ventana.agregarTexto(msj, tipoColor);
    }

    public void cerrarVentana(){
        getVentana().dispose();
    }
    
    public void abrirVentana(){
        getVentana().setVisible(true);
    }

    public boolean estaVisible(){
        return getVentana().isVisible();
    }
    @Override
    public void run() {
        try {
            hacerVisible();
//            Thread.sleep(TIEMPO);
//            desvanecer();
//            ventana.dispose();
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    private void hacerVisible() throws InterruptedException {
        opacidad = 0.3f;
        while (opacidad < 1) {
            AWTUtilities.setWindowOpacity(getVentana(), opacidad);
            opacidad += 0.03f;
            Thread.sleep(20);
        }
    }

    private void desvanecer() throws InterruptedException {
        opacidad = 1.0f;
        while (opacidad > 0) {
            AWTUtilities.setWindowOpacity(getVentana(), opacidad);
            opacidad -= 0.03f;
            Thread.sleep(20);
        }
    }

    /**
     * @return the ventana
     */
    public Ventana getVentana() {
        return ventana;
    }

    class Ventana extends JDialog {

        private final int BARRA_DE_ESTADO = 30; // Tamaño de la barra de estado en windows 
        private SimpleAttributeSet attrib;
        private JScrollPane scrollPane;
        private JTextPane textoPane;

        public Ventana() {
            iniciarComponentes();
            ubicacionVentana();
            attrib = new SimpleAttributeSet();
        }

        private void ubicacionVentana() {
            int tamanioX = getWidth();
            int tamanioY = getHeight();
            int maxX = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
            int maxY = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

            // ubicacion de la ventana
            setLocation(maxX - tamanioX, maxY - tamanioY - BARRA_DE_ESTADO);
        }

        private void iniciarComponentes() {
            setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            scrollPane = new JScrollPane();
            setTextoPane(new JTextPane());
            //btnCerrar = new JButton();
            setResizable(true);
            setAlwaysOnTop(true);                          // siempre arriba
            setPreferredSize(new java.awt.Dimension(280, 120));           // tamaño de la ventana
            //setResizable(false);                             // no se puede modificar el tamaño
            setUndecorated(true);                           // no tiene los controles de estado

            scrollPane.setAutoscrolls(true);
            getTextoPane().setEditable(false);
            getTextoPane().setBackground(Color.white);
            getTextoPane().setFont(new java.awt.Font("Times New Roman", 0, 11));            
            scrollPane.setViewportView(getTextoPane());

            getContentPane().add(scrollPane, BorderLayout.CENTER);

//            btnCerrar.setText("Cerrar Ventana");
//            btnCerrar.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent evt) {
//                    dispose();
//                }
//            });
//            getContentPane().add(btnCerrar, BorderLayout.PAGE_END);
            pack();
            
        }

        public void agregarTexto(String msj, int tipoColor) {
            try {
                StyleConstants.setForeground(attrib, getColorTexto(tipoColor));
                StyledDocument sd = getTextoPane().getStyledDocument();               
                if (!textoPane.getText().isEmpty()) {
                    textoPane.setText("");
                    //sd.insertString(sd.getLength(), "n", attrib);
                }
                sd.insertString(sd.getLength(), msj, attrib);
            } catch (BadLocationException e) {
                System.err.println(e);
            }
        }

        private Color getColorTexto(int tipo) {
            switch (tipo) {
                case 0:     // Verde
                    return new Color(0, 130, 0);
                case 1:     // ROJO
                    return new Color(255, 0, 0);
                    
                default:    // Negro
                    return new Color(0, 0, 0);
            }
        }

        /**
         * @return the textoPane
         */
        public JTextPane getTextoPane() {
            return textoPane;
        }

        /**
         * @param textoPane the textoPane to set
         */
        public void setTextoPane(JTextPane textoPane) {
            this.textoPane = textoPane;
        }
    }
}
