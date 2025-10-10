// TODO: persist tasks in localStorage si hay tiempo
const $ = (id) => document.getElementById(id);

// Referencias a los elementos del DOM
const form = $("task-form");
const input = $("task-input");
const addBtn = $("add-btn");
const list = $("todo-list");
const err = $("error-message");
const sr = $("sr-status");
const year = $("year");

if (year) year.textContent = new Date().getFullYear();

/** Envía un mensaje a lectores de pantalla (aria-live) */
function speak(msg) {
  if (sr) sr.textContent = msg;
}

/** Validación mínima y accesible */
function isValid() {
  const value = input.value.trim();
  if (!value) {
    err.textContent = "Please enter a task.";
    input.setAttribute("aria-invalid", "true");
    return false;
  }
  err.textContent = "";
  input.removeAttribute("aria-invalid");
  return true;
}

/** Crea un <li> con texto y botón Delete */
function makeItem(text) {
  const li = document.createElement("li");
  li.className = "todo-item";

  const span = document.createElement("span");
  span.className = "todo-text";
  span.textContent = text;

  const del = document.createElement("button");
  del.type = "button";
  del.className = "todo-delete";
  del.textContent = "Delete";
  del.setAttribute("aria-label", `Delete "${text}"`);

  // Eliminar con click o tecla Delete/Backspace
  del.addEventListener("click", () => removeItem(li, del));
  del.addEventListener("keydown", (e) => {
    if (e.key === "Delete" || e.key === "Backspace") {
      e.preventDefault();
      removeItem(li, del);
    }
  });

  li.append(span, del);
  return li;
}

/** Elimina el item y mueve el foco al siguiente botón o al Add */
function removeItem(li, delBtn) {
  const allBtns = Array.from(list.querySelectorAll(".todo-delete"));
  const index = allBtns.indexOf(delBtn);
  const next = allBtns[index + 1] || allBtns[index - 1] || addBtn;

  const name = li.querySelector(".todo-text")?.textContent || "task";
  li.remove();
  speak(`Deleted ${name}.`);
  next?.focus();
}

/** Evento de envío del formulario */
form.addEventListener("submit", (e) => {
  e.preventDefault();
  if (!isValid()) {
    input.focus();
    return;
  }

  const text = input.value.trim();
  list.appendChild(makeItem(text));
  speak(`Added "${text}".`);

  form.reset();
  input.focus();
});

/** Limpia el mensaje de error mientras el usuario escribe */
input.addEventListener("input", () => {
  if (input.value.trim()) {
    err.textContent = "";
    input.removeAttribute("aria-invalid");
  }
});
