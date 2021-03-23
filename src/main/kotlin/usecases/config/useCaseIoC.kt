package usecases.config

import adapters.repositories.CategoriaJpaRepository
import adapters.repositories.CategoriaRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan("usecases.categorias")
class UseCaseIoC {

}