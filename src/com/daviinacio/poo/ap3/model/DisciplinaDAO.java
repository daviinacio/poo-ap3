package com.daviinacio.poo.ap3.model;

import java.io.File;

import com.daviinacio.poo.ap3.Program;

public class DisciplinaDAO extends DataSource<Disciplina>{
	public DisciplinaDAO() {
		super(new File(Program.dataStorageFolderPath, "DisciplinaStorage.osf"));
	}
	
	@Override
	public void delete(Disciplina e) {
		// Remove this 'Disciplina' from others DataSets
		DataSource<Professor> pdao = Program.professores;
		for(Professor p : pdao.list()) {
			p.removeDisciplina(e);
			pdao.update(p);
		}
		
		DataSource<Aluno> adao = Program.alunos;
		for(Aluno a : adao.list()) {
			a.removeDisciplina(e);
			adao.update(a);
		}
		
		super.delete(e);
	}
}
