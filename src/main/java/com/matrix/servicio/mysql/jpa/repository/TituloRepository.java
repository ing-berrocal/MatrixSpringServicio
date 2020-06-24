/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.servicio.mysql.jpa.repository;

import com.matrix.servicio.mysql.jpa.entity.Titulo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL
 */
@Repository
public interface TituloRepository extends CrudRepository<Titulo, Long> {        
    
    //@Query("select v from VistaAlquiler v where v.fechaAlquiler between ?1 and ?2")
    @Query("select t from Titulo t where lower(t.nombre) like %:nombre%")
    Streamable<Titulo> findByNombreContaining(@Param("nombre") String nombre);
    
    @Query("select t from Titulo t where lower(t.director) like %:director%")
    Streamable<Titulo> findByDirectorContaining(@Param("director") String director);
    
    @Query("select t from Titulo t where lower(t.protagonista) like %:protagonista%")
    Streamable<Titulo> findByProtagonistaContaining(@Param("protagonista") String protagonista);
    
    @Query("select t from Titulo t JOIN t.productor p where p.id = ?1")
    Streamable<Titulo> findByProductor(Long productorId);
    
    @Query("select t from Titulo t JOIN t.plataforma p where p.id = ?1")
    Streamable<Titulo> findByPlataforma(Long plataformaId);
}
