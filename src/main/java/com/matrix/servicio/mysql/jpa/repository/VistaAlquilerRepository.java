/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.servicio.mysql.jpa.repository;

import com.matrix.servicio.mysql.jpa.entity.view.VistaAlquiler;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL
 */
@Repository
public interface VistaAlquilerRepository extends JpaRepository<VistaAlquiler, Long> {                    
    
    @Query("select v from VistaAlquiler v where v.fechaAlquiler between ?1 and ?2")
    public List<VistaAlquiler> getAlquilerFecha(Date fechaInicio, Date fechaFinal);
    
    @Query("select v from VistaAlquiler v where v.documento = ?1")
    public List<VistaAlquiler> getClienteDocumento(String documento);
}
