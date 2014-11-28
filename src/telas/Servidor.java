package telas;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import Serializador.Serializador;
import Serializador.SerializadorUser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import mensagem.ServidorX;
import mensagem.ServidorY;

import java.awt.List;
import java.awt.Scrollbar;
import java.awt.Label;

public class Servidor extends JFrame {

	private JPanel contentPane;
	private ServidorX servidorX;
	private ServidorY servidorY;
	private JButton btnAtivar;
	private JButton btnDesligar;
	private List listUsuarios;
	private List listMensagem;

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
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 600, 400);
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
		
		this.btnAtivar = new JButton("Ativar");
		
		btnAtivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					listaUsersCadastrados();
				}catch (Exception e1) {}
				
				
				btnAtivar.setEnabled(false);
				btnDesligar.setEnabled(true);
				
				
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
		btnAtivar.setBounds(10, 35, 89, 23);
		contentPane.add(btnAtivar);
		
		this.btnDesligar = new JButton("Desligar");
		
		
		btnDesligar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnAtivar.setEnabled(true);
				btnDesligar.setEnabled(false);
				
				new Thread(new Runnable() {  
				    @Override  
				    public void run() {  
				servidorX.setStatus(false);
				
				    }  
				}).start();
			}
		});
		btnDesligar.setBounds(109, 35, 89, 23);
		contentPane.add(btnDesligar);
		
		JLabel lblServidor = new JLabel("Servidor");
		lblServidor.setBounds(10, 0, 94, 29);
		lblServidor.setForeground(Color.BLACK);
		lblServidor.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(lblServidor);
		
		this.listUsuarios = new List();
		listUsuarios.setBounds(10, 111, 183, 219);
		contentPane.add(listUsuarios);
		
		Scrollbar scrollbar = new Scrollbar();
		scrollbar.setBounds(172, 111, 17, 219);
		contentPane.add(scrollbar);
		
		Label lblClientes = new Label("Clientes");
		lblClientes.setFont(new Font("Arial", Font.BOLD, 12));
		lblClientes.setBounds(10, 83, 62, 22);
		contentPane.add(lblClientes);
		
		Label lblMensagem = new Label("Mensagens");
		lblMensagem.setFont(new Font("Arial", Font.BOLD, 12));
		lblMensagem.setBounds(199, 83, 80, 22);
		contentPane.add(lblMensagem);
		
		this.listMensagem = new List();
		listMensagem.setBounds(199, 111, 375, 219);
		contentPane.add(listMensagem);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(485, 336, 89, 23);
		contentPane.add(btnAtualizar);
		
		btnAtualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void listaUsersCadastrados ()
	{
			SerializadorUser.carregaUser();
			for (int i=0; i < SerializadorUser.user.size(); i++)
				listUsuarios.add(SerializadorUser.user.get(i).getNome());
	}
	
	public void listMensagens () throws ClassNotFoundException, IOException
	{
		
	}
}
