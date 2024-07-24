package iftm.edu.br.funcionarios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FuncionarioTercerizadoTests {
    private FuncionarioTercerizado funcionarioTerc;

    @BeforeEach
    public void instanciarObjetos() {
        funcionarioTerc = new FuncionarioTercerizado();
    }

    @Test
    @DisplayName("Caso de teste para validar as entradas do construtor com valores válidos.")
    public void testarConstrutorEntradasValidas(){
        //Arrange
        String nomeValido = "Fernanda Romanoel";
        int horasTrabalhadasValido = 30;
        double valorHoraValido = 66.00;
        double despesasAdicionaisValido = 320.00;
        //Act
        funcionarioTerc = new FuncionarioTercerizado(nomeValido, horasTrabalhadasValido, valorHoraValido, despesasAdicionaisValido);

        //Assert
        assertEquals(nomeValido, funcionarioTerc.getNome());
        assertEquals(horasTrabalhadasValido, funcionarioTerc.getHorasTrabalhadas());
        assertEquals(valorHoraValido, funcionarioTerc.getValorHora());
        assertEquals(despesasAdicionaisValido, funcionarioTerc.getDespesasAdicionais());
    }

    @Test
    @DisplayName("Caso de teste para validar o construtor de entrada com despesas adicionais invalido.")
    public void testarConstrutorEntradaDespesasInvalida(){
        //Arrange
        String nome = "Fernanda";
        int horasTrabalhadasValidas = 38;
        double valorHoraValido = 59.00;
        double despesasAdicionaisInvalido = 1300.00;
        //Act and assert
        assertThrows(IllegalArgumentException.class, () -> {
            funcionarioTerc = new FuncionarioTercerizado(nome, horasTrabalhadasValidas, valorHoraValido, despesasAdicionaisInvalido);
        });

    }

    @Test
    @DisplayName("Caso de teste para validar a modificação da despesa adicional com valor inválido.")
    public void testarModificarDespesasEntradaInvalida(){
        //Arrange
        FuncionarioTercerizado funcionarioTercerizado = new FuncionarioTercerizado("Fernanda", 30,  56.0, 0.0);

        double despesaAdicionalInvalida = 1001.00;
        //Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            funcionarioTercerizado.modificarDespesasAdicionais(despesaAdicionalInvalida);
        } );
    }

    @Test
    @DisplayName("Caso de teste para validar a modificação da despesa adicional com valor válido.")
    public void testarModificarDespesasEntradaValida(){
        //Arrange
        FuncionarioTercerizado funcionarioTercerizado = new FuncionarioTercerizado("Fernanda", 30, 59.0, 600.0);
        double despesaAdicionalValida = 950.00;
        //Act and Assert
        funcionarioTercerizado.modificarDespesasAdicionais(despesaAdicionalValida);
        assertEquals(despesaAdicionalValida, funcionarioTercerizado.getDespesasAdicionais());
    }

    @Test
    @DisplayName("Caso de teste para validar um pagamento terceirizado com valores válidos.")
    public void testarConstrutorPagamentoTerceirizadoValido() {
        // Arrange
        int horasTrabalhadas = 25;
        double valorHora = 64;
        double despesaAdicional = 1000.00;
        double pagamentoEsperado = 2700.00;

        // Act
        FuncionarioTercerizado funcionarioTerceirizado = new FuncionarioTercerizado("Fernanda", horasTrabalhadas, valorHora, despesaAdicional);
        double pagamentoObtido = funcionarioTerceirizado.calcularPagamentoTerceirizado();

        // Assert
        assertEquals(pagamentoEsperado, pagamentoObtido);
    }

}





