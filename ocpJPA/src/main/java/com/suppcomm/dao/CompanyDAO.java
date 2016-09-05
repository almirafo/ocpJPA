/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suppcomm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.suppcomm.entity.Company;




/**
 *
 * @author deoliva
 */
public interface CompanyDAO   extends JpaRepository<Company, Long> {
    
}
