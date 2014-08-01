
package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartPanel;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graficas {

    public Graficas(int t, int rango, String nombre, String datos, String valores, String user) {
        c = Calendar.getInstance();
        this.t = t;
        this.rango = rango;
        this.nombre = nombre;
        this.datos = datos;
        this.valores = valores;
        this.user = user;
        u=new Usuario();
        
    }
    private Usuario u;
    private ResultSet r,r2;
    private int   t,totalError,totalErrorCom,rango;
    private Double totalOrden, ordenCompleta, ordenIncompleta,ordenNada;
    private String nombre, datos,valores;
    private String user,condicion="";
    public Calendar c;
    private String fechaInicio,fechaFin,mes="";

    public void setMes(String mes) {
        this.mes = mes;
    }
    private boolean semestre;

    public void setSemestre(boolean semestre) {
        this.semestre = semestre;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    
  
     public ChartPanel pastel() {
         definirRango();
         DefaultPieDataset dataset=llenarDataSetPastel();

    JFreeChart grafica = ChartFactory.createPieChart3D( //objeto tipo grafico
    nombre, // El nombre de la gráfica 
    dataset, // El arreglo de datos 
    true, // Indica si lleva leyenda 
    true, // Indica si lleva tooltips 
    false); // Indica si son URls 
        return new ChartPanel(grafica,false);
        
    }
     
     public ChartPanel barras() { 
         definirRango();
    
         DefaultCategoryDataset dataset=llenarDataSetBarras();
         JFreeChart grafica=ChartFactory.createBarChart3D(
                 nombre,
                 datos,//etiqueta Categoria
                 valores,//etiqueta Valores
                 dataset,//datos
                 PlotOrientation.VERTICAL,//orientacion
                 true,//Leyenda
                 true,//tooltips
                 false);//URL   

        CategoryPlot plot = (CategoryPlot)grafica.getPlot();
        CategoryAxis xAxis = (CategoryAxis)plot.getDomainAxis();
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
                 
        return new ChartPanel(grafica,false);
         
    }
     
     public ChartPanel lineal() { 
         definirRango();
        DefaultCategoryDataset dataset = llenarDataSetLineal();
        
        JFreeChart grafica = ChartFactory.createLineChart( 
        nombre, // Titulo 
        datos, // Etiqueta de datos 
        valores, // Etiqueta de valores 
        dataset, // Datos 
        PlotOrientation.VERTICAL, // orientacion 
        true, // Incluye leyenda 
        true, // Incluye tooltips 
        false // urls 
        ); 
        
        CategoryPlot plot = (CategoryPlot)grafica.getPlot();
        CategoryAxis xAxis = (CategoryAxis)plot.getDomainAxis();
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        
        return new ChartPanel(grafica,false);

    }
     
     public DefaultCategoryDataset llenarDataSetBarras(){
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
         int usuarios=0;
         r=u.seleccionar("COUNT(*) as user",
                 "usuario,es", 
                 "es.codigoTipoUser=1 AND usuario.user=es.user");
         try {
            r.beforeFirst();
            if(r.next()){
                usuarios=r.getInt("user");
                 r=u.seleccionar("usuario.user,usuario.nombre,usuario.apellido",
                         "usuario,tipousuario", 
                         "tipousuario.codigoTipoUser=1");
                 r.beforeFirst();
                 for (int i=0;i<usuarios;i++){
                     r.next();
                     r2=u.seleccionar("COUNT(*) as ordenComp", 
                             "orden,procesa_audita",
                             "procesa_audita.user='"+r.getString("user")+"'"
                             + " AND procesa_audita.specimen=orden.specimen");
                     dataset.addValue(r2.getInt("ordenComp"),
                             "Ordenes Completas",
                             r.getString("usuario.nombre")+" "+r.getString("apellido") );                     
                 
                 }
            
            }
            else{
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return dataset;
     }  
     
     public DefaultPieDataset llenarDataSetPastel(){
      DecimalFormat df = new DecimalFormat("0.00"); 
      Double porc;
      DefaultPieDataset dataset = new DefaultPieDataset();
      String aux=" AND ";
      switch (t){
          case 1:{ //ordenes Totales.
               r = u.seleccionar("COUNT(distinct procesa_audita.specimen) AS orden", "orden,procesa_audita", condicion);
        try {
            if(condicion.equals(""))
                aux="";
            r.beforeFirst();
            if(r.next()){
                totalOrden=r.getDouble("orden");
                r=u.seleccionar("COUNT(distinct procesa_audita.specimen) as comp",
                        "orden, procesa_audita", 
                        condicion+aux+"tipoOrden=1 AND orden.specimen=procesa_audita.specimen");
                r.beforeFirst();
                if(r.next())
                    ordenCompleta=r.getDouble("comp");
                else
                    ordenCompleta=0.0;
                r=u.seleccionar("COUNT(distinct procesa_audita.specimen) as inc",
                        "orden, procesa_audita",
                        condicion+aux+"tipoOrden=2 AND orden.specimen=procesa_audita.specimen ");
                r.beforeFirst();
                if(r.next())
                    ordenIncompleta=r.getDouble("inc");
                else
                    ordenIncompleta=0.0;
                r=u.seleccionar("COUNT(distinct procesa_audita.specimen) as nada",
                        "orden, procesa_audita", 
                        condicion+aux+"tipoOrden=3 AND orden.specimen=procesa_audita.specimen");
                r.beforeFirst();
                if(r.next())
                    ordenNada=r.getDouble("nada");
                else
                    ordenNada=0.0;
                
                
            }
            else{
                JOptionPane.showMessageDialog(null, "No existen Ordenes Ingresadas al sistema", 
                    null, JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
        }
              break;
          }
              
          case 2:{//ordenes Individuales
              if(condicion.equals("")){
                aux="";}
              r = u.seleccionar("COUNT(distinct specimen) AS error", "procesa_audita", condicion+aux+"user='"+user+"'");
        try {            
            r.beforeFirst();
            if(r.next()){
                totalOrden=r.getDouble("error");
                r=u.seleccionar("COUNT(distinct procesa_audita.specimen) as comp", "orden, procesa_audita", 
                        condicion+aux+"orden.tipoOrden=1 AND procesa_audita.user='"+user+"' "
                        + "AND orden.specimen=procesa_audita.specimen");
                r.beforeFirst();
                if(r.next())
                    ordenCompleta=r.getDouble("comp");
                else
                    ordenCompleta=0.0;
                r=u.seleccionar("COUNT(distinct procesa_audita.specimen) as inc", 
                        "orden, procesa_audita", 
                        condicion+aux+"tipoOrden=2 AND user='"+user+"' AND orden.specimen=procesa_audita.specimen");
                r.beforeFirst();
                if(r.next())
                    ordenIncompleta=r.getDouble("inc");
                else
                    ordenIncompleta=0.0;
                r=u.seleccionar("COUNT(distinct procesa_audita.specimen) as nada", 
                        "orden,procesa_audita", 
                        condicion+aux+"tipoOrden=3 AND user='"+user+"' AND orden.specimen=procesa_audita.specimen");
                r.beforeFirst();
                if(r.next())
                    ordenNada=r.getDouble("nada");
                else
                    ordenNada=0.0;
                
                
            }
            else{
                JOptionPane.showMessageDialog(null, "No existen Ordenes Ingresadas al sistema", 
                    null, JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
        }
              break;
          }
              
          case 3:{//error globales
              r = u.seleccionar("COUNT(*) AS errorCom", "puede_tener", condicion);
        try {
            r.beforeFirst();
            if(r.next()){
                if(condicion.equals(""))
                    aux="";
                totalErrorCom=r.getInt("errorCom");
                if (totalErrorCom!=0){
                r=u.seleccionar("COUNT(*) as error","error", "");
                r.beforeFirst();
                if(r.next())
                    totalError=r.getInt("error");
                r=u.seleccionar("codigoError","error","");
                r.beforeFirst();
                for(int i=0;i<totalError;i++){  
                    r.next();
                    r2=u.seleccionar("COUNT(*) AS rec", "puede_tener", 
                            condicion+aux+"codigoError='"+r.getString("codigoError")+"'");
                    if(r2.getInt("rec")!=0){
                        porc=((r2.getDouble("rec")/totalErrorCom)*100);
                        dataset.setValue(r.getString("codigoError")+" "+df.format(porc)+"%", porc);  
                    }                 
                
                }                 
            }
                else
                    JOptionPane.showMessageDialog(null, "No hay errores registrados");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
        }
              break;
          }
              
          case 4:{//error individual
              if(condicion.equals(""))
                aux="";
              r = u.seleccionar("COUNT(*) AS errorCom", "puede_tener", condicion+aux+"user='"+user+"'");
        try {
            r.beforeFirst();
            if(r.next()){
                totalErrorCom=r.getInt("errorCom");
                if (totalErrorCom!=0){
                r=u.seleccionar("COUNT(*) as error","error", "");
                r.beforeFirst();
                if(r.next())
                    totalError=r.getInt("error");
                r=u.seleccionar("codigoError","error","");
                r.beforeFirst();
                for(int i=0;i<totalError;i++){  
                    r.next();
                    r2=u.seleccionar("COUNT(*) AS rec", "puede_tener", 
                            condicion+aux+"codigoError='"+r.getString("codigoError")+"' AND user='"+user+"'");
                    if(r2.getInt("rec")!=0){
                        porc=((r2.getDouble("rec")/totalErrorCom)*100);
                        dataset.setValue(r.getString("codigoError")+" "+df.format(porc)+"%", porc);  
                    }                 
                }
                }                 
            }
            else 
                JOptionPane.showMessageDialog(null, "El Agente no tiene errores");
        } catch (SQLException ex) {
            Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
        }
              break;
          }
      }
      if(t==1||t==2){
                //calcular porcentajes
                
                ordenCompleta=(ordenCompleta/totalOrden)*100;
                ordenIncompleta=(ordenIncompleta/totalOrden)*100;
                ordenNada=(ordenNada/totalOrden)*100;
                
                //enviar los datos
                 dataset.setValue("Ordenes Completas ("+df.format(ordenCompleta)+"%)",ordenCompleta); 
                 dataset.setValue("Ordenes Incompletas ("+df.format(ordenIncompleta)+"%)", ordenIncompleta); 
                 dataset.setValue("Ordenes Sin Hacen Nada ("+df.format(ordenNada)+"%)", ordenNada); 
      }
                 
         return dataset;
     
     }
     
    private DefaultCategoryDataset llenarDataSetLineal() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int [] rangos=new int[12];
        Double [] rangosD=new Double[12];
        switch(t){
            
//------------------------inicio Switch (t) Case 1-------------------------------
            case 1:{//tendencia errores globales
                switch(rango){
                    case 1:{//mensual                 
                        try {                        
                    r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-"+mes+"-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-"+mes+"-07 23:59:59'");
                    rangos[0]=r.getInt("error");
                    
                    r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-"+mes+"-08 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-"+mes+"-15 23:59:59'");
                    rangos[1]=r.getInt("error");
                    
                    r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-"+mes+"-16 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-"+mes+"-23 23:59:59'");
                    rangos[2]=r.getInt("error");
                    
                    r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-"+mes+"-24 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-"+mes+"-31 23:59:59'");
                    rangos[3]=r.getInt("error");
                
                    } catch (SQLException ex) {
                        Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        break;
                    }
                        
                    case 2:{//semestral
                        try{
                            if(semestre){//primer semestre
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-01-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-01-31 23:59:59'");                    
                                rangos[0]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-02-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-02-31 23:59:59'");                    
                                rangos[1]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-03-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-03-31 23:59:59'");                    
                                rangos[2]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-04-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-04-31 23:59:59'");                    
                                rangos[3]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-05-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-05-31 23:59:59'");                    
                                rangos[4]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-06-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-06-31 23:59:59'");                    
                                rangos[5]=r.getInt("error");
                                
                            }
                            else{//segundo semeste
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-07-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-07-31 23:59:59'");                    
                                rangos[0]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-08-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-08-31 23:59:59'");                    
                                rangos[1]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-09-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-09-31 23:59:59'");                    
                                rangos[2]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-10-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-10-31 23:59:59'");                    
                                rangos[3]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-11-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-11-31 23:59:59'");                    
                                rangos[4]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-12-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-12-31 23:59:59'");                    
                                rangos[5]=r.getInt("error");                            
                            }
                            } catch (SQLException ex) {
                        Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        
                    break;
                    }
                        
                    case 3:{//anual
                        try{
                        r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-01-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-01-31 23:59:59'");                    
                                rangos[0]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-02-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-02-31 23:59:59'");                    
                                rangos[1]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-03-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-03-31 23:59:59'");                    
                                rangos[2]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-04-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-04-31 23:59:59'");                    
                                rangos[3]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-05-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-05-31 23:59:59'");                    
                                rangos[4]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-06-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-06-31 23:59:59'");                    
                                rangos[5]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-07-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-07-31 23:59:59'");                    
                                rangos[6]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-08-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-08-31 23:59:59'");                    
                                rangos[7]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-09-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-09-31 23:59:59'");                    
                                rangos[8]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-10-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-10-31 23:59:59'");                    
                                rangos[9]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-11-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-11-31 23:59:59'");                    
                                rangos[10]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-12-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-12-31 23:59:59'");                    
                                rangos[11]=r.getInt("error");
                                
                    } catch (SQLException ex) {
                        Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                                break;
                    }
                
            }
                break;
            }
//-----------------------------inicio Switch (t) case 2:--------------------------
            case 2:{//tendencia errores individuales
                
                switch(rango){
                    case 1:{//mensual                 
                        try {
                        
                    r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-"+mes+"-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-"+mes+"-07 23:59:59' AND user='"+user+"'");
                    rangos[0]=r.getInt("error");
                    
                    r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-"+mes+"-08 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-"+mes+"-15 23:59:59' AND user='"+user+"'");
                    rangos[1]=r.getInt("error");
                    
                    r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-"+mes+"-16 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-"+mes+"-23 23:59:59' AND user='"+user+"'");
                    rangos[2]=r.getInt("error");
                    
                    r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-"+mes+"-24 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-"+mes+"-31 23:59:59' AND user='"+user+"'");
                    rangos[3]=r.getInt("error");
                
                    } catch (SQLException ex) {
                        Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        break;
                    }
                        
                    case 2:{//semestral
                        try{
                            if(semestre){//primer semestre
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-01-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-01-31 23:59:59' AND user='"+user+"'");                    
                                rangos[0]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-02-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-02-31 23:59:59' AND user='"+user+"'");                    
                                rangos[1]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-03-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-03-31 23:59:59' AND user='"+user+"'");                    
                                rangos[2]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-04-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-04-31 23:59:59' AND user='"+user+"'");                    
                                rangos[3]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-05-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-05-31 23:59:59' AND user='"+user+"'");                    
                                rangos[4]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-06-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-06-31 23:59:59' AND user='"+user+"'");                    
                                rangos[5]=r.getInt("error");
                                
                            }
                            else{//segundo semeste
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-07-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-07-31 23:59:59' AND user='"+user+"'");                    
                                rangos[0]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-08-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-08-31 23:59:59' AND user='"+user+"'");                    
                                rangos[1]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-09-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-09-31 23:59:59' AND user='"+user+"'");                    
                                rangos[2]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-10-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-10-31 23:59:59' AND user='"+user+"'");                    
                                rangos[3]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-11-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-11-31 23:59:59' AND user='"+user+"'");                    
                                rangos[4]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-12-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-12-31 23:59:59' AND user='"+user+"'");                    
                                rangos[5]=r.getInt("error");
                            
                            }
                            } catch (SQLException ex) {
                        Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        
                    break;
                    }
                        
                    case 3:{//anual
                        try{
                        r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-01-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-01-31 23:59:59' AND user='"+user+"'");                    
                                rangos[0]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-02-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-02-31 23:59:59' AND user='"+user+"'");                    
                                rangos[1]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-03-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-03-31 23:59:59' AND user='"+user+"'");                    
                                rangos[2]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-04-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-04-31 23:59:59' AND user='"+user+"'");                    
                                rangos[3]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-05-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-05-31 23:59:59' AND user='"+user+"'");                    
                                rangos[4]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-06-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-06-31 23:59:59' AND user='"+user+"'");                    
                                rangos[5]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-07-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-07-31 23:59:59' AND user='"+user+"'");                    
                                rangos[6]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-08-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-08-31 23:59:59' AND user='"+user+"'");                    
                                rangos[7]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-09-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-09-31 23:59:59' AND user='"+user+"'");                    
                                rangos[8]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-10-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-10-31 23:59:59' AND user='"+user+"'");                    
                                rangos[9]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-11-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-11-31 23:59:59' AND user='"+user+"'");                    
                                rangos[10]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","puede_tener","fecha BETWEEN '"+c.get(Calendar.YEAR)+"-12-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-12-31 23:59:59' AND user='"+user+"'");                    
                                rangos[11]=r.getInt("error");
                                
                    } catch (SQLException ex) {
                        Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                                break;
                    }
                
            }
                
                
            break;
            }
//-----------------------------inicio Switch (t) case 3:--------------------------               
            case 3:{//ordenes completas globales
                switch(rango){
                    case 1:{//mensual                 
                        try {
                        
                    r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-"+mes+"-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-"+mes+"-07 23:59:59'");
                            rangos[0]=r.getInt("error");
                    
                    r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-"+mes+"-08 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-"+mes+"-15 23:59:59'");
                    rangos[1]=r.getInt("error");
                    
                    r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-"+mes+"-16 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-"+mes+"-23 23:59:59'");
                    rangos[2]=r.getInt("error");
                    
                    r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-"+mes+"-24 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-"+mes+"-31 23:59:59'");
                    rangos[3]=r.getInt("error");
                
                    } catch (SQLException ex) {
                        Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        break;
                    }
                        
                    case 2:{//semestral
                        try{
                            if(semestre){//primer semestre
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-01-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-01-31 23:59:59'");                    
                                rangos[0]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-02-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-02-31 23:59:59'");                    
                                rangos[1]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-03-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-03-31 23:59:59'");                    
                                rangos[2]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-04-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-04-31 23:59:59'");                    
                                rangos[3]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-05-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-05-31 23:59:59'");                    
                                rangos[4]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-06-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-06-31 23:59:59'");                    
                                rangos[5]=r.getInt("error");
                                
                            }
                            else{//segundo semeste
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-07-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-07-31 23:59:59'");                    
                                rangos[0]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-08-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-08-31 23:59:59'");                    
                                rangos[1]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-09-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-09-31 23:59:59'");                    
                                rangos[2]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-10-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-10-31 23:59:59'");                    
                                rangos[3]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-11-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-11-31 23:59:59'");                    
                                rangos[4]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-12-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-12-31 23:59:59'");                    
                                rangos[5]=r.getInt("error");
                            
                            }
                            } catch (SQLException ex) {
                        Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        
                    break;
                    }
                        
                    case 3:{//anual
                        try{
                        r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-01-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-01-31 23:59:59'");                    
                                rangos[0]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-02-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-02-31 23:59:59'");                    
                                rangos[1]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-03-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-03-31 23:59:59'");                    
                                rangos[2]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-04-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-04-31 23:59:59'");                    
                                rangos[3]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-05-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-05-31 23:59:59'");                    
                                rangos[4]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-06-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-06-31 23:59:59'");                    
                                rangos[5]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-07-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-07-31 23:59:59'");                    
                                rangos[6]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-08-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-08-31 23:59:59'");                    
                                rangos[7]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-09-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-09-31 23:59:59'");                    
                                rangos[8]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-10-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-10-31 23:59:59'");                    
                                rangos[9]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-11-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-11-31 23:59:59'");                    
                                rangos[10]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-12-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-12-31 23:59:59'");                    
                                rangos[11]=r.getInt("error");
                                
                    } catch (SQLException ex) {
                        Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
                    }

                
            break;
            }
                }
                break;
            }
     //------------------------inicio swhitch (t) case 4:--------------------------------           
            case 4:{//ordenes completas individuales
                switch(rango){
                    case 1:{//mensual                 
                        try {
                        
                    r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-"+mes+"-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-"+mes+"-07 23:59:59'"+ "AND procesa_audita.user='"+user+"'");
                    
                    rangos[0]=r.getInt("error");
                    
                    r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-"+mes+"-08 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-"+mes+"-15 23:59:59'"+ "AND procesa_audita.user='"+user+"'");
                    rangos[1]=r.getInt("error");
                    
                    r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-"+mes+"-16 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-"+mes+"-23 23:59:59'"+ "AND procesa_audita.user='"+user+"'");
                    rangos[2]=r.getInt("error");
                    
                    r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-"+mes+"-24 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-"+mes+"-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");
                    rangos[3]=r.getInt("error");
                
                    } catch (SQLException ex) {
                        Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        break;
                    }
                        
                    case 2:{//semestral
                        try{
                            if(semestre){//primer semestre
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-01-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-01-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");                    
                                rangos[0]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-02-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-02-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");                    
                                rangos[1]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-03-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-03-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");                    
                                rangos[2]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-04-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-04-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");                    
                                rangos[3]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-05-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-05-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");                    
                                rangos[4]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-06-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-06-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");                    
                                rangos[5]=r.getInt("error");
                                
                            }
                            else{//segundo semeste
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-07-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-07-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");                    
                                rangos[0]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-08-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-08-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");                    
                                rangos[1]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-09-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-09-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");                    
                                rangos[2]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-10-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-10-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");                    
                                rangos[3]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-11-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-11-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");                    
                                rangos[4]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-12-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-12-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");                  
                                rangos[5]=r.getInt("error");
                            
                            }
                            } catch (SQLException ex) {
                        Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        
                    break;
                    }
                        
                    case 3:{//anual
                        try{
                        r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-01-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-01-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");                    
                                rangos[0]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-02-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-02-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");                    
                                rangos[1]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-03-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-03-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");                    
                                rangos[2]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-04-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-04-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");                    
                                rangos[3]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-05-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-05-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");                    
                                rangos[4]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-06-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-06-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");                    
                                rangos[5]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-07-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-07-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");                    
                                rangos[6]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-08-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-08-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");                    
                                rangos[7]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-09-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-09-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");                    
                                rangos[8]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-10-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-10-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");                    
                                rangos[9]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-11-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-11-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");                   
                                rangos[10]=r.getInt("error");
                                
                                r=u.seleccionar("COUNT(*) AS error","orden,procesa_audita","orden.specimen=procesa_audita.specimen AND "+ "fecha BETWEEN '"+c.get(Calendar.YEAR)+"-12-01 00:00:01'"+ " AND '"+c.get(Calendar.YEAR)+"-12-31 23:59:59'"+ "AND procesa_audita.user='"+user+"'");                    
                                rangos[11]=r.getInt("error");
                                
                    } catch (SQLException ex) {
                        Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
                    }

                
            break;
            }
                }
            break;
            }
//------------------Inicio switch(t) case 5:-----------------------------------------                
            case 5:{//relacion orden auditada/completa 
                switch(rango){
                    case 1:{//mensual
                        try{
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita","orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"+ " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-"+mes+"-"+ "01 00:00:01' AND '"+c.get(Calendar.YEAR)+"-"+mes+"-"+ "07 23:59:59'");
                        rangosD[0]=r.getDouble("aud")/r.getDouble("com");
                        
                        
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-"+mes+"-"
                                + "08 00:00:00' AND '"+c.get(Calendar.YEAR)+"-"+mes+"-"
                                + "15 23:59:59'");
                        rangosD[1]=r.getDouble("aud")/r.getDouble("com");
                        
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-"+mes+"-"
                                + "16 00:00:01' AND '"+c.get(Calendar.YEAR)+"-"+mes+"-"
                                + "23 23:59:59'");
                        rangosD[2]=r.getDouble("aud")/r.getDouble("com");
                        
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-"+mes+"-"
                                + "24 00:00:00' AND '"+c.get(Calendar.YEAR)+"-"+mes+"-"
                                + "31 23:59:59'");
                        rangosD[3]=r.getDouble("aud")/r.getDouble("com");
                        
                        
                       } catch (SQLException ex) {
                        Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                    break;
                    }
                        
                    case 2:{//semestral                        
                        try{
                            if(semestre){
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-01-01 00:00:01' AND "
                                + "'"+c.get(Calendar.YEAR)+"-01-31 23:59:59'");
                        rangosD[0]=r.getDouble("aud")/r.getDouble("com");
                        
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-02-01 00:00:01' AND "
                                + "'"+c.get(Calendar.YEAR)+"-02-31 23:59:59'");
                        rangosD[1]=r.getDouble("aud")/r.getDouble("com");
                        
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-03-01 00:00:01' AND "
                                + "'"+c.get(Calendar.YEAR)+"-03-31 23:59:59'");
                        rangosD[2]=r.getDouble("aud")/r.getDouble("com");
                        
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-04-01 00:00:01' AND "
                                + "'"+c.get(Calendar.YEAR)+"-04-31 23:59:59'");
                        rangosD[3]=r.getDouble("aud")/r.getDouble("com");
                        
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-05-01 00:00:01' AND "
                                + "'"+c.get(Calendar.YEAR)+"-05-31 23:59:59'");
                        rangosD[4]=r.getDouble("aud")/r.getDouble("com");
                        
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-06-01 00:00:01' AND "
                                + "'"+c.get(Calendar.YEAR)+"-06-31 23:59:59'");
                        rangosD[5]=r.getDouble("aud")/r.getDouble("com");
                        
                            }
                            
                            else{
                                 r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-07-01 00:00:01' AND "
                                + "'"+c.get(Calendar.YEAR)+"-07-31 23:59:59'");
                        rangosD[0]=r.getDouble("aud")/r.getDouble("com");
                        
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-08-01 00:00:01' AND "
                                + "'"+c.get(Calendar.YEAR)+"-08-31 23:59:59'");
                        rangosD[1]=r.getDouble("aud")/r.getDouble("com");
                        
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-09-01 00:00:01' AND "
                                + "'"+c.get(Calendar.YEAR)+"-09-31 23:59:59'");
                        rangosD[2]=r.getDouble("aud")/r.getDouble("com");
                        
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-10-01 00:00:01' AND "
                                + "'"+c.get(Calendar.YEAR)+"-10-31 23:59:59'");
                        rangosD[3]=r.getDouble("aud")/r.getDouble("com");
                        
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-11-01 00:00:01' AND "
                                + "'"+c.get(Calendar.YEAR)+"-11-31 23:59:59'");
                        rangosD[4]=r.getDouble("aud")/r.getDouble("com");
                        
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-12-01 00:00:01' AND "
                                + "'"+c.get(Calendar.YEAR)+"-12-31 23:59:59'");
                        rangosD[5]=r.getDouble("aud")/r.getDouble("com");
                            }
                            
                            
                       } catch (SQLException ex) {
                        Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                    break;
                    }
                        
                    case 3:{//anual
                        try{
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-01-01 00:00:01' AND "
                                + "'"+c.get(Calendar.YEAR)+"-01-31 23:59:59'");
                        rangosD[0]=r.getDouble("aud")/r.getDouble("com");
                        
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-02-01 00:00:01' AND "
                                + "'"+c.get(Calendar.YEAR)+"-02-31 23:59:59'");
                        rangosD[1]=r.getDouble("aud")/r.getDouble("com");
                        
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-03-01 00:00:01' AND "
                                + "'"+c.get(Calendar.YEAR)+"-03-31 23:59:59'");
                        rangosD[2]=r.getDouble("aud")/r.getDouble("com");
                        
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-04-01 00:00:01' AND "
                                + "'"+c.get(Calendar.YEAR)+"-04-31 23:59:59'");
                        rangosD[3]=r.getDouble("aud")/r.getDouble("com");
                        
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-05-01 00:00:01' AND "
                                + "'"+c.get(Calendar.YEAR)+"-05-31 23:59:59'");
                        rangosD[4]=r.getDouble("aud")/r.getDouble("com");
                        
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-06-01 00:00:01' AND "
                                + "'"+c.get(Calendar.YEAR)+"-06-31 23:59:59'");
                        rangosD[5]=r.getDouble("aud")/r.getDouble("com");
                        
                            
                                 r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-07-01 00:00:01' AND "
                                + "'"+c.get(Calendar.YEAR)+"-07-31 23:59:59'");
                        rangosD[6]=r.getDouble("aud")/r.getDouble("com");
                        
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-08-01 00:00:01' AND "
                                + "'"+c.get(Calendar.YEAR)+"-08-31 23:59:59'");
                        rangosD[7]=r.getDouble("aud")/r.getDouble("com");
                        
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-09-01 00:00:01' AND "
                                + "'"+c.get(Calendar.YEAR)+"-09-31 23:59:59'");
                        rangosD[8]=r.getDouble("aud")/r.getDouble("com");
                        
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-10-01 00:00:01' AND "
                                + "'"+c.get(Calendar.YEAR)+"-10-31 23:59:59'");
                        rangosD[9]=r.getDouble("aud")/r.getDouble("com");
                        
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-11-01 00:00:01' AND "
                                + "'"+c.get(Calendar.YEAR)+"-11-31 23:59:59'");
                        rangosD[10]=r.getDouble("aud")/r.getDouble("com");
                        
                        r=u.seleccionar("COUNT( DISTINCT procesa_audita.specimen ) AS aud, COUNT( DISTINCT orden.specimen ) AS com",
                                "orden, procesa_audita",
                                "orden.tipoOrden =1 AND procesa_audita.tipoOperacion =2"
                                + " AND fecha BETWEEN '"+c.get(Calendar.YEAR)+"-12-01 00:00:01' AND "
                                + "'"+c.get(Calendar.YEAR)+"-12-31 23:59:59'");
                        rangosD[11]=r.getDouble("aud")/r.getDouble("com");
                            
                            
                            
                       } catch (SQLException ex) {
                        Logger.getLogger(Graficas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        
                    break;
                    }
                }
            break;
            }
        }
        for (int k=0;k<12;k++)
        
        switch(rango){
            case 1:{
                if(t==5){
                dataset.addValue(rangosD[0],"Valores" , "Semana 1");
                dataset.addValue(rangosD[1],"Valores" , "Semana 2");
                dataset.addValue(rangosD[2],"Valores" , "Semana 3");
                dataset.addValue(rangosD[3],"Valores" , "Semana 4");
                }
                else{    
                dataset.addValue(rangos[0],"Valores" , "Semana 1");
                dataset.addValue(rangos[1],"Valores" , "Semana 2");
                dataset.addValue(rangos[2],"Valores" , "Semana 3");
                dataset.addValue(rangos[3],"Valores" , "Semana 4");
                }
            break;
            }
                
            case 2:{
                if (t==5){
                if(semestre){
                dataset.addValue(rangosD[0],"Valores" , "Enero");
                dataset.addValue(rangosD[1],"Valores" , "Febrero");
                dataset.addValue(rangosD[2],"Valores" , "Marzo");
                dataset.addValue(rangosD[3],"Valores" , "Abril");
                dataset.addValue(rangosD[4],"Valores" , "Mayo");
                dataset.addValue(rangosD[5],"Valores" , "Junio");
                }
                else{
                dataset.addValue(rangosD[0],"Valores" , "Julio");
                dataset.addValue(rangosD[1],"Valores" , "Agosto");
                dataset.addValue(rangosD[2],"Valores" , "Septiembre");
                dataset.addValue(rangosD[3],"Valores" , "Octubre");
                dataset.addValue(rangosD[4],"Valores" , "Noviembre");
                dataset.addValue(rangosD[5],"Valores" , "Diciembre");
                }
                }
                else{
                if(semestre){
                dataset.addValue(rangos[0],"Valores" , "Enero");
                dataset.addValue(rangos[1],"Valores" , "Febrero");
                dataset.addValue(rangos[2],"Valores" , "Marzo");
                dataset.addValue(rangos[3],"Valores" , "Abril");
                dataset.addValue(rangos[4],"Valores" , "Mayo");
                dataset.addValue(rangos[5],"Valores" , "Junio");
                }
                else{
                dataset.addValue(rangos[0],"Valores" , "Julio");
                dataset.addValue(rangos[1],"Valores" , "Agosto");
                dataset.addValue(rangos[2],"Valores" , "Septiembre");
                dataset.addValue(rangos[3],"Valores" , "Octubre");
                dataset.addValue(rangos[4],"Valores" , "Noviembre");
                dataset.addValue(rangos[5],"Valores" , "Diciembre");
                
                }
                }
            break;
            }
                    
            case 3:{
                if (t==5){
                dataset.addValue(rangosD[0],"Valores" , "Enero");
                dataset.addValue(rangosD[1],"Valores" , "Febrero");
                dataset.addValue(rangosD[2],"Valores" , "Marzo");
                dataset.addValue(rangosD[3],"Valores" , "Abril");
                dataset.addValue(rangosD[4],"Valores" , "Mayo");
                dataset.addValue(rangosD[5],"Valores" , "Junio");
                dataset.addValue(rangosD[6],"Valores" , "Julio");
                dataset.addValue(rangosD[7],"Valores" , "Agosto");
                dataset.addValue(rangosD[8],"Valores" , "Septiembre");
                dataset.addValue(rangosD[9],"Valores" , "Octubre");
                dataset.addValue(rangosD[10],"Valores" , "Noviembre");
                dataset.addValue(rangosD[11],"Valores" , "Diciembre");
                }
                else{
                dataset.addValue(rangos[0],"Valores" , "Enero");
                dataset.addValue(rangos[1],"Valores" , "Febrero");
                dataset.addValue(rangos[2],"Valores" , "Marzo");
                dataset.addValue(rangos[3],"Valores" , "Abril");
                dataset.addValue(rangos[4],"Valores" , "Mayo");
                dataset.addValue(rangos[5],"Valores" , "Junio");
                dataset.addValue(rangos[6],"Valores" , "Julio");
                dataset.addValue(rangos[7],"Valores" , "Agosto");
                dataset.addValue(rangos[8],"Valores" , "Septiembre");
                dataset.addValue(rangos[9],"Valores" , "Octubre");
                dataset.addValue(rangos[10],"Valores" , "Noviembre");
                dataset.addValue(rangos[11],"Valores" , "Diciembre");
                }
            break;
            }
                
        }

        return dataset;
    }
    
    private void definirRango(){
        if (rango==1){
             condicion="fecha BETWEEN '"+fechaInicio+" 00:00:01' and '"+fechaFin+" 23:59:59'";
                    
            }
        else if(rango==2){
                condicion="fecha BETWEEN '"+fechaInicio+" 00:00:01' and '"+fechaFin+" 23:59:59'";
        }
        else
            condicion="";    
       
    }
    
    
}
