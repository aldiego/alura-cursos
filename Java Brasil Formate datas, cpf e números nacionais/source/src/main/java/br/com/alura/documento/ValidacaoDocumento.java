package br.com.alura.documento;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.TituloEleitoralValidator;
import br.com.caelum.stella.validation.Validator;

public class ValidacaoDocumento {
	public static void main(String[] args) {
		validaCPF();

		validaCNPJ();

		validaTituloEleitor();
	}

	private static void validaTituloEleitor() {
		String tituloEleitor = "417453530116";
		try {
			validarDocumentos(new TituloEleitoralValidator(), tituloEleitor);
			System.out.println("TÍTULO VÁLIDO");

		} catch (InvalidStateException e) {
			System.out.println("TÍTULO INVÁLIDO :" + e);
		}
	}

	private static void validaCNPJ() {
		String cnpj = "82588641000173";
		try {
			validarDocumentos(new CNPJValidator(), cnpj);
			System.out.println("CNPJ VÁLIDO");

		} catch (InvalidStateException e) {
			System.out.println("CNPJ INVÁLIDO :" + e);
		}
	}

	private static void validaCPF() {
		String cpf = "86288366757";
		try {
			validarDocumentos(new CPFValidator(), cpf);
			System.out.println("CPF VÁLIDO");

		} catch (InvalidStateException e) {
			System.out.println("CPF INVÁLIDO : " + e);
		}
	}

	public static void validarDocumentos(Validator<String> validador, String documento) {
		validador.assertValid(documento);
	}
}
