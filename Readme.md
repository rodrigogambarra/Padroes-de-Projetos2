<h1 align="center">SEGUNDO PROJETO que simula operações financeiras de uma loja - desenvolvido com a utilização dos principais padrões de projetos</h1>
<p align="center">Aplicando padrões de projetos do livro *"Gang of Four"*</p>

---

**<p align="center">Sumário:</p>**
<p align="center">
<a href="#sobre">Sobre</a> |
<a href="#funcionalidades-e-descrição-dos-padrões-utilizados">Funcionalidades</a> |
<a href="#tecnologias-utilizadas">Tecnologias</a> |
<a href="#serviços-usados">Serviços usados</a> |
<a href="#padrões-de-projetos-utilizados">Padrões de projetos utilizados</a> |
<a href="#pré-requisitos">Pré-requisitos</a> |
<a href="#links">Links</a> |
<a href="#autor">Autor</a></p>


## Sobre
Essa é uma continuidade do primeiro projeto que foi desenvolvido utilizando os principais padrões de projetos descritos no livro *Gang of Four* que descreve um total de 22 padrões e formas de solucionar diferentes tipos de problemas no desenvolivmento de projetos de software.


## Funcionalidades e descrição dos padrões utilizados

✅ Criar orçamentos contendo uma lista de ítens;

✅ Calcular diferentes impostos que podem ser incididos aos orçamentos; (Para essa funcionalidade foi utilizado o padrão *Strategy* juntamente com o padrão Decorate, possibilitando criar um objeto tipo imposto decorado com outros impostos)

✅ Calcular diferentes descontos para cada tipo de orçamento, dependendo do valor ou do número de ítens; (Para essa funcionalidade foi utilizado o padrão *Chain of Responsibility* Também conhecido como: Corrente de responsabilidade - exemplificado pela Classe CalculadoraDeDescontos)

✅ Criados descontos por meio da abstração de Polimorfismo isolando as regras de negócios em classes filhas e os testes condicionais na classe mãe: Desconto (Implementação do padrão de projetos *Template Method* Também conhecido como: Método padrão)

✅ Gerenciar diferentes estados para cada tipo de orçamento, determinando a transitividade entre os estados; (Para essa funcionalidade foi utilizado o padrão *State* Também conhecido como: Estado)

✅ Criar pedidos contendo nome do cliente, valor do orçamento e a quantidade de ítens.

✅ Simulação da ação enviar pedido por e-mail (Após a criação do pedido)

✅ Simulação da ação cadastrar pedido no banco (Após a criação do pedido)

✅ A interface do sistema simulada pela classe main *TestesPedidos* solicita execução das acões às classes intermediárias: *GeraPedido* e *GeraPedidoHandler* (Implementação do padrão de projeto *Command*)

✅ A classe *GeraPedidoHandler* dispara o método "executar" para as ações serem feitas. (Implementação do padrão de projetos *Observer*)

✅  Possibilidade de registro de orçamentos já finalizados, onde o registro é feito em uma possível Api externa e a comunicação é feita por meio do protocolo http. Para abstrair as configurações da comunicação com a Api da classe de registro, foi utilizado o padrão *Adapter* servindo como um adaptador das classes http com a classe Registro)


## Tecnologias utilizadas
* Java 20

## Serviços usados
* Intellij (Idea)
* GitHub


## Padrões de projetos utilizados


* <b> ADAPTER - Também conhecido como: Adaptador</b>

Foi utilizado o padrão <b>Adapter</b> com a inserção da funcionalidade de Registro de Orçamento, onde um orçamento após "Finalizado" poderá ser registrado em uma Api externa por meio do protocolo Http. Para criação desta funcionalidade foi criada uma interface HttpAdapter onde as diferentes formas de se implementar essa comunição
devem fazer a implementação da interface. A classe RegistroOrçamento não conhece qual sistema será utilizado para enviar o restro à Api exter por meio do protocolo Http, essa classe apenas fará uso do adaptador Http. A classe main "TesteAdapter" é que faz a escolha da implementação de comunicação.

Mais detalhes sobre este padrão: https://refactoring.guru/pt-br/design-patterns/adapter

* <b> STRATEGY - Também conhecido como: Estratégia</b>

Foi utilizado este padrão para separar as regras de negócio do cálculo de impostos ICMS e ISS. Foi criada uma classe para cada imposto, cada um com sua estratégia de cálculo que extende
a classe abstrata "Imposto" e define a sua regra no método "RealizarCalculo". Caso futuramente sejam criados novos impostos com novas regras basta criar outras classes específicas que extende a classe "Imposto".

Mais detalhes sobre este padrão: https://refactoring.guru/pt-br/design-patterns/strategy

* <b> DECORATOR - Também conhecido como: Decorador, Envoltório</b>

Foi utilizado este padrão com a insersão da funcionalidade de associar um imposto com outros impostos. Como uma forma de decorar um objeto tipo imposto com outros objetos imposto e após, atribuir esta junção a um orçamento. Essa implementação evita de ter que criar 
novos impostos que são uma associação de outros impostos, por exemplo: um imposto ICMS/ISS, com o pabrão decorate temos dois impostos que podem ser somados para incidir em um orçamento.

Mais detalhes sobre este padrão: https://refactoring.guru/pt-br/design-patterns/decorator

* <b> COMPOSITE - Também conhecido como: Árvore de objetos, Object tree</b>

Foi utilizado o padrão de projeto Composite para implementar a funcionalidade de um orçamento conter a sua própria lista de itens e também ser composto por todos os itens de um antigo orçamento que foi reprovado. Com essa funcionalidade podemos aproveitar um antigo orçamento para compor
um novo orçamento. Para isso, foi criada uma classe ItemOrçamento com suas informações e uma interface "Orçavel" que foi implementada pela classe "Orçamento" e pela classe "ItemOrcamento", na interface Orcacel foi criado somente o método getValor() o qual será o único item comum
entre a classe "Orcamento" e "ItemOrcamento". O método adicionarItem da classe "Orçamento" recebe como parametro um item "Orçavel", assim ela poderá somar os valores de um outro Orçamento ou um novo Item.

Mais detalhes sobre este padrão: https://refactoring.guru/pt-br/design-patterns/composite

* <b> CHAIN OF RESPONSIBILITY - Também conhecido como: CoR, Corrente de responsabilidade, Corrente de comando, Chain of command</b>

Foi utilizado este padrão na implementação dos descontos, onde cada desconto é aplicado conforme o valor e o número de ítens do orçamento. Com a aplicação do 
padrão "corrente de comando", foi criada uma CalculadoraDeDescontos com o método "Cálcular" que instancia cada classe desconto em uma cadeia de ocorrência, fazendo uso da classe abstrata "Desconto" que contém um atributo próximo do tipo "Desconto".

Mais detalhes sobre este padrão: https://refactoring.guru/pt-br/design-patterns/chain-of-responsibility

* <b> TEMPLATE METHOD - Também conhecido como: Método padrão</b>

O padrão <b>Template</b> foi utilizado com a criação do método padrão: "Calcular" da classe abstrata "Desconto". Este método é padrão para as classes filhas que realizam o desconto, a classe mãe apenas pergunta se deve aplicar e efetuar cálculo e as filhas respontem.

O Template Method é um padrão de projeto comportamental que define o esqueleto de um algoritmo na superclasse mas deixa as subclasses sobrescreverem etapas específicas do algoritmo sem modificar sua estrutura.

Mais detalhes sobre este padrão: https://refactoring.guru/design-patterns/template-method

* <b> STATE - Também conhecido como: Estado</b>

Foi utilizado este padrão com a definição dos estados que cada orçamento pode assumir. Atribuindo condições de transitividade entre os estados. Exemplo: o estado <b>Aprovado</b> não pode voltar para o estado <b>Em Análise</b>, e o estado <b>Reprovado</b> não pode ir para o estado <b>Aprovado</b>. 

Mais detalhes sobre este padrão: https://refactoring.guru/design-patterns/state

* <b> COMMAND - Também conhecido como: Comando, Ação, Action, Transação, Transaction</b>

Foi utilizado o padrão <b>Command</b> para disparar as ações relacionadas aos pedidos criados, ou seja, sempre que um pedido é criado há sempre uma sequencia de ações a serem feitas, como *CriarPedidoNoBanco* e *EnviarPedidoPorEmail*, para não executar essas ações separadamente após a criação de um pedido, 
foram criadas as classes GeraPedido e GeraPedidoHandler que farão a distribuição das ações a serem realizadas.

Mais detalhes sobre este padrão: https://refactoring.guru/pt-br/design-patterns/command

* <b> OBSERVER - Também conhecido como: Observador, Assinante do evento, Event-Subscriber, Escutador, Listener</b>

Foi utilizado o padrão <b>Observer</b> para que cada ação seja executada com a criação do *GeraPedidoHandler* e a execução do seu método *Executar*. Cada ação passada pela lista de ações pelo construtor de *GeraPEdidoHandler* será executada com o comando *Executar*.

Mais detalhes sobre este padrão: https://refactoring.guru/pt-br/design-patterns/observer

* <b> FACADE - Também conhecido como: Fachada</b>

Foi utilizado o padrão Facade com a disponibilização do método "Executar" da classe EnviarPedidoHandler. Esté método simples serve como fachada para toda a implementação das regras de negócio das ações executadas após gerar pedido.

Mais detalhes sobre este padrão: https://refactoring.guru/pt-br/design-patterns/facade


* <b> PROXY - Também conhecido como: Propósito</b>

Foi utilizado o padrão Proxy com a implementação da classe OrçamentoProxy, que intercepta o método "getValor()" da classe Orcamento. O método "getValor()" da classe Orcamento simula uma requisição externa a uma Api muito demorada e custosa. O padrão Proxy neste caso irá trazer maior desempenho ao sistema verificando se o atributo valor já foi recuperado pela Api externa,
caso já tenha sido recuperado ele retornará o valor instantaneamente a quem solicitou, sem fazer a requisição novamente à Api externa. Ou seja, na primeira requisição o atributo valor será nulo, portanto será feita a requisição à Api externa, já nas próximas chamadas do método "getValor()" da classe OrcamentoProxy, ele irá retornar o valor instantaneamente.

Mais detalhes sobre este padrão: https://refactoring.guru/pt-br/design-patterns/proxy

## Pré-requisitos
Java 20

## Links
* Repositório: https://github.com/rodrigogambarra/Padroes-de-Projetos


## Autor
✨ Feito por Rodrigo Gambarra!!

* rodrigo@gambarra.com.br
* <a href="linkedin.com/in/rodrigo-gambarra-2a195b151" target=”_blank”>LinkedIn</a>
* <a href="https://github.com/rodrigogambarra/OrcamentosApp" target=”_blank”>GitHub</a>
