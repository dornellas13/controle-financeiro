package usecases.categorias

import adapters.entities.toCategoria
import domains.Categoria
import org.springframework.stereotype.Component
import usecases.repositories.ICategoriaRepository

@Component
class ListarCategoriaUseCase(private val categoriaRepository: ICategoriaRepository) {
    fun run (nome: String?): List<Categoria> {
        return if(nome.isNullOrEmpty()) {
            categoriaRepository.findAll().map { it.toCategoria() }.orEmpty()
        } else {
            categoriaRepository.findAllByNome(nome).map { it.toCategoria() }.orEmpty()
        }
    }
}