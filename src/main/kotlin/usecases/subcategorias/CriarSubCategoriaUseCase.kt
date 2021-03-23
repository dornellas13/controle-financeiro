package usecases.subcategorias

import adapters.dto.SubCategoriaDto
import adapters.dto.toCategoriaDto
import adapters.dto.toSubCategoria
import adapters.entities.toCategoria
import adapters.entities.toSubCategoria
import adapters.entities.toSubCategoriaEntity
import domains.SubCategoria
import org.springframework.stereotype.Component
import usecases.repositories.ICategoriaRepository
import usecases.repositories.ISubCategoriaRepository

@Component
class CriarSubCategoriaUseCase(private val categoriaRepository: ICategoriaRepository,private val subCategoriaRepository: ISubCategoriaRepository) {
    fun run (subCategoria: SubCategoria): SubCategoria {
        return subCategoriaRepository.save(subCategoria.toSubCategoriaEntity()).toSubCategoria()
    }
}