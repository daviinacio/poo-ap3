package com.daviinacio.poo.ap3;

import java.io.File;

import com.daviinacio.poo.ap3.model.Aluno;
import com.daviinacio.poo.ap3.model.AlunoDAO;
import com.daviinacio.poo.ap3.model.Disciplina;
import com.daviinacio.poo.ap3.model.DisciplinaDAO;
import com.daviinacio.poo.ap3.model.Professor;
import com.daviinacio.poo.ap3.model.ProfessorDAO;

public class Program {
	public static final File dataStorageFolderPath = new File("C:/Users/Davi-PC/Desktop");
	
	private static AlunoDAO alunos = new AlunoDAO();
	private static ProfessorDAO professores = new ProfessorDAO();
	private static DisciplinaDAO disciplinas = new DisciplinaDAO();
	
	public static void main(String [] args) {
		//Aluno a1 = new Aluno("Nome do aluno1");
		//Aluno a2 = new Aluno("Nome do aluno2");
		
		//alunos.insert(a1);
		//alunos.insert(a2);
		
		//alunos.insert(new Aluno("aluno12gfh3"));
		
		//System.out.println(alunos.selectByNome("aluno1"));
		
		//Aluno a = alunos.selectById(5);
		
		//a.setNome("aluno 2");
		
		//alunos.update(a);,
		
		//alunos.delete(alunos.selectById(1));
		
		//alunos.deleteById(3);
		
		//System.out.println(alunos.selectById(2));
		
		
		//professores.insert(new Professor("professor2"));
		
		
		//disciplinas.insert(new Disciplina("Programação Orientada a Objetos"));
		//disciplinas.insert(new Disciplina("Programação Estruturada"));
	}
}
