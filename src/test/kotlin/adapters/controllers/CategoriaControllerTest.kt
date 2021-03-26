import adapters.controllers.CategoriaController
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import usecases.categorias.*
import usecases.subcategorias.CriarSubCategoriaUseCase

@RunWith(MockitoJUnitRunner::class)
class CategoriaControllerUnitTest {
    @InjectMocks
    lateinit var categoriaController: CategoriaController

    @Mock
    lateinit var criarCategoriaUseCase: CriarCategoriaUseCase
    @Mock
    lateinit var atualizarCategoriaUseCase: AtualizarCategoriaUseCase
    @Mock
    lateinit var obterCategoriaUseCase: ObterCategoriaUseCase
    @Mock
    lateinit var listarCategoriaUseCase: ListarCategoriaUseCase
    @Mock
    lateinit var excluirCategoriaUseCase: ExcluirCategoriaUseCase
    @Mock
    lateinit var criarSubCategoriaUseCase: CriarSubCategoriaUseCase


    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

}