package com.mplcoding.firstdemo.database;

import com.mplcoding.firstdemo.models.Product;
import com.mplcoding.firstdemo.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {

    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository){

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product productA = new Product("iPhone 13 Pro Max 128GB", 2021, 2400.0, "");
                Product productB = new Product("iPhone 12 Pro Max 128GB", 2021, 2000.0, "");
                logger.info("Insert data" + productRepository.save(productA));
                logger.info("Insert data" + productRepository.save(productB));
            }
        };
    }
}
