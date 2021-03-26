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
import org.mockito.Mockito.doNothing
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import usecases.repositories.ICategoriaRepository

@RunWith(MockitoJUnitRunner::class)

class ExcluirCategoriaUseCaseTest {
    @InjectMocks
    lateinit var excluirCategoriaUseCase: ExcluirCategoriaUseCase

    @Mock
    lateinit var categoriaRepository: ICategoriaRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun excluirCategoria() {
        `when`(categoriaRepository.deleteById(1)).thenReturn(true)
        val categoriaDeleted = excluirCategoriaUseCase.run(1)
        assertTrue(categoriaDeleted)
    }

}