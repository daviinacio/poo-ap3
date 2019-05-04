package com.daviinacio.poo.ap3.model;

import java.io.Serializable;

public class Disciplina extends BaseModel implements Serializable {
	private Professor professor;
	private Aluno aluno;
	
	public Disciplina() {}
	
	public Disciplina(String nome) {
		this();
		this.nome = nome;
	}

	public Disciplina(String nome, Professor professor, Aluno aluno) {
		this();
		this.nome = nome;
		this.professor = professor;
		this.aluno = aluno;
	}

	public Disciplina(int id, String nome, Professor professor, Aluno aluno) {
		this();
		this.id = id;
		this.nome = nome;
		this.professor = professor;
		this.aluno = aluno;
	}

	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public boolean equals(Object obj) {
		return ((Disciplina) obj).getId() == this.getId();
	}
	
	@Override
	public String toString() {
		return String.format("{ Disciplina(%s) -> id: %s | nome: %s | aluno: %s | professor: %s }",
				super.toString(), this.id, this.nome, this.aluno, this.professor);
	}
}
