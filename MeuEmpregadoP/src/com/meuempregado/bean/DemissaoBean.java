package com.meuempregado.bean;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.meuempregado.model.ContratoDemissao;
import com.meuempregado.model.Empregado;
import com.meuempregado.model.Mensagem;
import com.meuempregado.service.LoginService;
import com.meuempregado.service.MensagemService;
import com.meuempregado.service.TipoDemissaoService;

@ManagedBean(name = "DemissaoBean")
@SessionScoped

public class DemissaoBean implements Serializable {

	private static final long serialVersionUID = -5852851847769851291L;
	
	private TipoDemissaoService demissaoS ;
	private ContratoDemissao contratodemissao;
	private Mensagem mensagem;
	private MensagemService mgmservice;
	private Empregado empregado;
	private LoginService ls;
	
	
	public DemissaoBean() throws SQLException{
		mensagem = new Mensagem();
		demissaoS = new TipoDemissaoService();
		contratodemissao = new ContratoDemissao(null, "", 0, 0, 0, 0, "", "", "");
		mgmservice = new MensagemService();
		empregado = new Empregado();
		ls = new LoginService();
	}
	public String ObterDadosAction(){
		List<Mensagem> ms = mgmservice.listall();
		
		for(Mensagem m:ms){
			if(m.getIdEmpregado()== empregado.getId() && m.getIdEmpregador()== ls.getIdEmpregadorlogin()){
				mensagem = m;
				contratodemissao.setSaldosalario(mensagem.getSalario());
			}
		}
		return "telaDemissao";
	}
	public String CalculoDemissaoAction() {
			
		contratodemissao.setTotal(demissaoS.tipoDemisao(mensagem.getSalario(), contratodemissao.getDiastrabalhados(), contratodemissao.getAvisotrabalhado(), contratodemissao.getFeriasvencida(), mensagem.getData(), contratodemissao.getDatademissao(), contratodemissao.getTipodemissao()));
	
		return "telaDemissao";
	}
	public String salvarDemissaoAction(){
		
		
		Document doc = new Document(PageSize.A4);
		doc.setPageSize(PageSize.A4.rotate());

		try {
			PdfWriter.getInstance(doc, new FileOutputStream(
					"C:/Users/Daniel/Desktop/contrato/" + empregado.getNomeCompleto()+ ".pdf"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		doc.open();
		Font font = new Font(FontFamily.COURIER, 12);

		Paragraph p1 = new Paragraph("RESCISAO CONTRATO DE TRABALHO", font);
		try {
			doc.add(p1);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		Paragraph p27 = new Paragraph(" ", font);
		
		try {
			doc.add(p27);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		Paragraph p2 = new Paragraph("IDENTIFICAÇÃO EMPREGADO:", font);
		try {
			doc.add(p2);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p28 = new Paragraph(" ", font);
		
		try {
			doc.add(p28);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p3 = new Paragraph("EMPREGADO(a): " + empregado.getNomeCompleto() + ", possui CPF. nº " + empregado.getCpf() + " admitido na data " + 
		mensagem.getData() + " e rescindindo contrato na data: " + contratodemissao.getDatademissao()
		+ " sendo desligado pelo motivo " + contratodemissao.getTipodemissao() + ".", font);
		try {
			
			doc.add(p3);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p29 = new Paragraph(" ", font);
		
		try {
			doc.add(p29);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p4 = new Paragraph("CALCULO DE VERBAS", font);
		try {
			doc.add(p4);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p30 = new Paragraph(" ", font);
		
		try {
			doc.add(p30);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p5 = new Paragraph("Ultimo salrio: R$ " + mensagem.getSalario() + " " + " Ferias vencidas: " + contratodemissao.getFeriasvencida() + " Aviso indenizado: " +contratodemissao.getAvisotrabalhado()
		 + " calculo da rescisao no valor R$ "  + contratodemissao.getTotal(), font);
		
		try {
			doc.add(p5);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		try {
			doc.add(p29);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		Paragraph p23 = new Paragraph("____________________________________________", font);
		
		try {
			doc.add(p23);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		Paragraph p24 = new Paragraph("Assinatura do (a) Empregado (a)", font);
		
		try {
			doc.add(p24);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		try {
			doc.add(p29);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		Paragraph p25 = new Paragraph("____________________________________________", font);
		
		try {
			doc.add(p25);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		Paragraph p26 = new Paragraph("Assinatura do (a) Empregador (a).", font);
		
		try {
			doc.add(p26);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		doc.close();
		File pdf = new File("C:/Users/Daniel/Desktop/contrato/" + empregado.getNomeCompleto()+ ".pdf");
		try {
			Desktop.getDesktop().open(pdf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		demissaoS.cadastrar(contratodemissao);
		mgmservice.excluir(mensagem);
		return "listamensagemEMPREGADOR";
	}
	public ContratoDemissao getContratodemissao() {
		return contratodemissao;
	}

	public void setContratodemissao(ContratoDemissao contratodemissao) {
		this.contratodemissao = contratodemissao;
	}

	public TipoDemissaoService getDemissaoS() {
		return demissaoS;
	}

	public void setDemissaoS(TipoDemissaoService demissaoS) {
		this.demissaoS = demissaoS;
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}
	public MensagemService getMgmservice() {
		return mgmservice;
	}
	public void setMgmservice(MensagemService mgmservice) {
		this.mgmservice = mgmservice;
	}
	public Empregado getEmpregado() {
		return empregado;
	}
	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}
	public LoginService getLs() {
		return ls;
	}
	public void setLs(LoginService ls) {
		this.ls = ls;
	}
}
