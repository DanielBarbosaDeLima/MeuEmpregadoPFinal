package com.meuempregado.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_empregador")
public class Empregador {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Integer idEmpregador;
	private String nome;
	private String rg;
	private String cpf;
	private String orgao_emissor;
	private String telefone_celular;
	private String telefone_fixo;
	private String data_nascimento;
	private String sexo;
	private String email;
	private String senha;
	
	public Empregador(){
		
	}
	public Empregador(Integer id, String nome, String rg, String cpf, String orgao_emissor, String telefone_celular,
			String telefone_fixo, String data_nascimento, String sexo, String email, String senha) {
		//this.idEmpregador = id;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.orgao_emissor = orgao_emissor;
		this.telefone_celular = telefone_celular;
		this.telefone_fixo = telefone_fixo;
		this.data_nascimento = data_nascimento;
		this.sexo = sexo;
		this.email = email;
		this.senha = senha;
	}

	public Integer getId() {
		return idEmpregador;
	}
	public void setId(Integer id) {
		this.idEmpregador = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getOrgao_emissor() {
		return orgao_emissor;
	}
	public void setOrgao_emissor(String orgao_emissor) {
		this.orgao_emissor = orgao_emissor;
	}
	public String getTelefone_celular() {
		return telefone_celular;
	}
	public void setTelefone_celular(String telefone_celular) {
		this.telefone_celular = telefone_celular;
	}
	public String getTelefone_fixo() {
		return telefone_fixo;
	}
	public void setTelefone_fixo(String telefone_fixo) {
		this.telefone_fixo = telefone_fixo;
	}
	public String getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
