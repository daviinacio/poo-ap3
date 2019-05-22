package com.daviinacio.poo.ap3.model;

import java.io.File;

import com.daviinacio.poo.ap3.Program;

public class ProfessorDAO extends DataSource<Professor> {
	public ProfessorDAO() {
		super(new File(Program.dataStorageFolderPath, "ProfessorStorage.osf"));
	}
	
	@Override
	public void delete(Professor e) {
		super.delete(e);
		
		// Remove this 'Aluno' from others DataSets
		DataSource<Disciplina> ddao = Program.disciplinas;
		for(Disciplina d : ddao.list()) {
			if(d.getProfessor().equals(e))
				d.setProfessor(null);
			
			ddao.update(d);
		}
	}
}
