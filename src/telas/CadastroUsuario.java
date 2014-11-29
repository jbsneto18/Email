package telas;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import Serializador.SerializadorUser;
import CadastroUser.Cadastro;
import mensagem.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CadastroUsuario extends JPanel {
	private JTextField txtNome;
	private JTextField txtEmail;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;

	/**
	 * Create the panel.
	 */
	public CadastroUsuario(TelaPrincipal fp) {
		setLayout(null);
		SerializadorUser.carregaUser();
		JLabel lblCadastroDeCliente = new JLabel("Cadastro de Usu\u00E1rio");
		lblCadastroDeCliente.setFont(new Font("Arial", Font.BOLD, 18));
		lblCadastroDeCliente.setBounds(190, 37, 188, 43);
		add(lblCadastroDeCliente);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.BOLD, 12));
		lblNome.setBounds(166, 109, 46, 14);
		add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(166, 134, 235, 20);
		add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 12));
		lblEmail.setBounds(166, 165, 46, 14);
		add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(166, 190, 235, 20);
		add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fp.dispose();
			}
		});
		btnCancelar.setBounds(286, 221, 115, 23);
		add(btnCancelar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nome, email;
				nome = txtNome.getText();
				email = txtEmail.getText();
				
				String splitEmail[] = email.split("@");
				
				if (splitEmail[1].equals("apocalipse") || splitEmail[1].equals("ikinho"))
				{
					Cadastro cad = new Cadastro(nome, email);
					Cliente c = new Cliente();
					try {
						c.cadastrarUsuario(cad);
					} catch (ClassNotFoundException | IOException
							| InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
					fp.getCancelarCaixaEntrada();
				}
				else
					JOptionPane.showMessageDialog(null, "Domínio inválido, @ikinho ou @apocalipse são os disponíveis!");
			}
		});
		btnCadastrar.setBounds(166, 221, 110, 23);
		add(btnCadastrar);

	}
}
