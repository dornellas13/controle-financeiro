package usecases.lancamentos

import org.springframework.stereotype.Component
import usecases.repositories.ILancamentoRepository

@Component
class ExcluirLancamentoUseCase(private val lancamentoRepository: ILancamentoRepository) {
    fun run (id: Int) {
        return lancamentoRepository.deleteById(id)
    }
}