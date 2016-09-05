package com.suppcomm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.suppcomm.entity.Ivr;



@Repository
public interface IvrDAO extends JpaRepository<Ivr, Long>{
    public Ivr findByIvrCode(String ivrCode);
	
	public Ivr findByMachine(String maquine);

	@Query(name="findByIvrSiteMachine")
	public Ivr findBySiteandMachine(@Param("machine") String machine, @Param("siteCode") String siteCode);



	
	
}
