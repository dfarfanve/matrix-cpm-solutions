# Matrix CPM Solutions — Descarga

Servicio web (Spring Boot 1.4.3, Java 8, Maven) de Matrix CPM Solutions para la
gestión de descargas de usuarios y cadenas, con integración a Provecomer
(ETL con Kettle y scraping).

Recuperado del respaldo guardado en Google Drive (`com.matrix.respaldo`).

## Estructura

- `src/main/java/com/download/` — aplicación Spring Boot
  - `controller/` — endpoints REST (usuarios, cadenas, descargas)
  - `service/` — lógica de negocio
  - `repository/` — repositorios Spring Data JPA
  - `model/` — entidades (User, Url, DimCadenas, DimClienteCadena, Parameter, Property, Response)
  - `provecomer/` — integración con Provecomer (proceso Kettle, scraping)
  - `component/` — componentes asíncronos de descarga
  - `util/` — utilidades (FTP, HTTP, JSON, XML)
- `src/main/webapp/` — configuración del contexto web
- `des_security.sql`, `des_user.sql` — scripts de base de datos
- `pom.xml` — dependencias Maven (empaqueta como WAR: `Descarga-1.0.war`)

## Compilar

```bash
mvn clean package
```

Requiere JDK 8 y Maven. El WAR resultante se despliega en un servidor
de aplicaciones (Tomcat) bajo el contexto `/Descarga`.
