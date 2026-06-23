package com.upiiz.Proyecto_final.controllers.api;

import com.upiiz.Proyecto_final.services.PdfService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pdf")
@RequiredArgsConstructor
public class PdfRestController {

    private final PdfService pdfService;

    @GetMapping("/alumno/{id}")
    public ResponseEntity<byte[]> generar(
            @PathVariable Long id)
            throws Exception {

        byte[] pdf =
                pdfService.generarConstancia(id);

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "inline; filename=constancia.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }

}