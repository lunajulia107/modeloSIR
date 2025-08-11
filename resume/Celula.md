## Classe Célula 
**Responsabilidade:** Modelar o estado (`S`, `I`, ou `R`) e o tempo de infecção de uma célula. 

**Código:**
```java
public class Celula {
    // Atributo privado que representa o estado da célula ('S' = saudável, 'I' = infectada, 'R' = recuperada)
    private char estado;
    
    // Atributo privado que representa o tempo de infecção da célula
    private int tempoInfectado;
    
    // Construtor que inicializa a célula com um estado inicial e o tempo de infecção como 0
    public Celula(char estadoInicial) {
        this.estado = estadoInicial;  // Atribui o estado inicial à variável 'estado'
        this.tempoInfectado = 0;  // Inicializa o tempo de infecção como 0
    }

    // Método público para obter o estado atual da célula
    public char getEstado() {
        return estado;  // Retorna o valor do estado da célula
    }

    // Método público para alterar o estado da célula
    public void setEstado(char estado) {
        this.estado = estado;  // Atribui o novo estado à variável 'estado'
    }

    // Método público para obter o tempo de infecção atual da célula
    public int getTempoInfectado() {
        return tempoInfectado;  // Retorna o valor do tempo de infecção
    }

    // Método público para incrementar o tempo de infecção em 1
    public void incrementarTempoInfectado() {
        this.tempoInfectado++;  // Aumenta o valor de 'tempoInfectado' em 1
    }

    // Método público para resetar o tempo de infecção para 0
    public void resetarTempoInfectado() {
        this.tempoInfectado = 0;  // Zera o valor de 'tempoInfectado'
    }
}
``` 

## Conceitos relacionados as aulas:
### Tipos e Variáveis Utilizadas
- Primitivas: `char` (armazena um único caractere) e `int` (para números inteiros). 

### Java Fortemente Tipado
Exige que todas as variáveis e métodos declarem seus tipos, como `int` para `getTempoInfectado`.     

### Encapsulamento 
- Protege os atributos `estado` e `tempoInfectado`, permitindo acesso e modificações apenas por métodos controlados nesta classe.  

### Modificadores de Acesso 
- `private`: Restringe o acesso de `estado` e `tempoInfectado` a métodos dentro da classe.  
- `public`: Permite o acesso externo aos métodos como `getEstado()` e `setEstado()`.  

### Métodos  
- **Comportamentos encapsulados:** Métodos como `incrementarTempoInfectado` incrementam `tempoInfectado` de forma controlada.  

---

### Diferentes Utilizados: `this` e `++`**  
- `this`* Refere-se ao próprio objeto da classe para evitar ambiguidade com variáveis locais.  
  - Exemplo: `this.estado = estadoInicial`.  
- `++`: Incrementa o valor de `tempoInfectado` em 1, equivalente a `tempoInfectado = tempoInfectado + 1`.  


