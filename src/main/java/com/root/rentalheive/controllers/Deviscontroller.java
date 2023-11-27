package com.root.rentalheive.controllers;

import com.itextpdf.text.DocumentException;
import com.root.rentalheive.dto.DevisDto;
import com.root.rentalheive.entities.Devis;
import com.root.rentalheive.services.DevisService;
import com.root.rentalheive.services.Impl.DevisServiceImpl;
import com.root.rentalheive.utils.PdfGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/devis")
public class Deviscontroller {

    private final DevisService devisService;

    @GetMapping("")
    public ResponseEntity<List<Devis>> getDevis() {
        List<Devis> devisList = devisService.getDevis();
        return new ResponseEntity<>(devisList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<FileSystemResource> saveDevis(@RequestBody DevisDto devisDto) throws IOException, DocumentException {
        Devis devis = this.devisService.saveDevis(devisDto.getDate(), devisDto.getPrice(), devisDto.getDemand_id());
        Map<String, Object> devisMap = devis.toMap();

        String localFolderPath = "com/root/rentalheive/pdfs/";

        ByteArrayOutputStream pdfStream = PdfGenerator.generatePdfStream(devisMap, "Devis");
        String fileName = "devis.pdf";
        String filePath = localFolderPath + fileName;
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(pdfStream.toByteArray());
        }

        FileSystemResource fileResource = new FileSystemResource(new File(filePath));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
        headers.setContentLength(fileResource.contentLength());

        return new ResponseEntity<>(fileResource, headers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevis(@PathVariable long id) {
        boolean deleted = this.devisService.deleteDevis(id);

        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
