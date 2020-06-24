/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.servicio.mysql.jpa.repository;

import com.matrix.servicio.mysql.jpa.entity.Alquiler;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL
 */
@Repository
public interface AlquilerRepository extends CrudRepository<Alquiler, Long> {                    
}
