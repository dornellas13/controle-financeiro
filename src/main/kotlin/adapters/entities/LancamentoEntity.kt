package adapters.entities

import domains.Lancamento
import domains.SubCategoria
import javax.persistence.*

@Entity
@Table(name = "lancamentos")
data class LancamentoEntity(
    @Id
    @GeneratedValue
    val id: Int = 0
)

fun LancamentoEntity.toLancamento() =
    Lancamento(
        id = this.id
    )

fun Lancamento.toLancamentoEntity() =
    LancamentoEntity(
        id = this.id
    )