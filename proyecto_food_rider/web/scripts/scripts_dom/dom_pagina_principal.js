/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
document.addEventListener("DOMContentLoaded", () => {
    const tipo = document.body.dataset.tipo;

    //const formulario = document.getElementById("formulario_registro");

    // Ocultamos todas las secciones
    document.getElementById("boton_cerrar_sesion").style.display = "none";
    document.getElementById("boton_registro_rider").style.display = "none";
    document.getElementById("boton_registro_comprador").style.display = "none";
    document.getElementById("boton_registro_administrador").style.display = "none";
    document.getElementById("boton_registro_proveedor").style.display = "none";
    document.getElementById("boton_clientes").style.display = "none";
    document.getElementById("boton_riders").style.display = "none";
    document.getElementById("boton_compradores").style.display = "none";
    document.getElementById("boton_socios").style.display = "none";
    document.getElementById("boton_ruta_pendiente").style.display = "none";
    document.getElementById("boton_administracion_rutas").style.display = "none";
    document.getElementById("boton_historico_rutas").style.display = "none";
    document.getElementById("boton_productos_frecuentes").style.display = "none";
    document.getElementById("boton_almacen").style.display = "none";
    document.getElementById("boton_incidencias").style.display = "none";
    document.getElementById("boton_historico_incidencia").style.display = "none";
    document.getElementById("boton_estadisticas").style.display = "none";
    document.getElementById("boton_ruta_sugerida").style.display = "none";
    document.getElementById("boton_solicitudes").style.display = "none";
    document.getElementById("boton_contabilidad").style.display = "none";

    // Mostramos en función del tipo de usuario
    switch (tipo) {
        case "Administrador":
            document.getElementById("boton_cerrar_sesion").style.display = "block";
            document.getElementById("boton_registro_rider").style.display = "block";
            document.getElementById("boton_registro_comprador").style.display = "block";
            document.getElementById("boton_registro_administrador").style.display = "block";
            document.getElementById("boton_registro_proveedor").style.display = "block";
            document.getElementById("boton_proveedor").style.display = "block";
            document.getElementById("boton_clientes").style.display = "block";
            document.getElementById("boton_riders").style.display = "block";
            document.getElementById("boton_compradores").style.display = "block";
            document.getElementById("boton_socios").style.display = "block";
            document.getElementById("boton_administracion_rutas").style.display = "block";
            document.getElementById("boton_historico_rutas").style.display = "block";
            document.getElementById("boton_productos_frecuentes").style.display = "block";
            document.getElementById("boton_almacen").style.display = "block";
            document.getElementById("boton_incidencias").style.display = "block";
            document.getElementById("boton_historico_incidencia").style.display = "block";
            document.getElementById("boton_estadisticas").style.display = "block";
            document.getElementById("boton_solicitudes").style.display = "block";
            document.getElementById("boton_contabilidad").style.display = "block";
            break;

        case "Comprador":
            document.getElementById("boton_cerrar_sesion").style.display = "block";
            document.getElementById("boton_ruta_pendiente").style.display = "block";
            document.getElementById("boton_administracion_rutas").style.display = "block";
            document.getElementById("boton_historico_rutas").style.display = "block";
            document.getElementById("boton_productos_frecuentes").style.display = "block";
            document.getElementById("boton_almacen").style.display = "block";
            document.getElementById("boton_incidencias").style.display = "block";
            document.getElementById("boton_historico_incidencia").style.display = "block";
            document.getElementById("boton_ruta_sugerida").style.display = "block";
            break;

        case "Rider":
            document.getElementById("boton_cerrar_sesion").style.display = "block";
            document.getElementById("boton_ruta_pendiente").style.display = "block";
            document.getElementById("boton_administracion_rutas").style.display = "block";
            document.getElementById("boton_historico_rutas").style.display = "block";
            document.getElementById("boton_incidencias").style.display = "block";
            document.getElementById("boton_historico_incidencia").style.display = "block";
            document.getElementById("boton_ruta_sugerida").style.display = "block";
            break;

        case "Empresa cliente":
            document.getElementById("boton_cerrar_sesion").style.display = "block";
            document.getElementById("boton_proveedor").style.display = "block";
            document.getElementById("boton_productos_frecuentes").style.display = "block";
            document.getElementById("boton_almacen").style.display = "block";
            document.getElementById("boton_incidencias").style.display = "block";
            document.getElementById("boton_historico_incidencia").style.display = "block";
            break;
    }
});