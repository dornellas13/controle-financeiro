package usecases.repositories

import adapters.entities.LancamentoEntity

interface ILancamentoRepository {
    fun save(lancamento: LancamentoEntity): LancamentoEntity
    fun getById(id: Int): LancamentoEntity
    fun findAll(): List<LancamentoEntity>
    fun deleteById(id: Int)
}