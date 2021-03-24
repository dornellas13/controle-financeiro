package usecases.lancamentos

import adapters.entities.toLancamento
import domains.Lancamento
import org.springframework.stereotype.Component
import usecases.repositories.ILancamentoRepository

@Component
class AtualizarLancamentoUseCase(private val lancamentoRepository: ILancamentoRepository) {
    fun run (id: Int, lancamento: Lancamento): Lancamento {
        val lancamentoEntity = lancamentoRepository.getById(id)
        val lancamentoUpdated = lancamentoRepository.save(lancamentoEntity.copy(valor = lancamento.valor, data = lancamento.data, comentario = lancamento.comentario))
        return lancamentoUpdated.toLancamento()
    }
}