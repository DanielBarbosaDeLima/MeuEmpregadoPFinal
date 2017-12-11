package com.meuempregado.model;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Entity
@Table(name = "tb_contratoseguro")
public class ContratoSeguro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String rg_funcionario;
	private String nome_funcionario;
	private String cpf_funcionario;
	private String endereco_rua_funcionario;
	private String cep_funcionario;
	private String cidade_funcionario;
	private String uf_funcionario;
	private String funcao_funcionario;

	private String nome_empregador;
	private String vaga_empregador;

	private String nome_pacote;
	private String cobertura_pacote;
	@Column(length = 1000)
	private String descricao_pacote;
	private Double indenizacao_pacote;
	private Double valorMensal_pacote;

	private Boolean ativo;

	public ContratoSeguro() {

	}

	public ContratoSeguro(Integer id, String rg_funcionario, String nome_funcionario, String cpf_funcionario,
			String endereco_rua_funcionario, String cep_funcionario, String cidade_funcionario, String uf_funcionario,
			String funcao_funcionario, String nome_empregador, String vaga_empregador, String nome_pacote,
			String cobertura_pacote, String descricao_pacote, Double indenizacao_pacote, Double valorMensal_pacote,
			Boolean ativo) {
		this.id = id;
		this.rg_funcionario = rg_funcionario;
		this.nome_funcionario = nome_funcionario;
		this.cpf_funcionario = cpf_funcionario;
		this.endereco_rua_funcionario = endereco_rua_funcionario;
		this.cep_funcionario = cep_funcionario;
		this.cidade_funcionario = cidade_funcionario;
		this.uf_funcionario = uf_funcionario;
		this.funcao_funcionario = funcao_funcionario;
		this.nome_empregador = nome_empregador;
		this.vaga_empregador = vaga_empregador;
		this.nome_pacote = nome_pacote;
		this.cobertura_pacote = cobertura_pacote;
		this.descricao_pacote = descricao_pacote;
		this.indenizacao_pacote = indenizacao_pacote;
		this.valorMensal_pacote = valorMensal_pacote;
		this.ativo = ativo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRg_funcionario() {
		return rg_funcionario;
	}

	public void setRg_funcionario(String rg_funcionario) {
		this.rg_funcionario = rg_funcionario;
	}

	public String getNome_funcionario() {
		return nome_funcionario;
	}

	public void setNome_funcionario(String nome_funcionario) {
		this.nome_funcionario = nome_funcionario;
	}

	public String getCpf_funcionario() {
		return cpf_funcionario;
	}

	public void setCpf_funcionario(String cpf_funcionario) {
		this.cpf_funcionario = cpf_funcionario;
	}

	public String getEndereco_rua_funcionario() {
		return endereco_rua_funcionario;
	}

	public void setEndereco_rua_funcionario(String endereco_rua_funcionario) {
		this.endereco_rua_funcionario = endereco_rua_funcionario;
	}

	public String getCep_funcionario() {
		return cep_funcionario;
	}

	public void setCep_funcionario(String cep_funcionario) {
		this.cep_funcionario = cep_funcionario;
	}

	public String getCidade_funcionario() {
		return cidade_funcionario;
	}

	public void setCidade_funcionario(String cidade_funcionario) {
		this.cidade_funcionario = cidade_funcionario;
	}

	public String getUf_funcionario() {
		return uf_funcionario;
	}

	public void setUf_funcionario(String uf_funcionario) {
		this.uf_funcionario = uf_funcionario;
	}

	public String getFuncao_funcionario() {
		return funcao_funcionario;
	}

	public void setFuncao_funcionario(String funcao_funcionario) {
		this.funcao_funcionario = funcao_funcionario;
	}

	public String getNome_pacote() {
		return nome_pacote;
	}

	public void setNome_pacote(String nome_pacote) {
		this.nome_pacote = nome_pacote;
	}

	public String getDescricao_pacote() {
		return descricao_pacote;
	}

	public void setDescricao_pacote(String descricao_pacote) {
		this.descricao_pacote = descricao_pacote;
	}

	public Double getIndenizacao_pacote() {
		return indenizacao_pacote;
	}

	public void setIndenizacao_pacote(Double indenizacao_pacote) {
		this.indenizacao_pacote = indenizacao_pacote;
	}

	public Double getValorMensal_pacote() {
		return valorMensal_pacote;
	}

	public void setValorMensal_pacote(Double valorMensal_pacote) {
		this.valorMensal_pacote = valorMensal_pacote;
	}

	public String getNome_empregador() {
		return nome_empregador;
	}

	public void setNome_empregador(String nome_empregador) {
		this.nome_empregador = nome_empregador;
	}

	public String getVaga_empregador() {
		return vaga_empregador;
	}

	public void setVaga_empregador(String vaga_empregador) {
		this.vaga_empregador = vaga_empregador;
	}

	public String getCobertura_pacote() {
		return cobertura_pacote;
	}

	public void setCobertura_pacote(String cobertura_pacote) {
		this.cobertura_pacote = cobertura_pacote;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String IndenizaçãoReal() {
		Locale ptBr = new Locale("pt", "BR");
		String valorString = NumberFormat.getCurrencyInstance(ptBr).format(this.indenizacao_pacote);
		return valorString;
	}

	public String ValorMensalReal() {
		Locale ptBr = new Locale("pt", "BR");
		String valorString = NumberFormat.getCurrencyInstance(ptBr).format(this.valorMensal_pacote);
		return valorString;
	}
}
