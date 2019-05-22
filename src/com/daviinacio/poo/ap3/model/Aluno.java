package com.daviinacio.poo.ap3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Aluno extends BaseModel implements Serializable {
	private List<Disciplina> disciplinas;
	
	public Aluno() {
		this.disciplinas = new ArrayList<>();
	}
	
	public Aluno(String nome) {
		this();
		super.nome = nome;
	}

	public Aluno(int id, String nome) {
		this();
		this.id = id;
		super.nome = nome;
	}
	
	public void addDisciplina(Disciplina disciplina) {
		for(Disciplina d : this.disciplinas) {
			if(true){
				System.err.println("Esse aluno já cursa nessa disciplina");
				return;
			}
		}
		

		this.disciplinas.add(disciplina);
		disciplina.addAluno(this);
	}
	public void removeDisciplina(Disciplina displina) {
		this.disciplinas.remove(displina);
	}
	public List<Disciplina> listDisciplinas() {
		return this.disciplinas;
	}
	
	@Override
	public String toString() {
		return String.format("Aluno(%s):\nid:\t%s\nnome:\t%s\ndisciplinas:\t%s\n",
				super.toString(), this.id, this.nome, this.disciplinas);
	}
}
