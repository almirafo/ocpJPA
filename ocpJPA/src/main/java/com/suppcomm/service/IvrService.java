package com.suppcomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.suppcomm.entity.Ivr;
import com.suppcomm.dao.IvrDAO;




@Service
public class IvrService {
	
	@Autowired IvrDAO ivrDAO;
	
	public void save(Ivr ivr){
		ivrDAO.findByIvrCode(ivr.getIvrCode());
	}
	public void delete(Ivr ivr){
		ivrDAO.delete(ivr);
	};
	
	public Ivr findById(Ivr ivr)
	{
		return ivrDAO.findOne(ivr.getIvrId());
	};
	
	public Ivr findByIvrCode(Ivr ivr){
		return ivrDAO.findByIvrCode(ivr.getIvrCode());
	};

	public void update(Ivr ivr){
		ivrDAO.save(ivr);
	};
	
	
	public List<Ivr> getListAll(){
		return ivrDAO.findAll();
	};
	
	public Ivr findByIvrMachine(Ivr ivr){
		return ivrDAO.findByMachine(ivr.getMachine());
	};
	
	public Ivr findByIvrSiteMachine(Ivr ivr){
		return ivrDAO.findBySiteandMachine(ivr.getMachine(), ivr.getSiteCode());
	};

}
