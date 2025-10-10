# WebUITesting Selenium – Local & Docker Setup

Proyecto listo para ejecutar **frontend + backend** y correr **tests UI (Selenium)**, replicando el entorno del desafío.

## Estructura
```
WebUITesting/selenium/
├─ website/                # index.html, styles.css, script.js, responsive.html
├─ src/
│  ├─ main/java/com/hackerearth/fullstack/backend/
│  │  ├─ BackendApplication.java
│  │  ├─ JettyServer.java
│  │  └─ Result.java
│  └─ test/java/com/hackerearth/fullstack/backend/sample/
│     └─ sampleTest.java
├─ nginx/nginx.conf
├─ Dockerfile.backend
├─ Dockerfile.frontend
├─ docker-compose.yml
├─ pom.xml
├─ install.sh
└─ Makefile
```

## Requisitos locales
- **Java JDK 8+** (el `pom.xml` usa `1.8`).  
- **Google Chrome** (los tests usan ChromeDriver vía WebDriverManager).  
- **Maven** _no es necesario_ (incluye wrapper), pero puedes usarlo si ya lo tienes.

## 1) Ejecutar backend (Spring Boot)
```bash
# Linux/macOS
chmod +x mvnw
./mvnw clean package -DskipTests
./mvnw spring-boot:run

# Windows
mvnw.cmd clean package -DskipTests
mvnw.cmd spring-boot:run
```
Backend disponible (si lo usas) en `http://localhost:8080`.

> Nota: Los tests **no requieren** el backend arriba; el `sampleTest` levanta un `JettyServer` que sirve `website/`.

## 2) Ejecutar frontend
Abre `website/index.html` en el navegador **o** sirvelo con un servidor estático si prefieres:
```bash
npx serve website
# o
npx http-server website
```

## 3) Correr los tests (Selenium)
```bash
# Linux/macOS
./mvnw test -Dtest=sampleTest

# Windows
mvnw.cmd test -Dtest=sampleTest
```
El test:
- Descarga el ChromeDriver correcto con WebDriverManager.
- Levanta `JettyServer` en `http://localhost:8080` sirviendo la carpeta `website/`.
- Verifica el título “User Data” y otras interacciones si agregas más asserts.

## 4) Docker (frontend+backend)
Construir y levantar:
```bash
docker compose build
docker compose up
```
- Frontend: `http://localhost:3000`  
- Backend: `http://localhost:8080`

> El `nginx.conf` enruta `/api/` al `backend`. Tu `script.js` ahora mismo consume `https://jsonplaceholder.typicode.com/users`; puedes mantenerlo así o cambiarlo a `/api/...` cuando tengas endpoints.

## 5) Notas importantes
- Asegúrate de que en `index.html` los archivos se llamen **`styles.css`** y **`script.js`** (ya están así aquí).
- Si quieres ejecutar Chrome dentro de contenedor para tests, debes cambiar `ChromeDriver` por `RemoteWebDriver` y agregar un servicio Selenium en `docker-compose`.

## Comandos rápidos
```bash
# build sin tests
./mvnw -q clean package -DskipTests

# tests
./mvnw -q test -Dtest=sampleTest
```

¡Listo! Cualquier duda o si quieres agregar endpoints REST y validar desde el frontend con `/api`, te preparo el controlador en Spring Boot y los tests extra.
