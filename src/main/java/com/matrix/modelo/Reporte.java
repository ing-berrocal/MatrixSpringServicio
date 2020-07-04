/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.modelo;

import com.matrix.servicio.mysql.jpa.entity.view.VistaAlquiler;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Reporte {
    private int yinicio;
    private int yfinal;
    private VistaAlquiler vistaalquiler;
    private Integer cantidad = Integer.MAX_VALUE;

    public int getYinicio() {
        return yinicio;
    }

    public void setYinicio(int yinicio) {
        this.yinicio = yinicio;
        this.yfinal = yinicio+9;
    }

    public int getYfinal() {
        return yfinal;
    }   

    public VistaAlquiler getVistaalquiler() {
        return vistaalquiler;
    }

    public void setVistaalquiler(VistaAlquiler vistaalquiler) {
        this.vistaalquiler = vistaalquiler;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    public void setCantidad(List<VistaAlquiler> lista){
        if(lista.size() < cantidad){
            this.vistaalquiler = lista.get(0);
            cantidad = lista.size();
        }
    }
}
