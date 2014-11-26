package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.Font;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCaixaDeEntrada = new JButton("Caixa de Entrada");
		btnCaixaDeEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCaixaDeEntrada.setBounds(220, 112, 138, 23);
		contentPane.add(btnCaixaDeEntrada);
		
		JButton btnNovaMensagem = new JButton("Nova Mensagem");
		btnNovaMensagem.setBounds(220, 155, 138, 23);
		contentPane.add(btnNovaMensagem);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(220, 196, 138, 23);
		contentPane.add(btnSair);
		
		Label label = new Label("Tela Principal");
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(220, 52, 151, 22);
		contentPane.add(label);
	}
}
