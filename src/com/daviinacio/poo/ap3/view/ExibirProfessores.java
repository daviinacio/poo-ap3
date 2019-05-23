package com.daviinacio.poo.ap3.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Comparator;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.daviinacio.poo.ap3.controller.ExibirAlunosController;
import com.daviinacio.poo.ap3.controller.ExibirProfessoresController;
import com.daviinacio.poo.ap3.model.Aluno;
import com.daviinacio.poo.ap3.model.DataSource;
import com.daviinacio.poo.ap3.model.DataSourceObserver;
import com.daviinacio.poo.ap3.model.Professor;

public class ExibirProfessores extends JFrame implements DataSourceObserver<Professor>{
	// Controller
		private ExibirProfessoresController controller;

		// Layout
		private JPanel contentPane, panelBusca;
		public JTextField txtQuery;
		private JButton btnBuscar;
		private JTable table;

		private Font fontList = new Font("Tahoma", Font.PLAIN, 20);
		private Font font = new Font("Dialog", Font.BOLD, 15);
		
		private DefaultTableModel tableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		private JButton btnNovo;
		private JButton btnFechar;
		private Component horizontalStrut;
		
		public ExibirProfessores(ExibirProfessoresController controller) {
			this.controller = controller;
			this.controller.setView(this);
			
			// Initialize layout
			initialize();
		}
		
		private void initialize() {
			setResizable(false);
			setTitle("Lista de professor");
			setBounds(100, 100, 507, 365);
			contentPane = new JPanel();
			contentPane.setBackground(Color.DARK_GRAY);
			contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
			
			panelBusca = new JPanel();
			panelBusca.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
			panelBusca.setBackground(Color.LIGHT_GRAY);
			FlowLayout fl_panelBusca = (FlowLayout) panelBusca.getLayout();
			fl_panelBusca.setVgap(4);
			fl_panelBusca.setHgap(4);
			fl_panelBusca.setAlignment(FlowLayout.LEFT);
			contentPane.add(panelBusca, BorderLayout.SOUTH);
			
			txtQuery = new JTextField();
			panelBusca.add(txtQuery);
			txtQuery.setFont(fontList);
			txtQuery.setColumns(10);
			
			btnBuscar = new JButton("Buscar");
			panelBusca.add(btnBuscar);
			btnBuscar.setActionCommand("search");
			btnBuscar.addActionListener(this.controller);
			btnBuscar.setFont(this.font);
			
			horizontalStrut = Box.createHorizontalStrut(65);
			panelBusca.add(horizontalStrut);
			
			btnNovo = new JButton("Novo");
			btnNovo.setActionCommand("new");
			btnNovo.addActionListener(this.controller);
			btnNovo.setFont(font);
			panelBusca.add(btnNovo);
			
			btnFechar = new JButton("Fechar");
			btnFechar.setActionCommand("close");
			btnFechar.addActionListener(this.controller);
			btnFechar.setFont(font);
			panelBusca.add(btnFechar);
			
			table = new JTable(tableModel);
			table.setFont(fontList);
			table.setBorder(new EmptyBorder(0, 0, 0, 0));
			table.setRowHeight((int)(table.getFont().getSize() * 1.5));
			table.getTableHeader().setFont(fontList);
			contentPane.add(table, BorderLayout.CENTER);
			
			table.addMouseListener(this.controller);
			
			tableModel.addColumn("ID");
			tableModel.addColumn("Nome do professor");
			
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(1).setPreferredWidth(600);
			
			JScrollPane tableScroll = new JScrollPane(table);
			contentPane.add(BorderLayout.CENTER, tableScroll);
		}
		
		@Override
		public void changed(DataSource<Professor> dao) {
			// Clean list
			tableModel.setNumRows(0);
			
			java.util.List<Professor> as = dao.selectByNome(txtQuery.getText());
			
			// Sort by name
			as.sort(new Comparator<Professor>() {
				@Override
				public int compare(Professor a1, Professor a2) {
					return a1.getNome().compareTo(a2.getNome());
				}
			});
			
			for (Professor a : as) {
				tableModel.addRow(new Object[] { a.getId(), a.getNome() });
				//table.setRowHeight(i, (int)(table.getFont().getSize() * 1.5));
			}
		}
		
		public int getSelectRowId() {
			return Integer.parseInt(this.tableModel.getValueAt(this.table.getSelectedRow(), 0).toString());
		}
		
		public String getSelectRowName() {
			return this.tableModel.getValueAt(this.table.getSelectedRow(), 1).toString();
		}
}
