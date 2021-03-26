package usecases.categorias

import adapters.entities.CategoriaEntity
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import usecases.repositories.ICategoriaRepository

@RunWith(MockitoJUnitRunner::class)

class ListarCategoriaUseCaseTest {
    @InjectMocks
    lateinit var listarCategoriaUseCase: ListarCategoriaUseCase

    @Mock
    lateinit var categoriaRepository: ICategoriaRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun listarCategorias() {
        val categoriasMock: List<CategoriaEntity> = listOf(CategoriaEntity(
            id = 1,
            nome = "Transporte"
        ))
       `when`(categoriaRepository.findAllByNome(anyString())).thenReturn(categoriasMock)
        val categorias = listarCategoriaUseCase.run("Transporte")
        assertFalse(categorias.isEmpty())
    }

    @Test
    fun listarCategoriaVazio() {
        val categorias = listarCategoriaUseCase.run().map { it };
        assertTrue(categorias.isEmpty())
    }

}