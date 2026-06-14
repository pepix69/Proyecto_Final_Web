function abrirCorreo(id){

    $("#correoAlumnoId").val(id);

    $("#modalCorreo").modal("show");

}

function enviarCorreoIndividual(){

    let data = {

        alumnoId:$("#correoAlumnoId").val(),

        asunto:$("#asuntoCorreo").val(),

        mensaje:$("#mensajeCorreo").val()

    };

    $.ajax({

        url:"/api/correos/individual",

        method:"POST",

        contentType:"application/json",

        data:JSON.stringify(data),

        success:function(){

            $("#modalCorreo").modal("hide");

            Swal.fire(
                "Enviado",
                "Correo enviado",
                "success"
            );

        }

    });

}

function abrirCorreoMasivo(){

    $("#modalMasivo").modal("show");

}

function enviarCorreoMasivo(){

    let data = {

        asunto:$("#asuntoMasivo").val(),

        mensaje:$("#mensajeMasivo").val()

    };

    $.ajax({

        url:"/api/correos/masivo",

        method:"POST",

        contentType:"application/json",

        data:JSON.stringify(data),

        success:function(){

            $("#modalMasivo").modal("hide");

            Swal.fire(
                "Correcto",
                "Correos enviados",
                "success"
            );

        }

    });

}