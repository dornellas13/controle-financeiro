package adapters.controllers

import adapters.dto.LancamentoDto
import adapters.dto.toLancamento
import domains.Lancamento
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.junit.MockitoJUnitRunner
import usecases.lancamentos.*
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class LancamentoControllerUnitTest {
    @InjectMocks
    lateinit var lancamentoController: LancamentoController

    @Mock
    lateinit var obterLancamentoUseCase: ObterLancamentoUseCase
    @Mock
    lateinit var atualizarLancamentoUseCase: AtualizarLancamentoUseCase
    @Mock
    lateinit var listarLancamentoUseCase: ListarLancamentoUseCase
    @Mock
    lateinit var excluirLancamentoUseCase: ExcluirLancamentoUseCase

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun obter() {
        val lancamento = Lancamento(
            id = 1,
            valor = 20.00,
            data = Date(),
            comentario = "Gastos de Combustível"
        )
        Mockito.`when`(obterLancamentoUseCase.run(1)).thenReturn(lancamento)
        val result = lancamentoController.obter(1)
        assertNotNull(result)
    }

    @Test
    fun listar() {
        val lancamento = listOf(Lancamento(
            id = 1,
            valor = 20.00,
            data = Date(),
            comentario = "Gastos de Combustível"
        ))
        Mockito.`when`(listarLancamentoUseCase.run()).thenReturn(lancamento)
        val result = lancamentoController.listar()
        assertNotNull(result)
    }

    @Test
    fun atualizar () {
        val lancamentoDto = LancamentoDto(
            id = 1,
            valor = 20.00,
            data = Date(),
            comentario = "Gastos de Combustível"
        )

        val lancamento = lancamentoDto.toLancamento()

        Mockito.`when`(atualizarLancamentoUseCase.run(1, lancamento)).thenReturn(lancamento)

        val result = lancamentoController.atualizar(1,lancamentoDto)
        assertNotNull(result)
    }

    @Test
    fun excluir() {
        Mockito.`when`(excluirLancamentoUseCase.run(id = 1)).thenReturn(true)

        val result = lancamentoController.excluir(1)
        assertNotNull(result)
    }

}
