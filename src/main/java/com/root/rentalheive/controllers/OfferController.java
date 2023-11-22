package com.root.rentalheive.controllers;


import com.itextpdf.text.DocumentException;
import com.root.rentalheive.dto.OfferDto;
import com.root.rentalheive.entities.Offer;
import com.root.rentalheive.services.OfferService;
import com.root.rentalheive.utils.PdfGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/offers")
public class OfferController {
    OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService){this.offerService = offerService;}

    @GetMapping("")
    public List<Offer> getOffers(){
        return offerService.getOffers();
    }

    @GetMapping("/{id}/send")
    public void sendOffer(@PathVariable Long id){
        this.offerService.sendOffer(id);
    }

    @PostMapping("")
    public ResponseEntity<byte[]> saveOffer(@RequestBody OfferDto offerDto)throws IOException, DocumentException {
        Offer offer = this.offerService.saveOffer(offerDto.getDevis_id());
        ByteArrayOutputStream pdfStream = PdfGenerator.generatePdfStream(offer.toMap(), "Offer");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=offer.pdf");
        headers.setContentLength(pdfStream.size());
        return new ResponseEntity<>(pdfStream.toByteArray(), headers, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public void deleteOffer(@PathVariable long id){
        this.offerService.deleteOffer(id);
    }

}
