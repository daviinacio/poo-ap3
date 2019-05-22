package com.daviinacio.poo.ap3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.daviinacio.poo.ap3.model.Aluno;
import com.daviinacio.poo.ap3.model.AlunoDAO;
import com.daviinacio.poo.ap3.model.Disciplina;
import com.daviinacio.poo.ap3.view.CadastroAluno;

public class CadastroAlunoController implements ActionListener {
	private CadastroAluno view;
	private AlunoDAO model;
	
	private Aluno targetModel;
	
	public CadastroAlunoController(AlunoDAO model) {
		this.model = model;
	}
	
	public void setView(CadastroAluno view) {
		this.view = view;
	}
	
	public void setTargetModel(Aluno targetModel) {
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
