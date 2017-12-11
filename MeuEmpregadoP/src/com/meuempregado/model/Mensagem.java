package com.meuempregado.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_mensagem")
public class Mensagem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMensagem;
	private String nomeempresa;
	private String email;
	private String msg;
	private String endereco;
	private String vaga;
	private String horaentrevista;
	private String data;
	private Float salario;
	private String beneficios;
		
	private Boolean ativo;
	
	private Integer idContratoSeguro;
	private Boolean ofereceSeguro;
	
	@ManyToOne
	@JoinColumn(name="idResposta")
	private Resposta resposta;
	
	@JoinColumn(name="idEmpregado")
	private Integer idEmpregado;
	
	@JoinColumn(name="idEmpregador")
	private Integer idEmpregador;
	
	public Mensagem(int idMensagem, String nomeempresa, String email, String msg, Resposta resposta, String endereco,
			String vaga, String horaentrevista,String data, Float salario, String beneficios, int idEmpregado, int idEmpregador, Boolean ativo, Integer idContratoSeguro, Boolean ofereceSeguro) {
		super();
		this.idMensagem = idMensagem;
		this.nomeempresa = nomeempresa;
		this.email = email;
		this.msg = msg;
		this.resposta = resposta;
		this.endereco = endereco;
		this.vaga = vaga;
		this.horaentrevista = horaentrevista;
		this.data=data;
		this.salario = salario;
		this.beneficios = beneficios;
		this.idEmpregado = idEmpregado;
		this.idEmpregador = idEmpregador;
		this.ativo = ativo;
		this.idContratoSeguro = idContratoSeguro;
		this.ofereceSeguro = ofereceSeguro;
	}
	
	public Mensagem(){
		
	}
	
	public int getIdMensagem() {
		return idMensagem;
	}
	public void setIdMensagem(int idMensagem) {
		this.idMensagem = idMensagem;
	}
	/*public void setId(int idMensagem) {
		this.idMensagem = idMensagem;
	}*/
	public String getNomeempresa() {
		return nomeempresa;
	}
	public void setNomeempresa(String nomeempresa) {
		this.nomeempresa = nomeempresa;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Resposta getResposta() {
		if (resposta == null){
			resposta = new Resposta();
		}//*
		
		return resposta;
	}
	public void setResposta(Resposta resposta) {
		this.resposta = resposta;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getVaga() {
		return vaga;
	}
	public void setVaga(String vaga) {
		this.vaga = vaga;
	}
	public String getHoraentrevista() {
		return horaentrevista;
	}
	public void setHoraentrevista(String horaentrevista) {
		this.horaentrevista = horaentrevista;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}	
	public Float getSalario() {
		return salario;
	}
	public void setSalario(Float salario) {
		this.salario = salario;
	}
	public String getBeneficios() {
		return beneficios;
	}
	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

	public Integer getIdEmpregado() {
		return idEmpregado;
	}
	public void setIdEmpregado(Integer idEmpregado) {
		this.idEmpregado = idEmpregado;
	}

	public Integer getIdEmpregador() {
		return idEmpregador;
	}
	public void setIdEmpregador(Integer idEmpregador) {
		this.idEmpregador = idEmpregador;
	}
	
	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Integer getIdContratoSeguro() {
		return idContratoSeguro;
	}

	public void setIdContratoSeguro(Integer idContratoSeguro) {
		this.idContratoSeguro = idContratoSeguro;
	}

	public Boolean getOfereceSeguro() {
		return ofereceSeguro;
	}

	public void setOfereceSeguro(Boolean ofereceSeguro) {
		this.ofereceSeguro = ofereceSeguro;
	}

}
