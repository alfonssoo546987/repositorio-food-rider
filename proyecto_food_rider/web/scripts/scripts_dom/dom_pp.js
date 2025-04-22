/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */


document.addEventListener("DOMContentLoaded", () => {
    const tipo = document.body.dataset.tipo;

    // Ocultamos todas las secciones
    document.getElementById("administrador").style.display = "none";
    document.getElementById("comprador").style.display = "none";
    document.getElementById("rider").style.display = "none";

    // Ocultar todos los botones extra por defecto
    document.getElementById("btn1").style.display = "none";
    document.getElementById("btn2").style.display = "none";
    document.getElementById("btn3").style.display = "none";

    // Mostramos solo la sección correspondiente al tipo de usuario
    if (tipo === "Administrador") {
        document.getElementById("administrador").style.display = "block";
        botonPrincipal.textContent = "Panel de administración";
        document.getElementById("btn1").style.display = "inline-block";
        document.getElementById("btn2").style.display = "inline-block";
        document.getElementById("btn3").style.display = "inline-block";
    } else if (tipo === "Comprador") {
        document.getElementById("comprador").style.display = "block";
        botonPrincipal.textContent = "Panel de compra";
        document.getElementById("btn1").style.display = "inline-block";
        document.getElementById("btn2").style.display = "inline-block";
    } else if (tipo === "Rider") {
        document.getElementById("rider").style.display = "block";
    }
});
