package com.br.suppcomm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.transaction.Transactional;



@Entity	
@Transactional
public class PieChartOccupationTotalVO {
	
	
  @Id  
  @Column(name="total_capacity")
  private Long totalCapacity;
  private Long used;
  
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
