package com.meuempregado.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.meuempregado.bean.ContratoSeguroManagedBean;
import com.meuempregado.bean.LoginManagedBean;
import com.meuempregado.bean.MensagemManagedBean;
import com.meuempregado.bean.PacoteSeguroManagedBean;
import com.meuempregado.model.ContratoSeguro;
import com.meuempregado.model.Empregado;
import com.meuempregado.model.Empregador;
import com.meuempregado.model.PacoteSeguro;
import com.meuempregado.service.ContratoSeguroService;
import com.meuempregado.service.EmpregadoService;
import com.meuempregado.service.EmpregadorService;
import com.meuempregado.service.PacoteSeguroService;

public class Test_Listar {
	@Test
	public void Listar() throws ClassNotFoundException, SQLException, IOException{
		MensagemManagedBean bean = new MensagemManagedBean();
		bean.atualizar();
	}
}
