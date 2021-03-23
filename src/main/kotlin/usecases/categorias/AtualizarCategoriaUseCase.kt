package usecases.categorias

import adapters.entities.toCategoria
import domains.Categoria
import org.springframework.stereotype.Component
import usecases.repositories.ICategoriaRepository

@Component
class AtualizarCategoriaUseCase(private val categoriaRepository: ICategoriaRepository) {
    fun run (id: Int, categoria: Categoria): Categoria {
        val categoria = categoriaRepository.getById(id)
        val categoriaUpdated = categoriaRepository.save(categoria.copy(nome = categoria.nome))
        return categoriaUpdated.toCategoria()
    }
}