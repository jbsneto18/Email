package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import Serializador.Serializador;
import Serializador.SerializadorUser;

public class Inicio extends JFrame {

	private JPanel contentPane;

	private JTextField txtEmail;
	private TelaPrincipal newTela = new TelaPrincipal("");

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

		setTitle("Controle de E-mails - SD");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(null);
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
		btnCancelar.setBounds(363, 162, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int status = 0;
				
				String emailUser = "";
				
				emailUser = txtEmail.getText();
				
				SerializadorUser.carregaUser();
				
				for (int i=0; i < SerializadorUser.user.size(); i++)
				{
					if (emailUser.equals(SerializadorUser.user.get(i).getEmail()))
					{
						newTela = new TelaPrincipal(emailUser);
						newTela.setVisible(true);
						dispose();
						status = 1;
					}
				}		
				
				if (status == 0)
					JOptionPane.showMessageDialog(null, "Usuário inválido, por favor, cadastra-se");
			}
		});
		btnEntrar.setBounds(265, 162, 89, 23);
		contentPane.add(btnEntrar);
		
		JLabel lblNovoUsurio = new JLabel("Novo Usu\u00E1rio ?");
		lblNovoUsurio.setFont(new Font("Arial", Font.BOLD, 12));
		lblNovoUsurio.setBounds(333, 228, 89, 23);
		contentPane.add(lblNovoUsurio);
		
		JButton btnCadastrese = new JButton("Cadastre-se");
		btnCadastrese.setBounds(333, 262, 119, 23);
		contentPane.add(btnCadastrese);
		btnCadastrese.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				newTela.getCadastroUsuario();
				dispose();
			}
		});

	}

}
