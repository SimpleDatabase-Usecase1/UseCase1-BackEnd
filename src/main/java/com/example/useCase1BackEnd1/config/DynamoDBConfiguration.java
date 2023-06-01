package com.example.useCase1BackEnd1.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories
public class DynamoDBConfiguration {

    //deployment version of configuration:

    @Value("https://dynamodb.us-east-1.amazonaws.com")
    private String dBEndpoint;

    @Value("us-east-1")
    private String amazonDynamoDBRegion;

//    @Bean
//    public DynamoDBMapper dynamoDBMapper() {
//        return new DynamoDBMapper(buildAmazonDynamoDB());
//    }

    @Bean
    public AmazonDynamoDB buildAmazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(dBEndpoint, amazonDynamoDBRegion))
                .build();
    }
//below is not for deployment
//    @Value("${endpoint}")
//    String endpoint;
//
//    @Value("${region}")
//    String region;
//
//    @Value("${access_key}")
//    String accesskey;
//
//    @Value("${secret_access_key}")
//    String secretkey;
//
//    @Bean
//    public DynamoDBMapper dynamoDBMapper() {
//        return new DynamoDBMapper(buildAmazonDynamoDB());
//    }
//
//    @Bean
//    public AmazonDynamoDB buildAmazonDynamoDB() {
//        return AmazonDynamoDBClientBuilder
//                .standard()
//                .withEndpointConfiguration(
//                        new AwsClientBuilder.EndpointConfiguration(endpoint,region))
//                .withCredentials(new AWSStaticCredentialsProvider(
//                        new BasicAWSCredentials(accesskey,secretkey)))
//                .build();
//    }

}
