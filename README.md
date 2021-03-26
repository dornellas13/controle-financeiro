# Financial control software
proof of concept about kotlin and spring boot

## Clean Architecture Concept
[![Clean Architecture](assets/img/clean_architecture.png)](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)


Packages Explanation
- /src/test/kotlin/usecases
    - Tests all use cases
- /src/test/kotlin/controllers
    - Tests all controllers
- /src/main/kotlin/domains:
    - Entities encapsulate Enterprise wide business rules. An entity can be an object with methods, or it can be a set of data structures and functions. It doesn’t matter so long as the entities could be used by many different applications in the enterprise.

      If you don’t have an enterprise, and are just writing a single application, then these entities are the business objects of the application. They encapsulate the most general and high-level rules. They are the least likely to change when something external changes. For example, you would not expect these objects to be affected by a change to page navigation, or security. No operational change to any particular application should affect the entity layer.

- /src/main/kotlin/usecases:
    - The software in this layer contains application specific business rules. It encapsulates and implements all of the use cases of the system. These use cases orchestrate the flow of data to and from the entities, and direct those entities to use their enterprise wide business rules to achieve the goals of the use case.

      We do not expect changes in this layer to affect the entities. We also do not expect this layer to be affected by changes to externalities such as the database, the UI, or any of the common frameworks. This layer is isolated from such concerns.

      We do, however, expect that changes to the operation of the application will affect the use-cases and therefore the software in this layer. If the details of a use-case change, then some code in this layer will certainly be affected.
- /src/main/kotlin/adapters:
    - The software in this layer is a set of adapters that convert data from the format most convenient for the use cases and entities, to the format most convenient for some external agency such as the Database or the Web. It is this layer, for example, that will wholly contain the MVC architecture of a GUI. The Presenters, Views, and Controllers all belong in here. The models are likely just data structures that are passed from the controllers to the use cases, and then back from the use cases to the presenters and views.

      Similarly, data is converted, in this layer, from the form most convenient for entities and use cases, into the form most convenient for whatever persistence framework is being used. i.e. The Database. No code inward of this circle should know anything at all about the database. If the database is a SQL database, then all the SQL should be restricted to this layer, and in particular to the parts of this layer that have to do with the database.

      Also in this layer is any other adapter necessary to convert data from some external form, such as an external service, to the internal form used by the use cases and entities.
- /src/main/kotlin/frameworks:
    - The outermost layer is generally composed of frameworks and tools such as the Database, the Web Framework, etc. Generally you don’t write much code in this layer other than glue code that communicates to the next circle inwards.
      This layer is where all the details go. The Web is a detail. The database is a detail. We keep these things on the outside where they can do little harm.

From ⭐️ [Clean Code Blog](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)

## Technologies👨‍💻
- Kotlin
- Spring Boot
- Docker
- Gradle
- JPA Data
- Swagger
- H2 Database
- Actuator (HealthCheck)
- JUnit5

## Requirements⚠️
- JDK >= 8
- Kotlin
- Gradle >= 5.0
- Docker >= 19

## Build and Run 🚀

```bash
1. gradle build
2. docker build -t controle-financeiro .
3. docker run -dp 8080:8080 controle-financeiro
4. open cmd and copy -> curl http://localhost:8080/actuator/health
5. open swagger http://localhost:8080/swagger-ui.html
```

