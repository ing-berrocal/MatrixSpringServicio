/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.servicio.jpa;

import com.matrix.servicio.mysql.jpa.entity.Cliente;
import com.matrix.servicio.mysql.jpa.repository.ClienteRepository;
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
public class ClienteJPATest {
    
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private ClienteRepository clienteRepository;
    
    public ClienteJPATest() {
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
        Cliente c = new Cliente();
        c.setDocumento("1000006");
        c.setApellidos("A1000006");
        c.setNombres("N1000006");
        c.setDireccion("D1000006");
        c.setEmail("E1000006");
        c.setTelefono("T1000006");
        c.setFechaNacimiento(Calendar.getInstance().getTime());
        clienteRepository.save(c);
        
        List<Cliente> findAll = (List<Cliente>) clienteRepository.findAll();
        findAll.forEach((cliente)->{System.out.println(cliente.getDocumento());});
        Assert.notEmpty(findAll,"");        
    }
    
    @Test
    public void insertarTest() {
        
        Cliente c = new Cliente();
        c.setDocumento("100006");
        c.setApellidos("A100006");
        c.setNombres("N100006");
        c.setDireccion("D100006");
        c.setEmail("E100006");
        c.setTelefono("T100006");
        c.setFechaNacimiento(Calendar.getInstance().getTime());        
        clienteRepository.save(c);        
        assertNotNull(c.getId());
    }
    
    @Test
    public void insertarExcepcionTest() {     
        
        Cliente c = new Cliente();
        c.setDocumento("100005");
        c.setApellidos("A100006");
        c.setNombres("N100006");
        c.setDireccion("D100006");
        c.setEmail("E100006");
        c.setTelefono("T100006");
        c.setFechaNacimiento(Calendar.getInstance().getTime());        
        
        DataIntegrityViolationException assertThrows = Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            clienteRepository.save(c);        
        });
                        
    }
    
    @Test
    public void actualizarTest() {     
        String edicionDireccion = "MODF";
        Cliente clienteDocumento = clienteRepository.getClienteDocumento("100001").get();
        clienteDocumento.setDireccion(edicionDireccion);        
        clienteRepository.save(clienteDocumento);
        
        Cliente clienteDocumentoModificado = clienteRepository.getClienteDocumento("100001").get();                
        assertEquals(edicionDireccion, clienteDocumentoModificado.getDireccion());
    }
}
