package br.com.alura.documento;

import br.com.caelum.stella.format.CNPJFormatter;
import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.format.Formatter;
import br.com.caelum.stella.format.TituloEleitoralFormatter;

public class FormatadorDocumento {
	public static void main(String[] args) {
		desformataCPF();

		desformataCNPJ();

		formataTitulo();
	}

	private static void formataTitulo() {
		String tituloEleitor = "417453530116";
		System.out.println(tituloEleitor);
		System.out.println(formataDocumentos(new TituloEleitoralFormatter(), tituloEleitor));
	}

	private static void desformataCNPJ() {
		String cnpj = "98.610.832/0001-24";
		System.out.println(cnpj);
		System.out.println(desformataDocumentos(new CNPJFormatter(), cnpj));
	}

	private static void desformataCPF() {
		String cpf = "862.883.667-57";
		System.out.println(cpf);
		System.out.println(desformataDocumentos(new CPFFormatter(), cpf));
	}

	private static String formataDocumentos(Formatter formatter, String documento) {
		return formatter.format(documento);
	}

	private static String desformataDocumentos(Formatter formatter, String documento) {
		return formatter.unformat(documento);
	}
}
