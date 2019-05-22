package com.daviinacio.poo.ap3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.daviinacio.poo.ap3.Program;

public class Disciplina extends BaseModel implements Serializable {
	private Professor professor;
	private List<Aluno> alunos;
	
	public Disciplina() {
		this.alunos = new ArrayList<>();
		//this.alunos.add(Program.alunos.selectById(1));
	}
	
	public Disciplina(String nome) {
		this();
		this.nome = nome;
	}

	public Disciplina(String nome, Professor professor) {
		this();
		this.nome = nome;
		this.professor = professor;
	}

	public Disciplina(int id, String nome, Professor professor) {
		this();
		this.id = id;
		this.nome = nome;
		this.professor = professor;
	}

	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	
	public void addAluno(Aluno aluno) {
		for(Aluno d : this.alunos) {
			if(d.equals(aluno)){
				System.err.println("Essa disciplina já contem esse aluno");
				return;
			}
		}
		

		this.alunos.add(aluno);
		aluno.addDisciplina(this);
	}
	public void removeAluno(Aluno aluno) {
		this.alunos.remove(aluno);
	}
	public List<Aluno> listAlunos() {
		return this.alunos;
	}

	@Override
	public String toString() {
		int professorId = 0;
		List<String> alunosId = new ArrayList<>();
		
		try {
			for(Aluno a : this.alunos)
				alunosId.add(Integer.toString(a.getId()));
			
			professorId = this.professor.getId();
		} catch (NullPointerException ex) { }
		
		return String.format("{ Disciplina(%s) -> id: %s | nome: %s | alunos: %s | professor: %s }",
				super.toString(), this.id, this.nome, alunosId, professorId);
	}
}
