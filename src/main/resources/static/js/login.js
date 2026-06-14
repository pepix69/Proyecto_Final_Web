$("#btnLogin").click(function(){

    let data = {
        correo: $("#correo").val(),
        password: $("#password").val()
    };

    $.ajax({
        url:'/api/auth/login',
        method:'POST',
        contentType:'application/json',
        data:JSON.stringify(data),

        success:function(){

            window.location.href='/dashboard';

        },

        error:function(){

            Swal.fire(
                'Error',
                'Credenciales inválidas',
                'error'
            );

        }

    });

});