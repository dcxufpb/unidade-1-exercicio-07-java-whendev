package com.example.project;

public class CupomFiscal {

	public static Boolean isNullOrEmpty(String s) {
		return s == null || s.isEmpty();
	}

	public static String dadosLojaParam( String NOME_LOJA,String LOGRADOURO,
										int NUMERO,String COMPLEMENTO,String BAIRRO, String MUNICIPIO,
										 String ESTADO,String CEP,String TELEFONE,String OBSERVACAO,String CNPJ,
										 String INSCRICAO_ESTADUAL) throws RuntimeException {


		if (isNullOrEmpty(NOME_LOJA)){
			throw new RuntimeException("O campo nome da loja é obrigatório");
		}

		if (isNullOrEmpty(LOGRADOURO)){
			throw new RuntimeException("O campo logradouro do endereço é obrigatório");
		}

		if (isNullOrEmpty(MUNICIPIO)){
			throw new RuntimeException("O campo município do endereço é obrigatório");
		}

		if (isNullOrEmpty(ESTADO)){
			throw new RuntimeException("O campo estado do endereço é obrigatório");
		}

		if (isNullOrEmpty(CNPJ)){
			throw new RuntimeException("O campo CNPJ da loja é obrigatório");
		}

		if (isNullOrEmpty(INSCRICAO_ESTADUAL)) {
			throw new RuntimeException("O campo inscrição estadual da loja é obrigatório");
		}

		String _COMPLEMENTO = "";
		if (!COMPLEMENTO.equals("")){
			_COMPLEMENTO = " " + COMPLEMENTO;
		}

		String _BAIRRO = "";
		if (!BAIRRO.equals("")) {
			_BAIRRO = BAIRRO + " - ";
		}

		String _CEP = "";
		String _TELEFONE = "";

		if (!isNullOrEmpty(CEP)) {
			_CEP = "CEP:" + CEP;
			if (!TELEFONE.equals("")){
				_TELEFONE = " Tel " + TELEFONE;
			}
		} else {
			_CEP = "";
			if (!TELEFONE.equals("")){
				_TELEFONE = "Tel " + TELEFONE;
			}
		}

		String _OBSERVACAO = "";
		if (!OBSERVACAO.equals("")){
			_OBSERVACAO = OBSERVACAO;
		}

		String _texto = "";
		_texto = String.format("%s\r\n",NOME_LOJA);
		if (NUMERO == 0){
			_texto += String.format("%s, %s%s\r\n",LOGRADOURO,"s/n",_COMPLEMENTO);
		} else {
			_texto += String.format("%s, %d%s\r\n",LOGRADOURO,NUMERO,_COMPLEMENTO);
		}
		_texto += String.format("%s%s - %s\r\n",_BAIRRO,MUNICIPIO,ESTADO);
		_texto += String.format("%s%s\r\n",_CEP,_TELEFONE);
		_texto += String.format("%s\r\n",_OBSERVACAO);
		_texto += String.format("CNPJ: %s\r\n",CNPJ);
		_texto += String.format("IE: %s\r\n",INSCRICAO_ESTADUAL);
		return _texto;
	}
}
