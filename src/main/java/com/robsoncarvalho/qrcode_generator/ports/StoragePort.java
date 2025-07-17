package com.robsoncarvalho.qrcode_generator.ports;

public interface StoragePort {
    String uploadFile(byte[] fileData, String fileName, String contentType);
}
