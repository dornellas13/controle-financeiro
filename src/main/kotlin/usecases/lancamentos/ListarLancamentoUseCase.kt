package usecases.lancamentos

import adapters.entities.toLancamento
import domains.Lancamento
import org.springframework.stereotype.Component
import usecases.repositories.ILancamentoRepository
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

@Component
class ListarLancamentoUseCase(private val lancamentoRepository: ILancamentoRepository) {
    fun run (dataInicial: LocalDate?, dataFinal: LocalDate?): List<Lancamento> {
        val dataInicialDate = if(dataInicial != null) Date.from(dataInicial.atStartOfDay(ZoneId.systemDefault()).toInstant()) else null
        val dataFinalDate = if(dataFinal != null) Date.from(dataFinal.atStartOfDay(ZoneId.systemDefault()).toInstant()) else null
        return lancamentoRepository.findAll(dataInicial = dataInicialDate, dataFinal = dataFinalDate, null).map {
            it.toLancamento()
        }.orEmpty()
    }
}