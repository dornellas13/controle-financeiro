package usecases.categorias

import adapters.entities.CategoriaEntity
import adapters.entities.SubCategoriaEntity
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
import usecases.repositories.ISubCategoriaRepository
import usecases.subcategorias.ObterSubCategoriaUseCase

@RunWith(MockitoJUnitRunner::class)

class ObterSubCategoriaUseCaseTest {
    @InjectMocks
    lateinit var obterSubCategoriaUseCase: ObterSubCategoriaUseCase

    @Mock
    lateinit var subCategoriaRepository: ISubCategoriaRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun obterSubCategoria() {
        `when`(subCategoriaRepository.getById(1)).thenReturn(
            SubCategoriaEntity(
            id = 1,
            nome = "Combustível",
            categoria = CategoriaEntity(
                id = 1,
                nome = "Transporte"
            )
        )
        )

        val subCategoria = obterSubCategoriaUseCase.run(id = 1)

        assertTrue(subCategoria.id == 1)
    }

}