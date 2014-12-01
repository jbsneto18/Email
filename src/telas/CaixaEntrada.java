package telas;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Button;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import Serializador.Serializador;
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
		
		ButtonGroup group = new ButtonGroup();
		
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnUltimaMensagem);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(501, 334, 89, 23);
		add(btnCancelar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (rdbtnNewRadioButton.isSelected())
				{
					Cliente c = new Cliente();
					try {
						
						String dominio = tp.getDominio();
						
						ArrayList<Mensagem> m = c.retornarEmails(tp.getUsuarioLogado(), dominio);
						list.removeAll();
						
						if (m.size() > 0)
						{
							for (int i=0; i < m.size(); i++)
							{
								list.add("                                                                         Mensagem "+ i);
								list.add("Remetente:");
								list.add(m.get(i).getRemetente());
								list.add("Título:");
								list.add(m.get(i).getTitulo());
								list.add("Mensagem:");
								list.add(m.get(i).getCorpo());
								list.add("-------------------------------------------------------------------------------------------------------------------------------------------------------");
							}
						}
						else
							JOptionPane.showMessageDialog(null, "Nenhuma mensagem no servidor!");
												
					} catch (ClassNotFoundException | IOException
							| InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if (rdbtnUltimaMensagem.isSelected())
				{
					Cliente c = new Cliente();
					
					try
					{
						Mensagem m = c.retornarEmail(tp.getUsuarioLogado(), tp.getDominio());
						
						if(m != null){
						list.add("                                                                   Ultima Mensagem ");
						list.add("Remetente:");
						list.add(m.getRemetente());
						list.add("Título:");
						list.add(m.getTitulo());
						list.add("Mensagem:");
						list.add(m.getCorpo());
						}
					}catch (Exception e) {}
				}
				else
					JOptionPane.showMessageDialog(null, "Selecione uma das opções!");
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
