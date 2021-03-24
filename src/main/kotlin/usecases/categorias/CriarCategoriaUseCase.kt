package usecases.categorias

import adapters.entities.toCategoria
import adapters.entities.toCategoriaEntity
import domains.Categoria
import org.springframework.stereotype.Component
import usecases.repositories.ICategoriaRepository

@Component
class CriarCategoriaUseCase(private val categoriaRepository: ICategoriaRepository) {
    fun run (categoria: Categoria): Categoria {
        return categoriaRepository.save(categoria.toCategoriaEntity()).toCategoria()
    }
}