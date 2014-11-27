package telas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroUsuario extends JPanel {
	private JTextField txtNome;
	private JTextField txtEmail;

	/**
	 * Create the panel.
	 */
	public CadastroUsuario(TelaPrincipal fp) {
		setLayout(null);
		
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
		btnCancelar.setBounds(312, 221, 89, 23);
		add(btnCancelar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(192, 221, 110, 23);
		add(btnCadastrar);

	}
}
