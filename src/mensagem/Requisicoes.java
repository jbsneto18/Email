package mensagem;

import java.io.Serializable;

import CadastroUser.Cadastro;

public class Requisicoes implements Serializable {

	private String requisicao;
	private String email;
	private Mensagem mensagem;
	private Cadastro cadastro;
	private String dominio;
	
	public Requisicoes(String requisicao, String email, Mensagem m, Cadastro c, String domin) {		
		this.requisicao = requisicao;
		this.email = email;
		this.mensagem = m;
		this.cadastro = c;
		this.dominio = domin;
	}
		
	public Cadastro getCadastro(){
		return this.cadastro;
	}
	
	public void setCadastro(Cadastro c){
		this.cadastro = c;
	}
	
	public String getRequisicao() {
		return requisicao;
	}
	public void setRequisicao(String requisicao) {
		this.requisicao = requisicao;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Mensagem getMensagem() {
		return mensagem;
	}
	public void setMensagem(Mensagem m) {
		this.mensagem = m;
	}
	
	public void setDominio (String domin)
	{
		this.dominio = domin;
	}
	
	public String getDominio ()
	{
		return this.dominio;
	}
	
}
