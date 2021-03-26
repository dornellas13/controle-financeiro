package usecases.categorias

import adapters.entities.LancamentoEntity
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import usecases.lancamentos.ObterLancamentoUseCase
import usecases.repositories.ILancamentoRepository
import java.util.*

@RunWith(MockitoJUnitRunner::class)

class ObterLancamentoUseCaseTest {
    @InjectMocks
    lateinit var obterLancmentoUseCase: ObterLancamentoUseCase

    @Mock
    lateinit var lancamentoRepository: ILancamentoRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun obterLancamento() {
        `when`(lancamentoRepository.getById(1)).thenReturn(
            LancamentoEntity(
                id = 1,
                valor = 20.00,
                data = Date(),
                comentario = "Gastos de Combustível"
            )
        )

        val lancamento = obterLancmentoUseCase.run(id = 1)

        assertTrue(lancamento.id == 1)
    }

}