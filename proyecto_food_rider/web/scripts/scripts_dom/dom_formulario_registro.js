/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

document.addEventListener("DOMContentLoaded", () => {

    const tipoDiv = document.getElementById('usuario');

    let tipoRegistro = tipoDiv.dataset.nombre;

    const formulario = document.getElementById("formulario_registro");

    if (!tipoRegistro)
        return;

    switch (tipoRegistro) {
        case "Rider":
            // Ocultar campos no necesarios
            document.getElementById("nombre_empresa_proveedora").parentElement.style.display = "none";
            document.getElementById("cif").parentElement.style.display = "none";
            document.getElementById("direccion").parentElement.style.display = "none";
            document.getElementById("especialidad").parentElement.style.display = "none";

            // Eliminar los atributos "required" de los campos ocultos
            document.getElementById("nombre_empresa_proveedora").removeAttribute("required");
            document.getElementById("cif").removeAttribute("required");
            document.getElementById("direccion").removeAttribute("required");
            document.getElementById("especialidad").removeAttribute("required");
            break;

        case "Comprador":
            // Ocultar campos no necesarios
            document.getElementById("nombre_empresa_proveedora").parentElement.style.display = "none";
            document.getElementById("cif").parentElement.style.display = "none";
            document.getElementById("direccion").parentElement.style.display = "none";
            document.getElementById("especialidad").parentElement.style.display = "none";

            // Eliminar los atributos "required" de los campos ocultos
            document.getElementById("nombre_empresa_proveedora").removeAttribute("required");
            document.getElementById("cif").removeAttribute("required");
            document.getElementById("direccion").removeAttribute("required");
            document.getElementById("especialidad").removeAttribute("required");
            break;

        case "Administrador":
            // Ocultar campos no necesarios
            document.getElementById("nombre_empresa_proveedora").parentElement.style.display = "none";
            document.getElementById("cif").parentElement.style.display = "none";
            document.getElementById("direccion").parentElement.style.display = "none";
            document.getElementById("especialidad").parentElement.style.display = "none";

            // Eliminar los atributos "required" de los campos ocultos
            document.getElementById("nombre_empresa_proveedora").removeAttribute("required");
            document.getElementById("cif").removeAttribute("required");
            document.getElementById("direccion").removeAttribute("required");
            document.getElementById("especialidad").removeAttribute("required");
            break;

        case "Proveedor":
            // Ocultar campos no necesarios
            document.getElementById("dni").parentElement.style.display = "none";
            document.getElementById("nss").parentElement.style.display = "none";
            document.getElementById("nombre").parentElement.style.display = "none";
            document.getElementById("primer_apellido").parentElement.style.display = "none";
            document.getElementById("segundo_apellido").parentElement.style.display = "none";
            document.getElementById("contrasenia").parentElement.style.display = "none";
            document.getElementById("nick").parentElement.style.display = "none";

            // Eliminar los atributos "required" de los campos ocultos
            document.getElementById("nick").removeAttribute("required");
            document.getElementById("contrasenia").removeAttribute("required");
            document.getElementById("dni").removeAttribute("required");
            document.getElementById("nss").removeAttribute("required");
            document.getElementById("nombre").removeAttribute("required");
            document.getElementById("primer_apellido").removeAttribute("required");
            break;

        default:
            // Ya viene por defecto con action a ServletRegistroEmpresaCliente
            break;
    }
});
