package com.suppcomm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.suppcomm.entity.Login;

@Repository("loginDao")
public interface LoginDao extends JpaRepository<Login, Long>{

	public Login findByloginId(Long id);
	public Login findByEmail(String email);
	public Login FindByLogin(Login login);
	@Query(value="from Login where email = :login and password = :senha")
	public Login getUserAccessLoginPass( @Param("login") String login, @Param("senha")  String senha);
	
}
