/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.servicio.rest;

import com.matrix.domain.AlquilerModel;
import com.matrix.domain.TituloModel;
import com.matrix.servicio.bean.AlquilerServicio;
import com.matrix.servicio.mysql.jpa.entity.Alquiler;
import com.matrix.servicio.mysql.jpa.entity.view.VistaAlquiler;
import com.matrix.servicio.mysql.jpa.repository.PlataformaRepository;
import com.matrix.servicio.mysql.jpa.repository.ProductorRepository;
import com.matrix.servicio.mysql.jpa.repository.VistaAlquilerRepository;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/alquiler")
@CrossOrigin(origins = "*")
public class AlquilerRestController {
    
    @Autowired
    private AlquilerServicio alquilerServicio;    
    
    @Autowired
    private VistaAlquilerRepository vistaRepository;    
    
    @GetMapping
    public ResponseEntity getListadoAlquiler(){        
        List<Alquiler> titulo = alquilerServicio.getListado();
        return ResponseEntity.ok(titulo);
    }
    
    @GetMapping("/fecha")
    public ResponseEntity getListadoAlquilerFecha(
            @RequestParam 
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicial,
            @RequestParam 
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFinal){                                
        Calendar ff = Calendar.getInstance();
        ff.setTime(fechaFinal);
        ff.add(Calendar.DATE, 1);        
        List<VistaAlquiler> clienteDocumento = vistaRepository.getAlquilerFecha(fechaInicial, ff.getTime());
        return ResponseEntity.ok(clienteDocumento);
    }
    
    @PostMapping
    public ResponseEntity postTitulo(@RequestBody AlquilerModel alquiler){        
        alquilerServicio.agregarAlquiler(alquiler);        
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity putTitulo(@PathVariable("id") Long id){        
        alquilerServicio.editarAlquiler(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
