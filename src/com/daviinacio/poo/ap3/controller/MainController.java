package com.daviinacio.poo.ap3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.daviinacio.poo.ap3.Program;

public class MainController implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("listAlunos")) {
			Program.exibirAlunos.setVisible(true);
		}
		else
		if(e.getActionCommand().equals("listProfessores")) {
			Program.exibirProfessores.setVisible(true);
		}
		else
		if(e.getActionCommand().equals("listDisciplinas")) {
			Program.exibirDisciplinas.setVisible(true);
		}
	}
}
