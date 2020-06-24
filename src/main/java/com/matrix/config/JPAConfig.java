/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matrix.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author DELL
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.matrix.servicio.mysql.jpa")
public class JPAConfig {
    
}
