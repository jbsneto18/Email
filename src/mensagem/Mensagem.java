/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mensagem;

import java.io.Serializable;

/**
 *
 * @author Jose
 */
public class Mensagem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String remetente;
	private String destinatario;
	private String corpo;
	
	public String getRemetente(){
		return this.remetente;
	}
	
	public String getDestinatario(){
		return this.destinatario;
	}
	
	public String getCorpo(){
		return this.corpo;
	}
	
	public void setRemetente(String remetente){
		this.remetente = remetente;
	}
	
	public void setDestinatario(String destinatario){
		this.destinatario = destinatario;
	}
	
	public void setCorpo(String corpo){
		this.corpo = corpo;
	}

}
