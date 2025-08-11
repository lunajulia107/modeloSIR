### Classe Simulação  
**Responsabilidade:** realiza uma simulação baseada no modelo SIR utilizando um autômato celular. 
A cada iteração, a simulação registra o número de células em cada estado e, ao final, gera um gráfico 
mostrando a evolução dos estados ao longo do tempo.
  
*Código:*
```java
import org.knowm.xchart.*;
import java.util.ArrayList;
import java.util.List;

public class Simulacao {
    // Atributos que armazenam a referência ao autômato celular e os dados da simulação
    private AutomatoCelular automato;
    private int iteracoes;

    // Listas para armazenar as proporções de células Suscetíveis, Infectados e Recuperados
    private List<Double> suscetiveis;
    private List<Double> infectados;
    private List<Double> recuperados;

    // Construtor da classe, inicializa o autômato e as listas para armazenar os dados
    public Simulacao(int tamanho, double taxaInfeccao, int tempoRecuperacao, int iteracoes) {
        // Inicializa o autômato com o tamanho da grade, taxa de infecção e tempo de recuperação
        this.automato = new AutomatoCelular(tamanho, taxaInfeccao, tempoRecuperacao);
        this.iteracoes = iteracoes;

        // Inicializa as listas para armazenar as proporções de células
        this.suscetiveis = new ArrayList<>();
        this.infectados = new ArrayList<>();
        this.recuperados = new ArrayList<>();
    }

    // Método que executa a simulação por um número determinado de iterações
    public void executar() {
        // Loop para executar a simulação por 'iteracoes' passos
        for (int t = 0; t < iteracoes; t++) {
            // Calcula o total de células na grade
            int total = automato.getTamanho() * automato.getTamanho();

            // Armazena a proporção de células Suscetíveis, Infectados e Recuperados em relação ao total
            suscetiveis.add((double) automato.contarCelulas('S') / total);
            infectados.add((double) automato.contarCelulas('I') / total);
            recuperados.add((double) automato.contarCelulas('R') / total);

            // Atualiza o estado da grade (aplica as regras do autômato)
            automato.atualizarGrade();
        }
    }

    // Método para gerar o gráfico da simulação
    public void gerarGrafico() {
        // Executa a simulação para coletar os dados necessários
        this.executar();

        // Cria o gráfico XYChart usando a biblioteca XChart
        XYChart chart = new XYChartBuilder().width(800).height(600).title("SIR Model Simulation")
                .xAxisTitle("Time Steps").yAxisTitle("Normalized Concentrations").build();

        // Adiciona as séries de dados ao gráfico (Suscetíveis, Infectados, Recuperados)
        chart.addSeries("Suscetiveis", suscetiveis);
        chart.addSeries("Infectados", infectados);
        chart.addSeries("Recuperados", recuperados);

        // Exibe o gráfico em uma janela utilizando Swing
        new SwingWrapper<>(chart).displayChart();
    }
}  
``` 

### Imports  
**Padrão de Nomenclatura**:  
- Para bibliotecas externas, utiliza-se o padrão `br.com.nomedaempresa.nomedoprojeto.subpacote`. 
Exemplo: `import org.knowm.xchart.*;`.  
- Para bibliotecas padrão do Java, não é necessário seguir essa nomenclatura.  
Exemplo:
```java  
import java.util.ArrayList;  
import java.util.List;  
```  
util: para trabalhar com coleções, entrada de dados (Scanner) e componentes de data e hora.

### Modificadores de Acesso  
- **`private`**: Restringe o acesso aos atributos, garantindo controle interno.  
- **`public`**: Permite acesso externo apenas aos métodos construtor, `executar` e `gerarGrafico`. 

### Uso de ArrayList e List  
Recipientes para armazenar múltiplos valores de um mesmo tipo, com a vantagem de terem tamanho dinâmico, diferentemente de arrays tradicionais cujo comprimento é fixo após a criação.

Exemplo: 
```java  
private List<Double> suscetiveis;  
private List<Double> infectados;  
private List<Double> recuperados;  
``` 

### O operador `new`  
Nova instância de uma classe, gerando um objeto baseado em seu modelo (Simulação).
```java  
public Simulacao(int tamanho, double taxaInfeccao, int tempoRecuperacao, int iteracoes) {
    // Inicializa o autômato com o tamanho da grade, taxa de infecção e tempo de recuperação
    this.automato = new AutomatoCelular(tamanho, taxaInfeccao, tempoRecuperacao);
    this.iteracoes = iteracoes;

    // Inicializa as listas para armazenar as proporções de células
    this.suscetiveis = new ArrayList<>();
    this.infectados = new ArrayList<>();
    this.recuperados = new ArrayList<>();
}
```  
### Estrutura de Repetição `for` e Cálculo da Proporção (método executar)
- Executar a simulação do autômato celular para um número de iterações especificado.
- Em cada iteração, calcula e armazena as proporções de células em cada estado (Suscetíveis, Infectados, Recuperados).
- Atualiza a grade do autômato aplicando as regras de transição de estado.

SwingWrapper: É uma classe da biblioteca XChart que usa o Swing para exibir gráficos em uma janela. Ela permite integrar o gráfico criado com XChart em uma interface gráfica Java.

### Diferentes utilizados: 
- **List**: Estrutura de dados que armazena uma coleção de elementos, permitindo acesso e manipulação dinâmicos.  
- **new**: Operador usado para criar novas instâncias de objetos na memória.  
- **this**: Referência ao objeto atual da classe, usado para acessar seus atributos e métodos.  
- **add**: Método utilizado para adicionar elementos a uma coleção, como listas.
- **new SwingWrapper<>(chart).displayChart();**
