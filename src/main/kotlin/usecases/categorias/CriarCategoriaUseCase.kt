package usecases.categorias

import adapters.entities.CategoriaEntity
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import usecases.repositories.ICategoriaRepository

@Component
class CriarCategoriaUseCase(private val categoriaRepository: ICategoriaRepository) {
    fun run (categoria: CategoriaEntity): CategoriaEntity {
        return categoriaRepository.save(categoria)
    }
}