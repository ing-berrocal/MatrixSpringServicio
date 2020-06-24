/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.servicio;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 *
 * @author DELL
 */
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter{

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
    }

    @Bean(name = "alquilerws")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema alquilerSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("AlquilerPort");
        definition.setTargetNamespace("http://matrix.com/alquiler");
        definition.setLocationUri("/ws");
        definition.setSchema(alquilerSchema);
        return definition;
    }

    @Bean
    public XsdSchema alquilerSchema() {
        return new SimpleXsdSchema(new ClassPathResource("consulta-alquiler.xsd"));
    }    
}
