package CadastroUser;

import java.io.Serializable;

public class Cadastro implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String email;
	
	public Cadastro(String nome, String email) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
		this.email = email;
	}

	public String getNome(){
		return this.nome;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
}