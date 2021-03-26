package usecases.subcategorias

import adapters.entities.toSubCategoria
import domains.SubCategoria
import org.springframework.stereotype.Component
import usecases.repositories.ISubCategoriaRepository

@Component
class ListarSubCategoriaUseCase(private val subCategoriaRepository: ISubCategoriaRepository) {
    fun run (nome: String? = null): List<SubCategoria> {
        return if(nome.isNullOrEmpty()) {
            subCategoriaRepository.findAll().map { it.toSubCategoria() }.orEmpty()
        } else {
            subCategoriaRepository.findAllByNome(nome).map { it.toSubCategoria() }.orEmpty()
        }
    }
}