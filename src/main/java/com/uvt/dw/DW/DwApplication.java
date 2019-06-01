package com.uvt.dw.DW;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@EnableAutoConfiguration(exclude = { CassandraDataAutoConfiguration.class, MongoAutoConfiguration.class, MongoDataAutoConfiguration.class })
@SpringBootApplication
public class DwApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(DwApplication.class, args);

		CassandraConfig c = new CassandraConfig();
		c.getStartupScripts();

			List<List<String>> records = new ArrayList<>();
			try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Cristina/Downloads/amis.csv"))) {
				String line;
				while ((line = br.readLine()) != null) {
					String[] values = line.split(",");
					records.add(Arrays.asList(values));
				}

				System.out.println(records);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


}
