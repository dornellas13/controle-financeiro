package usecases.repositories

import adapters.entities.CategoriaEntity

interface ICategoriaRepository {
    fun save(categoria: CategoriaEntity): CategoriaEntity
    fun getById(id: Int): CategoriaEntity
    fun getByNome(nome: String): CategoriaEntity?
    fun findAll(): List<CategoriaEntity>
    fun findAllByNome(nome: String): List<CategoriaEntity>
    fun deleteById(id: Int): Boolean
}