/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.servicio.bean;

import com.matrix.domain.TituloModel;
import com.matrix.servicio.mysql.jpa.entity.Titulo;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface TituloServicio {
    
    public List<Titulo> getListado(String parametro,String valor);        
    
    public Titulo getTitulo(Long id);        
    
    public void agregarTitulo(TituloModel titulo);
    
    public void editarTitulo(TituloModel titulo);
    
}
