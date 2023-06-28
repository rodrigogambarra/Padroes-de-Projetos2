package br.loja.orcamento;

import java.math.BigDecimal;

public class OrcamentoProxy extends Orcamento {

	private BigDecimal valor;
	private Orcamento orcamento;

	public OrcamentoProxy(Orcamento orcamento) {
		this.orcamento = orcamento;
	}
	//Implementa a funcionalidade de retorno imediato do atributo valor quando este não for nulo,
	// caso seja nulo então faz a chamada "custosa" do método "getValor()" da classe Orcamento
	public BigDecimal getValor() {
		if (this.valor == null) {
			this.valor = orcamento.getValor();
		}
		return this.valor;
	}

}
