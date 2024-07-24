package iftm.edu.br.funcionarios;

public class FuncionarioTercerizado extends Funcionario{
    private Double despesasAdicionais;
    private static final double salarioMinino = 1320.00;

    public FuncionarioTercerizado() {

    }

    public FuncionarioTercerizado(String nome, int horasTrabalhadas, Double valorHora, Double despesasAdicionais) {
        super(nome, horasTrabalhadas, valorHora);
        this.despesasAdicionais = validaDespesasAdicionais(despesasAdicionais);
    }

    public Double getDespesasAdicionais() {
        return despesasAdicionais;
    }

    public void setDespesasAdicionais(Double despesasAdicionais) {
        this.despesasAdicionais = despesasAdicionais;
    }

    public double validaDespesasAdicionais(double despesasAdicionais){
        if(despesasAdicionais > 1000){
            throw new IllegalArgumentException(
                "O valor da despesa adicional nao pode ser maior que 1000."
            );
        } else {
            return despesasAdicionais;
        }
    }

    public void modificarDespesasAdicionais (double novasDespesas){
        double despesasValidadas = validaDespesasAdicionais(novasDespesas);

        this.despesasAdicionais = despesasValidadas;
    }

    public double calcularPagamentoTerceirizado(){
        return super.calcularPagamento() + (despesasAdicionais * 1.10);
    }

}
