### Classe Main  
**Responsabilidade:** Classe principal do projeto, responsável por iniciar a aplicação.

**Código:**
```java
// Classe principal do programa
public class Main {
    // Método main é o ponto de entrada da aplicação em Java
    public static void main(String[] args) {
        // Criação de um objeto da classe Simulacao
        Simulacao simulacao = new Simulacao(200, 1, 15, 100);

        // Chamada de um método da classe Simulacao para gerar um gráfico
        simulacao.gerarGrafico();
    }
}
``` 

### Explicação do método `main`:  
- **Por que `static`?**  
O modificador `static` indica que o método pertence à classe, permitindo sua execução direta pela JVM (Java Virtual Machine - software que executa programas Java, transformando o código compilado (bytecode) em instruções compreensíveis pelo sistema operacional e hardware), sem a necessidade de criar objetos.

- **O que é `void`?**  
Indica que o método não retorna valores. Seu único objetivo é executar ações, como iniciar a aplicação.  

- **Por que usar `String[] args`?**  
Um array de strings que recebe dados da linha de comando. Cada argumento passado ao programa se torna um elemento do array. Por exemplo, ao rodar:
 
  java MeuPrograma arg1 arg2 arg3

  O array args terá: 
    args[0] = "arg1"
    args[1] = "arg2"
    args[2] = "arg3"
  Esses valores podem ser usados no programa.

---

### Diferentes utilizados:  
- **`new`**  
É uma palavra-chave usada para criar objetos. Ao ser chamado, ela aloca memória e chama o construtor da classe para inicializar o objeto.  

Exemplo:  
```java
Simulacao simulacao = new Simulacao(200, 1, 15, 100);
```
Nesse exemplo, `new` cria uma instância da classe `Simulacao`, configurando seus atributos iniciais.  