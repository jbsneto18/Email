package mensagem;

import java.io.Serializable;

public class Requisicoes implements Serializable {

	private String requisicao;
	private String email;
	private Mensagem mensagem;
	
	public Requisicoes(String requisicao, String email, Mensagem m) {		
		this.requisicao = requisicao;
		this.email = email;
		this.mensagem = m;
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
	
	
	
	
}
