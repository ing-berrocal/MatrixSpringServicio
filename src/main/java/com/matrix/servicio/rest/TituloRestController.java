/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.servicio.rest;

import com.matrix.domain.TituloModel;
import com.matrix.servicio.bean.TituloServicio;
import com.matrix.servicio.mysql.jpa.entity.Titulo;
import com.matrix.servicio.mysql.jpa.repository.PlataformaRepository;
import com.matrix.servicio.mysql.jpa.repository.ProductorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/titulo")
@CrossOrigin(origins = "http://localhost:8100")
public class TituloRestController {
    
    
    @Autowired
    private PlataformaRepository plataformaRepository;
    
    @Autowired
    private ProductorRepository productorRepository;
    
    @Autowired
    private TituloServicio tituloServicio;
    
    
    @GetMapping("/plataforma")
    public ResponseEntity getListadoPlataforma(){                
        return ResponseEntity.ok(plataformaRepository.findAll());
    }
    
    @GetMapping("/producto")
    public ResponseEntity getListadoProductor(){                
        return ResponseEntity.ok(productorRepository.findAll());
    }
    
    @GetMapping
    public ResponseEntity getListadoTitulo(@RequestParam(required = false) String parametro,
            @RequestParam(required = false) String valor){        
                        
        List<Titulo> titulo = tituloServicio.getListado(parametro,valor);
        return ResponseEntity.ok(titulo);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getListadoTitulo(@PathVariable Long id){        
                        
        Titulo titulo = tituloServicio.getTitulo(id);
        return ResponseEntity.ok(titulo);
    }
    
    @PostMapping
    public ResponseEntity postTitulo(@RequestBody TituloModel titulo){        
        tituloServicio.agregarTitulo(titulo);        
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PutMapping
    public ResponseEntity putTitulo(@RequestBody TituloModel titulo){        
        tituloServicio.editarTitulo(titulo);        
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
