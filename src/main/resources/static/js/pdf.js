function generarPdf(id){

    window.open(
        "/api/pdf/alumno/" + id,
        "_blank"
    );

}