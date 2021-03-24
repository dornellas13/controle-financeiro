package adapters.entities
import domains.SubCategoria
import javax.persistence.*

@Entity @Table(name = "subcategorias")
data class SubCategoriaEntity(
    @Id
    @GeneratedValue
    val id: Int? = 0,

    val nome: String? = "",

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    val categoria: CategoriaEntity? = null,

    @OneToMany(mappedBy = "subcategoria", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
    val lancamentos: List<LancamentoEntity> = emptyList()
    )

fun SubCategoriaEntity.toSubCategoria() =
    SubCategoria(
        id = this.id!!,
        nome = this.nome!!,
        categoria = this.categoria!!.toCategoria()
    )

fun SubCategoria.toSubCategoriaEntity() =
    SubCategoriaEntity(
        id = this.id,
        nome = this.nome,
        categoria = this.categoria!!.toCategoriaEntity()
    )