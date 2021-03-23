package usecases.repositories

import adapters.entities.CategoriaEntity
import java.util.*

interface ICategoriaRepository {
    fun save(product: CategoriaEntity): CategoriaEntity
    fun findById(id: Int): Optional<CategoriaEntity>
    fun getById(id: Int): CategoriaEntity
    fun findAll(): List<CategoriaEntity>
    fun deleteById(id: Int)
}