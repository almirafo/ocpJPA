package com.br.suppcomm.entity;

import java.io.Serializable;


import javax.persistence.*;


/**
 * The persistent class for the ivr database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="ivrListAll" ,query="select l from Ivr l order by l.site.name,l.ivrCode"),
	@NamedQuery(name="findByMachine" ,query="Select l from Ivr l where l.machine= :machine"),
	@NamedQuery(name="findByIvrCode" ,query="Select l from Ivr l where l.ivrCode= :ivrCode"),
	@NamedQuery(name="findByIvrSiteMachine" ,query="Select l from Ivr l where l.machine= :machine and l.siteCode= :siteCode"),
})
public class Ivr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ivr_id")
	private Long ivrId;

	@Column(name="ivr_code")
	private String ivrCode;

	
	@ManyToOne
	@JoinColumn(name="site_id")
	private Site site;
    
	@Column(name ="capacity")
	private Long capacity;
	
	@Column(name="machine")
	private  String machine;
	
	@Column(name="site_code")
	private  String siteCode;
	
	
	public Ivr() {
	}



	public Long getIvrId() {
		return ivrId;
	}



	public void setIvrId(Long ivrId) {
		this.ivrId = ivrId;
	}



	public String getIvrCode() {
		return ivrCode;
	}



	public void setIvrCode(String ivrCode) {
		this.ivrCode = ivrCode;
	}



	public Site getSite() {
		return site;
	}



	public void setSite(Site site) {
		this.site = site;
	}



	public Long getCapacity() {
		return capacity;
	}



	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}



	public String getMachine() {
		return machine;
	}



	public void setMachine(String machine) {
		this.machine = machine;
	}



	public String getSiteCode() {
		return siteCode;
	}



	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}



	

}