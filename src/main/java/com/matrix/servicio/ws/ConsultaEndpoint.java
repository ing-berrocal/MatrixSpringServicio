/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.servicio.ws;

import com.matrix.alquiler.AlquilerDetalle;
import com.matrix.alquiler.GetAlquilerRequest;
import com.matrix.alquiler.GetAlquilerResponse;
import com.matrix.servicio.mysql.jpa.entity.view.VistaAlquiler;
import com.matrix.servicio.mysql.jpa.repository.VistaAlquilerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 *
 * @author DELL
 */
@Endpoint
public class ConsultaEndpoint {
    
    @Autowired
    private VistaAlquilerRepository vistaAlquilerRepository;
    
    @PayloadRoot(namespace = "http://matrix.com/alquiler", localPart = "GetAlquilerRequest")
    @ResponsePayload
    public GetAlquilerResponse processCourseDetailsRequest(@RequestPayload GetAlquilerRequest request) {        
        List<VistaAlquiler> clienteDocumento = vistaAlquilerRepository.getClienteDocumento(request.getDocumento());
        List<AlquilerDetalle> listada = new ArrayList<>();        
        clienteDocumento.forEach((a)->{
            AlquilerDetalle ad = new AlquilerDetalle();
            ad.setFecha(a.getFechaAlquiler().toString());
            ad.setFecha(a.getFechaEntrega().toString());
            ad.setTitulo(a.getNombre());
            ad.setEstado(a.getEstado() == 1 ? "En Espera":"Entregado");
            listada.add(ad);
        });
        
        
        GetAlquilerResponse response = new GetAlquilerResponse();
        response.setAlquilerDetalle(listada);
    
        return response;
    }

}