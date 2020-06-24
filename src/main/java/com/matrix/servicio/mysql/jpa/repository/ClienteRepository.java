/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.servicio.mysql.jpa.repository;

import com.matrix.servicio.mysql.jpa.entity.Cliente;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL
 */
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {            
    
    @Query("select c from Cliente c where c.documento = ?1")
    public Optional<Cliente> getClienteDocumento(String documento);
    
    @Query("select c from Cliente c where c.email = ?1")
    public Cliente getClienteEmail(String email);
}
