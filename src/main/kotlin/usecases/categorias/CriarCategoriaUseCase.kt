package usecases.categorias

import adapters.entities.CategoriaEntity
import adapters.entities.toCategoria
import adapters.entities.toCategoriaEntity
import domains.Categoria
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import usecases.repositories.ICategoriaRepository

@Component
class CriarCategoriaUseCase(private val categoriaRepository: ICategoriaRepository) {
    fun run (categoria: Categoria): Categoria {
        categoriaRepository.save(categoria.toCategoriaEntity())
        return categoria
    }
}