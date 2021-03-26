package adapters.repositories

import adapters.entities.CategoriaEntity
import adapters.entities.QCategoriaEntity
import adapters.entities.QSubCategoriaEntity
import adapters.entities.SubCategoriaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository
import usecases.repositories.ISubCategoriaRepository

@Repository
interface ISubCategoriaJpaRepository: JpaRepository<SubCategoriaEntity, Int>

open class SubCategoriaRepository(private val subCategoriaRepository: ISubCategoriaJpaRepository) : QuerydslRepositorySupport(
    SubCategoriaEntity::class.java), ISubCategoriaRepository {
    override fun save(subCategoria: SubCategoriaEntity): SubCategoriaEntity {
        return this.subCategoriaRepository.save(subCategoria)
    }

    override fun getById(id: Int): SubCategoriaEntity {
        return this.subCategoriaRepository.getById(id)
    }

    override fun findAll(): List<SubCategoriaEntity> {
        return this.subCategoriaRepository.findAll()
    }

    override fun findAllByNome(nome: String): List<SubCategoriaEntity> {
        val subCategoriaEntity =  QSubCategoriaEntity.subCategoriaEntity
        return from(subCategoriaEntity).where(subCategoriaEntity.nome.like(nome)).fetch()
    }

    override fun deleteById(id: Int) {
        return this.subCategoriaRepository.deleteById(id)
    }

}