/*
 * Nombre de la Clase: Main
 * Fecha de Creacion:Domingo 08 de Septiembre de 2013
 * Objetivo: clase principal de la aplicacion. Direcciona a la pantalla de Login de Usuario.
 * Autor: Henry Daniel Díaz López.
 */
package clases;

import pantallas.general.PantallaLogin;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);          
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            ErroresSiapo.agregar(e, "codigo 23");
            //System.out.println();
        }        
        new PantallaLogin(0, "nouser").setVisible(true);
    }
}
