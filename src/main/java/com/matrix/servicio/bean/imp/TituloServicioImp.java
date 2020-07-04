/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.servicio.bean.imp;

import com.matrix.domain.TituloModel;
import com.matrix.excepcion.AppError;
import com.matrix.servicio.bean.TituloServicio;
import com.matrix.servicio.mysql.jpa.entity.Plataforma;
import com.matrix.servicio.mysql.jpa.entity.Productor;
import com.matrix.servicio.mysql.jpa.entity.Titulo;
import com.matrix.servicio.mysql.jpa.repository.PlataformaRepository;
import com.matrix.servicio.mysql.jpa.repository.ProductorRepository;
import com.matrix.servicio.mysql.jpa.repository.TituloRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class TituloServicioImp implements TituloServicio{

    @Autowired
    private TituloRepository repoTitulo;        

    @Autowired
    private PlataformaRepository palataformaRepository;
    
    @Autowired
    private ProductorRepository productorRepository;
    
    @Override
    public List<Titulo> getListado(String parametro,String valor) {
        List<Titulo> lista = new ArrayList<>();
        Streamable<Titulo> findByNombreContaining = null;
        if(valor != null)
            valor = valor.toLowerCase();
        if("t".equalsIgnoreCase(parametro))
            findByNombreContaining = repoTitulo.findByNombreContaining(valor);
        else if("d".equalsIgnoreCase(parametro))            
            findByNombreContaining = repoTitulo.findByDirectorContaining(valor);
        else if("pt".equalsIgnoreCase(parametro))
            findByNombreContaining = repoTitulo.findByProtagonistaContaining(valor);
        else if("pl".equalsIgnoreCase(parametro))        
            findByNombreContaining = repoTitulo.findByPlataforma(Long.valueOf(valor));
        else if("pr".equalsIgnoreCase(parametro))        
            findByNombreContaining = repoTitulo.findByProductor(Long.valueOf(valor));                                                               
        //lista.addAll(findByNombreContaining.filter(distinctByKey(p->p.getId())).toList());
        if(findByNombreContaining == null)
            lista.addAll((List<Titulo>) repoTitulo.findAll());
        else
            lista.addAll(findByNombreContaining.toList());
                
        return lista;
    }

    @Override
    public void agregarTitulo(TituloModel titulo) {
        
        Optional<Plataforma> plataformaId = palataformaRepository.findById(titulo.getPlataforma());
        Optional<Productor> productorId = productorRepository.findById(titulo.getProductor());
        
        Titulo t = new Titulo();
        t.setDirector(titulo.getDirector());
        t.setDisponible(titulo.getInventario());
        t.setInventario(titulo.getInventario());
        t.setNombre(titulo.getNombre());
        t.setPlataforma(plataformaId.get());
        t.setProductor(productorId.get());
        t.setProtagonista(titulo.getProtagonista());
        t.setYear(titulo.getYear());        
        t.setValorAlquiler(titulo.getValoralquiler());
        repoTitulo.save(t);        
    }

    @Override
    public void editarTitulo(TituloModel titulo) {
        
        Optional<Plataforma> plataformaId = palataformaRepository.findById(titulo.getPlataforma());
        Optional<Productor> productorId = productorRepository.findById(titulo.getProductor());
        
        Titulo get = repoTitulo.findById(titulo.getId()).orElseThrow(()->new AppError("No existe titulo"));
        
        get.setDirector(titulo.getDirector());
        //get.setDisponible(titulo.getDisponible());
        get.setInventario(titulo.getInventario());
        get.setNombre(titulo.getNombre());
        get.setPlataforma(plataformaId.get());
        get.setProductor(productorId.get());
        get.setProtagonista(titulo.getProtagonista());
        get.setYear(titulo.getYear());
        get.setValorAlquiler(titulo.getValoralquiler());        
        repoTitulo.save(get);
    }
    
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) 
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    @Override
    public Titulo getTitulo(Long id) {
        return repoTitulo.findById(id).get();
    }
}
