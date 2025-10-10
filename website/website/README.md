# Accessible Todo List — README

> **Transcripción de requisitos (desde las capturas)**
>
> - **HTML Structure**
>   - Create a semantic HTML5 structure
>   - Include `<header>`, `<main>`, and `<footer>` elements
>   - Add `role="main"` to main element
> - **Page Title**
>   - Set the page title to **Accessible Todo List**
> - **Form Components**
>   - Create a todo list form with:
>     - Task input field (id=`task-input`)
>     - Add task button
>     - Error message area (id=`error-message`)
> - **Accessibility Requirements**
>   - Implement ARIA attributes (e.g., `aria-live`, `aria-required`, `aria-describedby`)
> - **JavaScript Functionality**
>   - Implement task addition
>   - Add task deletion
>   - Provide input validation
>   - Manage focus after task operations
> - **CSS Styling**
>   - Use Arial font family
>   - Ensure sufficient color contrast
>   - Use flex or grid for layout
>   - Make the page responsive

---

## Estructura del proyecto

```
website/
├── index.html
├── index.css
└── index.js
```

## Cómo ejecutar **localmente** (paso a paso)

### Opción A: Abrir el archivo directamente
1. Descarga el ZIP desde abajo y descomprímelo.
2. Abre `website/index.html` con doble clic (se abrirá en tu navegador).
3. Prueba:
   - Escribe una tarea y presiona **Enter** o **Add task**.
   - Borra con el botón **Delete** (también funciona `Delete/Backspace` con el botón enfocado).
   - Si envías vacío, verás el error en `#error-message` y `aria-invalid` en el input.

> Nota: Abrir con `file://` es suficiente para esta prueba (no usa AJAX).

### Opción B: Servir con un servidor local (recomendado)
#### Con **Python 3**
```bash
cd website
python -m http.server 8080
# Ahora visita http://localhost:8080 en tu navegador
```

#### Con **Node.js** (http-server)
```bash
npm -g install http-server
cd website
http-server -p 8080
# Visita http://localhost:8080
```

### Opción C: VS Code Live Server
1. Abre la carpeta `website/` en VS Code.
2. Instala la extensión **Live Server**.
3. Clic en **Go Live** y navega a la URL que aparezca.

---

## Notas de accesibilidad implementadas
- `aria-live="polite"` para anuncios en `#sr-status`.
- `role="alert"` y `aria-live="polite"` para `#error-message`.
- `aria-required="true"` y `required` en el input.
- `aria-invalid` dinámico en validación.
- `aria-describedby` conecta el input con la ayuda y el mensaje de error.
- Botones **Delete** con `aria-label` descriptivo.
- Manejo de foco tras agregar y eliminar.

---

## Cómo correr el **sample test** de Selenium localmente (opcional)
> *Solo si quieres replicar el test de título en tu máquina.*

1. Asegúrate de tener **Google Chrome** o **Chromium** instalado.
2. Exporta la ruta del binario si es Chromium:
   - Linux:
     ```bash
     export CHROME_BIN=/usr/bin/chromium-browser
     ```
3. Ejecuta Maven en la carpeta `selenium/` del proyecto original (si cuentas con ella):
   ```bash
   mvn test
   ```
4. El primer test valida que el título sea exactamente **Accessible Todo List**.

---

## Licencia
Uso libre para fines educativos y de evaluación.
