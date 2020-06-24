/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.servicio.bean.imp;

import com.matrix.excepcion.AppError;
import com.matrix.servicio.bean.ClienteServicio;
import com.matrix.servicio.mysql.jpa.entity.Cliente;
import com.matrix.servicio.mysql.jpa.repository.ClienteRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class ClienteServicioImp implements ClienteServicio{

    @Autowired
    private ClienteRepository repoCliente;
    
    @Override
    public List<Cliente> getCliente(String param, String valor) {
        return (List<Cliente>) repoCliente.findAll();
    }
    
    @Override
    public void agregarCliente(Cliente cliente) {
        Optional<Cliente> clienteDocumento = repoCliente.getClienteDocumento(cliente.getDocumento());        
        if(clienteDocumento.isPresent()) throw new AppError("Existe documento");
        repoCliente.save(cliente);
    }

    @Override
    public void editarCliente(Cliente cliente) {
        repoCliente.save(cliente);
    }   

    @Override
    public Cliente getCliente(String documento) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Optional<Cliente> clienteDocumento = repoCliente.getClienteDocumento(documento);
        return clienteDocumento.get();
    }
    
}
