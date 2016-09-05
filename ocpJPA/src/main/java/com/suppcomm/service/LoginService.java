package com.suppcomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.suppcomm.entity.Login;
import com.suppcomm.dao.CompanyDAO;
import com.suppcomm.dao.LoginDao;



@Component("LoginService")
public class LoginService  {

	@Autowired LoginDao loginDao; 
	
	
	@Autowired CompanyDAO companyDao;
	
	
	public void save(Login login) {
		
		loginDao.save(login);
		

	}

	
	public void delete(Login login) {
		 loginDao.delete(login);
	}

	
	public Login findById(Login login) {
		return loginDao.findOne(login.getLoginId());
	}

	
	public Login findByEmail(Login login) {
		return loginDao.findByEmail(login.getEmail());
	}

	
	public Login FindByLogin(Login login) {
		return loginDao.FindByLogin(login);
	}

	
	public List<Login> getAll() {
		 
		return loginDao.findAll();
	}

	
	public Login getUserAccessLoginPass(String login, String password) {
		return loginDao.getUserAccessLoginPass(login, password);
	}

	
	public void update(Login login) {
		 loginDao.save(login);

	}

}
