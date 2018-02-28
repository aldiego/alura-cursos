package br.com.alura;

import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;

import br.com.alura.documento.ValidacaoDocumento;
import br.com.caelum.stella.inwords.FormatoDeReal;
import br.com.caelum.stella.inwords.NumericToWordsConverter;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public class Desafio {

	public static void main(String[] args) {
		String cpf = "51720155232";
		try {
			ValidacaoDocumento.validarDocumentos(new CPFValidator(), cpf);
			MonetaryAmount valor = Money.of(900, Monetary.getCurrency("BRL"));
			NumericToWordsConverter conversor = new NumericToWordsConverter(new FormatoDeReal());

			String valorPorExtenso = conversor.toWords(valor.getNumber().doubleValue());

			System.out.println("HÁ UMA COBRANÇA DO VALOR DE " + valorPorExtenso + " PARA ESSE CPF");
		} catch (InvalidStateException e) {
			System.out.println("CPF INVÁLIDO, FAVOR ATUALIZE SUAS INFORMAÇÔES: " + e);
		}
	}
}
