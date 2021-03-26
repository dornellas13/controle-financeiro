package usecases.categorias

import adapters.entities.CategoriaEntity
import adapters.entities.SubCategoriaEntity
import adapters.entities.toCategoria
import adapters.entities.toSubCategoria
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
import usecases.repositories.ISubCategoriaRepository
import usecases.subcategorias.CriarSubCategoriaUseCase

@RunWith(MockitoJUnitRunner::class)

class CriarSubCategoriaUseCaseTest {
    @InjectMocks
    lateinit var criarSubCategoriaUseCase: CriarSubCategoriaUseCase

    @Mock
    lateinit var subCategoriaRepository: ISubCategoriaRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun criarSubCategoria() {
        val subCategoriaMock = SubCategoriaEntity(
            id = 1,
            nome = "Combustível",
            categoria = CategoriaEntity(
                id = 1,
                nome = "Transporte"
            )
        )
        `when`(subCategoriaRepository.save(subCategoriaMock)).thenReturn(subCategoriaMock)

        val subCategoria = criarSubCategoriaUseCase.run(subCategoriaMock.toSubCategoria())

        assertTrue(subCategoria.id == 1)
    }

}