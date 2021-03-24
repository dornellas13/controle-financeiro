package adapters.repositories

import adapters.entities.LancamentoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import usecases.repositories.ILancamentoRepository

@Repository
interface ILancamentoJpaRepository: JpaRepository<LancamentoEntity, Int>

open class LancamentoRepository(private val lancamentoRepository: ILancamentoJpaRepository) : ILancamentoRepository {
    override fun save(lancamento: LancamentoEntity): LancamentoEntity {
        return this.lancamentoRepository.save(lancamento)
    }

    override fun getById(id: Int): LancamentoEntity {
        return this.lancamentoRepository.getById(id)
    }

    override fun findAll(): List<LancamentoEntity> {
        return this.lancamentoRepository.findAll()
    }

    override fun deleteById(id: Int) {
        return this.lancamentoRepository.deleteById(id)
    }

}