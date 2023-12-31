package com.root.rentalheive.controllers;

import com.itextpdf.text.DocumentException;
import com.root.rentalheive.dto.DevisDto;
import com.root.rentalheive.entities.*;
import com.root.rentalheive.mappers.DemandMapper;
import com.root.rentalheive.mappers.DevisMapper;
import com.root.rentalheive.services.DemandService;
import com.root.rentalheive.services.DevisService;
import com.root.rentalheive.services.EquipmentDemandService;
import com.root.rentalheive.services.EquipmentService;
import com.root.rentalheive.utils.PdfGenerator;
import lombok.RequiredArgsConstructor;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/devis")
public class DevisController {

    private final DevisService devisService;
    private final DemandService demandService;
    private final EquipmentDemandService equipmentDemandService;
    private final EquipmentService equipmentService;

    @GetMapping("")
    public ResponseEntity<List<Devis>> getDevis() {
        List<Devis> devisList = devisService.getDevis();
        return new ResponseEntity<>(devisList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<FileSystemResource> saveDevis(@RequestBody DevisDto devisDto) throws IOException, DocumentException {
        Demand demand = demandService.getDemandById(devisDto.getDemand_id());
        Devis devis = DevisMapper.convertDevisDtoToDevis(devisDto, demand);
        Devis savedDevis = devisService.saveDevis(devis);
        EquipmentDemand equipmentDemand = equipmentDemandService.findEquipmentDemandByDemand(savedDevis.getDemand());
        Equipment equipment = equipmentDemand.getEquipment();
        User user = savedDevis.getDemand().getUser();
        Map<String, Object> devisMap = new HashMap<>();
        devisMap.put("userName", user.getName());
        devisMap.put("Equipment", equipment.getName());
        devisMap.put("Price", equipment.getPrice());
        devisMap.put("Type", equipment.getType().getName());
        devisMap.put("Start Date", equipmentDemand.getStartDate());
        devisMap.put("End Date", equipmentDemand.getEndDate());
        devisMap.put("totalPrice", savedDevis.getTotalPrice());

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
