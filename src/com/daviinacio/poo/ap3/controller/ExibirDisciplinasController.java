package com.daviinacio.poo.ap3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.daviinacio.poo.ap3.Program;
import com.daviinacio.poo.ap3.model.Disciplina;
import com.daviinacio.poo.ap3.model.DisciplinaDAO;
import com.daviinacio.poo.ap3.view.ExibirDisciplinas;

public class ExibirDisciplinasController implements ActionListener, MouseListener {
	private ExibirDisciplinas view;
	private DisciplinaDAO model;
	private OnItemSelectListener<Disciplina> onItemSelectListener;
	
	private Disciplina selectedItem;
	
	public ExibirDisciplinasController(DisciplinaDAO model) {
		this.model = model;
	}
	
	public void setView(ExibirDisciplinas view) {
		this.view = view;
	}
	
	public void setOnItemSelectListener(OnItemSelectListener<Disciplina> listener) {
		this.onItemSelectListener = listener;
	}
	
	public boolean hasOnItemSelectListener() {
		return this.onItemSelectListener != null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("search")) {
			model.throwChanged();
			//((ExibirProfessores) SwingUtilities.getRoot((JButton)e.getSource())).changed(model);
		}
		else
		if(e.getActionCommand().equals("new")) {
			System.out.println("Nova disciplina");
			Program.cadastroDisciplina.showAsNewModel();
		}
		else
		if(e.getActionCommand().equals("select")) {
			if(this.onItemSelectListener != null) {
				if(this.selectedItem == null)
					System.err.println("Uma Disciplina deve ser selecionada.");
				else {
					this.onItemSelectListener.OnItemSelect(this.selectedItem);
					this.view.setVisible(false);
				}
			}
		}
		else
		if(e.getActionCommand().equals("close")) {
			this.view.setVisible(false);
			//SwingUtilities.getRoot((JButton)e.getSource()).setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.selectedItem = model.selectById(view.getSelectRowId());
		
		if(!this.hasOnItemSelectListener())
			Program.cadastroDisciplina.showAsEditor(this.selectedItem);
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
