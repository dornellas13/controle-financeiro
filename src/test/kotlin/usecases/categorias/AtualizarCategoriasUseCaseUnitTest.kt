package usecases.categorias

import adapters.repositories.CategoriaRepository
import domains.Categoria

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.junit.MockitoJUnitRunner
import usecases.repositories.ICategoriaRepository

@RunWith(MockitoJUnitRunner::class)

class AtualizarCategoriaUnitTest {
    @InjectMocks
    lateinit var atualizarCategoriaUseCase: AtualizarCategoriaUseCase
    @Mock
    lateinit var categoriaRepository: ICategoriaRepository
    @Test
    fun atualizarCategoria() {
        val result = atualizarCategoriaUseCase.run(1, Categoria(

        ))
    }

}