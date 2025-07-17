package com.robsoncarvalho.qrcode_generator.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.robsoncarvalho.qrcode_generator.dto.qrcode.QRCodeGenerateResponse;
import com.robsoncarvalho.qrcode_generator.ports.StoragePort;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class QRCodeGeneratorService {
    private final StoragePort storage;

    public QRCodeGeneratorService(StoragePort storage) {
        this.storage = storage;
    }

    public QRCodeGenerateResponse generateAndUploadQRCode(String text) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 320, 320);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngQRCodeData = pngOutputStream.toByteArray();

        String url = storage.uploadFile(pngQRCodeData, UUID.randomUUID().toString(), "image/png");

        return new QRCodeGenerateResponse(url);
    }
}
