package com.robsoncarvalho.qrcode_generator.controller;

import com.robsoncarvalho.qrcode_generator.dto.qrcode.QRCodeGenerateRequest;
import com.robsoncarvalho.qrcode_generator.dto.qrcode.QRCodeGenerateResponse;
import com.robsoncarvalho.qrcode_generator.service.QRCodeGeneratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class QRCodeController {

    private final QRCodeGeneratorService qrCodeGeneratorService;

    public QRCodeController(QRCodeGeneratorService qrCodeGeneratorService) {
        this.qrCodeGeneratorService = qrCodeGeneratorService;
    }

    @PostMapping
    public ResponseEntity<QRCodeGenerateResponse>  generate(@RequestBody QRCodeGenerateRequest request) {
        try {
            QRCodeGenerateResponse response = this.qrCodeGeneratorService.generateAndUploadQRCode(request.text());
            return ResponseEntity.ok(response);
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
