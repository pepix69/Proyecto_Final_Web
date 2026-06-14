function cargarAlumnos(){

    $.get('/api/alumnos',function(data){

        tabla.clear();

        tabla.rows.add(data);

        tabla.draw();

    });

}

function guardarAlumno(){

    let alumno = {

        matricula:$("#matricula").val(),
        nombre:$("#nombre").val(),
        apellidoPaterno:$("#apellidoPaterno").val(),
        apellidoMaterno:$("#apellidoMaterno").val(),
        correo:$("#correo").val(),
        telefono:$("#telefono").val(),
        direccion:$("#direccion").val(),
        carreraId:$("#carreraId").val()

    };

    $.ajax({

        url:'/api/alumnos',
        method:'POST',
        contentType:'application/json',
        data:JSON.stringify(alumno),

        success:function(){

            $('#modalAlumno').modal('hide');

            cargarAlumnos();

        }

    });

}

let tablaAlumnos;

$(document).ready(function () {

    cargarCarreras();

    inicializarTabla();

    cargarAlumnos();

    $("#btnGuardarAlumno").click(function () {

        let id = $("#idAlumno").val();

        if(id === ""){

            guardarAlumno();

        }else{

            actualizarAlumno(id);

        }

    });

});

function inicializarTabla(){

    tablaAlumnos = $("#tablaAlumnos").DataTable({

        columns:[

            {data:"id"},
            {data:"matricula"},

            {
                data:null,
                render:function(data){

                    return data.nombre +
                        " " +
                        data.apellidoPaterno +
                        " " +
                        data.apellidoMaterno;

                }
            },

            {data:"correo"},
            {data:"telefono"},
            {data:"carreraId"},

            {
                data:null,

                render:function(data){

                    return `

                    <button
                      class="btn btn-warning btn-sm"
                      onclick="editarAlumno(${data.id})">

                      <i class="fas fa-edit"></i>

                    </button>

                    <button
                      class="btn btn-danger btn-sm"
                      onclick="eliminarAlumno(${data.id})">

                      <i class="fas fa-trash"></i>

                    </button>

                    <button
                      class="btn btn-info btn-sm"
                      onclick="generarPdf(${data.id})">

                      <i class="fas fa-file-pdf"></i>

                    </button>

                    <button
                      class="btn btn-success btn-sm"
                      onclick="abrirCorreo(${data.id})">

                      <i class="fas fa-envelope"></i>

                    </button>

                    `;

                }
            }

        ]

    });

}

function cargarCarreras(){

    $.get("/api/carreras", function(data){

        $("#carreraId").empty();

        data.forEach(c => {

            $("#carreraId").append(

                `<option value="${c.id}">
                    ${c.nombre}
                 </option>`

            );

        });

    });

}

function cargarAlumnos(){

    $.get("/api/alumnos", function(data){

        tablaAlumnos.clear();

        tablaAlumnos.rows.add(data);

        tablaAlumnos.draw();

    });

}

function nuevoAlumno(){

    $("#idAlumno").val("");

    $("input").val("");

    $("textarea").val("");

    $("#tituloAlumno").text(
        "Nuevo Alumno"
    );

    $("#modalAlumno").modal("show");

}

function guardarAlumno(){

    let alumno = {

        matricula:$("#matricula").val(),
        nombre:$("#nombre").val(),
        apellidoPaterno:$("#apellidoPaterno").val(),
        apellidoMaterno:$("#apellidoMaterno").val(),
        correo:$("#correo").val(),
        telefono:$("#telefono").val(),
        fechaNacimiento:$("#fechaNacimiento").val(),
        direccion:$("#direccion").val(),
        carreraId:$("#carreraId").val()

    };

    $.ajax({

        url:"/api/alumnos",

        method:"POST",

        contentType:"application/json",

        data:JSON.stringify(alumno),

        success:function(){

            $("#modalAlumno").modal("hide");

            cargarAlumnos();

            Swal.fire(
                "Correcto",
                "Alumno guardado",
                "success"
            );

        }

    });

}

function editarAlumno(id){

    $.get("/api/alumnos/"+id,function(a){

        $("#idAlumno").val(a.id);
        $("#matricula").val(a.matricula);
        $("#nombre").val(a.nombre);
        $("#apellidoPaterno").val(a.apellidoPaterno);
        $("#apellidoMaterno").val(a.apellidoMaterno);
        $("#correo").val(a.correo);
        $("#telefono").val(a.telefono);
        $("#fechaNacimiento").val(a.fechaNacimiento);
        $("#direccion").val(a.direccion);
        $("#carreraId").val(a.carreraId);

        $("#modalAlumno").modal("show");

    });

}

function actualizarAlumno(id){

    let alumno = {

        matricula:$("#matricula").val(),
        nombre:$("#nombre").val(),
        apellidoPaterno:$("#apellidoPaterno").val(),
        apellidoMaterno:$("#apellidoMaterno").val(),
        correo:$("#correo").val(),
        telefono:$("#telefono").val(),
        fechaNacimiento:$("#fechaNacimiento").val(),
        direccion:$("#direccion").val(),
        carreraId:$("#carreraId").val()

    };

    $.ajax({

        url:"/api/alumnos/"+id,

        method:"PUT",

        contentType:"application/json",

        data:JSON.stringify(alumno),

        success:function(){

            $("#modalAlumno").modal("hide");

            cargarAlumnos();

            Swal.fire(
                "Actualizado",
                "Alumno actualizado",
                "success"
            );

        }

    });

}

function eliminarAlumno(id){

    Swal.fire({

        title:"¿Eliminar alumno?",

        icon:"warning",

        showCancelButton:true

    }).then((r)=>{

        if(r.isConfirmed){

            $.ajax({

                url:"/api/alumnos/"+id,

                method:"DELETE",

                success:function(){

                    cargarAlumnos();

                }

            });

        }

    });

}

