package usecases.subcategorias

import adapters.entities.CategoriaEntity
import adapters.entities.SubCategoriaEntity
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.junit.MockitoJUnitRunner
import usecases.repositories.ISubCategoriaRepository

@RunWith(MockitoJUnitRunner::class)

class ListarSubCategoriaUseCaseTest {
    @InjectMocks
    lateinit var listarSubCategoriaUseCase: ListarSubCategoriaUseCase

    @Mock
    lateinit var subCategoriaRepository: ISubCategoriaRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun listarSubCategorias() {
        val subCategoriasMock: List<SubCategoriaEntity> = listOf(SubCategoriaEntity(
            id = 1,
            nome = "Combustível",
            categoria = CategoriaEntity(
                id = 1,
                nome = "Transporte"
            )
        ))
        Mockito.`when`(subCategoriaRepository.findAllByNome(ArgumentMatchers.anyString())).thenReturn(subCategoriasMock)
        val subCategorias = listarSubCategoriaUseCase.run("Transporte")
        assertFalse(subCategorias.isEmpty())
    }

    @Test
    fun listarSubCategoriaVazio() {
        val subCategorias = listarSubCategoriaUseCase.run().map { it };
        assertTrue(subCategorias.isEmpty())
    }

}