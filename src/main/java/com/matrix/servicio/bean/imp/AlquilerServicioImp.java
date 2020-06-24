/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.servicio.bean.imp;

import com.matrix.domain.AlquilerModel;
import com.matrix.servicio.bean.AlquilerServicio;
import com.matrix.servicio.mysql.jpa.entity.Alquiler;
import com.matrix.servicio.mysql.jpa.entity.Cliente;
import com.matrix.servicio.mysql.jpa.entity.Titulo;
import com.matrix.servicio.mysql.jpa.repository.AlquilerRepository;
import com.matrix.servicio.mysql.jpa.repository.ClienteRepository;
import com.matrix.servicio.mysql.jpa.repository.TituloRepository;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class AlquilerServicioImp implements AlquilerServicio{

    @Autowired
    private AlquilerRepository alquilerRepository;        
    
    @Autowired
    private ClienteRepository clienteRepository;        
    
    @Autowired
    private TituloRepository tituloRepository;        

    @Override
    public List<Alquiler> getListado() {
        return (List<Alquiler>) alquilerRepository.findAll();
    }
    
    @Override
    public void agregarAlquiler(AlquilerModel alquiler) {
        
        Optional<Cliente> clienteId = clienteRepository.findById(alquiler.getCliente());
        Optional<Titulo> tituloId = tituloRepository.findById(alquiler.getTitulo());
        
        Alquiler a = new Alquiler();
        a.setClienteId(clienteId.get());
        a.setTituloId(tituloId.get());
        a.setValorDia(tituloId.get().getValorAlquiler());
        a.setFechaAlquiler(Calendar.getInstance().getTime());
        a.setDiasAlquiler(alquiler.getDias());
        a.setEstado(1);
        
        alquilerRepository.save(a);
    }   

    @Override
    public void editarAlquiler(Long id) {
        
        Optional<Alquiler> findById = alquilerRepository.findById(id);
        
        Alquiler get = findById.get();
        get.setEstado(2);
        alquilerRepository.save(get);
    }
}
