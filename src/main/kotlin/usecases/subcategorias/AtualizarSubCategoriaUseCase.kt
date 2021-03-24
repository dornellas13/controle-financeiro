package usecases.subcategorias
import adapters.entities.toSubCategoria
import domains.SubCategoria
import org.springframework.stereotype.Component
import usecases.repositories.ISubCategoriaRepository

@Component
class AtualizarSubCategoriaUseCase(private val subCategoriaRepository: ISubCategoriaRepository) {
    fun run (id: Int, subCategoria: SubCategoria): SubCategoria {
        val subCategoriaEntity = subCategoriaRepository.getById(id)
        val subCategoriaUpdated = subCategoriaRepository.save(subCategoriaEntity.copy(nome = subCategoria.nome))
        return subCategoriaUpdated.toSubCategoria()
    }
}