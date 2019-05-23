package com.daviinacio.poo.ap3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Professor extends BaseModel implements Serializable {
	private List<Disciplina> disciplinas;
	
	public Professor() {
		this.disciplinas = new ArrayList<>();
	}
	
	public Professor(String nome) {
		this();
		this.nome = nome;
	}

	public Professor(int id, String nome) {
		this();
		this.id = id;
		this.nome = nome;
	}
	
	public void addDisciplina(Disciplina disciplina) {
		for(Disciplina d : this.disciplinas) {
			if(d.equals(disciplina)){
				System.err.println("Esse professor já ministra nessa disciplina");
				return;
			}
		}
		
		this.disciplinas.add(disciplina);
	}
	public void removeDisciplina(Disciplina displina) {
		this.disciplinas.remove(displina);
	}
	public List<Disciplina> listDisciplinas() {
		return this.disciplinas;
	}
	
	@Override
	public String toString() {
		return String.format("Professor(%s):\nid:\t%s\nnome:\t%s\ndisciplinas:\t%s\n",
				super.toString(), this.id, this.nome, this.disciplinas);
	}
}













