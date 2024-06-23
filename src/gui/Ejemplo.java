package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import arreglo.ArregloAlumnos;
import clase.Alumno;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class Ejemplo extends JFrame {
	
	private DefaultTableModel modelo;
	
	ArregloAlumnos aa = new ArregloAlumnos();
	
	void Listar(ArregloAlumnos Objeto) {
		
		modelo.setRowCount(0);
		for (int i = 0; i < Objeto.tamaño(); i++) {
			int cod = aa.obtener(i).getCodigo();
			String nom = aa.obtener(i).getNombre();
			int n1 = aa.obtener(i).getNota1();
			int n2 = aa.obtener(i).getNota2();
			double prom = aa.obtener(i).promedio();
			String est = aa.obtener(i).estado();
			
			Object[] fila = {cod, nom, n1, n2, prom, est};
			modelo.addRow(fila);
		}
		tbltabla.setModel(modelo);
		
		}
		
		void LimpiarControles() {
			txtcodigo.setText("");
			txtnombre.setText("");
			txtnota1.setText("");
			txtnota2.setText("");
			txtcodigo.requestFocus();
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtcodigo;
	private JTextField txtnombre;
	private JTextField txtnota1;
	private JTextField txtnota2;
	private JTable tbltabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo frame = new Ejemplo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejemplo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(28, 36, 85, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(204, 36, 85, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nota 1:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(427, 36, 64, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nota 2:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(548, 36, 85, 13);
		contentPane.add(lblNewLabel_3);
		
		txtcodigo = new JTextField();
		txtcodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtcodigo.setFont(new Font("Arial", Font.PLAIN, 11));
		txtcodigo.setBounds(90, 33, 96, 19);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtnombre = new JTextField();
		txtnombre.setHorizontalAlignment(SwingConstants.LEFT);
		txtnombre.setFont(new Font("Arial", Font.PLAIN, 11));
		txtnombre.setColumns(10);
		txtnombre.setBounds(265, 33, 152, 19);
		contentPane.add(txtnombre);
		
		txtnota1 = new JTextField();
		txtnota1.setHorizontalAlignment(SwingConstants.CENTER);
		txtnota1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtnota1.setColumns(10);
		txtnota1.setBounds(474, 33, 64, 19);
		contentPane.add(txtnota1);
		
		txtnota2 = new JTextField();
		txtnota2.setHorizontalAlignment(SwingConstants.CENTER);
		txtnota2.setFont(new Font("Arial", Font.PLAIN, 11));
		txtnota2.setColumns(10);
		txtnota2.setBounds(594, 33, 64, 19);
		contentPane.add(txtnota2);
		
		JButton btnadicionar = new JButton("Adicionar");
		btnadicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Adiciona un nuevo alumno verificando que el código no se repita
				int cod = Integer.parseInt(txtcodigo.getText());
                String nom = txtnombre.getText().toString();
                int n1 = Integer.parseInt(txtnota1.getText());
                int n2 = Integer.parseInt(txtnota2.getText());
                
                // buscando si el codigo existe o no.
                Alumno resultado = aa.buscar(cod);
                if (resultado == null) {
                    aa.adicionar(new Alumno(cod, nom, n1, n2));
                    modelo.setRowCount(0); tbltabla.setModel(modelo);
                    LimpiarControles();
                    Listar(aa);
                    JOptionPane.showMessageDialog(null, "Registro Almacenado\n");
                } else {
                    LimpiarControles();
                    JOptionPane.showMessageDialog(null, "El Registro ya Existe, no se puede grabar\n");
                }
				
			}
		});
		btnadicionar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnadicionar.setBounds(17, 105, 85, 21);
		contentPane.add(btnadicionar);
		
		JButton btnconsultar = new JButton("Consultar");
		btnconsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int cod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Codigo"));
                //int cod = Integer.parseInt(txtCodigo.getText());
                Alumno Resultado = aa.buscar(cod);
                int pos = aa.buscarPosicion(cod);
                if (Resultado != null) {
                	
                    //En las cajas de texto
                	//txtcodigo.setText(Integer.toString(aa.obtener(pos).getCodigo()));
                    //txtnombre.setText(aa.obtener(pos).getNombre());
                    //txtnota1.setText(Integer.toString(aa.obtener(pos).getNota1()));
                    //txtnota2.setText(Integer.toString(aa.obtener(pos).getNota2()));
                    
                    // En la tabla
                          cod = aa.obtener(pos).getCodigo();
                    String nom = aa.obtener(pos).getNombre();
                    int n1 = aa.obtener(pos).getNota1();
                    int n2 = aa.obtener(pos).getNota2();
                    double prom = aa.obtener(pos).promedio();
                    String est = aa.obtener(pos).estado();
                    modelo.setRowCount(0);
                    Object[] fila = { cod, nom, n1, n2, prom, est };
                    modelo.addRow(fila);
                    tbltabla.setModel(modelo);
                } else {
                    JOptionPane.showMessageDialog(null, "Registro no Encontrado");
                    LimpiarControles();
                }
				
			}
		});
		btnconsultar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnconsultar.setBounds(17, 151, 85, 21);
		contentPane.add(btnconsultar);
		
		JButton btnmodificar = new JButton("Modificar");
		btnmodificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int cod =Integer.parseInt(JOptionPane.showInputDialog("Ingrese Codigo"));
		        Alumno Resultado = aa.buscar(cod);
		        int pos = aa.buscarPosicion(cod);
		        if (Resultado != null) {
		            cod = Integer.parseInt(txtcodigo.getText());
		            String nom = txtnombre.getText().toString();
		            int n1 = Integer.parseInt(txtnota1.getText());
		            int n2 = Integer.parseInt(txtnota2.getText());
		            Resultado.setCodigo(cod);
		            Resultado.setNombre(nom);
		            Resultado.setNota1(n1);
		            Resultado.setNota2(n2);
		            aa.modificar(pos, Resultado);
		            Listar(aa);
		            //LimpiarControles();
		        } else {
		            JOptionPane.showMessageDialog(null, "Registro no Encontrado");
		            LimpiarControles();
		        }
				
			}
		});
		btnmodificar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnmodificar.setBounds(17, 199, 85, 21);
		contentPane.add(btnmodificar);
		
		JButton btnNewButton_3 = new JButton("Eliminar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 int cod =Integer.parseInt(JOptionPane.showInputDialog("Ingrese Codigo"));
			        Alumno Resultado = aa.buscar(cod);
			        if (Resultado != null) {
			            aa.eliminar(Resultado);
			            Listar(aa);
			            //LimpiarControles();
			        } else {
			            JOptionPane.showMessageDialog(null, "Registro no Encontrado");
			            LimpiarControles();
			        }
				
			}
		});
		btnNewButton_3.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_3.setBounds(17, 244, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnimprimir = new JButton("Imprimir");
		btnimprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Listar(aa);
				
			}
		});
		btnimprimir.setFont(new Font("Arial", Font.PLAIN, 12));
		btnimprimir.setBounds(17, 331, 85, 21);
		contentPane.add(btnimprimir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(143, 96, 515, 279);
		contentPane.add(scrollPane);
		
		tbltabla = new JTable();
		tbltabla.setFont(new Font("Consolas", Font.PLAIN, 12));
		tbltabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbltabla);
		
		modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nnombre");
        modelo.addColumn("Nota 1");
        modelo.addColumn("Nota 2");
        modelo.addColumn("Promedio");
        modelo.addColumn("Estado");
	}
}
