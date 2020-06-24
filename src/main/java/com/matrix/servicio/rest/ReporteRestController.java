/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.servicio.rest;

import com.matrix.servicio.mysql.jpa.entity.view.VistaCliente;
import com.matrix.servicio.mysql.jpa.entity.view.VistaTitulo;
import com.matrix.servicio.mysql.jpa.repository.VistaClienteRepository;
import com.matrix.servicio.mysql.jpa.repository.VistaTituloRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/reporte")
@CrossOrigin(origins = "http://localhost:8100")
public class ReporteRestController {
    
    @Autowired
    private VistaClienteRepository vistaClienteRepository;
    
    @Autowired
    private VistaTituloRepository vistaTituloRepository;
    
    @GetMapping("/cliente")
    public ResponseEntity getVistaClienteFreq(){        
        List<VistaCliente> item = vistaClienteRepository.getVistaCliente();
        return ResponseEntity.ok(item);
    }
    
    @GetMapping("/titulo")
    public ResponseEntity getTituloFreq(){        
        List<VistaTitulo> item = vistaTituloRepository.getVistaTitulo();
        return ResponseEntity.ok(item);
    }
}
