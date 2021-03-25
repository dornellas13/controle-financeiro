package adapters.repositories

import adapters.entities.CategoriaEntity
import adapters.entities.QCategoriaEntity
import adapters.exceptions.ApplicationException
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository
import usecases.repositories.ICategoriaRepository
import javax.persistence.EntityNotFoundException

@Repository
interface ICategoriaJpaRepository: JpaRepository<CategoriaEntity, Int>

open class CategoriaRepository(private val categoriaRepository: ICategoriaJpaRepository) : QuerydslRepositorySupport(CategoriaEntity::class.java), ICategoriaRepository {
    override fun save(categoria: CategoriaEntity): CategoriaEntity {
        this.beforeSave(categoria)
        return this.categoriaRepository.save(categoria)
    }

    override fun getById(id: Int): CategoriaEntity {
        return this.categoriaRepository.getById(id)
    }

    override fun getByNome(nome: String): CategoriaEntity? {
        val categoriaEntity = QCategoriaEntity.categoriaEntity
        return from(categoriaEntity).where(categoriaEntity.nome.eq(nome)).fetchOne()
    }

    override fun findAll(): List<CategoriaEntity> {
        return this.categoriaRepository.findAll()
    }

    override fun findAllByNome(nome: String): List<CategoriaEntity> {
        val categoriaEntity = QCategoriaEntity.categoriaEntity
        return from(categoriaEntity).where(categoriaEntity.nome.like(nome)).fetch()
    }

    override fun deleteById(id: Int) {
        return this.categoriaRepository.deleteById(id)
    }

    private fun beforeSave(categoriaEntity: CategoriaEntity) {
        try {
            return if(this.getByNome(categoriaEntity.nome!!) != null){
                throw ApplicationException("categoria ${categoriaEntity.nome} already exists")
            } else {}
        } catch (exception: EntityNotFoundException) {
            throw exception
        }

    }

}