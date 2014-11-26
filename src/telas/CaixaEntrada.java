package telas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.List;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class CaixaEntrada extends JPanel {

	/**
	 * Create the panel.
	 */
	public CaixaEntrada() {
		setLayout(null);
		
		List list = new List();
		list.setBounds(10, 78, 430, 159);
		add(list);
		
		JLabel lblCaixaDeEntrada = new JLabel("Caixa de Entrada");
		lblCaixaDeEntrada.setBounds(130, 11, 185, 26);
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
		btnCancelar.setBounds(351, 243, 89, 23);
		add(btnCancelar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(252, 243, 89, 23);
		add(btnBuscar);

	}

}
