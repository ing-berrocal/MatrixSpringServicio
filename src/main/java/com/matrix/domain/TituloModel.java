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
public class TituloModel {
    
    private Long id;
    
    private String nombre;
        
    private Integer year;
        
    private String protagonista;
    
    private String director;
        
    private Long plataforma;
    
    private Long productor;
        
    private Integer inventario;
       
    private Integer disponible;
    
    private Double valoralquiler;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getProtagonista() {
        return protagonista;
    }

    public void setProtagonista(String protagonista) {
        this.protagonista = protagonista;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Long getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Long plataforma) {
        this.plataforma = plataforma;
    }

    public Integer getInventario() {
        return inventario;
    }

    public void setInventario(Integer inventario) {
        this.inventario = inventario;
    }

    public Integer getDisponible() {
        return disponible;
    }

    public void setDisponible(Integer disponible) {
        this.disponible = disponible;
    }

    public Double getValoralquiler() {
        return valoralquiler;
    }

    public void setValoralquiler(Double valorAlquiler) {
        this.valoralquiler = valorAlquiler;
    }

    public Long getProductor() {
        return productor;
    }

    public void setProductor(Long productor) {
        this.productor = productor;
    }        
}
