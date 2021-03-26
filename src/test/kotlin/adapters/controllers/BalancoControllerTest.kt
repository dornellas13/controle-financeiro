package adapters.controllers

import domains.Balanco
import domains.Categoria
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.ArgumentMatchers.any
import org.mockito.junit.MockitoJUnitRunner
import usecases.lancamentos.CalcularBalancoUseCase

@RunWith(MockitoJUnitRunner::class)
class BalancoControllerUnitTest {
    @InjectMocks
    lateinit var balancoController: BalancoController

    @Mock
    lateinit var calcularBalancoUseCase: CalcularBalancoUseCase


    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun calcularBalancoGeral() {
        val categoria = Categoria(
            id = 1,
            nome = "Transporte"
        )

        val balanco = Balanco(
            categoria = categoria,
            saldo = 0.00,
            receita = 20.00,
            despesa = 20.00
        )
        Mockito.`when`(calcularBalancoUseCase.run(any(), any(), any())).thenReturn(balanco)
        val result = balancoController.obter()
        assertNotNull(result)
    }
}
