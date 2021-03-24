package usecases.lancamentos

import adapters.entities.toCategoria
import adapters.entities.toCategoriaEntity
import adapters.entities.toLancamento
import adapters.entities.toLancamentoEntity
import domains.Categoria
import domains.Lancamento
import org.springframework.stereotype.Component
import usecases.repositories.ICategoriaRepository
import usecases.repositories.ILancamentoRepository

@Component
class CriarLancamentoUseCase(private val lancamentoRepository: ILancamentoRepository) {
    fun run (lancamento: Lancamento): Lancamento {
        return lancamentoRepository.save(lancamento.toLancamentoEntity()).toLancamento()
    }
}