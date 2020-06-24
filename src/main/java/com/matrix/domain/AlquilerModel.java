/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.domain;

/**
 *
 * @author DELL
 */
public class AlquilerModel {
    
    private Long id;
    
    private Long cliente;
        
    private Long titulo;
        
    private Integer estado;
    
    private Integer dias;
    
    private String observacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public Long getTitulo() {
        return titulo;
    }

    public void setTitulo(Long titulo) {
        this.titulo = titulo;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public Integer getDias() {
        return dias;
    }                
}
