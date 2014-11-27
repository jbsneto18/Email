package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import Serializador.Serializador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import mensagem.ServidorX;
import mensagem.ServidorY;

public class Servidor extends JFrame {

	private JPanel contentPane;
	private ServidorX servidorX;
	private ServidorY servidorY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servidor frame = new Servidor();
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
	public Servidor() {
		Serializador.carregaEmails();
		Serializador.listaEmail();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Serializador.salvarEmail();
			    System.exit(0);
			}
			  });
		
		JButton btnAtivar = new JButton("Ativar");
		btnAtivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {  
				    @Override  
				    public void run() {  
				try {
					servidorX = new ServidorX();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				servidorX.setStatus(true);
				    }  
				}).start();
			}
		});
		btnAtivar.setBounds(84, 104, 89, 23);
		contentPane.add(btnAtivar);
		
		JButton btnDesligar = new JButton("Desligar");
		btnDesligar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new Runnable() {  
				    @Override  
				    public void run() {  
				servidorX.setStatus(false);
				
				    }  
				}).start();
			}
		});
		btnDesligar.setBounds(251, 104, 89, 23);
		contentPane.add(btnDesligar);
		
		JLabel lblServidor = new JLabel("Servidor");
		lblServidor.setBounds(167, 11, 94, 44);
		lblServidor.setForeground(Color.BLACK);
		lblServidor.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(lblServidor);
	}

}
