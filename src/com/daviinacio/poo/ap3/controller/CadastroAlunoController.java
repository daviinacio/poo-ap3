package com.daviinacio.poo.ap3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.daviinacio.poo.ap3.Program;
import com.daviinacio.poo.ap3.model.Aluno;
import com.daviinacio.poo.ap3.model.AlunoDAO;
import com.daviinacio.poo.ap3.model.Disciplina;
import com.daviinacio.poo.ap3.view.CadastroAluno;

public class CadastroAlunoController implements ActionListener {
	private CadastroAluno view;
	private AlunoDAO model;
	
	private Aluno targetModel;
	private Disciplina selectedDisc;
	
	public CadastroAlunoController(AlunoDAO model) {
		this.model = model;
	}
	
	public void setView(CadastroAluno view) {
		this.view = view;
	}
	
	public void setTargetModel(Aluno targetModel) {
		this.targetModel = targetModel;
	}
	
	public void setSelectedDisciplina(Disciplina disciplina) {
		this.selectedDisc = disciplina;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("save")){
			this.targetModel.setName(view.getTxtName());
			this.model.update(this.targetModel);
			this.view.hide();
		}
		else
		if(e.getActionCommand().equals("insert")) {
			if(this.view.getTxtName().isEmpty()) {
				System.err.println("O campo [nome] está vazio");
				return;
			}

			this.targetModel.setName(view.getTxtName());
			this.model.insert(this.targetModel);
			
			this.view.hide();
		}
		else
		if(e.getActionCommand().equals("delete")) {
			this.model.delete(this.targetModel);
			
			this.view.hide();
		}
		else
		if(e.getActionCommand().equals("addDisc")) {
			System.out.println("Add Disciplina");
			
			Program.exibirDisciplinas.setOnItemSelectListener(new OnItemSelectListener<Disciplina>() {
				@Override
				public void OnItemSelect(Disciplina item) {
					System.out.println("Disciplina Selecionada: " + item);
					CadastroAlunoController.this.targetModel.addDisciplina(item);
					CadastroAlunoController.this.view.setVisible(false);
					CadastroAlunoController.this.view.refreshDisciplinas(targetModel.listDisciplinas());
					CadastroAlunoController.this.view.setVisible(true);
				}
			});
			
			Program.exibirDisciplinas.setVisible(true);
		}
		else
		if(e.getActionCommand().equals("removeDisc")) {
			System.out.println("Remove Disciplina");
			if(this.selectedDisc != null) {
				this.targetModel.removeDisciplina(selectedDisc);
				CadastroAlunoController.this.view.setVisible(false);
				CadastroAlunoController.this.view.refreshDisciplinas(targetModel.listDisciplinas());
				CadastroAlunoController.this.view.setVisible(true);
				((JButton) e.getSource()).setVisible(false);
			}
		}
	}
}
