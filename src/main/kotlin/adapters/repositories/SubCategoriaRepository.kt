package adapters.repositories

import adapters.entities.SubCategoriaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import usecases.repositories.ISubCategoriaRepository

@Repository
interface ISubCategoriaJpaRepository: JpaRepository<SubCategoriaEntity, Int>

open class SubCategoriaRepository(private val subCategoriaRepository: ISubCategoriaJpaRepository) : ISubCategoriaRepository {
    override fun save(subCategoria: SubCategoriaEntity): SubCategoriaEntity {
        return this.subCategoriaRepository.save(subCategoria)
    }

    override fun getById(id: Int): SubCategoriaEntity {
        return this.subCategoriaRepository.getById(id)
    }

    override fun findAll(): List<SubCategoriaEntity> {
        return this.subCategoriaRepository.findAll()
    }

    override fun deleteById(id: Int) {
        return this.subCategoriaRepository.deleteById(id)
    }

}