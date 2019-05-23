package com.daviinacio.poo.ap3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.daviinacio.poo.ap3.Program;

public class Disciplina extends BaseModel implements Serializable {
	
	public Disciplina() { }
	
	public Disciplina(String nome) {
		this();
		this.nome = nome;
	}

	@Override
	public String toString() {
		
		return String.format("{ Disciplina(%s) -> id: %s | nome: %s }",
				super.toString(), this.id, this.nome);
	}
}
