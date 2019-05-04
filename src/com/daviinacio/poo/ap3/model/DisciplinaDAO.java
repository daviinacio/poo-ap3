package com.daviinacio.poo.ap3.model;

import java.io.File;

import com.daviinacio.poo.ap3.Program;

public class DisciplinaDAO extends DataSource<Disciplina>{
	public DisciplinaDAO() {
		super(new File(Program.dataStorageFolderPath, "DisciplinaStorage.osf"));
	}
}
