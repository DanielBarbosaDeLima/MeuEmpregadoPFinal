package com.meuempregado.service;

import java.util.List;

import com.meuempregado.dao.ListarEmpregadosDAO;
import com.meuempregado.model.Empregado;

public class ListarEmpregadosService {
	LoginService serviceLogin = new LoginService();
	ListarEmpregadosDAO dao = new ListarEmpregadosDAO();
	
	public List<Empregado> listarEmpregados() {
		List<Empregado> listaEmpregado = dao.listarEmpregados();
		
		for(int i=0;i<listaEmpregado.size();i++) {
			//if(listaEmpregado.get(i).get) {
				//listaEmpregado.add(e);
			//}
		}
		
		return listaEmpregado;
	}
}
