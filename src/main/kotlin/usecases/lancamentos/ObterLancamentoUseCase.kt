package usecases.lancamentos

import adapters.entities.toLancamento
import domains.Lancamento
import org.springframework.stereotype.Component
import usecases.repositories.ILancamentoRepository


@Component
class ObterLancamentoUseCase(private val lancamentoRepository: ILancamentoRepository) {
    fun run (id: Int): Lancamento {
        return lancamentoRepository.getById(id).toLancamento()
    }
}