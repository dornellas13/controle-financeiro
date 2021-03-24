package adapters.entities

import domains.Lancamento
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "lancamentos")
data class LancamentoEntity(
    @Id
    @GeneratedValue
    val id: Int = 0,

    @Column(nullable = false)
    val valor: Float,

    @Column(nullable = false)
    val data: Date,

    @Column(nullable = false)
    val comentario: String,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subcategoria_id")
    val subcategoria: SubCategoriaEntity? = null
)

fun LancamentoEntity.toLancamento() =
    Lancamento(
        id = this.id,
        valor = this.valor,
        data = this.data,
        comentario = this.comentario
    )

fun Lancamento.toLancamentoEntity() =
    LancamentoEntity(
        id = this.id,
        valor = this.valor,
        data = this.data,
        comentario = this.comentario,
        subcategoria = this.subcategoria!!.toSubCategoriaEntity()
    )