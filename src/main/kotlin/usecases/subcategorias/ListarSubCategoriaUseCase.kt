package usecases.subcategorias

import adapters.entities.toSubCategoria
import domains.SubCategoria
import org.springframework.stereotype.Component
import usecases.repositories.ISubCategoriaRepository

@Component
class ListarSubCategoriaUseCase(private val subCategoriaRepository: ISubCategoriaRepository) {
    fun run (): List<SubCategoria> {
        return subCategoriaRepository.findAll().map {
            it.toSubCategoria()
        }.orEmpty()
    }
}