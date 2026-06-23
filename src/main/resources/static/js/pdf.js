function generarPdf(id){

    let url = "/api/pdf/alumno/" + id;

    $("#pdfViewer").attr("src", url);

    $("#btnDescargarPdf").attr("href", url);

    $("#modalPdf").modal("show");
}