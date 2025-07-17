package com.robsoncarvalho.qrcode_generator.infrastructure;

import com.robsoncarvalho.qrcode_generator.ports.StoragePort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Component
public class S3StorageAdapter implements StoragePort {
    private  final S3Client  s3Client;
    private  final String  bucket;
    private final String  region;

    public S3StorageAdapter(@Value("${aws.s3.region}") String region, @Value("${aws.s3.bucket}") String bucket) {
        this.bucket = bucket;
        this.region = region;
        this.s3Client = S3Client.builder().region(Region.of(this.region)).build();
    }

    @Override
    public String uploadFile(byte[] fileData, String fileName, String contentType) {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(this.bucket)
                .key(fileName)
                .contentType(contentType)
                .build();

        s3Client.putObject(putObjectRequest, RequestBody.fromBytes(fileData));

        return String.format("https://%s.s3.%s.amazonaws.com/%s", bucket, region, fileName);
    }
}
