package com.suppcomm.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.suppcomm.entity.Ivr;
import com.br.suppcomm.entity.Login;
import com.br.suppcomm.entity.Occupation;
import com.br.suppcomm.entity.OccupationHistory;
import com.br.suppcomm.entity.PieChartOccupationPortalVO;
import com.br.suppcomm.entity.PieChartOccupationSiteVO;
import com.br.suppcomm.entity.PieChartOccupationTotalVO;
import com.br.suppcomm.entity.Portal;
import com.br.suppcomm.entity.Site;
import com.suppcomm.dao.OccupationDAO;
import com.suppcomm.dao.OccupationHistoryDAO;


@Service
public class OccupationService  {

	@Autowired OccupationDAO occupationDao;
	@Autowired OccupationHistoryDAO occupationHistoryDao;


	
	public void save(Occupation occupation) {
		occupationDao.save(occupation);

	}

	
	public void remove(Occupation occupation) {
		occupationDao.delete(occupation);

	}

	
	public void release(Occupation occupation) {
		
		occupationDao.save(occupation);
		if(occupation.getCallId()!=null){
			OccupationHistory occupationHistory= new OccupationHistory();
			setOccupationHistory(occupation, occupationHistory);
			occupationHistoryDao.save(occupationHistory);
			occupationDao.delete(occupation);
		}
	}

	
	public void releaseAll(Ivr ivr) {
		occupationDao.releaseAll(ivr,"RELEASE",new Timestamp(System.currentTimeMillis()) );
		
		List<Occupation> occupations= occupationDao.listByIvr(ivr);
		for(Occupation occupation: occupations){
			OccupationHistory occupationHistory = new OccupationHistory();
			
			setOccupationHistory(occupation, occupationHistory);
			occupationHistoryDao.save(occupationHistory);
			
			occupationDao.delete(occupation);
			
		}

	}

	
	
	public void releaseAll(Ivr ivr, int minute) {
		occupationDao.releaseAllLastMinute(ivr, minute,"RELEASE",new Timestamp(System.currentTimeMillis()) ,new Timestamp(System.currentTimeMillis()) );
		
		List<Occupation> occupations= occupationDao.listByIvr(ivr);
		for(Occupation occupation: occupations){
			OccupationHistory occupationHistory = new OccupationHistory();
			
			setOccupationHistory(occupation, occupationHistory);
			occupationHistoryDao.save(occupationHistory);
			
			occupationDao.delete(occupation);
			
		}

	}


	
	public void releaseAllByPortal(Portal portal) {
		occupationDao.releaseAllByPortal( portal.getPortalNumber(),portal, new Timestamp(System.currentTimeMillis()) );
		
		List<Occupation> occupations= occupationDao.listByPortal(portal);
		for(Occupation occupation: occupations){
			OccupationHistory occupationHistory = new OccupationHistory();
			
			setOccupationHistory(occupation, occupationHistory);
			occupationHistoryDao.save(occupationHistory);
			
			occupationDao.delete(occupation);
			
		}

	}
	
	
	
	
	private void setOccupationHistory(Occupation occupation,
			OccupationHistory occupationHistory) {
		if(occupation.getCallId()!=null){
			occupationHistory.setCallid(occupation.getCallId());
			occupationHistory.setDatetimeHangup(occupation.getDatetimeHangup());
			occupationHistory.setDatetimeInCall(occupation.getDatetimeIncall());
			occupationHistory.setHangupStatus(occupation.getHangupStatus());
			occupationHistory.setIvrCode(occupation.getIvr().getIvrCode());
			occupationHistory.setIvrID(occupation.getIvr().getIvrId());
			occupationHistory.setMsisdn(occupation.getMsisdn());
			occupationHistory.setOccupationId(occupation.getOccupationId());
			occupationHistory.setPortalId(occupation.getPortal().getPortalId());
			occupationHistory.setPortalName(occupation.getPortal().getName());
			occupationHistory.setPortalNumber(occupation.getPortal().getPortalNumber());
			occupationHistory.setSiteId(occupation.getIvr().getSite().getSiteId());
			occupationHistory.setSiteName(occupation.getIvr().getSite().getName());
			occupationHistory.setChannel(occupation.getChannel());
		}
	}

	
	public Occupation findByMsisdn(Occupation occupation) {
	
		
		return occupationDao.findByMsisdn(occupation.getMsisdn());
	}

	
	public PieChartOccupationTotalVO totalOccupationByLogged() {
		
		return occupationDao.totalOccupationByLogged(null);
	}

	
	public List<PieChartOccupationPortalVO> portalOccupationByLogged(String order) {
		
		return occupationDao.portalOccupationByLogged(order);
	}

	
	public Occupation findByCallId(Occupation occupation) {
		
		return occupationDao.findByCallId(occupation.getCallId());
	}

	public List<PieChartOccupationSiteVO> portalOccupationSiteByLogged() {
		
		return occupationDao.portalOccupationSiteByLogged();
	}

	public List<PieChartOccupationSiteVO> portalOccupationSiteByLogged(Login login) {
		
		return occupationDao.portalOccupationSiteByLogged(login.getLoginId());
	}
	
	
	
	public List<PieChartOccupationSiteVO> portalOccupationUFByLogged(
	Login login){
		
		return occupationDao.portalOccupationUFByLogged(login.getLoginId());
	}
	
	public PieChartOccupationSiteVO portalOccupationSiteByLogged(Site site) {
		
		return occupationDao.portalOccupationSiteByLogged(site);
	}

	public List<PieChartOccupationPortalVO> portalSiteOccupationByLogged(Site site) {
		
		return occupationDao.portalSiteOccupationByLogged(site);
	}

	
}
