**Utilizando autômato celular simule um modelo SIR, cujo o reticulado tem tamanho de 200 (matriz 200x200), por 100 iterações. O resultado deve ser um gráfico de linhas igual a figura 3 do artigo:**
 
*As informações que vocês precisam que estão no artigos*
	Estados:
        ◦	SUSCETIVEL: Possui transições para INFECTADO e RECUPERADO.
        ◦	INFECTADO: Possui transições para RECUPERADO e SUSCETIVEL.
        ◦	RECUPERADO: Possui uma transição de retorno para SUSCETIVEL.

	•	Regras de Transição:
        ◦	SUSCETIVEL → INFECTADO:
            ▪	Função exponencial decrescente: 1 - e^(-k * v). k = 1 no artigo e v a quantidade de vizinhos infectados.
        ◦	SUSCETIVEL → RECUPERADO: Probabilidade constante 0.10.
        ◦	INFECTADO → RECUPERADO: Probabilidade constante 0.60.
        ◦	INFECTADO→ SUSCETIVEL: Probabilidade constante 0.30.
        ◦	RECUPERADO → SUSCETIVEL: Probabilidade constante 0.10.

## Geral
Camel Case: Letras maiúsculas para os primeiros caracteres em palavras composta 

**Conceitos básicos:**
- **Atributo:** Variáveis que armazenam informações sobre o estado do objeto.  
- **Método:** Funções que definem o comportamento ou realizam ações relacionadas aos atributos.  
- **Construtor:** Método especial para inicializar objetos, configurando seus atributos iniciais.

## O que é o AutomatoCelular?
Ele pode ser considerado um auxiliar para simular **sistemas que envolvam a complexidade das células**, 
como, por exemplo, o modelo SIR, onde tentamos explicar a propagação de doenças.

Em Java, é possível implementar um autômato celular usando apenas **recursos básicos**, 
como matrizes para representar a grade e regras para atualizar os estados das células.

### Diferentes Utilizados: 
- `this`: Refere-se ao próprio objeto da classe para evitar ambiguidade com variáveis locais.  
  - Exemplo: `this.estado = estadoInicial`.  
- `++`: Incrementa o valor de `tempoInfectado` em 1, equivalente a `tempoInfectado = tempoInfectado + 1`. 
- `void`*: Indica que o método *não retorna valores*. Seu único objetivo é executar ações, como iniciar a aplicação.   
- `new`: É uma palavra-chave usada para criar objetos. Ao ser chamado, ela aloca memória e *chama o construtor* da classe para inicializar o objeto.  
- `List`: Estrutura de dados que armazena uma coleção de elementos, permitindo acesso e manipulação dinâmicos. 

