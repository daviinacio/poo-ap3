package com.daviinacio.poo.ap3.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.daviinacio.poo.ap3.controller.CadastroAlunoController;
import com.daviinacio.poo.ap3.model.Aluno;
import com.daviinacio.poo.ap3.model.Disciplina;

import javafx.beans.Observable;

import java.awt.Panel;
import java.awt.Label;
import java.awt.TextField;
import java.awt.ScrollPane;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import java.awt.Font;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

public class CadastroAluno extends JFrame {
	// Controller
	private CadastroAlunoController controller;

	// Layout
	private JPanel contentPane;
	private JPanel panelEdit;
	private JPanel pnlDisciplinas;
	private JTextField txtNome;
	private JLabel lblNome;
	private JLabel lblDisciplinas;
	private JPanel panelBtn;
	private JButton btnApagar;
	private JButton btnSalvar;
	
	private Font fontEdit = new Font("Tahoma", Font.PLAIN, 20);
	private Font font = new Font("Dialog", Font.BOLD, 15);
	
	public CadastroAluno(CadastroAlunoController controller) {
		this.controller = controller;
		this.controller.setView(this);
		
		// Initialize layout
		initialize();
	}
	
	private void initialize() {
		this.setResizable(false);
		setType(Type.UTILITY);
		setTitle("Cadastro aluno");
		setBounds(100, 100, 308, 266);
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
		txtNome.setBounds(10, 32, 283, 32);
		panelEdit.add(txtNome);
		txtNome.setFont(fontEdit);
		txtNome.setColumns(10);
		
		lblDisciplinas = new JLabel("Disciplinas");
		lblDisciplinas.setBounds(10, 71, 89, 14);
		panelEdit.add(lblDisciplinas);
		lblDisciplinas.setFont(font);
		
		pnlDisciplinas = new JPanel();
		pnlDisciplinas.setBounds(10, 92, 283, 90);
		panelEdit.add(pnlDisciplinas);
		pnlDisciplinas.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pnlDisciplinas.setBackground(Color.WHITE);
		pnlDisciplinas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton button = new JButton("New button");
		pnlDisciplinas.add(button);
		
		JButton btnNewButton = new JButton("New button");
		pnlDisciplinas.add(btnNewButton);
		
		
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
		
		Component horizontalStrut = Box.createHorizontalStrut(117);
		panelBtn.add(horizontalStrut);
		
		btnSalvar = new JButton("Salvar");
		panelBtn.add(btnSalvar);
		btnSalvar.setActionCommand("save");
		btnSalvar.addActionListener(this.controller);
		btnSalvar.setFont(font);
		
	}
	
	public void refreshDisciplinas(List<Disciplina> disciplinas) {
		pnlDisciplinas.removeAll();
		
		System.out.println("List disciplinas");
		
		for(Disciplina d : disciplinas) {
			System.out.println(d);
			
			
			JButton row = new JButton(d.getNome());
			
			pnlDisciplinas.add(row);
		}
		
		System.out.println();
	}
	
	// Getters
	public String getTxtName() {
		return this.txtNome.getText();
	}
	
	// Visibility	
	public void showAsNewModel() {
		this.controller.setTargetModel(new Aluno());
		this.txtNome.setText("");
		
		this.btnApagar.setVisible(false);
		this.btnSalvar.setText("Adicionar");
		this.btnSalvar.setActionCommand("insert");
		
		this.pnlDisciplinas.removeAll();
		
		super.setVisible(true);
	}
	
	public void showAsEditor(Aluno model) {
		this.controller.setTargetModel(model);
		this.txtNome.setText(model.getNome());
		
		this.btnApagar.setVisible(true);
		this.btnSalvar.setText("Salvar");
		this.btnSalvar.setActionCommand("save");
		
		this.pnlDisciplinas.removeAll();
		this.refreshDisciplinas(model.listDisciplinas());
		
		super.setVisible(true);
		
		
		System.out.println(model);
	}
	
	@Deprecated
	@Override
	public void setVisible(boolean arg0) { super.setVisible(arg0); }
}








