# 🦠 Modelo SIR

📊 Simulação do **Modelo Epidemiológico SIR** (*Susceptible, Infected, Recovered*), implementada em Java, com geração de gráficos utilizando a biblioteca **XChart**.
Este projeto foi um desafio da faculdade que permite visualizar a propagação de uma doença em uma população ao longo do tempo, com possibilidade de ajustar parâmetros como taxa de infecção e recuperação.

---

## Sobre o Projeto

🧮 O modelo SIR é amplamente utilizado em epidemiologia para representar a dinâmica de surtos e epidemias.
Este sistema simula a evolução do número de suscetíveis, infectados e recuperados, exibindo resultados gráficos para facilitar a análise.

O projeto foi desenvolvido em Java, utilizando programação orientada a objetos, e faz uso da biblioteca **XChart** para exibição de gráficos interativos.

---

## Estrutura do Projeto

```
modeloSIR/
│
├── lib/                    Dependências externas
│   └── xchart-3.8.8.jar    Biblioteca para geração de gráficos
│
├── AutomatoCelular.java    Lógica do autômato para simulação
├── Celula.java             Representa cada célula/indivíduo da simulação
├── Main.java               Ponto de entrada da aplicação
├── Simulacao.java          Controla os parâmetros e execução da simulação
├── artigo_sir.pdf          Documento explicativo sobre o modelo SIR
└── resume/                 Resumo em relação a cada classe
```

---

## Tecnologias Utilizadas

* **Linguagem:** Java
* **Biblioteca Gráfica:** XChart (v3.8.8)
* **Paradigma:** Programação Orientada a Objetos (POO)

---

## Requisitos

* Java Development Kit (JDK) instalado (versão 8 ou superior recomendada).
* Biblioteca XChart disponível na pasta `lib/`.

---

## Como Rodar o Projeto

### 1. Compilar o Projeto

Abra o terminal na pasta do projeto e execute:

No Windows:

```bash
javac -cp ".;lib/xchart-3.8.8.jar" *.java
```

### 2. Executar o Programa

No Windows:

```bash
java -cp ".;lib/xchart-3.8.8.jar" Main
```

---

## Configurações

Para alterar parâmetros da simulação, abra o arquivo `Main.java` e ajuste as variáveis:

* `int passosSimulacao` — Número de passos/ticks da simulação.
* `double taxaInfeccao` — Taxa de infecção (exemplo: 0.3 para 30%).
* `double taxaRecuperacao` — Taxa de recuperação (exemplo: 0.1 para 10%).
* `int populacaoInicial` — Número inicial de indivíduos na simulação.

Após alterar, compile e execute novamente.

---

## Dependências

* A biblioteca XChart está na pasta `lib/xchart-3.8.8.jar`.
* Caso precise baixar a biblioteca, acesse: [https://knowm.org/open-source/xchart/](https://knowm.org/open-source/xchart/)

---

## Contato

Para dúvidas ou sugestões, entre em contato:
[rodriguesjuliaw23@gmail.com](mailto:rodriguesjuliaw23@gmail.com)

---

## Autores

* 👩‍💻 **Desenvolvimento e Simulação:** Daniele Bonilha (@danibonilha)
* 🧩 **Apoio na lógica e entendimento:** Julia Gomes
* 🤝 **Entendimento do problema:** Camila Bonilha
* 🎤 **Apresentação:** Samara Duarte