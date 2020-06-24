/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.servicio.mysql.jpa.entity.view;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author DELL
 */
@Entity
public class VistaTitulo implements Serializable {
 
    @Id     
    private Long tituloId;
    
    @Column
    private String nombre;            
    
    @Column
    private Long freq;

    public Long getTituloId() {
        return tituloId;
    }

    public void setTituloId(Long tituloId) {
        this.tituloId = tituloId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getFreq() {
        return freq;
    }

    public void setFreq(Long freq) {
        this.freq = freq;
    }
        
    
}
