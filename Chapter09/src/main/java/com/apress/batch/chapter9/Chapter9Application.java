package com.apress.batch.chapter9;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter9Application {

	public static void main(String[] args) {
		List<String> newArgs = new ArrayList<>(3);
		// FormattedTextFileJob
//		newArgs.add("customerFile=/data/customer.csv");
//		newArgs.add("outputFile=Chapter09/target/test-outputs/formattedCustomers.txt");

		//DelimitedFileJob
//		newArgs.add("customerFile=/data/customer.csv");
//		newArgs.add("outputFile=Chapter09/target/test-outputs/delimitedCustomers.txt");

		//XmlFileJob
//		newArgs.add("customerFile=/data/customer.csv");
//		newArgs.add("outputFile=Chapter09/target/test-outputs/xmlCustomer.xml");

		//JdbcImportJob, ItemWriterAdapterJob, MultiResourceJob, PropertyExtractingJob
		newArgs.add("customerFile=/data/customer.csv");

		SpringApplication.run(Chapter9Application.class, newArgs.toArray(new String[0]));
	}
}
