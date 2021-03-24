package usecases.subcategorias

import adapters.entities.toSubCategoria
import domains.SubCategoria
import org.springframework.stereotype.Component
import usecases.repositories.ISubCategoriaRepository

@Component
class ObterSubCategoriaUseCase(private val subCategoriaRepository: ISubCategoriaRepository) {
    fun run (id: Int): SubCategoria {
        return subCategoriaRepository.getById(id).toSubCategoria()
    }
}