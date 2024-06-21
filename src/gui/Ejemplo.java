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

public class Ejemplo extends JFrame {
	
	ArregloAlumnos aa = new ArregloAlumnos();
	
	void Listar(ArregloAlumnos Objeto) {
		txts.setText("");
		txts.append("\n");
		txts.append(" Datos del alumno: \n");
		txts.append(" -------------------- \n");
		for (int i = 0; i < aa.tamaño(); i++) {
			txts.append(" Código     : " + aa.obtener(i).getCodigo() + "\n");
			txts.append(" Nombre     : " + aa.obtener(i).getNombre() + "\n");
			txts.append(" Nota 1     : " + aa.obtener(i).getNota1() + "\n");
			txts.append(" Nota 2     : " + aa.obtener(i).getNota2() + "\n");
			txts.append(" Promedio   : " + aa.obtener(i).promedio() + "\n");
			txts.append(" Estado     : " + aa.obtener(i).estado() + "\n");
			txts.append(" Nota Mayor : " + aa.obtener(i).notaMayor() + "\n");
			txts.append(" Nota Menor : " + aa.obtener(i).notaMenor() + "\n");
			txts.append("\n");
		}
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
	private JTextArea txts;

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
		setBounds(100, 100, 601, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(17, 25, 85, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(143, 25, 85, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nota 1:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(350, 25, 64, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nota 2:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(466, 25, 85, 13);
		contentPane.add(lblNewLabel_3);
		
		txtcodigo = new JTextField();
		txtcodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtcodigo.setFont(new Font("Arial", Font.PLAIN, 11));
		txtcodigo.setBounds(17, 48, 96, 19);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtnombre = new JTextField();
		txtnombre.setHorizontalAlignment(SwingConstants.LEFT);
		txtnombre.setFont(new Font("Arial", Font.PLAIN, 11));
		txtnombre.setColumns(10);
		txtnombre.setBounds(143, 48, 181, 19);
		contentPane.add(txtnombre);
		
		txtnota1 = new JTextField();
		txtnota1.setHorizontalAlignment(SwingConstants.CENTER);
		txtnota1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtnota1.setColumns(10);
		txtnota1.setBounds(350, 48, 96, 19);
		contentPane.add(txtnota1);
		
		txtnota2 = new JTextField();
		txtnota2.setHorizontalAlignment(SwingConstants.CENTER);
		txtnota2.setFont(new Font("Arial", Font.PLAIN, 11));
		txtnota2.setColumns(10);
		txtnota2.setBounds(466, 48, 96, 19);
		contentPane.add(txtnota2);
		
		JButton btnadicionar = new JButton("Adicionar");
		btnadicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int cod = Integer.parseInt(txtcodigo.getText());
                String nom = txtnombre.getText().toString();
                int n1 = Integer.parseInt(txtnota1.getText());
                int n2 = Integer.parseInt(txtnota2.getText());
                
                // buscando si el codigo existe o no.
                Alumno resultado = aa.buscar(cod);
                if (resultado == null) {
                    aa.adicionar(new Alumno(cod, nom, n1, n2));
                    txts.setText("");
                    LimpiarControles();
                    txts.append("Registro Almacenado, Vuelva a Imprimir\n");
                } else {
                    LimpiarControles();
                    txts.append("El Registro ya Existe, no se puede grabar\n");
                }
				
			}
		});
		btnadicionar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnadicionar.setBounds(17, 105, 85, 21);
		contentPane.add(btnadicionar);
		
		JButton btnconsultar = new JButton("Consultar");
		btnconsultar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnconsultar.setBounds(17, 151, 85, 21);
		contentPane.add(btnconsultar);
		
		JButton btnmodificar = new JButton("Modificar");
		btnmodificar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnmodificar.setBounds(17, 199, 85, 21);
		contentPane.add(btnmodificar);
		
		JButton btnNewButton_3 = new JButton("Eliminar");
		btnNewButton_3.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_3.setBounds(17, 244, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(112, 103, 448, 409);
		contentPane.add(scrollPane);
		
		txts = new JTextArea();
		scrollPane.setViewportView(txts);
		txts.setFont(new Font("Consolas", Font.BOLD, 14));
		
		JButton btnimprimir = new JButton("Imprimir");
		btnimprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Listar(aa);
				
			}
		});
		btnimprimir.setFont(new Font("Arial", Font.PLAIN, 12));
		btnimprimir.setBounds(17, 354, 85, 21);
		contentPane.add(btnimprimir);
	}
}
