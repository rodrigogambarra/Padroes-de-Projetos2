package br.loja;

import java.math.BigDecimal;

import br.loja.http.ApacheHttpAdapter;
import br.loja.orcamento.ItemOrcamento;
import br.loja.orcamento.Orcamento;
import br.loja.orcamento.RegistroOrcamento;

public class TestesAdapter {

	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento();
		orcamento.adicionarItem(new ItemOrcamento(BigDecimal.TEN));
		orcamento.aprovar();
		orcamento.finalizar();

		RegistroOrcamento registro = new RegistroOrcamento(new ApacheHttpAdapter());
		registro.registrar(orcamento);
	}

}
