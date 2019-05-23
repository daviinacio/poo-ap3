package com.daviinacio.poo.ap3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import com.daviinacio.poo.ap3.Program;
import com.daviinacio.poo.ap3.model.AlunoDAO;
import com.daviinacio.poo.ap3.model.ProfessorDAO;
import com.daviinacio.poo.ap3.view.ExibirAlunos;
import com.daviinacio.poo.ap3.view.ExibirProfessores;

public class ExibirProfessoresController implements ActionListener, MouseListener {
	private ExibirProfessores view;
	private ProfessorDAO model;
	
	public ExibirProfessoresController(ProfessorDAO model) {
		this.model = model;
	}
	
	public void setView(ExibirProfessores view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("search")) {
			model.throwChanged();
			//((ExibirProfessores) SwingUtilities.getRoot((JButton)e.getSource())).changed(model);
		}
		else
		if(e.getActionCommand().equals("new")) {
			System.out.println("Novo professor");
			Program.cadastroProfessor.showAsNewModel();
		}
		else
		if(e.getActionCommand().equals("close")) {
			this.view.setVisible(false);
			//SwingUtilities.getRoot((JButton)e.getSource()).setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Editar professor");
		Program.cadastroProfessor.showAsEditor(model.selectById(view.getSelectRowId()));
	}

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }

	@Override
	public void mousePressed(MouseEvent e) { }

	@Override
	public void mouseReleased(MouseEvent e) { }
}
