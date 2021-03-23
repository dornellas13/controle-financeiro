package usecases.repositories

import adapters.entities.CategoriaEntity
import java.util.*

interface ICategoriaRepository {
    fun save(categoria: CategoriaEntity): CategoriaEntity
    fun getById(id: Int): CategoriaEntity
    fun findAll(): List<CategoriaEntity>
    fun deleteById(id: Int)
}