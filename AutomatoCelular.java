import java.util.Random;

public class AutomatoCelular {
    private Celula[][] grade;
    private int tamanho;
    private double taxaInfeccao;
    private int tempoRecuperacao;

    public AutomatoCelular(int tamanho, double taxaInfeccao, int tempoRecuperacao) {
        this.tamanho = tamanho;
        this.taxaInfeccao = taxaInfeccao;
        this.tempoRecuperacao = tempoRecuperacao;
        this.grade = new Celula[tamanho][tamanho];
        inicializarGrade();
    }

    private void inicializarGrade() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                grade[i][j] = new Celula('S');
            }
        }
        grade[tamanho / 2][tamanho / 2].setEstado('I');
    }

    public void atualizarGrade() {
        Celula[][] novaGrade = new Celula[tamanho][tamanho];
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                Celula celulaAtual = grade[i][j];
                char novoEstado = aplicarRegras(i, j, celulaAtual);
                novaGrade[i][j] = new Celula(novoEstado);
                if (novoEstado == 'I') {
                    novaGrade[i][j].incrementarTempoInfectado();
                }
            }
        }
        grade = novaGrade;

    }

    private char aplicarRegras(int x, int y, Celula celula) {
        Random random = new Random();

        if (celula.getEstado() == 'S') {
            // Pv = 3% - Usar esse ou 0.10 ?
            if (random.nextDouble() < 0.03) {
                return 'R';
            }
            // Ps = 1% - Faltando nos estados do teams ?
            if (random.nextDouble() < 0.01) {
                return 'I';
            }

            // Pi
            int k = 1;
            int vizinhosInfectados = contarVizinhosInfectados(x, y);
            double probabilidadeInfeccao = 1 - Math.pow(Math.E, (-k * vizinhosInfectados));

            if (random.nextDouble() < probabilidadeInfeccao) {
                return 'I';
            }

            return 'S';
        }
        if (celula.getEstado() == 'I') { 
            // Pc = 60%
            if (random.nextDouble() < 0.60) {
                return 'R';
            }
            // Pd = 30%
            if (random.nextDouble() < 0.30) {
                return 'S';
            }

            return 'I';
        }
        if (celula.getEstado() == 'R') {
            // Po = 10%
            if (random.nextDouble() < 0.10) {
                return 'S';
            }
            return 'R';
        }
        return celula.getEstado();
    }

    private int contarVizinhosInfectados(int x, int y) {
        int infectados = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Ignora a própria célula
                if (i == 0 && j == 0)
                    continue; // Pula para a próxima iteração
                int vizinhoX = x + i;
                int vizinhoY = y + j;
                // Verifica se o vizinho está dentro dos limites da grade
                if (vizinhoX >= 0 && vizinhoX < tamanho && vizinhoY >= 0 && vizinhoY < tamanho) {
                    if (grade[vizinhoX][vizinhoY].getEstado() == 'I') {
                        infectados++;
                    }
                }
            }
        }

        return infectados;
    }

    public int contarCelulas(char estado) {
        int qtd = 0;
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (grade[i][j].getEstado() == estado) {
                    qtd++;
                }
            }
        }
        return qtd;
    }

    public int getTamanho() {
        return tamanho;
    }
}