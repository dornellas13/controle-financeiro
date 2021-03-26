package usecases.subcategorias

import usecases.categorias.ExcluirCategoriaUseCase
import usecases.repositories.ISubCategoriaRepository
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

class ExcluirSubCategoriaUseCaseTest {
    @InjectMocks
    lateinit var excluirSubCategoriaUseCase: ExcluirSubCategoriaUseCase

    @Mock
    lateinit var subCategoriaRepository: ISubCategoriaRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun excluirSubCategoria() {
        `when`(subCategoriaRepository.deleteById(1)).thenReturn(true)
        val subCategoriaDeleted = excluirSubCategoriaUseCase.run(1)
        assertTrue(subCategoriaDeleted)
    }

}