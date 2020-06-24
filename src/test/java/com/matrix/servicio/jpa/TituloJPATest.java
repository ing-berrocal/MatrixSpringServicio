/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.servicio.jpa;

import com.matrix.servicio.mysql.jpa.entity.Cliente;
import com.matrix.servicio.mysql.jpa.entity.Titulo;
import com.matrix.servicio.mysql.jpa.repository.ClienteRepository;
import com.matrix.servicio.mysql.jpa.repository.TituloRepository;
import java.util.Calendar;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.util.Assert;

/**
 *
 * @author DELL
 */
//@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
@ActiveProfiles("test")
@TestPropertySource("/application-test.properties")
public class TituloJPATest {
    
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private TituloRepository tituloRepository;
    
    public TituloJPATest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void ListadoCLienteTest() {
                
        List<Titulo> findAll = (List<Titulo>) tituloRepository.findAll();        
        Assert.notEmpty(findAll,"");        
    }
    
    @Test
    public void insertarTest() {                
        //assertNotNull(c.getId());
    }
    
    @Test
    public void insertarExcepcionTest() {                     
        
        /*DataIntegrityViolationException assertThrows = Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            clienteRepository.save(c);        
        });*/
                        
    }
    
    @Test
    public void actualizarTest() {             
    }
}
