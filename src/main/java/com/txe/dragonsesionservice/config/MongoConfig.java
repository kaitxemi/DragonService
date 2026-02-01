package com.txe.dragonsesionservice.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Value("${spring.data.mongodb.uri:}")
    private String mongoUri;

    @Value("${spring.data.mongodb.database:}")
    private String mongoDatabase;

    @Bean
    public MongoClient mongoClient() {
        if (mongoUri == null || mongoUri.isEmpty()) {
            return MongoClients.create();
        }
        ConnectionString connectionString = new ConnectionString(mongoUri);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(settings);
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        String db = mongoDatabase;
        if ((db == null || db.isEmpty()) && mongoUri != null && !mongoUri.isEmpty()) {
            db = new ConnectionString(mongoUri).getDatabase();
        }
        if (db == null || db.isEmpty()) {
            db = "test"; // fallback database if none specified
        }
        return new MongoTemplate(mongoClient, db);
    }
}
