/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.servicio.mysql.jpa.repository;

import com.matrix.servicio.mysql.jpa.entity.view.VistaTitulo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL
 */
@Repository
public interface VistaTituloRepository extends JpaRepository<VistaTitulo, Long> {                    
    
    @Query("select v from VistaTitulo v ORDER BY v.freq")
    public List<VistaTitulo> getVistaTitulo();
}
