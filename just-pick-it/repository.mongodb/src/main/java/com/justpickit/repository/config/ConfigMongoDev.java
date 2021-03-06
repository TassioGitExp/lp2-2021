package com.justpickit.repository.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class ConfigMongoDev {

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(getClient(), "justpickit-lp2");
    }

    private MongoClient getClient() {
        return MongoClients.create("mongodb+srv://lp2Tassio:O6cLsEMyVxRwM3kU@aulalp2.ft9s2.mongodb.net/test");
    }
}
