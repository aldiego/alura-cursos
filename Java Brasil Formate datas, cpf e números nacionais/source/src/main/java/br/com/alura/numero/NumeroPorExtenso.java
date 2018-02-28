package br.com.alura.numero;

import java.math.BigDecimal;

import br.com.caelum.stella.inwords.FormatoDeReal;
import br.com.caelum.stella.inwords.NumericToWordsConverter;

public class NumeroPorExtenso {
	public static void main(String[] args) {
		NumericToWordsConverter coversor = new NumericToWordsConverter(new FormatoDeReal());
		BigDecimal valor = new BigDecimal("999999.99");
		String valorPorExtenso = coversor.toWords(valor.doubleValue());
		System.out.println(valorPorExtenso);
	}
}
