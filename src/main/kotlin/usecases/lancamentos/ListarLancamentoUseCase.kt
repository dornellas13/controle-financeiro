package usecases.lancamentos

import adapters.entities.toLancamento
import domains.Lancamento
import org.springframework.stereotype.Component
import usecases.repositories.ILancamentoRepository

@Component
class ListarLancamentoUseCase(private val lancamentoRepository: ILancamentoRepository) {
    fun run (): List<Lancamento> {
        return lancamentoRepository.findAll().map {
            it.toLancamento()
        }.orEmpty()
    }
}