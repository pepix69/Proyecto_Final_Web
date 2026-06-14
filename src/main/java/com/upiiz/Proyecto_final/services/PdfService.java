package com.upiiz.Proyecto_final.services;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import com.upiiz.Proyecto_final.entities.Alumno;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
@RequiredArgsConstructor
public class PdfService {

    private final AlumnoService alumnoService;

    public byte[] generarConstancia(Long alumnoId)
            throws Exception {

        Alumno alumno =
                alumnoService.obtenerPorId(alumnoId);

        ByteArrayOutputStream output =
                new ByteArrayOutputStream();

        Document document =
                new Document(PageSize.A4);

        PdfWriter.getInstance(document, output);

        document.open();

        Font titulo =
                new Font(Font.HELVETICA,
                        18,
                        Font.BOLD);

        Paragraph encabezado =
                new Paragraph(
                        "CONSTANCIA DE INSCRIPCIÓN",
                        titulo);

        encabezado.setAlignment(Element.ALIGN_CENTER);

        document.add(encabezado);

        document.add(new Paragraph(" "));
        document.add(new Paragraph("Alumno: "
                + alumno.getNombre() + " "
                + alumno.getApellidoPaterno() + " "
                + alumno.getApellidoMaterno()));

        document.add(new Paragraph(
                "Matrícula: "
                        + alumno.getMatricula()));

        document.add(new Paragraph(
                "Correo: "
                        + alumno.getCorreo()));

        document.add(new Paragraph(
                "Fecha de registro: "
                        + alumno.getFechaRegistro()));

        document.add(new Paragraph(" "));
        document.add(new Paragraph(
                "Se hace constar que el alumno "
                        + "se encuentra inscrito "
                        + "en esta institución."
        ));

        document.close();

        return output.toByteArray();
    }

}