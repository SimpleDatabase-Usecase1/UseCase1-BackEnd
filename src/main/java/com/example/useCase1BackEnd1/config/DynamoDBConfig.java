package com.example.useCase1BackEnd1.config;


//Config File from https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/creating-clients.html

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DynamoDBConfiguration {

    @Value("${endpoint}")
    private String endpoint;

    @Value("${region}")
    private String region;

    @Value("${access_key}")
    private String accessKey;

    @Value("${secret_access_key}")
    private String sercretAccessKey;

    //https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBMapper.html
    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(buildAmazonDynamoDB());
    }

    private AmazonDynamoDB buildAmazonDynamoDB() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(endpoint,region))
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials(accessKey,sercretAccessKey)))
                .build();
    }
}