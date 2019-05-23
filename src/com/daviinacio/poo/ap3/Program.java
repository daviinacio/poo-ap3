package com.daviinacio.poo.ap3;

import java.io.File;

import javax.swing.UnsupportedLookAndFeelException;

import com.daviinacio.poo.ap3.controller.CadastroAlunoController;
import com.daviinacio.poo.ap3.controller.CadastroDisciplinaController;
import com.daviinacio.poo.ap3.controller.CadastroProfessorController;
import com.daviinacio.poo.ap3.controller.ExibirAlunosController;
import com.daviinacio.poo.ap3.controller.ExibirDisciplinasController;
import com.daviinacio.poo.ap3.controller.ExibirProfessoresController;
import com.daviinacio.poo.ap3.controller.MainController;
import com.daviinacio.poo.ap3.model.Aluno;
import com.daviinacio.poo.ap3.model.AlunoDAO;
import com.daviinacio.poo.ap3.model.Disciplina;
import com.daviinacio.poo.ap3.model.DisciplinaDAO;
import com.daviinacio.poo.ap3.model.Professor;
import com.daviinacio.poo.ap3.model.ProfessorDAO;
import com.daviinacio.poo.ap3.view.CadastroAluno;
import com.daviinacio.poo.ap3.view.CadastroDisciplina;
import com.daviinacio.poo.ap3.view.CadastroProfessor;
import com.daviinacio.poo.ap3.view.ExibirAlunos;
import com.daviinacio.poo.ap3.view.ExibirDisciplinas;
import com.daviinacio.poo.ap3.view.ExibirProfessores;
import com.daviinacio.poo.ap3.view.MainView;

public class Program {
	public static final File dataStorageFolderPath = new File(System.getenv("APPDATA"), "daviinacio/poo-ap3");
	
	public static AlunoDAO alunos;
	private static ExibirAlunosController exibirAlunosController;
	private static CadastroAlunoController cadastroAlunoController;
	public static ExibirAlunos exibirAlunos;
	public static CadastroAluno cadastroAluno;
	
	public static ProfessorDAO professores;
	private static ExibirProfessoresController exibirProfessoresController;
	private static CadastroProfessorController cadastroProfessorController;
	public static ExibirProfessores exibirProfessores;
	public static CadastroProfessor cadastroProfessor;
	
	public static DisciplinaDAO disciplinas;
	private static ExibirDisciplinasController exibirDisciplinasController;
	private static CadastroDisciplinaController cadastroDisciplinaController;
	public static ExibirDisciplinas exibirDisciplinas;
	public static CadastroDisciplina cadastroDisciplina;
	
	
	private static MainController mainController;
	public static MainView mainView;
	
	
	public static void main(String [] args) {
		dataStorageFolderPath.mkdirs();
		
		System.out.println(dataStorageFolderPath.getAbsolutePath());
		
		// Models
		alunos = new AlunoDAO();
		professores = new ProfessorDAO();
		disciplinas = new DisciplinaDAO();
		
		// Controllers
		exibirAlunosController = new ExibirAlunosController(alunos);
		cadastroAlunoController = new CadastroAlunoController(alunos);
		
		exibirProfessoresController = new ExibirProfessoresController(professores);
		cadastroProfessorController = new CadastroProfessorController(professores);
		
		exibirDisciplinasController = new ExibirDisciplinasController(disciplinas);
		cadastroDisciplinaController = new CadastroDisciplinaController(disciplinas);
		
		mainController = new MainController();
		
		// Views
		exibirAlunos = new ExibirAlunos(exibirAlunosController);
		cadastroAluno = new CadastroAluno(cadastroAlunoController);
		
		exibirProfessores = new ExibirProfessores(exibirProfessoresController);
		cadastroProfessor = new CadastroProfessor(cadastroProfessorController);
		
		exibirDisciplinas = new ExibirDisciplinas(exibirDisciplinasController);
		cadastroDisciplina = new CadastroDisciplina(cadastroDisciplinaController);
		
		mainView = new MainView(mainController);
		
		// Add DaoListeners
		alunos.addDataSourceObserver(exibirAlunos);
		professores.addDataSourceObserver(exibirProfessores);
		disciplinas.addDataSourceObserver(exibirDisciplinas);
		
		// Show frame
		mainView.setVisible(true);
		
		// Load content from storage file
		alunos.init();
		professores.init();
		disciplinas.init();
		
		
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
	}
}
