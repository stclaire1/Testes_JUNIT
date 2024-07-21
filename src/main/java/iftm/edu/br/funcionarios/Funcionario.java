package iftm.edu.br.funcionarios;

public class Funcionario {
    private String nome;
    private int horasTrabalhadas;
    private Double valorHora;
    private static final double salarioMinino = 1320.00;

    public Funcionario() {
    }

    public Funcionario(String nome, int horasTrabalhadas, Double valorHora) {
        this.nome = nome;
        this.horasTrabalhadas = validaHorasTrabalhadas(horasTrabalhadas);
        this.valorHora = validaValorHorasTrabalhadas(valorHora);
        validaPagamento();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = validaHorasTrabalhadas(horasTrabalhadas);
    }

    private int validaHorasTrabalhadas(int horasTrabalhadas) {
        if (horasTrabalhadas > 40) {
            throw new IllegalArgumentException(
                    "O número de horas trabalhadas por funcionário próprio deve ser menor ou igual a 40!");
        } else {
            return horasTrabalhadas;
        }
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = validaValorHorasTrabalhadas(valorHora);
    }

    public double validaValorHorasTrabalhadas(double valorHora) {
        double limiteInferior = 0.04;
        double limiteSuperior = 0.10;
        if ((valorHora < limiteInferior * salarioMinino) || (valorHora > limiteSuperior * salarioMinino)) {
            throw new IllegalArgumentException("O valor da hora deve ser entre 4% e 10% do salário mínimo");
        } else {
            return valorHora;
        }

    }

    public void validaPagamento() {
        if (calcularPagamento() < salarioMinino) {
            throw new IllegalArgumentException(
                    "O pagamento dos funcionários deve ser maior ou igual ao valor do salário mínimo.");
        }
    }

    public Double calcularPagamento() {
        return horasTrabalhadas * valorHora;
    }
}
