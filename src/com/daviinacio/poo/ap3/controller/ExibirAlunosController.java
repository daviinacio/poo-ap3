package com.daviinacio.poo.ap3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import com.daviinacio.poo.ap3.Program;
import com.daviinacio.poo.ap3.model.Aluno;
import com.daviinacio.poo.ap3.model.AlunoDAO;
import com.daviinacio.poo.ap3.view.CadastroAluno;
import com.daviinacio.poo.ap3.view.ExibirAlunos;

public class ExibirAlunosController implements ActionListener, MouseListener {
	private ExibirAlunos view;
	private AlunoDAO model;
	
	public ExibirAlunosController(AlunoDAO model) {
		this.model = model;
	}
	
	public void setView(ExibirAlunos view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("search")) {
			model.throwChanged();
			//((ExibirAlunos) SwingUtilities.getRoot((JButton)e.getSource())).changed(model);
		}
		else
		if(e.getActionCommand().equals("new")) {
			Program.cadastroAluno.showAsNewModel();
		}
		else
		if(e.getActionCommand().equals("close")) {
			this.view.setVisible(false);
			//SwingUtilities.getRoot((JButton)e.getSource()).setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Program.cadastroAluno.showAsEditor(model.selectById(view.getSelectRowId()));
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
