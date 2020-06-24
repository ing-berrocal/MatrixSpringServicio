/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.servicio.bean;

import com.matrix.servicio.mysql.jpa.entity.Cliente;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface ClienteServicio {
    
    public List<Cliente> getCliente(String param,String valor);
    
    public Cliente getCliente(String documento);
    
    public void agregarCliente(Cliente cliente);
    
    public void editarCliente(Cliente cliente);
    
}
