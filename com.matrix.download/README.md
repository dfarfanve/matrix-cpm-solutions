# com.matrix.download — Descarga

Servicio web (Spring Boot 1.4.3, Java 8, Maven) de Matrix CPM Solutions para la
gestión de descargas de usuarios y cadenas, con integración a Provecomer
(scraping) y base de datos MySQL (`des_security`).

Recuperado del respaldo guardado en Google Drive (`#Ejemplos/Descargas`).
Antes versionado en GitLab (`danielfarfan87/Descarga`).

## Estructura

- `src/main/java/com/matrix/download/` — aplicación Spring Boot
  - `controller/` — endpoints REST (usuarios, cadenas, descargas de archivos)
  - `services/` — lógica de negocio
  - `clientchain/`, `user/` — repositorios y servicios por dominio
  - `model/` — entidades (User, ClientChain, UrlParam)
  - `util/` — utilidades (HTTP, JSON, cifrado, temporizadores)
- `src/main/java/com/matrix/scrapping/` — integración con Provecomer (scraping)
- `src/main/java/com/matrix/sql/` — scripts de base de datos
- `src/main/resources/` — configuración (`application.properties`, puerto 8090)
- `src/test/` — pruebas
- `pom.xml` — dependencias Maven (empaqueta como WAR: `Descarga-1.0.war`)

## Compilar

```bash
mvn clean package
```

Requiere JDK 8 y Maven. El WAR resultante se despliega en un servidor
de aplicaciones (Tomcat). La base de datos es MySQL (`des_security` en
`localhost:3306`); revisa `src/main/resources/application.properties`
antes de ejecutar.
