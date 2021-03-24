package usecases.categorias

import adapters.entities.toCategoria
import domains.Categoria
import org.springframework.stereotype.Component
import usecases.repositories.ICategoriaRepository

@Component
class ObterCategoriaUseCase(private val categoriaRepository: ICategoriaRepository) {
    fun run (id: Int): Categoria {
        return categoriaRepository.getById(id).toCategoria()
    }
}