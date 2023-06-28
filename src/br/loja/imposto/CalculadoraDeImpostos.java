package br.loja.imposto;

import java.math.BigDecimal;

import br.loja.orcamento.Orcamento;

public class CalculadoraDeImpostos {

	public BigDecimal calcular(Orcamento orcamento, Imposto imposto) {
		return imposto.realizarCalculoEspecifico(orcamento);
	}

}
