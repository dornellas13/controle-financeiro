package usecases.lancamentos

import adapters.entities.toCategoria
import domains.Balanco
import org.springframework.stereotype.Component
import usecases.repositories.ILancamentoRepository
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

@Component
class CalcularBalancoUseCase(private val lancamentoRepository: ILancamentoRepository) {
    fun run (dataInicial: LocalDate? = null, dataFinal: LocalDate? = null, categoriaId: Int? = null): Balanco? {
        val dataInicialDate = if(dataInicial != null) Date.from(dataInicial.atStartOfDay(ZoneId.systemDefault()).toInstant()) else null
        val dataFinalDate = if(dataFinal != null) Date.from(dataFinal.atStartOfDay(ZoneId.systemDefault()).toInstant()) else null

        val lancamentos = lancamentoRepository.findAll(dataInicialDate, dataFinalDate, categoriaId)
        if (lancamentos.isEmpty()) return null else {
            val receita = lancamentos
                .asSequence()
                .filter {
                    it.valor!! >= 0
                }.sumByDouble {
                    it.valor!!
                }

            val despesa = lancamentos
                .asSequence()
                .filter {
                    it.valor!! < 0
                }.sumByDouble {
                    it.valor!!
                }

            val saldo = (receita - (despesa * -1))

            return Balanco(
                categoria = if(categoriaId != null) lancamentos.firstOrNull()?.subcategoria!!.categoria!!.toCategoria() else null,
                saldo = saldo,
                receita = receita,
                despesa = despesa
            )
        }


    }
}