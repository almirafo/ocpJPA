package com.suppcomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.suppcomm.entity.Company;
import com.suppcomm.dao.CompanyDAO;

@Service
public class CompanyService {
	@Autowired CompanyDAO companyDAO;
	
	
	public void save(Company company){
		companyDAO.save(company);
	}


	public void remove(Company company) {
		companyDAO.delete(company);
		
	}


	public List<Company> lista() {

		return companyDAO.findAll();
	}


	public Company load(Company company) {
		
		return  companyDAO.findOne(company.getCompanyId());
	}
	
}
