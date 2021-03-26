package adapters.repositories

import adapters.entities.LancamentoEntity
import adapters.entities.QLancamentoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository
import usecases.repositories.ILancamentoRepository
import java.time.LocalDate
import java.util.*

@Repository
interface ILancamentoJpaRepository: JpaRepository<LancamentoEntity, Int>

open class LancamentoRepository(private val lancamentoRepository: ILancamentoJpaRepository) : QuerydslRepositorySupport(LancamentoEntity::class.java), ILancamentoRepository {
    override fun save(lancamento: LancamentoEntity): LancamentoEntity {
        return this.lancamentoRepository.save(lancamento)
    }

    override fun getById(id: Int): LancamentoEntity {
        return this.lancamentoRepository.getById(id)
    }

    override fun findAll(): List<LancamentoEntity> {
        return this.lancamentoRepository.findAll()
    }

    override fun findAll(dataInicial: Date?, dataFinal: Date?, categoriaId: Int?): List<LancamentoEntity> {
        val lancamentoEntity = QLancamentoEntity.lancamentoEntity
        var lancamentos = from(lancamentoEntity)
        if(categoriaId != null)
        {
            lancamentos = lancamentos.where(lancamentoEntity.subcategoria.categoria.id.eq(categoriaId))
        }
        if(dataInicial != null) {
            lancamentos = lancamentos.where(lancamentoEntity.data.gt(dataInicial))
        }
        if(dataFinal != null) {
            lancamentos = lancamentos.where(lancamentoEntity.data.lt(dataFinal))
        }
        return lancamentos.fetch()
    }


    override fun deleteById(id: Int): Boolean {
        this.lancamentoRepository.deleteById(id)
        return true
    }

}