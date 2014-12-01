package telas;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import mensagem.Cliente;

public class PainelPrincipal extends JPanel {

	
	public PainelPrincipal(final TelaPrincipal tp) {
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tela Principal");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(228, 122, 140, 22);
		add(lblNewLabel);
		
		JButton btnCaixaDeEntrada = new JButton("Caixa de Entrada");
		btnCaixaDeEntrada.setBounds(217, 155, 140, 23);
		add(btnCaixaDeEntrada);
		
		JButton btnNovaMensagem = new JButton("Nova Mensagem");
		btnNovaMensagem.setBounds(217, 189, 140, 23);
		add(btnNovaMensagem);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(217, 257, 140, 23);
		add(btnSair);
		
		JButton btnExcluirme = new JButton("Excluir-me");
		btnExcluirme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente c = new Cliente();
				try {
					c.excluirUsuario(tp.getUsuarioLogado(), tp.getDominio());
					JOptionPane.showMessageDialog(null, "Usuário deletado. Obrigado por usar nosso sistema!");
					System.exit(0);
				} catch (ClassNotFoundException | IOException
						| InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnExcluirme.setBounds(217, 223, 140, 23);
		add(btnExcluirme);
		
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
