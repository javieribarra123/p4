async function añadirRaza() {
    const form1 = document.querySelector("#form-post");
    const nombre = form1.querySelector("input[name='nombre']").value;
    const tamaño = form1.querySelector("input[name='tamaño']").value;
    const altura = form1.querySelector("input[name='altura']").value;
    const peso = form1.querySelector("input[name='peso']").value;

    try {
        const response = await fetch("http://localhost:8080/api/razas", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({nombre, tamaño, altura, peso}),
        });

        if (response.ok) {
            alert("Raza agregada correctamente");
        } else {
            alert("Error al agregar la raza");
        }
    } catch (error) {
        console.error("Error:", error);
        alert("Hubo un problema al conectar con el servidor");
    }
}

async function modificarRaza() {
    const form2 = document.querySelector("#form-put");
    const nombre = form2.querySelector("input[name='nombre']").value;
    const tamaño = form2.querySelector("input[name='tamaño']").value;
    const altura = form2.querySelector("input[name='altura']").value;
    const peso = form2.querySelector("input[name='peso']").value;

    try {
        const response = await fetch(`http://localhost:8080/api/razas/${nombre}/tamaño/${tamaño}/altura/${altura}/peso/${peso}`, {
            method: "PUT",
        });

        if (response.ok) {
            alert("Raza modificada correctamente");
        } else {
            alert("Error al modificar la raza");
        }
    } catch (error) {
        console.error("Error:", error);
        alert("Hubo un problema al conectar con el servidor");
    }
}

async function eliminarRaza() {
    const form3 = document.querySelector("#form-delete");
    const nombre = form3.querySelector("input[name='nombre']").value;

    try {
        const response = await fetch(`http://localhost:8080/api/razas/${nombre}`, {
            method: "DELETE",
        });

        if (response.ok) {
            alert("Raza eliminada correctamente");
        } else {
            alert("Error al eliminar la raza");
        }
    } catch (error) {
        console.error("Error:", error);
        alert("Hubo un problema al conectar con el servidor");
    }
}
