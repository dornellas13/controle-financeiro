package adapters.repositories

import adapters.entities.CategoriaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import usecases.repositories.ICategoriaRepository
import java.util.*

@Repository
interface CategoriaJpaRepository: JpaRepository<CategoriaEntity, Int>

open class CategoriaRepository(private val categoriaRepository: CategoriaJpaRepository) : ICategoriaRepository {
    override fun save(product: CategoriaEntity): CategoriaEntity {
        return this.categoriaRepository.save(product)
    }

    override fun findById(id: Int): Optional<CategoriaEntity> {
        return this.categoriaRepository.findById(id)
    }

    override fun getById(id: Int): CategoriaEntity {
        return this.categoriaRepository.getById(id)
    }

    override fun findAll(): List<CategoriaEntity> {
        return this.categoriaRepository.findAll()
    }

    override fun deleteById(id: Int) {
        return this.categoriaRepository.deleteById(id)
    }

}