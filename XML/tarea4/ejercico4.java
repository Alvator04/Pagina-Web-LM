// script.js
fetch('modulo.xml')  // Asegúrate de que el archivo XML se llama modulo.xml y está en la misma carpeta
    .then(response => response.text())
    .then(data => {
        const parser = new DOMParser();
        const xmlDoc = parser.parseFromString(data, "text/xml");
        const alumnos = xmlDoc.getElementsByTagName("alumno");
        const tbody = document.querySelector("#tabla-alumnos tbody");

        for (let alumno of alumnos) {
            const nombre = alumno.getElementsByTagName("nombre")[0].textContent;
            const apellido1 = alumno.getElementsByTagName("apellido_1")[0].textContent;
            const apellido2 = alumno.getElementsByTagName("apellido_2")[0]?.textContent || "";
            const nif = alumno.getElementsByTagName("nif")[0].textContent;
            const telefono = alumno.getElementsByTagName("telefono")[0].textContent;
            const email = alumno.getElementsByTagName("email")[0].textContent;
            const direccion = alumno.getElementsByTagName("direccion")[0];
            const calle = direccion.getElementsByTagName("calle")[0].textContent;
            const numero = direccion.getElementsByTagName("numero")[0].textContent;
            const ciudad = direccion.getElementsByTagName("ciudad")[0].textContent;
            const codigo_postal = direccion.getElementsByTagName("codigo_postal")[0].textContent;
            const faltas_asistencias = alumno.getElementsByTagName("faltas_asistencias")[0].textContent;
            const nota = alumno.getElementsByTagName("nota")[0].textContent;

            const row = `<tr>
                            <td>${nombre}</td>
                            <td>${apellido1}</td>
                            <td>${apellido2}</td>
                            <td>${nif}</td>
                            <td>${telefono}</td>
                            <td>${email}</td>
                            <td>${calle}</td>
                            <td>${numero}</td>
                            <td>${ciudad}</td>
                            <td>${codigo_postal}</td>
                            <td>${faltas_asistencias}</td>
                            <td>${nota}</td>
                         </tr>`;
            tbody.innerHTML += row;
        }
    })
    .catch(error => console.error("Error al cargar el XML:", error));
