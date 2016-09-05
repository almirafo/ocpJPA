package com.br.suppcomm;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.suppcomm.dao.LoginDao;
import com.suppcomm.service.LoginService;


@RunWith(SpringJUnit4ClassRunner.class)

@SpringApplicationConfiguration(classes = OcpJpaApplication.class)
@Configuration
public class TestUnit {

	@Autowired private LoginService loginService;
	
	@Test
	public void test() {
		
		loginService.getAll();
		System.out.println("????");
		
	}

}
