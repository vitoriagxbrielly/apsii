
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private List<Aluguel> alugueis = new ArrayList<>();

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionaAluguel(Aluguel aluguel) {
        alugueis.add(aluguel);
    }

    private double calcularValorAluguel(Aluguel aluguel) {
        double valor = 0;
        int dias = aluguel.getDiasAlugada();

        switch (aluguel.getFita().getCodigoDePreco()) {
            case Fita.NORMAL:
                valor = 2;
                if (dias > 2) {
                    valor += (dias - 2) * 1.5;
                }
                break;

            case Fita.LANCAMENTO:
                valor = dias * 3;
                break;

            case Fita.INFANTIL:
                valor = 1.5;
                if (dias > 3) {
                    valor += (dias - 3) * 1.5;
                }
                break;
        }

        return valor;
    }

    private int calcularPontosAluguel(Aluguel aluguel) {
        int pontos = 1;

        if (aluguel.getFita().getCodigoDePreco() == Fita.LANCAMENTO
                && aluguel.getDiasAlugada() > 1) {
            pontos++;
        }

        return pontos;
    }

    public String extrato() {
        double valorTotal = 0;
        int pontosTotais = 0;
        String resultado = "Registro de Alugueis de " + getNome() + "\n";

        for (Aluguel aluguel : alugueis) {
            double valor = calcularValorAluguel(aluguel);
            int pontos = calcularPontosAluguel(aluguel);

            resultado += "\t" + aluguel.getFita().getTitulo()
                    + "\t" + valor + "\n";

            valorTotal += valor;
            pontosTotais += pontos;
        }

        resultado += "Valor total devido: " + valorTotal + "\n";
        resultado += "Você ganhou " + pontosTotais
                + " pontos de alugador frequente";

        return resultado;
    }
}