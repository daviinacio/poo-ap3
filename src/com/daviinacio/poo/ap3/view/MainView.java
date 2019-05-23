package com.daviinacio.poo.ap3.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.daviinacio.poo.ap3.controller.MainController;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class MainView extends JFrame {
	private MainController controller;

	private JPanel contentPane;
	private JLabel lblHeader1;
	private JLabel lblHeader2;
	private JLabel lblHeader3;
	private JButton btnListAlunos;
	private JButton btnListProfessores;
	private JButton btnListDisciplinas;
	private JLabel lblMatrcula;
	private JLabel lblAuthor;
	
	public MainView(MainController controller) {
		setTitle("Programa\u00E7\u00E3o Orientada \u00E0 Objetos - AP3");
		this.controller = controller;
		
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblHeader1 = new JLabel("AP3");
		lblHeader1.setBounds(10, 5, 414, 35);
		lblHeader1.setFont(new Font("Arial", Font.PLAIN, 30));
		lblHeader1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblHeader1);
		
		lblHeader2 = new JLabel("Programa\u00E7\u00E3o Orientada \u00E0 Objetos");
		lblHeader2.setFont(new Font("Arial", Font.PLAIN, 23));
		lblHeader2.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader2.setBounds(10, 39, 414, 35);
		contentPane.add(lblHeader2);
		
		lblHeader3 = new JLabel("Swing + MVC + Manipula\u00E7\u00E3o de Arquivo");
		lblHeader3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblHeader3.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader3.setBounds(10, 72, 414, 23);
		contentPane.add(lblHeader3);
		
		lblAuthor = new JLabel("Aluno: Davi In\u00E1cio");
		lblAuthor.setFont(new Font("Arial", Font.PLAIN, 15));
		lblAuthor.setBounds(10, 242, 124, 18);
		contentPane.add(lblAuthor);
		
		btnListAlunos = new JButton("Exibir Listagem de Alunos");
		btnListAlunos.setActionCommand("listAlunos");
		btnListAlunos.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnListAlunos.setBounds(10, 106, 414, 35);
		btnListAlunos.addActionListener(this.controller);
		contentPane.add(btnListAlunos);
		
		btnListProfessores = new JButton("Exibir Listagem de Professores");
		btnListProfessores.setActionCommand("listProfessores");
		btnListProfessores.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnListProfessores.setBounds(10, 147, 414, 35);
		btnListProfessores.addActionListener(this.controller);
		contentPane.add(btnListProfessores);
		
		btnListDisciplinas = new JButton("Exibir Listagem de Disciplinas");
		btnListDisciplinas.setActionCommand("listDisciplinas");
		btnListDisciplinas.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnListDisciplinas.setBounds(10, 193, 414, 35);
		btnListDisciplinas.addActionListener(this.controller);
		contentPane.add(btnListDisciplinas);
		
		lblMatrcula = new JLabel("Matr\u00EDcula: 5404907");
		lblMatrcula.setFont(new Font("Arial", Font.PLAIN, 15));
		lblMatrcula.setBounds(300, 242, 124, 18);
		contentPane.add(lblMatrcula);
	}
}
