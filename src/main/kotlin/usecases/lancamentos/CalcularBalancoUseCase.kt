package usecases.lancamentos

import adapters.entities.toCategoria
import domains.Balanco
import org.springframework.stereotype.Component
import usecases.repositories.ILancamentoRepository
import java.util.*

@Component
class CalcularBalancoUseCase(private val lancamentoRepository: ILancamentoRepository) {
    fun run (dataInicial: Date? = null, dataFinal: Date? = null, categoriaId: Int? = null): Balanco {
        val lancamentos = lancamentoRepository.findAll(dataInicial, dataFinal, categoriaId)
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
            categoria = categoriaId.let { lancamentos.firstOrNull()?.subcategoria!!.categoria!!.toCategoria() },
            saldo = saldo,
            receita = receita,
            despesa = despesa
        )

    }
}