package com.daviinacio.poo.ap3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.daviinacio.poo.ap3.Program;
import com.daviinacio.poo.ap3.model.Disciplina;
import com.daviinacio.poo.ap3.model.Professor;
import com.daviinacio.poo.ap3.model.ProfessorDAO;
import com.daviinacio.poo.ap3.view.CadastroProfessor;

public class CadastroProfessorController implements ActionListener {
	private CadastroProfessor view;
	private ProfessorDAO model;
	
	private Professor targetModel;
	private Disciplina selectedDisc;
	
	public CadastroProfessorController(ProfessorDAO model) {
		this.model = model;
	}
	
	public void setView(CadastroProfessor view) {
		this.view = view;
	}
	
	public void setTargetModel(Professor targetModel) {
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
						CadastroProfessorController.this.targetModel.addDisciplina(item);
						CadastroProfessorController.this.view.setVisible(false);
						CadastroProfessorController.this.view.refreshDisciplinas(targetModel.listDisciplinas());
						CadastroProfessorController.this.view.setVisible(true);
					}
				});
				
				Program.exibirDisciplinas.setVisible(true);
			}
			else
			if(e.getActionCommand().equals("removeDisc")) {
				System.out.println("Remove Disciplina");
				if(this.selectedDisc != null) {
					this.targetModel.removeDisciplina(selectedDisc);
					CadastroProfessorController.this.view.setVisible(false);
					CadastroProfessorController.this.view.refreshDisciplinas(targetModel.listDisciplinas());
					CadastroProfessorController.this.view.setVisible(true);
					((JButton) e.getSource()).setVisible(false);
				}
			}
	}
}
