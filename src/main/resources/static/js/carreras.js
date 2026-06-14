function cargarCarreras(){

    $.get('/api/carreras',function(data){

        tabla.clear();

        tabla.rows.add(data);

        tabla.draw();

    });

}

function guardarCarrera(){

    let carrera = {

        clave:$("#clave").val(),
        nombre:$("#nombre").val(),
        descripcion:$("#descripcion").val()

    };

    $.ajax({

        url:'/api/carreras',
        method:'POST',
        contentType:'application/json',
        data:JSON.stringify(carrera),

        success:function(){

            $('#modalCarrera').modal('hide');

            cargarCarreras();

        }

    });

}

let tabla;

$(document).ready(function () {

    inicializarTabla();

    cargarCarreras();

    $("#btnGuardar").click(function () {

        let id = $("#id").val();

        if (id === "") {

            guardarCarrera();

        } else {

            actualizarCarrera(id);

        }

    });

});

function inicializarTabla() {

    tabla = $("#tablaCarreras").DataTable({

        columns: [

            {data: "id"},
            {data: "clave"},
            {data: "nombre"},
            {data: "descripcion"},

            {
                data: null,

                render: function (data) {

                    return `

                    <button
                        class="btn btn-warning btn-sm"
                        onclick="editarCarrera(${data.id})">

                        <i class="fas fa-edit"></i>

                    </button>

                    <button
                        class="btn btn-danger btn-sm"
                        onclick="eliminarCarrera(${data.id})">

                        <i class="fas fa-trash"></i>

                    </button>

                    `;

                }
            }

        ],

        language: {

            url: "//cdn.datatables.net/plug-ins/1.13.7/i18n/es-ES.json"

        }

    });

}

function cargarCarreras() {

    $.ajax({

        url: "/api/carreras",

        method: "GET",

        success: function (data) {

            tabla.clear();

            tabla.rows.add(data);

            tabla.draw();

        },

        error: function () {

            Swal.fire(
                "Error",
                "No se pudieron cargar las carreras",
                "error"
            );

        }

    });

}

function nuevoRegistro() {

    limpiarFormulario();

    $("#tituloModal").text(
        "Nueva Carrera"
    );

    $("#modalCarrera").modal("show");

}

function limpiarFormulario() {

    $("#id").val("");

    $("#clave").val("");

    $("#nombre").val("");

    $("#descripcion").val("");

}

function guardarCarrera() {

    let carrera = {

        clave: $("#clave").val(),

        nombre: $("#nombre").val(),

        descripcion: $("#descripcion").val()

    };

    $.ajax({

        url: "/api/carreras",

        method: "POST",

        contentType: "application/json",

        data: JSON.stringify(carrera),

        success: function () {

            $("#modalCarrera").modal("hide");

            cargarCarreras();

            Swal.fire(
                "Correcto",
                "Carrera registrada",
                "success"
            );

        },

        error: function () {

            Swal.fire(
                "Error",
                "No fue posible guardar",
                "error"
            );

        }

    });

}

function editarCarrera(id) {

    $.ajax({

        url: "/api/carreras/" + id,

        method: "GET",

        success: function (carrera) {

            $("#id").val(carrera.id);

            $("#clave").val(carrera.clave);

            $("#nombre").val(carrera.nombre);

            $("#descripcion").val(
                carrera.descripcion
            );

            $("#tituloModal").text(
                "Editar Carrera"
            );

            $("#modalCarrera").modal("show");

        }

    });

}

function actualizarCarrera(id) {

    let carrera = {

        clave: $("#clave").val(),

        nombre: $("#nombre").val(),

        descripcion: $("#descripcion").val()

    };

    $.ajax({

        url: "/api/carreras/" + id,

        method: "PUT",

        contentType: "application/json",

        data: JSON.stringify(carrera),

        success: function () {

            $("#modalCarrera").modal("hide");

            cargarCarreras();

            Swal.fire(
                "Actualizado",
                "Registro actualizado",
                "success"
            );

        },

        error: function () {

            Swal.fire(
                "Error",
                "No se pudo actualizar",
                "error"
            );

        }

    });

}

function eliminarCarrera(id) {

    Swal.fire({

        title: "¿Eliminar?",

        text: "Esta acción no se puede deshacer",

        icon: "warning",

        showCancelButton: true,

        confirmButtonText: "Eliminar"

    }).then((result) => {

        if (result.isConfirmed) {

            $.ajax({

                url: "/api/carreras/" + id,

                method: "DELETE",

                success: function () {

                    cargarCarreras();

                    Swal.fire(
                        "Eliminado",
                        "Registro eliminado",
                        "success"
                    );

                },

                error: function () {

                    Swal.fire(
                        "Error",
                        "No se pudo eliminar",
                        "error"
                    );

                }

            });

        }

    });

}