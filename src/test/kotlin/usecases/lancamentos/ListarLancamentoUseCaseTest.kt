package usecases.lancamentos
import adapters.entities.CategoriaEntity
import adapters.entities.LancamentoEntity
import adapters.entities.SubCategoriaEntity
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.ArgumentMatchers.any
import org.mockito.ArgumentMatchers.anyObject
import org.mockito.junit.MockitoJUnitRunner
import usecases.repositories.ILancamentoRepository
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class ListarLancamentoUseCaseTest {
    @InjectMocks
    lateinit var listarLancamentoUseCase: ListarLancamentoUseCase

    @Mock
    lateinit var lancamentoRepository: ILancamentoRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun listarLancamento() {
        val lancamentosMock: List<LancamentoEntity> = listOf(
            LancamentoEntity(
                id = 1,
                valor = 20.00,
                data = Date(),
                comentario = "Gastos de Combustível"
            ))

        Mockito.`when`(lancamentoRepository.findAll(any(), any(), any())).thenReturn(lancamentosMock)
        val lancamentos = listarLancamentoUseCase.run()
        assertFalse(lancamentos.isEmpty())
    }

    @Test
    fun listarLancamentoVazio() {
        val categorias = listarLancamentoUseCase.run().map { it };
        assertTrue(categorias.isEmpty())
    }

}