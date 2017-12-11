package com.meuempregado.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_contratodemissao")
public class ContratoDemissao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Integer id;
	private String datademissao;
	private float saldosalario;
	private float avisoprevio;
	private float total;
	private int diastrabalhados;
	private String feriasvencida;
	private String avisotrabalhado;
	private String tipodemissao;
	
	public ContratoDemissao() {
		
	}
	
	public ContratoDemissao(Integer id, String datademissao, float saldosalario, float avisoprevio, float total,
			int diastrabalhados, String feriasvencida, String avisotrabalhado, String tipodemissao) {
		super();
		this.id = id;
		this.datademissao = datademissao;
		this.saldosalario = saldosalario;
		this.avisoprevio = avisoprevio;
		this.total = total;
		this.diastrabalhados = diastrabalhados;
		this.feriasvencida = feriasvencida;
		this.avisotrabalhado = avisotrabalhado;
		this.tipodemissao = tipodemissao;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDatademissao() {
		return datademissao;
	}
	public void setDatademissao(String datademissao) {
		this.datademissao = datademissao;
	}
	public float getSaldosalario() {
		return saldosalario;
	}
	public void setSaldosalario(float saldosalario) {
		this.saldosalario = saldosalario;
	}
	public float getAvisoprevio() {
		return avisoprevio;
	}
	public void setAvisoprevio(float avisoprevio) {
		this.avisoprevio = avisoprevio;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getDiastrabalhados() {
		return diastrabalhados;
	}
	public void setDiastrabalhados(int diastrabalhados) {
		this.diastrabalhados = diastrabalhados;
	}
	public String getFeriasvencida() {
		return feriasvencida;
	}
	public void setFeriasvencida(String feriasvencida) {
		this.feriasvencida = feriasvencida;
	}
	public String getAvisotrabalhado() {
		return avisotrabalhado;
	}
	public void setAvisotrabalhado(String avisotrabalhado) {
		this.avisotrabalhado = avisotrabalhado;
	}
	public String getTipodemissao() {
		return tipodemissao;
	}
	public void setTipodemissao(String tipodemissao) {
		this.tipodemissao = tipodemissao;
	}
}
