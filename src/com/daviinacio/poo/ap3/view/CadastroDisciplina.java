package com.daviinacio.poo.ap3.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window.Type;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import com.daviinacio.poo.ap3.controller.CadastroDisciplinaController;
import com.daviinacio.poo.ap3.controller.CadastroProfessorController;
import com.daviinacio.poo.ap3.controller.OnItemSelectListener;
import com.daviinacio.poo.ap3.model.Disciplina;
import com.daviinacio.poo.ap3.model.Professor;

public class CadastroDisciplina extends JFrame {
	private CadastroDisciplinaController controller;

	// Layout
	private JPanel contentPane;
	private JPanel panelEdit;
	private JTextField txtNome;
	private JLabel lblNome;
	private JPanel panelBtn;
	private JButton btnApagar;
	private JButton btnSalvar;
	
	private Font fontEdit = new Font("Tahoma", Font.PLAIN, 20);
	private Font font = new Font("Dialog", Font.BOLD, 15);
	
	public CadastroDisciplina(CadastroDisciplinaController controller) {
		this.controller = controller;
		this.controller.setView(this);
		
		// Initialize layout
		initialize();
	}
	
	private void initialize() {
		this.setResizable(false);
		setType(Type.UTILITY);
		setTitle("Cadastro disciplina");
		setBounds(100, 100, 500, 142);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelEdit = new JPanel();
		panelEdit.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		contentPane.add(panelEdit);
		panelEdit.setLayout(null);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 7, 52, 14);
		panelEdit.add(lblNome);
		lblNome.setFont(font);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 32, 474, 32);
		panelEdit.add(txtNome);
		txtNome.setFont(fontEdit);
		txtNome.setColumns(10);
		
		
		panelBtn = new JPanel();
		panelBtn.setBackground(Color.LIGHT_GRAY);
		panelBtn.setBorder(new EmptyBorder(0, 5, 0, 5));
		FlowLayout fl_panelBusca = (FlowLayout) panelBtn.getLayout();
		fl_panelBusca.setVgap(4);
		fl_panelBusca.setHgap(4);
		fl_panelBusca.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panelBtn, BorderLayout.SOUTH);
		
		btnApagar = new JButton("Apagar");
		panelBtn.add(btnApagar);
		btnApagar.setActionCommand("delete");
		btnApagar.addActionListener(this.controller);
		btnApagar.setForeground(new Color(178, 34, 34));
		btnApagar.setFont(font);
		
		Component horizontalStrut = Box.createHorizontalStrut(310);
		panelBtn.add(horizontalStrut);
		
		btnSalvar = new JButton("Salvar");
		panelBtn.add(btnSalvar);
		btnSalvar.setActionCommand("save");
		btnSalvar.addActionListener(this.controller);
		btnSalvar.setFont(font);
	}
	
	// Getters
	public String getTxtName() {
		return this.txtNome.getText();
	}
	
	// Visibility	
	public void showAsNewModel() {
		this.controller.setTargetModel(new Disciplina());
		this.txtNome.setText("");
		
		this.btnApagar.setVisible(false);
		this.btnSalvar.setText("Adicionar");
		this.btnSalvar.setActionCommand("insert");
		
		//this.pnlDisciplinas.removeAll();
		
		super.setVisible(true);
	}
	
	public void showAsEditor(Disciplina model) {
		this.controller.setTargetModel(model);
		this.txtNome.setText(model.getNome());
		
		this.btnApagar.setVisible(true);
		this.btnSalvar.setText("Salvar");
		this.btnSalvar.setActionCommand("save");
		
		//this.pnlDisciplinas.removeAll();
		//this.refreshDisciplinas(model.listDisciplinas());
		
		super.setVisible(true);
		
		System.out.println(model);
	}
	
	@Deprecated
	@Override
	public void setVisible(boolean arg0) { super.setVisible(arg0); }
}
