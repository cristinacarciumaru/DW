package com.uvt.dw.DW;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@EnableAutoConfiguration(exclude = { CassandraDataAutoConfiguration.class })
@SpringBootApplication
public class DwApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(DwApplication.class, args);

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
