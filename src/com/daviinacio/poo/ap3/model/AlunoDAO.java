package com.daviinacio.poo.ap3.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.daviinacio.poo.ap3.Program;

public class AlunoDAO extends DataSource<Aluno>{
	
	public AlunoDAO() {
		super(new File(Program.dataStorageFolderPath, "AlunoStorage.osf"));
	}
}
