package io.techleadacademy._practiceTests.s3aws;

import io.techleadacademy.utils.ConfigReader;
import org.junit.Test;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
import software.amazon.awssdk.services.s3.model.HeadObjectResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PracticeTests {
    String bucketName = "code-vista-data";
    String keyName = "modules.json";
    String accessKeyId = ConfigReader.readProperty("accessKeyId");
    String secretAccessKey = ConfigReader.readProperty("secretAccessKey");

    @Test
    public void verifyFileExists() {
        //Create aws basic credentials object
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKeyId, secretAccessKey);

        //Build connection with AWS S3
        S3Client s3Client = S3Client.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();

        //Create request
        HeadObjectRequest headObjectRequest = HeadObjectRequest.builder()
                .bucket(bucketName)
                .key(keyName)
                .build();

        //Send request and capture the response
        HeadObjectResponse headObjectResponse = s3Client.headObject(headObjectRequest);

        System.out.println(headObjectResponse);

        s3Client.close();
    }

    @Test
    public void readFileContent() throws IOException {
        //Create aws basic credentials object
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKeyId, secretAccessKey);

        //Build connection with AWS S3
        S3Client s3Client = S3Client.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .build();

        //Create request
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(keyName)
                .build();

        ResponseInputStream<GetObjectResponse> objectResponse = s3Client.getObject(getObjectRequest);

        BufferedReader bfReader = new BufferedReader(new InputStreamReader(objectResponse));

        String info = "";

        while (info != null){
            info = bfReader.readLine();
            System.out.println(info);
        }

        s3Client.close();
    }
}
