package com.meuempregado.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_resposta")
public class Resposta {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idResposta;
	private String description;
	
	/*@ManyToOne
	@JoinColumn(name="idresposta")
	private Mensagem mensagem;*/
	
	public Resposta(Integer id, String description) {
		super();
		this.idResposta = id;
		this.description = description;
	}

	public Resposta(){
		
	}
	
	public Integer getIdResposta() {
		return idResposta;
	}

	public void setIdResposta(Integer idResposta) {
		this.idResposta = idResposta;
	}

	/*public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}*/

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
