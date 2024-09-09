package iftm.edu.br.funcionarios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FuncionarioTests {
    private Funcionario funcionario;

    @BeforeEach
    public void instanciarObjetos() {
        funcionario = new Funcionario();
    }

    //Casos de teste para validar a quantidade de horas trabalhadas
    @Test
    @DisplayName("Verifica se o valor de horas trabalhadas é válido e não está no limite máximo de 40 horas")
    void TestarHorasTrabalhadasValidasForaDoLimite() {
        //Arrange
        int horasTrabalhadasValidas = 35;
        Double valorHoraValido = 65.00;
        int horasTrabalhadasEsperada = 35;

        //Act
        funcionario = new Funcionario("Ana Clara", horasTrabalhadasValidas, valorHoraValido);
        int horasTrabalhadasObtida = funcionario.getHorasTrabalhadas();

        //Assert
        assertEquals(horasTrabalhadasEsperada, horasTrabalhadasObtida);
    }

    @Test
    @DisplayName("Verifica se o valor de horas trabalhadas é válido e está no limite máximo de 40 horas")
    void TestarHorasTrabalhadasValidasNoLimite() {
        //Arrange
        int horasTrabalhadasValidas = 40;
        Double valorHoraValido = 70.00;
        int horasTrabalhadasEsperada = 40;

        //Act
        funcionario = new Funcionario("Ana Clara", horasTrabalhadasValidas, valorHoraValido);
        int horasTrabalhadasObtida = funcionario.getHorasTrabalhadas();

        //Assert
        assertEquals(horasTrabalhadasEsperada, horasTrabalhadasObtida);
    }

    @Test
    @DisplayName("Verifica se o valor de horas trabalhadas é inválido e está fora do limite máximo de 40 horas")
    void TestarHorasTrabalhadasInvalidasForaDoLimite() {
        //Arrange
        int horasTrabalhadasInvalidas = 45;
        Double valorHoraValido = 70.00;

        //Act and Assert
        assertThrows(IllegalArgumentException.class,
        () -> {
            funcionario = new Funcionario("Ana Clara", horasTrabalhadasInvalidas, valorHoraValido);
        });
    }

    @Test
    @DisplayName("Verifica se o valor do pagamento é válido e não está no limite inferior de R$ 1320.00")
    void TestarPagamentoValidoForaLimite() {
        //Arrange
        int horasTrabalhadasValidas = 30;
        Double valorHoraValido = 60.00;
        Double pagamentoEsperado = 1800.00;

        //Act
        funcionario = new Funcionario("Ana Clara", horasTrabalhadasValidas, valorHoraValido);
        Double pagamentoObtido = funcionario.calcularPagamento();

        //Assert
        assertEquals(pagamentoEsperado, pagamentoObtido);
    }


    // @Test
    // // @DisplayName("Verifica se o construtor é inicializado com valores válidos")
    // public void testarConstrutorEntradasValidas() {
    //     //Arrange
    //     String nomeValido = "Ana Clara Custodio";
    //     int horasTrabalhadasValida = 35;
    //     Double valorHoraValida = 65;

    //     //Act
    //     funcionario = new Funcionario(nomeValido, horasTrabalhadasValida, valorHoraValida);
    //     String nomeObtido = funcionario.getNome();
    //     int horasTrabalhadasObtida = funcionario.getHorasTrabalhadas();
    //     Double valorHoraObtida = funcionario.getValorHora();

    //     //Assert
    //     assertEquals();

    // }

    @Test
    @DisplayName("Caso de teste para validar a construção com valor hora inválido.")
    void testarConstrutorEntradaValorHoraInvalida() {
    
        //Arrange
        String nome = "Isabela";
        int horasTrabalhadasValidas = 40;
        double valorHoraInvalido = 300.00;

        //Act and assert
        assertThrows(IllegalArgumentException.class,
        () -> {
            funcionario = new Funcionario(nome, horasTrabalhadasValidas, valorHoraInvalido);
        });
    }

    @Test
    @DisplayName("Caso de teste para validar a modificação do valor hora com entrada válida.")
    void testarModificarValorHoraEntradaValida() {
        // Arrange
        double valorHoraValida = 60.00;

        // Act
        funcionario.setValorHora(valorHoraValida);

        // Assert
        assertEquals(valorHoraValida, funcionario.getValorHora());
    }

    @Test
    @DisplayName("Caso de teste para validar a construção com pagamento inválido.")
    void testarConstrutorPagamentoInvalido() {
        // Arrange
        String nome = "João";
        int horasTrabalhadas = 10;
        double valorHora = 20.00;

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Funcionario(nome, horasTrabalhadas, valorHora);
        });
    }

    @Test
    @DisplayName("Caso de teste para validar um pagamento igual ao limite")
    void testarConstrutorPagamentoNoLimite() {
        // Arrange
        int horasTrabalhadas = 20;
        double valorHora = 66.00;
        double pagamentoEsperado = 1320.00;

        // Act
        funcionario = new Funcionario("Isabela", horasTrabalhadas, valorHora);
        double pagamentoObtido = funcionario.calcularPagamento();

        // Assert
        assertEquals(pagamentoEsperado, pagamentoObtido);
    }

}
