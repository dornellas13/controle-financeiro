package domains

data class Balanco(
    val categoria: Categoria? = null,
    val saldo: Double,
    val receita: Double,
    val despesa: Double
)