package br.com.alura.dinheiro;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.convert.ExchangeRateType;

public class Cotacao {
	// um produto que custou USD 90,00 mas temos que pagar BRL 30,00 de imposto
	public static void main(String[] args) {
		
		// Primeiro vamos criar as moedas e os valores
		CurrencyUnit dolar = Monetary.getCurrency("USD");
		CurrencyUnit real = Monetary.getCurrency("BRL");

		MonetaryAmount valorProdutoDolar = FastMoney.of(90, dolar);
		System.out.println("Valor produto em dolar: " + valorProdutoDolar);

		MonetaryAmount valorImpostoReal = FastMoney.of(30, real);
		System.out.println("Valor imposto em real: " + valorImpostoReal);

		// Agora vamos usar o provider para pegar a cotação
		ExchangeRateProvider provider = MonetaryConversions.getExchangeRateProvider(ExchangeRateType.ECB);

		// Vamos pegar a conversão atual(do dia)
		CurrencyConversion conversaoAtual = provider.getCurrencyConversion(dolar);
		System.out.println("Conversao atual: " + conversaoAtual);

		// Agora vamos transformar o valor do imposto em Real para dólar
		MonetaryAmount valorImpostoDolar = conversaoAtual.apply(valorImpostoReal);
		System.out.println("Valor imposto em dolar: " + valorImpostoDolar);

		// Agora que o valor do imposto está em dólar, podemos somar com o valor inicial
		// do produto
		MonetaryAmount valorFinalProdutoDolar = valorProdutoDolar.add(valorImpostoDolar);
		System.out.println("Valor final: " + valorFinalProdutoDolar);
	}
}
