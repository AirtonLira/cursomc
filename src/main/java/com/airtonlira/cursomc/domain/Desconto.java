package com.airtonlira.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Desconto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nomeDesconto;
	
	
	public Desconto() {
		
	}


	public Desconto(Integer id, String nomeDesconto) {
		super();
		this.id = id;
		this.nomeDesconto = nomeDesconto;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNomeDesconto() {
		return nomeDesconto;
	}


	public void setNomeDesconto(String nomeDesconto) {
		this.nomeDesconto = nomeDesconto;
	}


	
	
	

}
