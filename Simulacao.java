import org.knowm.xchart.*;
import java.util.ArrayList;
import java.util.List;

public class Simulacao {
    private AutomatoCelular automato;
    private int iteracoes;

    private List<Double> suscetiveis;
    private List<Double> infectados;
    private List<Double> recuperados;

    public Simulacao(int tamanho, double taxaInfeccao, int tempoRecuperacao, int iteracoes) {
        this.automato = new AutomatoCelular(tamanho, taxaInfeccao, tempoRecuperacao);
        this.iteracoes = iteracoes;
        this.suscetiveis = new ArrayList<>();
        this.infectados = new ArrayList<>();
        this.recuperados = new ArrayList<>();
    }

    public void executar() {
        for (int t = 0; t < iteracoes; t++) {
            int total = automato.getTamanho() * automato.getTamanho();

            suscetiveis.add((double) automato.contarCelulas('S') / total);
            infectados.add((double) automato.contarCelulas('I') / total);
            recuperados.add((double) automato.contarCelulas('R') / total);

            automato.atualizarGrade();
        }
    }

    public void gerarGrafico() {
        this.executar();

        XYChart chart = new XYChartBuilder().width(800).height(600).title("SIR Model Simulation")
                .xAxisTitle("Time Steps").yAxisTitle("Normalized Concentrations").build();
        chart.addSeries("Suscetiveis", suscetiveis);
        chart.addSeries("Infectados", infectados);
        chart.addSeries("Recuperados", recuperados);

        new SwingWrapper<>(chart).displayChart();
    }
}
