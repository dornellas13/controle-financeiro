import adapters.controllers.CategoriaController
import adapters.controllers.SubCategoriaController
import adapters.dto.CategoriaDto
import adapters.dto.toSubCategoriaDto
import adapters.entities.CategoriaEntity
import adapters.entities.SubCategoriaEntity
import adapters.entities.toSubCategoria
import domains.Categoria
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import usecases.categorias.*
import usecases.lancamentos.CriarLancamentoUseCase
import usecases.subcategorias.*

@RunWith(MockitoJUnitRunner::class)
class SubCategoriaControllerUnitTest {
    @InjectMocks
    lateinit var subCategoriaController: SubCategoriaController
    @InjectMocks
    lateinit var categoriaController: CategoriaController
    @Mock
    lateinit var criarSubCategoriaUseCase: CriarSubCategoriaUseCase
    @Mock
    lateinit var atualizarSubCategoriaUseCase: AtualizarSubCategoriaUseCase
    @Mock
    lateinit var obterSubCategoriaUseCase: ObterSubCategoriaUseCase
    @Mock
    lateinit var listarSubCategoriaUseCase: ListarSubCategoriaUseCase
    @Mock
    lateinit var excluirSubCategoriaUseCase: ExcluirSubCategoriaUseCase
    @Mock
    lateinit var criarLancamentoUseCase: CriarLancamentoUseCase
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

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun obter() {
        val subCategoria = SubCategoriaEntity(
            id = 1,
            nome = "Combustível",
            categoria = CategoriaEntity(
                id = 1,
                nome = "Transporte"
            )
        )
        Mockito.`when`(obterSubCategoriaUseCase.run(id = 1)).thenReturn(subCategoria.toSubCategoria())
        val result = subCategoriaController.obter(1)
        assertNotNull(result)
    }

    @Test
    fun criar() {
        val subCategoria = SubCategoriaEntity(
            id = 1,
            nome = "Combustível",
            categoria = CategoriaEntity(
                id = 1,
                nome = "Transporte"
            )
        )
        Mockito.`when`(criarSubCategoriaUseCase.run(subCategoria.toSubCategoria())).thenReturn(subCategoria.toSubCategoria())

        Mockito.`when`(obterCategoriaUseCase.run(id = 1)).thenReturn(Categoria(
            id = 1,
            nome = "Transporte"
        ))

        val result = categoriaController.criarSubCategoria(1, subCategoria.toSubCategoria().toSubCategoriaDto())
        assertNotNull(result)
    }

    @Test
    fun atualizar() {
        val subCategoria = SubCategoriaEntity(
            id = 1,
            nome = "Combustível",
            categoria = CategoriaEntity(
                id = 1,
                nome = "Transporte"
            )
        )
        Mockito.`when`(atualizarSubCategoriaUseCase.run(1, subCategoria.toSubCategoria())).thenReturn(subCategoria.toSubCategoria())
        val result = subCategoriaController.atualizar(1, subCategoria.toSubCategoria().toSubCategoriaDto())
        assertNotNull(result)
    }

    @Test
    fun excluir() {
        Mockito.`when`(excluirSubCategoriaUseCase.run(id = 1)).thenReturn(true)
        val result = categoriaController.excluir(1)
        assertNotNull(result)
    }

    @Test
    fun listar() {
        val subCategoria = listOf<SubCategoriaEntity>(
            SubCategoriaEntity(
                id = 1,
                nome = "Combustível",
                categoria = CategoriaEntity(
                    id = 1,
                    nome = "Transporte"
                )
            )
        )
        Mockito.`when`(listarSubCategoriaUseCase.run("Transporte")).thenReturn(subCategoria.map { it.toSubCategoria() })
        val result = subCategoriaController.listar("Transporte")
        assertNotNull(result)
    }

}