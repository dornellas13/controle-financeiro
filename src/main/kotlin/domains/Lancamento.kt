package domains

import java.util.*

data class Lancamento(
    val id: Int = 0,
    val valor: Float,
    val data: Date,
    val comentario: String,
    val subcategoria: SubCategoria? = null
)