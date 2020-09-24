package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestCupomFiscal {

	private String BREAK = System.lineSeparator();

	private String TEXTO_ESPERADO_LOJA_COMPLETA = "Loja 1" + BREAK + "Log 1, 10 C1" + BREAK + "Bai 1 - Mun 1 - E1"
			+ BREAK + "CEP:11111-111 Tel (11) 1111-1111" + BREAK + "Obs 1" + BREAK + "CNPJ: 11.111.111/1111-11" + BREAK
			+ "IE: 123456789" + BREAK;

	private String TEXTO_ESPERADO_SEM_NUMERO = "Loja 1" + BREAK + "Log 1, s/n C1" + BREAK + "Bai 1 - Mun 1 - E1" + BREAK
			+ "CEP:11111-111 Tel (11) 1111-1111" + BREAK + "Obs 1" + BREAK + "CNPJ: 11.111.111/1111-11" + BREAK
			+ "IE: 123456789" + BREAK;

	private String TEXTO_ESPERADO_SEM_COMPLEMENTO = "Loja 1" + BREAK + "Log 1, 10" + BREAK + "Bai 1 - Mun 1 - E1"
			+ BREAK + "CEP:11111-111 Tel (11) 1111-1111" + BREAK + "Obs 1" + BREAK + "CNPJ: 11.111.111/1111-11" + BREAK
			+ "IE: 123456789" + BREAK;

	private String TEXTO_ESPERADO_SEM_BAIRRO = "Loja 1" + BREAK + "Log 1, 10 C1" + BREAK + "Mun 1 - E1" + BREAK
			+ "CEP:11111-111 Tel (11) 1111-1111" + BREAK + "Obs 1" + BREAK + "CNPJ: 11.111.111/1111-11" + BREAK
			+ "IE: 123456789" + BREAK;

	private String TEXTO_ESPERADO_SEM_CEP = "Loja 1" + BREAK + "Log 1, 10 C1" + BREAK + "Bai 1 - Mun 1 - E1" + BREAK
			+ "Tel (11) 1111-1111" + BREAK + "Obs 1" + BREAK + "CNPJ: 11.111.111/1111-11" + BREAK + "IE: 123456789"
			+ BREAK;

	private String TEXTO_ESPERADO_SEM_TELEFONE = "Loja 1" + BREAK + "Log 1, 10 C1" + BREAK + "Bai 1 - Mun 1 - E1"
			+ BREAK + "CEP:11111-111" + BREAK + "Obs 1" + BREAK + "CNPJ: 11.111.111/1111-11" + BREAK + "IE: 123456789"
			+ BREAK;

	private String TEXTO_ESPERADO_SEM_OBSERVACAO = "Loja 1" + BREAK + "Log 1, 10 C1" + BREAK + "Bai 1 - Mun 1 - E1"
			+ BREAK + "CEP:11111-111 Tel (11) 1111-1111" + BREAK + "" + BREAK + "CNPJ: 11.111.111/1111-11" + BREAK
			+ "IE: 123456789" + BREAK;

	private String NOME_LOJA = "Loja 1";
	private String LOGRADOURO = "Log 1";
	private int NUMERO = 10;
	private String COMPLEMENTO = "C1";
	private String BAIRRO = "Bai 1";
	private String MUNICIPIO = "Mun 1";
	private String ESTADO = "E1";
	private String CEP = "11111-111";
	private String TELEFONE = "(11) 1111-1111";
	private String OBSERVACAO = "Obs 1";
	private String CNPJ = "11.111.111/1111-11";
	private String INSCRICAO_ESTADUAL = "123456789";

	@Test
	public void lojaCompleta() {
		rodarTestarRetorno(TEXTO_ESPERADO_LOJA_COMPLETA, NOME_LOJA, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, MUNICIPIO,
				ESTADO, CEP, TELEFONE, OBSERVACAO, CNPJ, INSCRICAO_ESTADUAL);
	}

	@Test
	public void nomeVazio() {
		verificarCampoObrigatorio("O campo nome da loja é obrigatório", "", LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO,
				MUNICIPIO, ESTADO, CEP, TELEFONE, OBSERVACAO, CNPJ, INSCRICAO_ESTADUAL);
	}

	@Test
	public void logradouroVazio() {
		verificarCampoObrigatorio("O campo logradouro do endereço é obrigatório", NOME_LOJA, "", NUMERO, COMPLEMENTO,
				BAIRRO, MUNICIPIO, ESTADO, CEP, TELEFONE, OBSERVACAO, CNPJ, INSCRICAO_ESTADUAL);
	}

	@Test
	public void numeroZero() {
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_NUMERO, NOME_LOJA, LOGRADOURO, 0, COMPLEMENTO, BAIRRO, MUNICIPIO, ESTADO,
				CEP, TELEFONE, OBSERVACAO, CNPJ, INSCRICAO_ESTADUAL);
	}

	@Test
	public void complementoVazio() {
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_COMPLEMENTO, NOME_LOJA, LOGRADOURO, NUMERO, "", BAIRRO, MUNICIPIO, ESTADO,
				CEP, TELEFONE, OBSERVACAO, CNPJ, INSCRICAO_ESTADUAL);
	}

	@Test
	public void bairroVazio() {
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_BAIRRO, NOME_LOJA, LOGRADOURO, NUMERO, COMPLEMENTO, "", MUNICIPIO, ESTADO,
				CEP, TELEFONE, OBSERVACAO, CNPJ, INSCRICAO_ESTADUAL);
	}

	@Test
	public void municipioVazio() {
		verificarCampoObrigatorio("O campo município do endereço é obrigatório", NOME_LOJA, LOGRADOURO, NUMERO,
				COMPLEMENTO, BAIRRO, "", ESTADO, CEP, TELEFONE, OBSERVACAO, CNPJ, INSCRICAO_ESTADUAL);
	}

	@Test
	public void estadoVazio() {
		verificarCampoObrigatorio("O campo estado do endereço é obrigatório", NOME_LOJA, LOGRADOURO, NUMERO,
				COMPLEMENTO, BAIRRO, MUNICIPIO, "", CEP, TELEFONE, OBSERVACAO, CNPJ, INSCRICAO_ESTADUAL);
	}

	@Test
	public void cepVazio() {
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_CEP, NOME_LOJA, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, MUNICIPIO,
				ESTADO, null, TELEFONE, OBSERVACAO, CNPJ, INSCRICAO_ESTADUAL);
	}

	@Test
	public void telefoneVazio() {
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_TELEFONE, NOME_LOJA, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, MUNICIPIO,
				ESTADO, CEP, "", OBSERVACAO, CNPJ, INSCRICAO_ESTADUAL);
	}

	@Test
	public void observacaoVazia() {
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_OBSERVACAO, NOME_LOJA, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, MUNICIPIO,
				ESTADO, CEP, TELEFONE, "", CNPJ, INSCRICAO_ESTADUAL);
	}

	@Test
	public void cnpjVazio() {
		verificarCampoObrigatorio("O campo CNPJ da loja é obrigatório", NOME_LOJA, LOGRADOURO, NUMERO, COMPLEMENTO,
				BAIRRO, MUNICIPIO, ESTADO, CEP, TELEFONE, OBSERVACAO, null, INSCRICAO_ESTADUAL);
	}

	@Test
	public void inscricaoEstadualVazia() {
		verificarCampoObrigatorio("O campo inscrição estadual da loja é obrigatório", NOME_LOJA, LOGRADOURO, NUMERO,
				COMPLEMENTO, BAIRRO, MUNICIPIO, ESTADO, CEP, TELEFONE, OBSERVACAO, CNPJ, "");
	}

	@Test
	public void exercicio02_Customizado() {
		// Defina seus próprios valores para as variáveis a seguir
		String nomeLoja = "";
		String logradouro = "";
		int numero = 0;
		String complemento = "";
		String bairro = "";
		String municipio = "";
		String estado = "";
		String cep = "";
		String telefone = "";
		String observacao = "";
		String cnpj = "";
		String inscricaoEstadual = "";

		// E atualize o texto esperado abaixo
		rodarTestarRetorno("" + BREAK, nomeLoja, logradouro, numero, complemento, bairro, municipio, estado, cep,
				telefone, observacao, cnpj, inscricaoEstadual);
	}

	private void rodarTestarRetorno(String expected, String nomeLoja, String logradouro, int numero, String complemento,
			String bairro, String municipio, String estado, String cep, String telefone, String observacao, String cnpj,
			String inscricaoEstadual) {

		// action
		String retorno = CupomFiscal.dadosLojaParam(nomeLoja, logradouro, numero, complemento, bairro, municipio,
				estado, cep, telefone, observacao, cnpj, inscricaoEstadual);

		// assertion
		assertEquals(expected, retorno);
	}

	private void verificarCampoObrigatorio(String mensagemEsperada, String nomeLoja, String logradouro, int numero,
			String complemento, String bairro, String municipio, String estado, String cep, String telefone,
			String observacao, String cnpj, String inscricaoEstadual) {
		try {
			CupomFiscal.dadosLojaParam(nomeLoja, logradouro, numero, complemento, bairro, municipio, estado, cep,
					telefone, observacao, cnpj, inscricaoEstadual);
		} catch (RuntimeException e) {
			assertEquals(mensagemEsperada, e.getMessage());
		}
	}

}
