package iftm.edu.br.funcionarios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FuncionarioTests {
    private Funcionario funcionario;

    @BeforeEach
    public void instanciarObjetos() {
        funcionario = new Funcionario();
    }

    //Casos de teste para validar a quantidade de horas trabalhadas
    @Test
    @DisplayName("Verifica se o valor de horas trabalhadas é válido e não está no limite máximo de 40 horas")
    public void TestarHorasTrabalhadasValidasForaDoLimite() {
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
    public void TestarHorasTrabalhadasValidasNoLimite() {
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
    public void TestarHorasTrabalhadasInvalidasForaDoLimite() {
        //Arrange
        int horasTrabalhadasInvalidas = 45;
        Double valorHoraValido = 70.00;

        //Act and Assert
        assertThrows(IllegalArgumentException.class,
        () -> {
            funcionario = new Funcionario("Ana Clara", horasTrabalhadasInvalidas, valorHoraValido);
        });
    }

    //implementar depois

    // @Test
    // @DisplayName("Verifica se o valor do pagamento é válido e não está no limite inferior de R$ 1320.00")
    // public void TestarPagamentoValidoForaLimite() {
    //     //Arrange
    //     int horasTrabalhadasValidas = 30;
    //     Double valorHoraValido = 60.00;
    //     Double pagamentoEsperado = 1800.00;

    //     //Act
    //     funcionario = new Funcionario("Ana Clara", horasTrabalhadasValidas, valorHoraValido);
    //     Double pagamentoObtido = funcionario.calcularPagamento();

    //     //Assert
    //     assertEquals(pagamentoEsperado, pagamentoObtido);
    // }


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
}