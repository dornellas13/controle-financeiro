package usecases.categorias

import adapters.entities.toCategoria
import domains.Categoria
import org.springframework.stereotype.Component
import usecases.repositories.ICategoriaRepository

@Component
class AtualizarCategoriaUseCase(private val categoriaRepository: ICategoriaRepository) {
    fun run (id: Int, categoria: Categoria): Categoria {
        val categoriaEntity = categoriaRepository.getById(id)
        val categoriaUpdated = categoriaRepository.save(categoriaEntity.copy(nome = categoria.nome))
        return categoriaUpdated.toCategoria()
    }
}