package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Inicio extends JFrame {

	private JPanel contentPane;
<<<<<<< HEAD
	private JTextField txtEmail;
	private TelaPrincipal newTela = new TelaPrincipal();
=======
>>>>>>> origin/master

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
<<<<<<< HEAD
		setTitle("Controle de E-mails - SD");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
=======
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
>>>>>>> origin/master
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
<<<<<<< HEAD
		contentPane.setLayout(null);
		
		Label lblEmail = new Label("E-mail");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmail.setBounds(106, 96, 62, 22);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField("");
		txtEmail.setBounds(109, 131, 343, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(264, 162, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newTela = new TelaPrincipal();
				newTela.setVisible(true);
				dispose();
			}
		});
		btnEntrar.setBounds(363, 162, 89, 23);
		contentPane.add(btnEntrar);
=======
>>>>>>> origin/master
	}

}
