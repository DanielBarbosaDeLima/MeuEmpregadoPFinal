package com.meuempregado.service;


import java.util.StringTokenizer;

import com.meuempregado.dao.FactoryDao;
import com.meuempregado.model.ContratoDemissao;




public class TipoDemissaoService {

	public float tipoDemisao(float Salario, int dias, String aviso, String vencida, String inicio, String fim,
			String tipo) {
	
		if (tipo.equals("JustaCausa")) {
			return DemissaoJusta(Salario, dias, aviso, vencida, inicio, fim);
		}
		if (tipo.equals("SemJusta")) {
			return DemissaoSemJusta(Salario, dias, aviso, vencida, inicio, fim);
		}
		if (tipo.equals("PedidoDemissao")) {
			return PedidoDemissao(Salario, dias, aviso, vencida, inicio, fim);
		}
		
		return 112;
	}
	
	public float DemissaoJusta(float Salario, int dias, String aviso, String vencida, String inicio, String fim) {
		float calculo = 0;

		calculo = SaldoSalarial(Salario, dias) + FeriasSemJusta(vencida, Salario);

		return calculo;
	}
	
	public float PedidoDemissao(float Salario, int dias, String aviso, String vencida, String inicio, String fim) {
		float calculo = 0;
		calculo = SaldoSalarial(Salario, dias);
		

		calculo = calculo + DecSalarioPropor(Salario, MesesTrabalhados(inicio, fim));

		calculo = calculo + FeriasProporcional(Salario, MesesTrabalhados(inicio, fim));
 
		calculo = calculo + FeriasSemJusta(vencida, Salario);

		calculo = calculo + AvisoPrevio( aviso, Salario);

		return calculo;

	}

	public float DemissaoSemJusta(float Salario, int dias, String aviso, String vencida, String inicio, String fim) {
		float calculo = 0;
		calculo = SaldoSalarial(Salario, dias) + 
				DecSalarioPropor(Salario, MesesTrabalhados(inicio, fim))
				+ FeriasSemJusta(vencida, Salario) + 
				FeriasProporcional(Salario, MesesTrabalhados(inicio, fim)) + Salario + salariocont(Salario);

		return calculo;
	}
	
	public float salariocont(float Salario){
		float saldo=0;
		saldo=Salario/3;
		
		return saldo;
	}
	
	public float SaldoSalarial(float Salario, int dias){
		
		float Saldo=0;
		
		Saldo=dias * (Salario/30);
				
		return Saldo;
	}
	
	public float AvisoPrevio(String aviso, float Salario){
		float Saldo=0;
		
		if(aviso.equals("SIM")){
			Saldo=Salario;
			
			return Saldo;
		}
		if(aviso.equals("NAO")) {
			
			Saldo=(Salario);
		
			return -Saldo;
		}
		 
		
		
		return Saldo;
	}
		
	public float FeriasSemJusta(String vencida, float Salario){
		float Saldo=0;
		if(vencida.equals("SIM")){
			Saldo= Salario+(Salario/3);
			return Saldo;
		}
		if(vencida.equals("NAO")) {
			return Saldo;
		}
		 return Saldo;
	}
	
	public float FeriasProporcional(float Salario, int meses){
		float Saldo=0;
		Saldo= ((Salario+(Salario/3))/12)*meses;
				
		return Saldo;
	}
	
	public float DecSalarioPropor(float Salario, int meses){
		float Saldo=0;
		Saldo= ((Salario)/12)*meses;

		return Saldo;
	}
		
	public int MesesTrabalhados(String inicio, String fim){
		
		String recebe;
		String recebefim;
		int i = 0;
		int f = 0;
		
		StringTokenizer st = new StringTokenizer(inicio);
		st.nextToken("/");
		recebe=st.nextToken("/");
		StringTokenizer stf = new StringTokenizer(fim);
		stf.nextToken("/");
		recebefim=stf.nextToken("/");
		
		i = Integer.parseInt(recebe);
		f = Integer.parseInt(recebefim);
		
		return ((f - i)-12)+12;
		
	}
	
	public int AnosTrabalhados(String inicio, String fim){
		String recebe;
		String recebefim;
		int i = 0;
		int f = 0;
		
		StringTokenizer st = new StringTokenizer(inicio);
		st.nextToken("/");
		st.nextToken("/");
		recebe=st.nextToken("/");
		StringTokenizer stf = new StringTokenizer(fim);
		stf.nextToken("/");
		stf.nextToken("/");
		recebefim=stf.nextToken("/");
		
		i = Integer.parseInt(recebe);
		f = Integer.parseInt(recebefim);
		
		return (f-i);
	}
	
	public void cadastrar(ContratoDemissao cd){
		FactoryDao.createGenericDao(ContratoDemissao.class).inserir(cd);
	}
}