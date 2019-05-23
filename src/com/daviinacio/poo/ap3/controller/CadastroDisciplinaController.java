package com.daviinacio.poo.ap3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.daviinacio.poo.ap3.model.Disciplina;
import com.daviinacio.poo.ap3.model.DisciplinaDAO;
import com.daviinacio.poo.ap3.model.Professor;
import com.daviinacio.poo.ap3.model.ProfessorDAO;
import com.daviinacio.poo.ap3.view.CadastroDisciplina;
import com.daviinacio.poo.ap3.view.CadastroProfessor;

public class CadastroDisciplinaController implements ActionListener {
	private CadastroDisciplina view;
	private DisciplinaDAO model;
	
	private Disciplina targetModel;
	
	public CadastroDisciplinaController(DisciplinaDAO model) {
		this.model = model;
	}
	
	public void setView(CadastroDisciplina view) {
		this.view = view;
	}
	
	public void setTargetModel(Disciplina targetModel) {
		this.targetModel = targetModel;
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
	}
}