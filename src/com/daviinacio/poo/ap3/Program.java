package com.daviinacio.poo.ap3;

import java.io.File;

import javax.swing.UnsupportedLookAndFeelException;

import com.daviinacio.poo.ap3.controller.CadastroAlunoController;
import com.daviinacio.poo.ap3.controller.ExibirAlunosController;
import com.daviinacio.poo.ap3.controller.ExibirProfessoresController;
import com.daviinacio.poo.ap3.model.Aluno;
import com.daviinacio.poo.ap3.model.AlunoDAO;
import com.daviinacio.poo.ap3.model.Disciplina;
import com.daviinacio.poo.ap3.model.DisciplinaDAO;
import com.daviinacio.poo.ap3.model.Professor;
import com.daviinacio.poo.ap3.model.ProfessorDAO;
import com.daviinacio.poo.ap3.view.CadastroAluno;
import com.daviinacio.poo.ap3.view.ExibirAlunos;
import com.daviinacio.poo.ap3.view.ExibirProfessores;

public class Program {
	public static final File dataStorageFolderPath = new File("C:/Users/Davi-PC/Desktop");
	
	public static AlunoDAO alunos;
	private static ExibirAlunosController exibirAlunosController;
	private static CadastroAlunoController cadastroAlunoController;
	public static ExibirAlunos exibirAlunos;
	public static CadastroAluno cadastroAluno;
	
	public static ProfessorDAO professores;
	private static ExibirProfessoresController exibirProfessoresController;
	public static ExibirProfessores exibirProfessores;
	
	public static DisciplinaDAO disciplinas;
	
	
	public static void main(String [] args) {
		// Models
		alunos = new AlunoDAO();
		professores = new ProfessorDAO();
		disciplinas = new DisciplinaDAO();
		
		// Controllers
		exibirAlunosController = new ExibirAlunosController(alunos);
		cadastroAlunoController = new CadastroAlunoController(alunos);
		
		exibirProfessoresController = new ExibirProfessoresController(professores);
		
		// Views
		exibirAlunos = new ExibirAlunos(exibirAlunosController);
		cadastroAluno = new CadastroAluno(cadastroAlunoController);
		
		exibirProfessores = new ExibirProfessores(exibirProfessoresController);
		
		// Add DaoListeners
		alunos.addDataSourceObserver(exibirAlunos);
		
		
		// Show frame
		//exibirAlunos.setVisible(true);
		exibirProfessores.setVisible(true);
		
		// Load content from storage file
		alunos.init();
		professores.init();
		disciplinas.init();
		
		//disciplinas.insert(new Disciplina("Programação Orientada a Objetos"));
		//disciplinas.insert(new Disciplina("Programação Estruturada"));
		
		/*for(Disciplina d : disciplinas.list()) {
			System.out.println(d);
			
			Aluno a = alunos.selectById(2);
			a.addDisciplina(d);
			alunos.update(a);
		}*/
		
		
		// Debug
		//for(Aluno a : alunos.list())
		//	System.out.println(a);
		
		
		/*for (int i = 0; i < 200; i++) {
			Aluno a = new Aluno("Nome do aluno" + i);
			alunos.insert(a);
			System.out.println(a);
		}*/
		
		/*try {
			for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				// Nimbus, Windows, Metal
				if("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
				}
					
			}
		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO: handle exception
		}*/
		
		//new ExibirAlunos().setVisible(true);
		
		
		
		
		/*for(Aluno a : alunos.list())
			System.out.println(a);
		
		for(Professor a : professores.list())
			System.out.println(a);
		
		for(Disciplina a : disciplinas.list())
			System.out.println(a);*/
		
		
		
		
		/*Aluno a1 = new Aluno("Nome do aluno1");
		Aluno a2 = new Aluno("Nome do aluno2");
		
		alunos.insert(a1);
		alunos.insert(a2);*/
		
		//for (int i = 0; i < 100; i++) {
		//	alunos.insert(new Aluno("Nome do aluno" + i));
		//}
		
		//alunos.insert(new Aluno("aluno12gfh3"));
		
		//System.out.println(alunos.selectByNome("aluno1"));
		
		//Aluno a = alunos.selectById(5);
		
		//a.setNome("aluno 2");
		
		//alunos.update(a);,
		
		//alunos.delete(alunos.selectById(1));
		
		//alunos.deleteById(3);
		
		//System.out.println(alunos.selectById(2));
		
		
		//professores.insert(new Professor("professor2"));
		
		//Disciplina d1 = disciplinas.selectById(1);
		//Professor p1 = professores.selectById(1);
		//Aluno a1 = alunos.selectById(1);
		
		//a1.setName("Nome do aluno1");
		
		//p1.addDisciplina(d1);
		//a1.addDisciplina(d1);
		
		//disciplinas.update(d1);
		//professores.update(p1);
		//alunos.update(a1);
		
		
		
		//disciplinas.insert(new Disciplina("Programação Orientada a Objetos"));
		//disciplinas.insert(new Disciplina("Programação Estruturada"));
	}
}
