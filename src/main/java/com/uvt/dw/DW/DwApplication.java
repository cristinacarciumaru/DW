package com.uvt.dw.DW;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@EnableAutoConfiguration(exclude = { CassandraDataAutoConfiguration.class, MongoAutoConfiguration.class, MongoDataAutoConfiguration.class })
@SpringBootApplication
public class DwApplication {
	public static void main(String[] args) {
		SpringApplication.run(DwApplication.class, args);
	}

}
