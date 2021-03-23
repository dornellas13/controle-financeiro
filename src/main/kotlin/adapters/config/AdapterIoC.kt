package adapters.config

import adapters.repositories.CategoriaJpaRepository
import adapters.repositories.CategoriaRepository
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@ComponentScan("adapters.controllers")
@EntityScan("adapters.entities")
@EnableJpaRepositories("adapters.repositories")
class AdapterIoC {
    @Bean
    fun categoriaRepository(db: CategoriaJpaRepository) = CategoriaRepository(db)
}