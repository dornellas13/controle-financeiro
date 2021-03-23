package frameworks.IoC

import adapters.repositories.CategoriaRepository
import adapters.entities.CategoriaEntity
import adapters.repositories.CategoriaJpaRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.JpaRepository
import usecases.categorias.CriarCategoriaUseCase

@Configuration
@ComponentScan("adapters.config", "usecases.config")
class IoC { }