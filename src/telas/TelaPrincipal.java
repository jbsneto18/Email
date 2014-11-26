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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		
		
		PainelPrincipal painelPrinc = new PainelPrincipal(this);
		this.add(painelPrinc);
		
		
	}
	
	public void getCaixaEntrada(){
		this.getContentPane().removeAll();
		CaixaEntrada caixEntr = new CaixaEntrada(this);
		this.getContentPane().add(caixEntr);
		this.setVisible(true);
	}
	
	public void getNovaMensagem(){
		this.getContentPane().removeAll();
		NovaMensagem novMen = new NovaMensagem(this);
		this.getContentPane().add(novMen);
		this.setVisible(true);
	}
	
	public void getSair(){
		this.dispose();
	}
	
	public void getCancelarCaixaEntrada(){
		this.getContentPane().removeAll();
		PainelPrincipal painelPrinc = new PainelPrincipal(this);
		this.getContentPane().add(painelPrinc);
		this.setVisible(true);
	}
	
	public void getCancelarNovaMensagem(){
		this.getContentPane().removeAll();
		PainelPrincipal painelPrinc = new PainelPrincipal(this);
		this.getContentPane().add(painelPrinc);
		this.setVisible(true);
	}
}
