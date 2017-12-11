package com.meuempregado.model;

import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_pacoteseguro")
public class PacoteSeguro {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String cobertura;
	@Column(length = 1000)
	private String descricao;
	private Double indenizacao;
	private Double valorMensal;
	
	public PacoteSeguro(){
		
	}
	public PacoteSeguro(Integer id, String nome,String cobertura, String descricao, Double indenizacao, Double valorMensal) {
		this.id = id;
		this.nome = nome;
		this.cobertura = cobertura;
		this.descricao = descricao;
		this.indenizacao = indenizacao;
		this.valorMensal = valorMensal;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getIndenizacao() {
		return indenizacao;
	}
	public void setIndenizacao(Double indenizacao) {
		this.indenizacao = indenizacao;
	}
	public Double getValorMensal() {
		return valorMensal;
	}
	public void setValorMensal(Double valorMensal) {
		this.valorMensal = valorMensal;
	}
	public String getCobertura() {
		return cobertura;
	}
	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}
	public String IndenizaçãoReal(){
		Locale ptBr = new Locale("pt", "BR");
		String valorString = NumberFormat.getCurrencyInstance(ptBr).format(this.indenizacao);
		return valorString;
	}
	public String ValorMensalReal(){
		Locale ptBr = new Locale("pt", "BR");
		String valorString = NumberFormat.getCurrencyInstance(ptBr).format(this.valorMensal);
		return valorString;
	}
}
