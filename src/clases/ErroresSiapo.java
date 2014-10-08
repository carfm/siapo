/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

/**
 *
 * @author Carlos y Jose
 */
public class ErroresSiapo {
    public static void agregar(Exception ex, String mensaje) {
        FileWriter fichero = null;
        PrintWriter pw;
        java.util.Date fecha = new Date();
        File fi= new File("c:/prueba.txt");
       
        try {
            fichero = new FileWriter("c:/prueba.txt", true);
            pw = new PrintWriter(fichero);
            pw.println(fecha + " " + ex + " mensaje SIAPO: " + mensaje);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
