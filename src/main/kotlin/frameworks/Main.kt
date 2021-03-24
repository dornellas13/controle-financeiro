package frameworks

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication()
@ComponentScan("frameworks.IoC")
class Main

fun main (args: Array<String>) {
    runApplication<Main>(*args)
}
