package usecases.categorias

import adapters.entities.CategoriaEntity
import adapters.entities.toCategoria
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
import usecases.repositories.ICategoriaRepository

@RunWith(MockitoJUnitRunner::class)

class CriarCategoriaUseCaseTest {
    @InjectMocks
    lateinit var criarCategoriaUseCase: CriarCategoriaUseCase

    @Mock
    lateinit var categoriaRepository: ICategoriaRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun criarCategoria() {
        val categoriaMock = CategoriaEntity(
            id = 1,
            nome = "Transporte"
        )
        `when`(categoriaRepository.save(categoriaMock)).thenReturn(categoriaMock)

        val categoria = criarCategoriaUseCase.run(categoriaMock.toCategoria())

        assertTrue(categoria.id == 1)
    }

}