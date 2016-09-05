package com.br.suppcomm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.transaction.Transactional;



@Entity	
@Transactional
public class PieChartOccupationPortalVO {
	
	
  @Id
  @Column(name="portal_name")
  private String portalName;
 
 
  private Long used;
  

	public Long getUsed() {
		return used;
	}
	public void setUsed(Long used) {
		this.used = used;
	}
	public String getPortalName() {
		return portalName;
	}
	public void setPortalName(String portalName) {
		this.portalName = portalName;
	}
  
  
}
