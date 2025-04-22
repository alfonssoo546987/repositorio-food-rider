/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

window.addEventListener('DOMContentLoaded', () => {
    const boton = document.getElementById('btnCambiar');
    const lista = document.getElementById('lista-empleados');
    const campoSalario = document.getElementById('campo-salario');
    const campoProfesion = document.getElementById('campo-profesion');
    const texto = document.getElementById('texto');

    boton.addEventListener('click', (e) => {
        e.preventDefault();

        // Cambiar el texto del encabezado
        if (texto) {
            texto.textContent = 'Listado de Salarios';
        }

        // Mostrar solo el campo de salario
        campoSalario.style.display = 'block';
        campoProfesion.style.display = 'none';

        // Actualizar los items de la lista de empleados para mostrar solo los salarios
        lista.querySelectorAll('li').forEach(item => {
            const salario = item.getAttribute('data-salario');
            item.textContent = `Salario: ${salario} €`;
        });

        // Cambiar el texto del botón
        boton.textContent = '¡Lista actualizada!';

        // Traduce el texto del botón
        const textoActualizado = document.getElementById('texto-actualizado').textContent;
        boton.textContent = textoActualizado;

    });
});