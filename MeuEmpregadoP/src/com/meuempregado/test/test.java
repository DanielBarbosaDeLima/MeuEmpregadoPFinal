package com.meuempregado.test;

import org.junit.Test;

import com.meuempregado.model.PacoteSeguro;
import com.meuempregado.service.PacoteSeguroService;

public class test {
	@Test
	public void cadastrarPacote(){
		PacoteSeguroService service = new PacoteSeguroService();
		
		PacoteSeguro pacote1 = new PacoteSeguro(null,"SEG+","Morte Natural e Acidental","Garanta as pessoas que mais precisam de você, recebam uma indenização em caso do seu falecimento.",20000.00,59.00);
		service.cadastrar(pacote1);
		PacoteSeguro pacote2 = new PacoteSeguro(null,"SEG++","Morte Natural, Acidental e Invalidez","Garanta as pessoas que mais precisam de você, recebam uma indenização em caso do seu falecimento e mais tranquilidade para manter as finanças em dia no caso de uma invalidez permanente.",35000.00,89.00);
		service.cadastrar(pacote2);
		PacoteSeguro pacote3 = new PacoteSeguro(null,"SEGTOP","Morte Natural, Acidental, Invalidez e Doenças Graves.","Garanta as pessoas que mais precisam de você, recebam uma indenização em caso do seu falecimento e mais tranquilidade para manter as finanças em dia no caso de uma invalidez permanente. No caso de doenças graves ( AVC, Câncer, Infarto, Mal de Alzheimer, etc. ) suas finanças estarão seguras  e seus esforços fiquem voltados para o mais importante a sua saúde.",50000.00,99.00);
		service.cadastrar(pacote3);
	}
}
