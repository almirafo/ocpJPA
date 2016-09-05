package com.suppcomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.suppcomm.entity.Site;
import com.suppcomm.dao.SiteDAO;


@Service
public class SiteService{

	@Autowired SiteDAO siteDao; 

	
	public void save(Site site) {
		siteDao.save(site);
		
	}

	
	public List<Site> listAll() {

		return siteDao.findAll();
	}

	
	public Site load(Site site) {
		
		return siteDao.findOne(site.getSiteId());
	}

	
	public void remove(Site site) {
			siteDao.delete(site.getSiteId());
		
	}

	
	public void update(Site site) {
		siteDao.save(site);
		
	}

	

		

}
