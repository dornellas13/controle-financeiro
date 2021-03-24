package adapters.repositories

import adapters.entities.CategoriaEntity
import adapters.entities.LancamentoEntity
import adapters.entities.SubCategoriaEntity
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import usecases.repositories.ILancamentoRepository
import java.util.*

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

    override fun findAll(dataInicial: Date?, dataFinal: Date?, categoriaId: Int?): List<LancamentoEntity> {
        val findByCategoriaId = LancamentoEntity(
            id = null,
            valor= null,
            comentario = null,
            data = null,
            subcategoria = SubCategoriaEntity(
                id = null,
                nome = null,
                categoria = CategoriaEntity(
                    id = categoriaId,
                    nome = null
                )
            )
        )

        val matcher = ExampleMatcher
            .matching()
            .withIgnoreNullValues()

        return this.lancamentoRepository.findAll(Example.of(findByCategoriaId, matcher))
    }


    override fun deleteById(id: Int) {
        return this.lancamentoRepository.deleteById(id)
    }

}