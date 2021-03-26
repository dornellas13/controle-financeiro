package usecases.categorias

import adapters.entities.CategoriaEntity
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.ArgumentMatchers.anyString
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import usecases.repositories.ICategoriaRepository

@RunWith(MockitoJUnitRunner::class)

class ObterCategoriaUseCaseTest {
    @InjectMocks
    lateinit var obterCategoriaUseCase: ObterCategoriaUseCase

    @Mock
    lateinit var categoriaRepository: ICategoriaRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun obterCategoria() {
        `when`(categoriaRepository.getById(1)).thenReturn(CategoriaEntity(
            id = 1,
            nome = "Transporte"
        ))

        val categoria = obterCategoriaUseCase.run(id = 1)

        assertTrue(categoria.id == 1)
    }

}