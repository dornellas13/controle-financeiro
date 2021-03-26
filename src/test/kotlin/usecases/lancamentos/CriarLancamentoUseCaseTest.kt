package usecases.categorias

import adapters.entities.*
import domains.Categoria
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import usecases.lancamentos.CriarLancamentoUseCase
import usecases.repositories.ICategoriaRepository
import usecases.repositories.ILancamentoRepository
import java.util.*

@RunWith(MockitoJUnitRunner::class)

class CriarLancamentoUseCaseTest {
    @InjectMocks
    lateinit var criarLancamentoUseCase: CriarLancamentoUseCase

    @Mock
    lateinit var lancamentoRepository: ILancamentoRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun criarLancamento() {
        val lancamentoMock = LancamentoEntity(
            id = 1,
            valor = 20.00,
            data = Date(),
            comentario = "Gastos de Combustível",
            subcategoria = SubCategoriaEntity(
                id = 1,
                nome = "Combustível",
                categoria = CategoriaEntity(
                    id = 1,
                    nome = "Transporte"
                )
            )
        )
        `when`(lancamentoRepository.save(lancamentoMock)).thenReturn(lancamentoMock)

        val lancamento = criarLancamentoUseCase.run(lancamentoMock.toLancamento())

        assertTrue(lancamento.id == 1)
    }

}