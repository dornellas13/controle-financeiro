package usecases.categorias

import adapters.entities.LancamentoEntity
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import usecases.lancamentos.CalcularBalancoUseCase
import usecases.lancamentos.ObterLancamentoUseCase
import usecases.repositories.ILancamentoRepository
import java.util.*

@RunWith(MockitoJUnitRunner::class)

class CalcularBalancoUseCaseTest {
    @InjectMocks
    lateinit var calcularBalancoUseCase: CalcularBalancoUseCase

    @Mock
    lateinit var lancamentoRepository: ILancamentoRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun calcularBalancoGeral() {
        val receita = LancamentoEntity(
            id = 1,
            valor = 100.00,
            data = Date(),
            comentario = "Gastos de Combustível"
        )

        val despesa = LancamentoEntity(
            id = 2,
            valor = -50.00,
            data = Date(),
            comentario = "Gastos de Combustível"
        )
        val lancamentosMock: List<LancamentoEntity> = listOf(receita, despesa)

        Mockito.`when`(lancamentoRepository.findAll(
            ArgumentMatchers.any(),
            ArgumentMatchers.any(),
            ArgumentMatchers.any()
        )).thenReturn(lancamentosMock)

        val balancoGeral = calcularBalancoUseCase.run()

        assertTrue(balancoGeral!!.saldo == 50.00)
    }

    @Test
    fun calcularBalancoGeralVazio() {
        Mockito.`when`(lancamentoRepository.findAll(
            ArgumentMatchers.any(),
            ArgumentMatchers.any(),
            ArgumentMatchers.any()
        )).thenReturn(emptyList())

        val balancoGeral = calcularBalancoUseCase.run()
        assertTrue(balancoGeral == null)
    }

}