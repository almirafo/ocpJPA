package com.br.suppcomm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.transaction.Transactional;

@Entity	
@Transactional
public class PieChartOccupationSiteVO {
 
	 @Id	
	 private String name;
	 
	 @Column(name="total_capacity")
	 private Long totalCapacity;
	 private Long used;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getTotalCapacity() {
		return totalCapacity;
	}
	public void setTotalCapacity(Long totalCapacity) {
		this.totalCapacity = totalCapacity;
	}
	public Long getUsed() {
		return used;
	}
	public void setUsed(Long used) {
		this.used = used;
	}
	 
	 
}
