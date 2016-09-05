package com.br.suppcomm.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the area_code database table.
 * 
 */
@Entity
@Table(name="area_code")
public class AreaCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AREA_CODE_IDAREACODE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AREA_CODE_IDAREACODE_GENERATOR")
	@Column(name="id_area_code")
	private Long idAreaCode;

	private String code;

	private String description;

	
	public AreaCode() {
	}

	public Long getIdAreaCode() {
		return this.idAreaCode;
	}

	public void setIdAreaCode(Long idAreaCode) {
		this.idAreaCode = idAreaCode;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}