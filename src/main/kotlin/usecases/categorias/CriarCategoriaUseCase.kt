package usecases.categorias

import adapters.entities.toCategoria
import adapters.entities.toCategoriaEntity
import domains.Categoria
import org.springframework.stereotype.Component
import usecases.repositories.ICategoriaRepository

@Component
class CriarCategoriaUseCase(private val categoriaRepository: ICategoriaRepository) {
    fun run (categoria: Categoria): Categoria {
//        val categoriaAlreadyExists = categoriaRepository.getByNome(categoria.nome)
//        if(categoriaAlreadyExists != null) {
//            throw categoriaAlreadyExists()
//        }
        return categoriaRepository.save(categoria.toCategoriaEntity()).toCategoria()
    }
}


