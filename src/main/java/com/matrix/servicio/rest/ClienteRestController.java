/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.servicio.rest;

import com.matrix.servicio.bean.ClienteServicio;
import com.matrix.servicio.mysql.jpa.entity.Cliente;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:8100")
public class ClienteRestController {
    
    @Autowired
    private ClienteServicio clienteServicio;
    
    @GetMapping
    public ResponseEntity getListado(){        
        List<Cliente> cliente = clienteServicio.getCliente(null,null);
        return ResponseEntity.ok(cliente);
    }
    
    @GetMapping("/{documento}")
    public ResponseEntity getCliente(@PathVariable("documento") String documento){        
        Cliente cliente = clienteServicio.getCliente(documento);
        return ResponseEntity.ok(cliente);
    }
    
    @PostMapping
    public ResponseEntity postCliente(@RequestBody Cliente cliente){        
        clienteServicio.agregarCliente(cliente);        
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PutMapping
    public ResponseEntity putCliente(@RequestBody Cliente cliente){        
        clienteServicio.editarCliente(cliente);        
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
