import adapters.controllers.CategoriaController
import adapters.dto.CategoriaDto
import adapters.entities.CategoriaEntity
import domains.Categoria
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import usecases.categorias.*
import usecases.repositories.ICategoriaRepository
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

    @Test
    fun obter() {
        `when`(obterCategoriaUseCase.run(id = 1)).thenReturn(Categoria(
            id = 1,
            nome = "Transporte"
       ))

        val result = categoriaController.obter(1)
        assertNotNull(result)
    }

    @Test
    fun criar() {
        val categoria = Categoria(
            id = 1,
            nome = "Transporte"
        )
        `when`(criarCategoriaUseCase.run(categoria)).thenReturn(categoria)

        val result = categoriaController.criar(categoria = CategoriaDto(
            id = 1,
            nome = "Transporte"
        ))

        assertNotNull(result)
    }

    @Test
    fun atualizar() {
        val categoria = Categoria(
            id = 1,
            nome = "Transporte"
        )
        `when`(atualizarCategoriaUseCase.run(1, categoria)).thenReturn(categoria)

        val result = categoriaController.atualizar(1, categoria = CategoriaDto(
            id = 1,
            nome = "Transporte"
        ))

        assertNotNull(result)
    }

    @Test
    fun excluir() {
        `when`(excluirCategoriaUseCase.run(id = 1)).thenReturn(true)

        val result = categoriaController.excluir(1)
        assertNotNull(result)
    }

    @Test
    fun listar() {
        val categoria = listOf<Categoria>(Categoria(
            id = 1,
            nome = "Transporte"
        ))

        `when`(listarCategoriaUseCase.run("Transporte")).thenReturn(categoria)

        val result = categoriaController.listar("Transporte")
        assertNotNull(result)
    }

}