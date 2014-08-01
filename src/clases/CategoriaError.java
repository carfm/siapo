/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

/**
 *
 * @author Carlos y Jose
 */
public class CategoriaError {
    private String nombreCategoria;
    private String codigoCategoria;
    private int diasLimite;
    private int recurrenciaSoportada;

    /**
     * @return the nombreCategoria
     */
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    /**
     * @param nombreCategoria the nombreCategoria to set
     */
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    /**
     * @return the codigoCategoria
     */
    public String getCodigoCategoria() {
        return codigoCategoria;
    }

    /**
     * @param codigoCategoria the codigoCategoria to set
     */
    public void setCodigoCategoria(String codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    /**
     * @return the diasLimite
     */
    public int getDiasLimite() {
        return diasLimite;
    }

    /**
     * @param diasLimite the diasLimite to set
     */
    public void setDiasLimite(int diasLimite) {
        this.diasLimite = diasLimite;
    }

    /**
     * @return the recurrenciaSoportada
     */
    public int getRecurrenciaSoportada() {
        return recurrenciaSoportada;
    }

    /**
     * @param recurrenciaSoportada the recurrenciaSoportada to set
     */
    public void setRecurrenciaSoportada(int recurrenciaSoportada) {
        this.recurrenciaSoportada = recurrenciaSoportada;
    }
}
