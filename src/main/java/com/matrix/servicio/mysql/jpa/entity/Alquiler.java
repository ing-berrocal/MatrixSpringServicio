/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.servicio.mysql.jpa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author DELL
 */
@Entity
public class Alquiler implements Serializable {
 
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
        
    @JoinColumn(name = "cliente_id", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cliente clienteId;
    
    @JoinColumn(name = "titulo_id", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Titulo tituloId;
    
    @Column
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAlquiler;
    
    @Column
    private Integer diasAlquiler;
    
    @Column
    private Double valorDia;
    
    @Column
    private Integer estado;
    
    @Column    
    private String observacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente cliente) {
        this.clienteId = cliente;
    }

    public Titulo getTituloId() {
        return tituloId;
    }

    public void setTituloId(Titulo titulo) {
        this.tituloId = titulo;
    }

    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(Date fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public Integer getDiasAlquiler() {
        return diasAlquiler;
    }

    public void setDiasAlquiler(Integer diasAlquiler) {
        this.diasAlquiler = diasAlquiler;
    }

    public Double getValorDia() {
        return valorDia;
    }

    public void setValorDia(Double valorDia) {
        this.valorDia = valorDia;
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

    
}
