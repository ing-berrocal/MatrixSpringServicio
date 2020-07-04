/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.servicio.rest;

import com.matrix.modelo.Reporte;
import com.matrix.servicio.mysql.jpa.entity.view.VistaAlquiler;
import com.matrix.servicio.mysql.jpa.entity.view.VistaCliente;
import com.matrix.servicio.mysql.jpa.entity.view.VistaTitulo;
import com.matrix.servicio.mysql.jpa.repository.VistaAlquilerRepository;
import com.matrix.servicio.mysql.jpa.repository.VistaClienteRepository;
import com.matrix.servicio.mysql.jpa.repository.VistaTituloRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;
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
@CrossOrigin(origins = "*")
public class ReporteRestController {
    
    @Autowired
    private VistaClienteRepository vistaClienteRepository;
    
    @Autowired
    private VistaTituloRepository vistaTituloRepository;
    
    @Autowired
    private VistaAlquilerRepository vistaAlquilerRepository;
    
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
    
    @GetMapping("/reporte10")
    public ResponseEntity getRango(){        
        
        List<VistaAlquiler> findAll = vistaAlquilerRepository.findAll();        
        
        OptionalInt min = findAll.stream().mapToInt(VistaAlquiler::getFechaYear).min();
        OptionalInt max = findAll.stream().mapToInt(VistaAlquiler::getFechaYear).max();        
        List<Reporte> estadistica = new ArrayList<>();
        for(int i=min.getAsInt();i<=max.getAsInt();i+=10){
            Reporte newClass = new Reporte();
            newClass.setYinicio(i);                        
            final int j = i;
            List<VistaAlquiler> collect = findAll.stream().filter((alquiler)-> j <= alquiler.getFechaYear() &&  alquiler.getFechaYear() < j+10)
                    .collect(Collectors.toList());            
            Map<Long, List<VistaAlquiler>> collect1 = collect.stream().collect(Collectors.groupingBy(VistaAlquiler::getTituloId));
            collect1.forEach((k,m)->{               
               newClass.setCantidad(m);
            });
            estadistica.add(newClass);
        }                
        return ResponseEntity.ok(estadistica);
    }
}
