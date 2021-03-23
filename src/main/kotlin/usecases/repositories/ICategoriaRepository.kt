package usecases.repositories

import adapters.entities.CategoriaEntity

interface ICategoriaRepository {
    fun save(product: CategoriaEntity): CategoriaEntity
}