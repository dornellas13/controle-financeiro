package usecases.repositories

import adapters.entities.SubCategoriaEntity

interface ISubCategoriaRepository {
    fun save(subCategoria: SubCategoriaEntity): SubCategoriaEntity
    fun getById(id: Int): SubCategoriaEntity
    fun findAll(): List<SubCategoriaEntity>
    fun findAllByNome(nome: String): List<SubCategoriaEntity>
    fun deleteById(id: Int)
}