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
import usecases.subcategorias.AtualizarSubCategoriaUseCase
import usecases.subcategorias.CriarSubCategoriaUseCase

@RunWith(MockitoJUnitRunner::class)

class AtualizarSubCategoriaUseCaseTest {
    @InjectMocks
    lateinit var atualizarSubCategoriaUseCase: AtualizarSubCategoriaUseCase

    @Mock
    lateinit var subCategoriaRepository: ISubCategoriaRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun atualizarSubCategoria() {
        val subCategoriaMock = SubCategoriaEntity(
            id = 1,
            nome = "Combustível",
            categoria = CategoriaEntity(
                id = 1,
                nome = "Transporte"
            )
        )
        `when`(subCategoriaRepository.getById(1)).thenReturn(subCategoriaMock)

        `when`(subCategoriaRepository.save(subCategoriaMock)).thenReturn(subCategoriaMock)

        val subCategoria = atualizarSubCategoriaUseCase.run(1, subCategoriaMock.toSubCategoria())

        assertTrue(subCategoria.id == 1)
    }

}