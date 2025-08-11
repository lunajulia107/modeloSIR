
### Imports  
**Ordem do Código**:  
Essa classe segue boas práticas relacionadas à organização do código:  
(pacote, imports e classe).

Pacote interno do Java utilizado para gerar números aleatórios:
```java  
import java.util.Random;
```  

### Encapsulamento  
Os atributos `grade`, `tamanho`, `taxaInfeccao`, e `tempoRecuperacao`, e os métodos 
`inicializarGrade`, `aplicarRegras` e `contarVizinhosInfectados` são protegidos por meio 
do encapsulamento, permitindo acesso e modificação apenas nesta classe.  

### Relacionando aos Conceitos
Modificador PUBLIC (permite acesso externo) e usa CAMELCASE
```java  
public class AutomatoCelular {}
```  

Atributos com modificador PRIVATE (restringe acesso)
```java  
private Celula[linhas][colunas] grade; // matriz bidimensional nomeada como grade (recebe os estados da célula)
private int tamanho; // atributo para armazenar o tamanho da matriz
private double (decimal) taxaInfeccao; // atributo não utilizado ao longo do cod
private int tempoRecuperacao;
```  

Construtor com modificador PUBLIC (permite acesso externo utilizado em simulação)
```java 
public AutomatoCelular(int tamanho, double taxaInfeccao, int tempoRecuperacao) { // parâmetros a serem utilizados de tipo   primitivo
    this.tamanho = tamanho; // this é usado para se referir aos atributos da instância do objeto (automatoCelular)
    this.taxaInfeccao = taxaInfeccao;
    this.tempoRecuperacao = tempoRecuperacao;
    this.grade = new Celula[tamanho][tamanho]; // cria a matriz já predefinida a cima
    inicializarGrade(); // chama o método 
}
```

Método com modificador PRIVATE (acesso apenas na classe AutomatoCelular)
```java 
private void inicializarGrade() { // void indica que não retorna valor algum, mas executa a ação
    // inicializa a matriz bidimensional chamada 'grade', onde cada célula armazenará um objeto da classe 'Celula'
    
    // estrutura de repetição 'for' para percorrer as linhas e colunas da matriz
    for (int i = 0; i < tamanho; i++) { 
        for (int j = 0; j < tamanho; j++) {
            // cada célula da matriz é inicializada como um objeto da classe 'Celula' com o estado 'S' (Suscetível)
            grade[i][j] = new Celula('S');  
        }
    }
    
    // após inicializar a matriz, alteramos o estado da célula no centro para 'I' (Infectado)
    grade[tamanho / 2][tamanho / 2].setEstado('I');  
}

```

Método com modificador PUBLIC (permite acesso externo)
```java 
public void atualizarGrade() {  // void indica que não retorna valor algum, mas executa a ação
    Celula[][] novaGrade = new Celula[tamanho][tamanho]; // cria uma nova matriz de células para armazenar os novos estados

    // percorre as linhas da matriz
    for (int i = 0; i < tamanho; i++) { 
        // percorre as colunas da matriz
        for (int j = 0; j < tamanho; j++) { 
            Celula celulaAtual = grade[i][j]; // armazena a célula da posição [i][j] da grade original

            // aplica as regras de transição de estado da célula
            char novoEstado = aplicarRegras(i, j, celulaAtual); 
            novaGrade[i][j] = new Celula(novoEstado); // cria uma nova célula com o novo estado obtido
 
            if (novoEstado == 'I') {
                novaGrade[i][j].incrementarTempoInfectado(); // simula a passagem de tempo
            }
        }
    }
    grade = novaGrade;  // atualiza a grade original para a nova matriz com os estados atualizados
}

```

Método com modificador PRIVATE (restringe o acesso)  
```java 
// método para aplicar as regras do modelo SIR
private char aplicarRegras(int x, int y, Celula celula) { // parâmetros: x (linha), y (coluna), celula (estado atual da célula)

    // instancia o recurso de números aleatórios
    Random random = new Random();

    // verifica se a célula está no estado 'S' (Suscetível)
    if (celula.getEstado() == 'S') {
        // Pv = 3% de chance de transição direta para 'R' (Recuperado)
        if (random.nextDouble() < 0.03) {
            return 'R';
        }

        // Ps = 1% de chance de transição direta para 'I' (Infectado)
        if (random.nextDouble() < 0.01) {
            return 'I';
        }

        // Pi: calcula a probabilidade de infecção com base nos vizinhos infectados
        int k = 1; // constante para ajustar o impacto dos vizinhos infectados
        int vizinhosInfectados = contarVizinhosInfectados(x, y); // obtém o número de vizinhos infectados
        double probabilidadeInfeccao = 1 - Math.pow(Math.E, (-k * vizinhosInfectados)); // fórmula da probabilidade

        // verifica se ocorre infecção com base na probabilidade calculada
        if (random.nextDouble() < probabilidadeInfeccao) {
            return 'I';
        }

        // caso nenhuma condição seja atendida, permanece no estado 'S'
        return 'S';
    }

    // verifica se a célula está no estado 'I' (Infectado)
    if (celula.getEstado() == 'I') {
        // Pc = 60% de chance de transição para 'R' (Recuperado)
        if (random.nextDouble() < 0.60) {
            return 'R';
        }

        // Pd = 30% de chance de transição para 'S' (Suscetível)
        if (random.nextDouble() < 0.30) {
            return 'S';
        }

        // caso nenhuma condição seja atendida, permanece no estado 'I'
        return 'I';
    }

    // verifica se a célula está no estado 'R' (Recuperado)
    if (celula.getEstado() == 'R') {
        // Po = 10% de chance de transição para 'S' (Suscetível), indicando perda de imunidade
        if (random.nextDouble() < 0.10) {
            return 'S';
        }

        // caso nenhuma condição seja atendida, permanece no estado 'R'
        return 'R';
    }

    // caso o estado da célula não seja reconhecido, retorna o estado atual
    return celula.getEstado();
}
```

### Importância do `random.nextDouble()`
- Número aleatório do tipo `double` no intervalo [0.0, 1.0). 
- Essencial para determinar se as transições de estado ocorrem de acordo com as probabilidades especificadas. 
- Aleatoriedade para simular o comportamento da propagação da doença na população.

Método com modificador PUBLIC (acesso público - acessado pela classe Simulação)  
```java 
// utilizado para contar células em um estado específico (S, I, R)
public int contarCelulas(char estado) { 
    int qtd = 0; // inicializa a variável de contagem

    // percorre todas as linhas da matriz
    for (int i = 0; i < tamanho; i++) {
        // percorre todas as colunas da matriz
        for (int j = 0; j < tamanho; j++) {
            // verifica se o estado da célula na posição [i][j] é igual ao estado fornecido
            if (grade[i][j].getEstado() == estado) {
                qtd++; // incrementa a contagem se o estado for igual
            }
        }
    }
    return qtd; // retorna a quantidade de células no estado especificado
}
```

Método com modificador PUBLIC (permite acesso externo) para retorna o valor do 
atributo "tamanho"  
```java 
public int getTamanho() { // ret
    return tamanho; // retorna um valor inteiro
}
```