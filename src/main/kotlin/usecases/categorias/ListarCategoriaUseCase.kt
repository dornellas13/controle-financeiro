package usecases.categorias

import adapters.entities.toCategoria
import domains.Categoria
import org.springframework.stereotype.Component
import usecases.repositories.ICategoriaRepository

@Component
class ListarCategoriaUseCase(private val categoriaRepository: ICategoriaRepository) {
    fun run (): List<Categoria> {
        return categoriaRepository.findAll().map {
            it.toCategoria()
        }.orEmpty()
    }
}