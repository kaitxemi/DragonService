# Dragon Service

Pequeñas instrucciones para compilar y configurar Lombok en el proyecto.

Requisitos
- JDK 17
- Maven (opcional si usas el wrapper)

Compilar y ejecutar
- Compilar:

```
mvn clean package
```

- Ejecutar la aplicación:

```
mvn spring-boot:run
```

Lombok
- Lombok está añadido como dependencia en `pom.xml` (scope `provided`). Para que las anotaciones funcionen en tu IDE:

Eclipse:
1. Descarga `lombok.jar` desde https://projectlombok.org/download
2. Ejecuta: `java -jar lombok.jar` y selecciona tu instalación de Eclipse.
3. Reinicia Eclipse.
4. Asegúrate de activar Annotation Processing en: Preferences > Java > Compiler > Annotation Processing > Enable project specific settings (o globalmente).

IntelliJ IDEA:
1. Instala el plugin Lombok (Settings > Plugins > Marketplace).
2. Habilita Annotation Processing: Settings > Build, Execution, Deployment > Compiler > Annotation Processors > Enable annotation processing.

Swagger / OpenAPI
- La dependencia `springdoc-openapi-starter-webmvc-ui` está incluida.
- Swagger UI (por defecto): `http://localhost:8080/swagger-ui/index.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

Si quieres que añada el Maven Wrapper (`mvnw`) o que migre más controladores para usar anotaciones `io.swagger.v3`, dímelo e lo preparo.
