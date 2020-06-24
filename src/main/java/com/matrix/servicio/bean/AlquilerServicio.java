/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.servicio.bean;

import com.matrix.domain.AlquilerModel;
import com.matrix.servicio.mysql.jpa.entity.Alquiler;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface AlquilerServicio {            
    
    public List<Alquiler> getListado();
    
    public void agregarAlquiler(AlquilerModel alquiler);        
    
    public void editarAlquiler(Long id);
    
}
