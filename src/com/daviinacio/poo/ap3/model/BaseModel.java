package com.daviinacio.poo.ap3.model;

import java.io.Serializable;
import java.util.Observable;

abstract class BaseModel implements Serializable {
	protected int id;
	protected String nome;
	
	public int getId() {
		return id;
	}
	void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setName(String nome) {
		this.nome = nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		return ((BaseModel) obj).getId() == this.getId();
	}
}
