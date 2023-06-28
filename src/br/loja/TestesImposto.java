package br.loja;

import java.math.BigDecimal;

import br.loja.imposto.ICMS;
import br.loja.imposto.ISS;
import br.loja.imposto.Imposto;
import br.loja.orcamento.ItemOrcamento;
import br.loja.orcamento.Orcamento;

public class TestesImposto {

	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("200")));

		Imposto imposto = new ICMS(new ISS(null));
		System.out.println(imposto.calcular(orcamento));
	}

}
