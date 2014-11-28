package telas;

import javax.swing.JPanel;
import javax.swing.JLabel;

import Serializador.Serializador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JButton;

import mensagem.Cliente;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class NovaMensagem extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public NovaMensagem(final TelaPrincipal tp) {
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
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(482, 328, 89, 23);
		add(btnCancelar);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(383, 328, 89, 23);
		add(btnEnviar);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo");
		lblTtulo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTtulo.setBounds(10, 97, 46, 14);
		add(lblTtulo);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 122, 302, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 199, 569, 118);
		add(textArea);
		
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tp.getCancelarNovaMensagem();
			}
		});

		btnEnviar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String remetente, destinatario, corpo, titulo;
				remetente = textField.getText();
				destinatario = textField_1.getText();
				corpo = textArea.getText();
				titulo = textField_3.getText();
				
				try {
					Cliente c = new Cliente(remetente, destinatario, corpo, titulo);
				} catch (ClassNotFoundException | IOException
						| InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
	}
}
