package usecases.subcategorias
import org.springframework.stereotype.Component
import usecases.repositories.ISubCategoriaRepository

@Component
class ExcluirSubCategoriaUseCase(private val subCategoriaRepository: ISubCategoriaRepository) {
    fun run (id: Int): Boolean {
        return subCategoriaRepository.deleteById(id)
    }
}