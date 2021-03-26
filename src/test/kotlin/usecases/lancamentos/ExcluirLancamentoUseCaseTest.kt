package usecases.subcategorias

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import usecases.lancamentos.ExcluirLancamentoUseCase
import usecases.repositories.ILancamentoRepository

@RunWith(MockitoJUnitRunner::class)

class ExcluirLancamentoUseCaseTest {
    @InjectMocks
    lateinit var excluirLancamentoUseCase: ExcluirLancamentoUseCase

    @Mock
    lateinit var lancamentoRepository: ILancamentoRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun excluirSubCategoria() {
        `when`(lancamentoRepository.deleteById(1)).thenReturn(true)
        val lancamentoDeleted = excluirLancamentoUseCase.run(1)
        assertTrue(lancamentoDeleted)
    }

}