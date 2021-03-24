package usecases.subcategorias
import org.springframework.stereotype.Component
import usecases.repositories.ISubCategoriaRepository

@Component
class ExcluirSubCategoriaUseCase(private val subCategoriaRepository: ISubCategoriaRepository) {
    fun run (id: Int) {
        return subCategoriaRepository.deleteById(id)
    }
}