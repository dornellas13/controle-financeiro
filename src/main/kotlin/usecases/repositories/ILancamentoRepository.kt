package usecases.repositories

import adapters.entities.LancamentoEntity
import java.time.LocalDate
import java.util.*

interface ILancamentoRepository {
    fun save(lancamento: LancamentoEntity): LancamentoEntity
    fun getById(id: Int): LancamentoEntity
    fun findAll(): List<LancamentoEntity>
    fun findAll(dataInicial: Date?, dataFinal: Date?, categoriaId: Int?): List<LancamentoEntity>
    fun deleteById(id: Int)
}