package com.suppcomm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.suppcomm.entity.Site;


public interface SiteDAO extends JpaRepository<Site, Long>{
    
}
