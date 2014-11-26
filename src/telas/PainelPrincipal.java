package telas;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PainelPrincipal extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelPrincipal(TelaPrincipal tp) {
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tela Principal");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(228, 122, 140, 22);
		add(lblNewLabel);
		
		JButton btnCaixaDeEntrada = new JButton("Caixa de Entrada");
		btnCaixaDeEntrada.setBounds(217, 170, 140, 23);
		add(btnCaixaDeEntrada);
		
		JButton btnNovaMensagem = new JButton("Nova Mensagem");
		btnNovaMensagem.setBounds(217, 204, 140, 23);
		add(btnNovaMensagem);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(217, 238, 140, 23);
		add(btnSair);
		
		btnCaixaDeEntrada.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					tp.getCaixaEntrada();
			}
		});

		btnNovaMensagem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tp.getNovaMensagem();
			}
		});
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tp.getSair();
			}
		});

	}

}
