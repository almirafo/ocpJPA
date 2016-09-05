package com.suppcomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.br.suppcomm.entity.Portal;
import com.br.suppcomm.entity.PortalLoginVO;
import com.suppcomm.dao.PortalDAO;



public class PortalService  {

	@Autowired PortalDAO portalDao;
	
	public void save(Portal portal) {
		portalDao.save(portal);

	}

	
	public void delete(Portal portal) {
		portalDao.delete(portal);
	}

	
	public Portal findById(Portal portal) {

		return portalDao.findOne(portal.getPortalId());
	}

	
	public Portal findByPortalNumber(Portal portal) {
		return portalDao.findByPortalNumber(portal.getPortalNumber());
	}

	public void update(Portal portal) {
		portalDao.save(portal);
		
	}

	public List<Portal> listAll() {
		return portalDao.findAll();
	}

	
	public List<PortalLoginVO> setSelectedAccessRights(List<PortalLoginVO> selectedAccessRights) {
		    Long loginId=selectedAccessRights.get(0).getLoginId();
		    portalDao.removeAllPortalsLogin(loginId);
		  	for( PortalLoginVO portal :selectedAccessRights){
	    		portalDao.associatePortalLogin(portal.getPortalId(), portal.getLoginId());
	    		
	    	}
		  	List<PortalLoginVO> retorno = listAllByLogin( loginId );
	    	
	    	return  retorno;
		}
    	
    	


	public List<PortalLoginVO> listAllByLogin(Long loginId) {
		
		return portalDao.listAllByLogin(loginId);
	}

}
