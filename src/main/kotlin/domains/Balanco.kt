package domains

data class Balanco(
    val categoria: Categoria? = null,
    val saldo: Double = 0.0,
    val receita: Double = 0.0,
    val despesa: Double = 0.0
)