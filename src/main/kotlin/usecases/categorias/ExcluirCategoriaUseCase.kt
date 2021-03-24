package usecases.categorias

import org.springframework.stereotype.Component
import usecases.repositories.ICategoriaRepository

@Component
class ExcluirCategoriaUseCase(private val categoriaRepository: ICategoriaRepository) {
    fun run (id: Int) {
        return categoriaRepository.deleteById(id)
    }
}