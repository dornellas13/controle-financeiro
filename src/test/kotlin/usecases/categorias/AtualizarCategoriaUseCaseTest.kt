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

class AtualizarCategoriaUseCaseTest {
    @InjectMocks
    lateinit var atualizarCategoriaUseCase: AtualizarCategoriaUseCase

    @Mock
    lateinit var categoriaRepository: ICategoriaRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun atualizarCategoria() {
        val categoriaMock = CategoriaEntity(
            id = 1,
            nome = "Transporte"
        )
        `when`(categoriaRepository.getById(1)).thenReturn(categoriaMock)
        `when`(categoriaRepository.save(categoriaMock)).thenReturn(categoriaMock)

        val categoria = atualizarCategoriaUseCase.run(1, categoriaMock.toCategoria())

        assertTrue(categoria.id == 1)
    }

}