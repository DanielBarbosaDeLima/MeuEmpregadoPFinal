package com.meuempregado.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.meuempregado.bean.ContratoSeguroManagedBean;
import com.meuempregado.bean.MensagemManagedBean;
import com.meuempregado.model.ContratoDemissao;
import com.meuempregado.model.ContratoSeguro;
import com.meuempregado.model.Empregado;
import com.meuempregado.model.Empregador;
import com.meuempregado.model.Mensagem;
import com.meuempregado.service.ContratoSeguroService;
import com.meuempregado.service.EmpregadoService;
import com.meuempregado.service.EmpregadorService;
import com.meuempregado.service.MensagemService;
import com.meuempregado.service.TipoDemissaoService;

public class Test_Cadastro {
	@Test
	public void cadastrarEmpregados(){
		/*EmpregadoService service = new EmpregadoService();
		Empregado empregado1 = new Empregado(null, "Rodrigo Bora",new Date(), "100.687.912-20", "14.683.738-5", "(41) 3246-7490",
				"(41)99930-7485", "8189-350", "Rua José Rodrigues Pinheiro", 2261, "Sobrado A",
				"Lapa","Lapa", "PR", true, true, "Jardineiro", "bora@gmail.com",
				"senha", null);
		service.cadastrar(empregado1);*/
		EmpregadorService service = new EmpregadorService();
		Empregador empregador = new Empregador(null, "Thiago Souza","12.736.446-7", "100.485.912-92", "SSP", "(41)98454-9466",
				"(41)3240-2000", "28/11/1997", "M", "thiago@gmail.com", "senha");
		service.cadastrar(empregador);
	}
}
