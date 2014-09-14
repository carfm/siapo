/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.ResultSet;

/**
 *
 * @author Administrador
 */
public class Reporte extends Sistema {

    public boolean reporteQuincena(String mes, String año, int quincena) {
        ResultSet fechas, agentes;
        int num, dif;
        //DECLARE cursorito1 CURSOR FOR SELECT  distinct date(fecha) from procesa_audita where date(fecha) between fechaInicio and fechaFin ORDER BY date(fecha)  ASC;	
        // obtenemos las fechas
        if (quincena == 1) {
            fechas = seleccionar("distinct fecha ,DAY(fecha) AS dia", "procesa_audita",
                    "fecha between '" + año + "-" + mes + "-01' and '" + año + "-" + mes + "-15' ORDER BY date(fecha)  ASC");
            num = this.contadorFilas("(SELECT distinct fecha from procesa_audita where fecha between '" + año + "-" + mes + "-01' and '" + año + "-" + mes + "-15') a", "");
            dif = 0;
        } else {
            fechas = seleccionar("distinct fecha,DAY(fecha) AS dia", "procesa_audita",
                    "fecha between '" + año + "-" + mes + "-16' and '" + año + "-" + mes + "-31'ORDER BY date(fecha)  ASC");
            num = this.contadorFilas("(SELECT distinct fecha from procesa_audita where fecha between '" + año + "-" + mes + "-16' and '" + año + "-" + mes + "-31') a", "");
            dif = 15;
        }
        // obtenemos los nombres de los agentes
        this.cerrarConexionBase();
        agentes = seleccionar("b.user,concat(nombre,' ',apellido) as nombreCom", "es a,usuario b",
                "a.user = b.user and codigoTipoUser=1 ORDER BY correlativoUSA ASC ");
        ejecutarSQL("DROP TABLE IF EXISTS temporal1");
        // creacion de la tabla temporal para la quincena 1
        ejecutarSQL("create table temporal1( agente varchar(30),i1 integer NOT NULL DEFAULT '0',s1 integer NOT NULL DEFAULT '0',c1 integer NOT NULL DEFAULT '0',"
                + " i2 integer NOT NULL DEFAULT '0',s2 integer NOT NULL DEFAULT '0',c2 integer NOT NULL DEFAULT '0',i3 integer NOT NULL DEFAULT '0',s3 integer NOT NULL DEFAULT '0',c3 integer NOT NULL DEFAULT '0',"
                + "i4 integer NOT NULL DEFAULT '0',s4 integer NOT NULL DEFAULT '0',c4 integer NOT NULL DEFAULT '0',i5 integer NOT NULL DEFAULT '0',s5 integer NOT NULL DEFAULT '0',c5 integer NOT NULL DEFAULT '0',"
                + "i6 integer NOT NULL DEFAULT '0',s6 integer NOT NULL DEFAULT '0',c6 integer NOT NULL DEFAULT '0',i7 integer NOT NULL DEFAULT '0',s7 integer NOT NULL DEFAULT '0',c7 integer NOT NULL DEFAULT '0',"
                + "i8 integer NOT NULL DEFAULT '0',s8 integer NOT NULL DEFAULT '0',c8 integer NOT NULL DEFAULT '0',i9 integer NOT NULL DEFAULT '0',s9 integer NOT NULL DEFAULT '0',c9 integer NOT NULL DEFAULT '0',"
                + "i10 integer NOT NULL DEFAULT '0',s10 integer NOT NULL DEFAULT '0',c10 integer NOT NULL DEFAULT '0',i11 integer NOT NULL DEFAULT '0',s11 integer NOT NULL DEFAULT '0',c11 integer NOT NULL DEFAULT '0',"
                + "i12 integer NOT NULL DEFAULT '0',s12 integer NOT NULL DEFAULT '0',c12 integer NOT NULL DEFAULT '0',i13 integer NOT NULL DEFAULT '0',s13 integer NOT NULL DEFAULT '0',c13 integer NOT NULL DEFAULT '0',"
                + "i14 integer NOT NULL DEFAULT '0',s14 integer NOT NULL DEFAULT '0',c14 integer NOT NULL DEFAULT '0',i15 integer NOT NULL DEFAULT '0',s15 integer NOT NULL DEFAULT '0',c15 integer NOT NULL DEFAULT '0',"
                + "i16 integer NOT NULL DEFAULT '0',s16 integer NOT NULL DEFAULT '0',c16 integer NOT NULL DEFAULT '0')");
        try {
            Orden o = new Orden();
            int t[];
            agentes.beforeFirst();
            while (agentes.next()) {
                // insertamos la primera fila con el nombre del agente
                this.insertar("temporal1(agente)", "'" + agentes.getString(2) + "'");
                for (int i = 1; i <= num; i++) {
                    // obtenemos la cantidad de ordenes de ese dia
                    t = o.cantidadTipoOrdenes(agentes.getString("user"), "fecha='" + fechas.getString("fecha") + "'");
                    // actualizamos los campos correspondientes  a el dia
                    this.actualizar("temporal1", "i" + (fechas.getInt("dia") - dif) + "=" + t[1] + ",s" + (fechas.getInt("dia") - dif) + "=" + t[2] + ",c" + (fechas.getInt("dia") - dif) + "=" + t[0],
                            "agente='" + agentes.getString("nombreCom") + "'");
                    // seguimos con la siguiente fecha
                    fechas.next();
                }
                // volvemos a la primera fecha para contabilizar las de otro agente
                fechas.first();
            }
            this.pasarGarbageCollector();
            this.cerrarConexionBase();
            System.out.println("finnnnn");
        } catch (Exception e) {
            ErroresSiapo.agregar(e, "codigo 33");
            System.out.println(e);
        }
        return true;
    }
    
    
}
