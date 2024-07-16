package iftm.edu.br.funcionarios;

public class Funcionario {
    private String nome;
    private int horasTrabalhadas;
    private Double valorHora;

    public Funcionario() {}

    public Funcionario(String nome, int horasTrabalhadas, Double valorHora) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
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

    // public void setHorasTrabalhadas(int horasTrabalhadas) {
    //     this.horasTrabalhadas = validaHorasTrabalhadas(horasTrabalhadas);
    // }

    // private int validaHorasTrabalhadas(int horasTrabalhadas) {
    //     if(horasTrabalhadas > 40) {
    //         throw new IllegalArgumentException("O número de horas trabalhadas por funcionário próprio deve ser menor ou igual a 40!");
    //     }else {
    //         return horasTrabalhadas;
    //     }
    // }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    public Double calcularPagamento() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularPagamento'");
    }
}
