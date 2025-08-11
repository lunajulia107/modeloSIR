public class Celula {
    private char estado; // 'S', 'I', ou 'R'
    private int tempoInfectado;

    public Celula(char estadoInicial) {
        this.estado = estadoInicial;
        this.tempoInfectado = 0;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public int getTempoInfectado() {
        return tempoInfectado;
    }

    public void incrementarTempoInfectado() {
        this.tempoInfectado++;
    }

    public void resetarTempoInfectado() {
        this.tempoInfectado = 0;
    }
}
