package adapters.repositories

import adapters.entities.CategoriaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import usecases.repositories.ICategoriaRepository

@Repository
interface CategoriaJpaRepository: JpaRepository<CategoriaEntity, Int>

open class CategoriaRepository(private val categoriaRepository: CategoriaJpaRepository) : ICategoriaRepository {
    override fun save(product: CategoriaEntity): CategoriaEntity {
        return this.categoriaRepository.save(product)
    }

}