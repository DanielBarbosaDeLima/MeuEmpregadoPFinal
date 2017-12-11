package com.meuempregado.bean;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;
import com.meuempregado.model.ContratoSeguro;
import com.meuempregado.model.Empregado;
import com.meuempregado.model.Empregador;
import com.meuempregado.model.Mensagem;
import com.meuempregado.model.PacoteSeguro;
import com.meuempregado.service.ContratoSeguroService;
import com.meuempregado.service.EmpregadoService;
import com.meuempregado.service.EmpregadorService;
import com.meuempregado.service.LoginService;
import com.meuempregado.service.PacoteSeguroService;

@ManagedBean(name = "contratoSeguroManagedBean")
@SessionScoped
public class ContratoSeguroManagedBean implements Serializable{
	private static final long serialVersionUID = -4640086967386715764L;
	
	private ContratoSeguro contrato;
	private List<ContratoSeguro> contratos;
	private ContratoSeguroService service;
	
	private EmpregadoService serviceempregado = new EmpregadoService();
	private Empregado empregado = new Empregado();
	
	private LoginService login;
	
	private EmpregadorService empregadorservice = new EmpregadorService();
	
	public ContratoSeguroManagedBean(){
		atualizar();
	}
	public void inserirContratoSeguroAction(){
		service.cadastrar(contrato);
		atualizar();
	}
	
	public void atualizarContratoSeguroAction(){
		service.atulizar(contrato);
		atualizar();
	}
	public void excluirContratoSeguroAction(){
		service.excluir(contrato);
		atualizar();
	}
	public void addEmpregadoAction(){
		
		contrato.setRg_funcionario(empregado.getRg());
		contrato.setNome_funcionario(empregado.getNomeCompleto());
		contrato.setCpf_funcionario(empregado.getCpf());
		contrato.setEndereco_rua_funcionario(empregado.getEnderecoRua());
		contrato.setCep_funcionario(empregado.getCep());
		contrato.setCidade_funcionario(empregado.getCidade());
		contrato.setUf_funcionario(empregado.getUf());
	}
	public String addPacote1(){
		addEmpregadoAction();
		PacoteSeguroService pacoteservice = new PacoteSeguroService();
		PacoteSeguro pacote = pacoteservice.buscarId(1);
		
		contrato.setNome_pacote(pacote.getNome());
		contrato.setCobertura_pacote(pacote.getCobertura());
		contrato.setDescricao_pacote(pacote.getDescricao());
		contrato.setIndenizacao_pacote(pacote.getIndenizacao());
		contrato.setValorMensal_pacote(pacote.getValorMensal());
		
		contrato.setAtivo(true);
		service.cadastrar(contrato);
		
		ContratoSeguroService contratoseguroservice = new ContratoSeguroService();
		List<ContratoSeguro> contratos = contratoseguroservice.listar();
		for(ContratoSeguro c :contratos) {
			if(c.getNome_funcionario().equals(contrato.getNome_funcionario())) {
				empregado.setContratoseguro(c.getId());
				serviceempregado.atulizar(empregado);
			}
		}
		imprimir();
		
		atualizar();
		return "MeusEmpregados";
	}
	public String addPacote2(){
		addEmpregadoAction();
		PacoteSeguroService pacoteservice = new PacoteSeguroService();
		PacoteSeguro pacote = pacoteservice.buscarId(2);
		
		contrato.setNome_pacote(pacote.getNome());
		contrato.setCobertura_pacote(pacote.getCobertura());
		contrato.setDescricao_pacote(pacote.getDescricao());
		contrato.setIndenizacao_pacote(pacote.getIndenizacao());
		contrato.setValorMensal_pacote(pacote.getValorMensal());
		contrato.setAtivo(true);
		service.cadastrar(contrato);
		
		ContratoSeguroService contratoseguroservice = new ContratoSeguroService();
		List<ContratoSeguro> contratos = contratoseguroservice.listar();
		for(ContratoSeguro c :contratos) {
			if(c.getNome_funcionario().equals(contrato.getNome_funcionario())) {
				empregado.setContratoseguro(c.getId());
				serviceempregado.atulizar(empregado);
			}
		}
		imprimir();
		
		atualizar();
		return "MeusEmpregados";
	}
	public String addPacote3(){
		addEmpregadoAction();
		PacoteSeguroService pacoteservice = new PacoteSeguroService();
		PacoteSeguro pacote = pacoteservice.buscarId(3);
		
		contrato.setNome_pacote(pacote.getNome());
		contrato.setCobertura_pacote(pacote.getCobertura());
		contrato.setDescricao_pacote(pacote.getDescricao());
		contrato.setIndenizacao_pacote(pacote.getIndenizacao());
		contrato.setValorMensal_pacote(pacote.getValorMensal());
		contrato.setAtivo(true);
		service.cadastrar(contrato);
		
		ContratoSeguroService contratoseguroservice = new ContratoSeguroService();
		List<ContratoSeguro> contratos = contratoseguroservice.listar();
		for(ContratoSeguro c :contratos) {
			if(c.getNome_funcionario().equals(contrato.getNome_funcionario())) {
				empregado.setContratoseguro(c.getId());
				serviceempregado.atulizar(empregado);
			}
		}
		imprimir();
		
		atualizar();
		return "MeusEmpregados";
	}
	public String cancelar(){
		atualizar();
		return "MeusEmpregados";
	}
	public String restringir(){
		contrato.setAtivo(false);
		service.atulizar(contrato);
		
		Empregado empregado1 = new Empregado();
		List<Empregado> list = serviceempregado.listar();
		
		for(Empregado e:list) {
			if(contrato.getNome_funcionario().equals(e.getNomeCompleto())) {
				empregado1 = e;
				empregado1.setContratoseguro(null);
				serviceempregado.atulizar(empregado1);
			}
		}
		
		atualizar();
		return "listaContratoSeguro";
	}
	public ContratoSeguro getContrato() {
		return contrato;
	}
	public void setContrato(ContratoSeguro contrato) {
		this.contrato = contrato;
	}
	public List<ContratoSeguro> getContratos() {
		return contratos;
	}
	public void setContratos(List<ContratoSeguro> contratos) {
		this.contratos = contratos;
	}
	public ContratoSeguroService getService() {
		return service;
	}
	public void setService(ContratoSeguroService service) {
		this.service = service;
	}
	public void atualizar(){
		contrato = new ContratoSeguro();
		service = new ContratoSeguroService();
		contratos = service.listar();
	}
	public String imprimir() {
		// PDF
		Document doc = new Document(PageSize.A4);
		doc.setPageSize(PageSize.A4.rotate());

		try {
			PdfWriter.getInstance(doc, new FileOutputStream(
					"C:/Users/Daniel/Documents/" + contrato.getNome_funcionario() + contrato.getNome_pacote() + ".pdf"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		doc.open();
		Font font = new Font(FontFamily.COURIER, 12);

		Paragraph p1 = new Paragraph("CONTRATO DE SEGURO", font);
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
		
		Paragraph p2 = new Paragraph("IDENTIFICAÇÃO DAS PARTES CONTRATANTES:", font);
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
		Paragraph p3 = new Paragraph("SEGURADO(A): " + contrato.getNome_funcionario() + ", possui R.G. nº " + contrato.getRg_funcionario()
		+ ", C.P.F. nº " + contrato.getCpf_funcionario() + ", residente e domiciliado(a) na rua,"
		+ contrato.getEndereco_rua_funcionario() + " CEP " + contrato.getCep_funcionario() + ", na cidade de "
		+ contrato.getCidade_funcionario() + ", no Estado de " + contrato.getUf_funcionario() + ".", font);
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
		Paragraph p4 = new Paragraph("SEGURADORA: Bradesco Seguro S/A, com sede Barueri, na rua avenida Alphaville 779, bairro EMPRESARIAL 18 DO FORTE, CEP 06.472-900, no Estado de SP, inscrita no C.N.P.J. nº 33.055.146/0001-93, cadastro estadual nº 65.12-0-00.", font);
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
		Paragraph p5 = new Paragraph("As partes acima identificadas têm, entre si, justo e acertado, o presente CONTRATO DE SEGURO DE VIDA, que se regerá pelas cláusulas seguintes e pelas condições descritas no presente.", font);
		
		try {
			doc.add(p5);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p31 = new Paragraph(" ", font);
		
		try {
			doc.add(p31);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p6 = new Paragraph("DO OBJETO DO CONTRATO", font);
		
		try {
			doc.add(p6);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p32 = new Paragraph(" ", font);
		
		try {
			doc.add(p32);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p7 = new Paragraph(" Cláusula 1ª. O presente contrato tem como objeto a garantir AO SEGURADO as garantias do pacote de seguro "
				+ contrato.getNome_pacote() + "  com a seguinte descrição " + contrato.getCobertura_pacote() + " ("
				+ contrato.getDescricao_pacote() + ")  com o premio de indenização no valor de " + contrato.IndenizaçãoReal()
				+ ", ficando o SEGURADO OBRIGADO A PAGAR O VALOR MENSAL DE " + contrato.ValorMensalReal() + ".", font);
		
		try {
			doc.add(p7);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		try {
			doc.add(p32);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p8 = new Paragraph("DAS OBRIGAÇÕES DA SEGURADORA", font);
		
		try {
			doc.add(p8);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		try {
			doc.add(p32);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p9 = new Paragraph("Cláusula 2ª. A SEGURADORA fica obrigada a pagar o valor correspondente ao total das despesas e custos decorrentes dos danos experimentados pela SEGURADORA, quando da ocorrência de sinistro ou infortúnios envolvendo o(a) SEGURADO(A), sobre o(a) qual recai o presente seguro. Tais parcelas indenizatórias, ora pactuadas, devem necessariamente estar acobertadas e previstas neste contrato.", font);
		
		try {
			doc.add(p9);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		try {
			doc.add(p32);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p10 = new Paragraph("Cláusula 3ª. A SEGURADORA está obrigada a assegurar todos os serviços dispostos neste contrato de maneira segura e eficaz.", font);
		
		try {
			doc.add(p10);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		try {
			doc.add(p32);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p11 = new Paragraph("DAS OBRIGAÇÕES DO (A) SEGURADO (A)", font);
		
		try {
			doc.add(p11);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		try {
			doc.add(p32);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p12 = new Paragraph("Cláusula 4ª. O (a) SEGURADO (A) deve informar à SEGURADORA, por escrito, quaisquer fatos ou alterações verificadas durante a vigência deste contrato como a contratação ou cancelamento de qualquer outro seguro.", font);
		
		try {
			doc.add(p12);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		try {
			doc.add(p32);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p13 = new Paragraph(" Cláusula 5ª. Qualquer alteração do contrato que seja de interesse do (a) SEGURADO (A) só poderá ser feita com a concordância expressa e inequívoca da SEGURADORA.", font);
		
		try {
			doc.add(p13);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		try {
			doc.add(p32);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p14 = new Paragraph(" Cláusula 6ª. O (A) SEGURADO (A) tem o dever de fazer o pagamento da cota do prêmio do seguro mesmo que tenham ocorrido imprevistos.", font);
		
		try {
			doc.add(p14);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		try {
			doc.add(p32);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p15 = new Paragraph("DA SUB-ROGAÇÃO DE DIREITOS", font);
		
		try {
			doc.add(p15);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		try {
			doc.add(p32);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p16 = new Paragraph(" Cláusula 7ª. No caso do pagamento da indenização, o recibo valerá como instrumento de cessão, na qual a SEGURADORA ficará sub-rogada, até o limite da indenização, em todos os direitos e ações do (a) SEGURADO (A) contra aqueles que por ato, fato ou omissão, tenham causado os prejuízos indenizados pela SEGURADORA ou para eles concorrido, obrigando o (a) SEGURADO (A) a facilitar os meios necessários ao exercício dessa sub-rogação.", font);
		
		try {
			doc.add(p16);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		try {
			doc.add(p32);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p17 = new Paragraph("DO PRAZO", font);
		
		try {
			doc.add(p17);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		try {
			doc.add(p32);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p18 = new Paragraph("Cláusula 8ª. A cobertura deste seguro terá duração de até o fim do contrato de trabalho entre empregador e empregado.", font);
		
		try {
			doc.add(p18);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		try {
			doc.add(p32);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p19 = new Paragraph("DA RESCISÃO", font);
		
		try {
			doc.add(p19);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		try {
			doc.add(p32);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p20 = new Paragraph(" Cláusula 9ª. Este contrato poderá ser rescindido, total ou parcialmente, a qualquer tempo, por iniciativa de ambas as partes, quando obtida a concordância da outra parte, devendo ser observadas as disposições seguintes:", font);
		
		try {
			doc.add(p20);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		try {
			doc.add(p32);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p21 = new Paragraph("a) Se o pedido de rescisão for do (a) SEGURADO (A), a SEGURADORA reterá, além dos lucros cessantes, o prêmio calculado de acordo com o índice de correção em vigor;", font);
		
		try {
			doc.add(p21);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		try {
			doc.add(p32);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p22 = new Paragraph("b) A cobertura estabelecida no contrato ficará automaticamente cancelada, sem qualquer restituição de prêmios e lucros cessantes, se a indenização ou a soma das indenizações pagas atingir ou ultrapassar o valor do respectivo seguro.", font);
		
		try {
			doc.add(p22);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		try {
			doc.add(p32);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p23 = new Paragraph("____________________________________________", font);
		
		try {
			doc.add(p23);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		Paragraph p24 = new Paragraph("Assinatura do (a) representante da Seguradora", font);
		
		try {
			doc.add(p24);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		try {
			doc.add(p32);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Paragraph p25 = new Paragraph("____________________________________________", font);
		
		try {
			doc.add(p25);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		Paragraph p26 = new Paragraph("Assinatura do (a) segurado (a).", font);
		
		try {
			doc.add(p26);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		doc.close();
		File pdf = new File("C:/Users/Daniel/Documents/" + contrato.getNome_funcionario() + contrato.getNome_pacote() + ".pdf");
		try {
			Desktop.getDesktop().open(pdf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "listaContratoSeguro";
	}
	public Empregado getEmpregado() {
		return empregado;
	}
	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}
	public LoginService getLogin() {
		return login;
	}
	public void setLogin(LoginService login) {
		this.login = login;
	}
	public EmpregadorService getEmpregadorservice() {
		return empregadorservice;
	}
	public void setEmpregadorservice(EmpregadorService empregadorservice) {
		this.empregadorservice = empregadorservice;
	}
}
