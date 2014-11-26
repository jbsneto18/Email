package telas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class NovaMensagem extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public NovaMensagem() {
		setLayout(null);
		
		JLabel lblNovaMensagem = new JLabel("Nova Mensagem");
		lblNovaMensagem.setBounds(193, 4, 175, 26);
		lblNovaMensagem.setFont(new Font("Arial Black", Font.BOLD, 18));
		add(lblNovaMensagem);
		
		textField = new JTextField();
		textField.setBounds(10, 66, 191, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Remetente:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 41, 73, 14);
		add(lblNewLabel);
		
		JLabel lblDestinatrio = new JLabel("Destinat\u00E1rio:");
		lblDestinatrio.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDestinatrio.setBounds(233, 41, 73, 14);
		add(lblDestinatrio);
		
		textField_1 = new JTextField();
		textField_1.setBounds(230, 66, 210, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMensagem = new JLabel("Mensagem:");
		lblMensagem.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMensagem.setBounds(10, 153, 73, 14);
		add(lblMensagem);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 178, 580, 164);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(501, 353, 89, 23);
		add(btnCancelar);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(402, 353, 89, 23);
		add(btnEnviar);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo");
		lblTtulo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTtulo.setBounds(10, 97, 46, 14);
		add(lblTtulo);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 122, 302, 20);
		add(textField_3);
		textField_3.setColumns(10);

	}

}
