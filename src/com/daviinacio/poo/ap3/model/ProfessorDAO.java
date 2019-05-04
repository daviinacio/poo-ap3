package com.daviinacio.poo.ap3.model;

import java.io.File;

import com.daviinacio.poo.ap3.Program;

public class ProfessorDAO extends DataSource<Professor> {
	public ProfessorDAO() {
		super(new File(Program.dataStorageFolderPath, "ProfessorStorage.osf"));
	}
}
