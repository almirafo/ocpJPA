package com.br.suppcomm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.transaction.Transactional;

@Entity		
@Transactional
public class PieChartOccupationVO {
	
	
  @Id
  private String name;
  private String ivrCode;
  private Long capacity;
  private Long used;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getIvrCode() {
	return ivrCode;
}
public void setIvrCode(String ivrCode) {
	this.ivrCode = ivrCode;
}
public Long getCapacity() {
	return capacity;
}
public void setCapacity(Long capacity) {
	this.capacity = capacity;
}
public Long getUsed() {
	return used;
}
public void setUsed(Long used) {
	this.used = used;
}
  
  
}
