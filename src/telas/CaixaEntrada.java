package telas;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import Serializador.SerializadorUser;
import mensagem.Cliente;
import mensagem.Mensagem;

public class CaixaEntrada extends JPanel {

	/**
	 * Create the panel.
	 */
	public CaixaEntrada(final TelaPrincipal tp) {
		setLayout(null);
		
		List list = new List();
		list.setBounds(10, 78, 580, 250);
		add(list);
		
		JLabel lblCaixaDeEntrada = new JLabel("Caixa de Entrada");
		lblCaixaDeEntrada.setBounds(191, 11, 185, 26);
		lblCaixaDeEntrada.setFont(new Font("Arial Black", Font.BOLD, 18));
		add(lblCaixaDeEntrada);
		
		JRadioButton rdbtnUltimaMensagem = new JRadioButton("Ultima mensagem");
		rdbtnUltimaMensagem.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtnUltimaMensagem.setBounds(10, 49, 129, 23);
		add(rdbtnUltimaMensagem);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Todas mensagens");
		rdbtnNewRadioButton.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtnNewRadioButton.setBounds(155, 49, 131, 23);
		add(rdbtnNewRadioButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(501, 334, 89, 23);
		add(btnCancelar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente c = new Cliente();
				try {
					ArrayList<Mensagem> m = c.retornarEmails(tp.getUsuarioLogado());
					
					for (int i=0; i < m.size(); i++){
						System.out.println(m.get(i).getTitulo());
						list.add(m.get(i).getTitulo());
					}
					
				} catch (ClassNotFoundException | IOException
						| InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnBuscar.setBounds(402, 334, 89, 23);
		add(btnBuscar);
		
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tp.getCancelarCaixaEntrada();
			}
		});

	}

}
