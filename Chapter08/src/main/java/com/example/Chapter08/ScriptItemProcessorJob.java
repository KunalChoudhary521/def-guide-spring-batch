package com.example.Chapter08;

import com.example.Chapter08.domain.Customer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.support.ScriptItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
public class ScriptItemProcessorJob {
//
//	@Bean
//	@StepScope
//	public FlatFileItemReader<Customer> customerItemReader(
//			@Value("#{jobParameters['customerFile']}") Resource inputFile) {
//
//		return new FlatFileItemReaderBuilder<Customer>()
//				.name("customerItemReader")
//				.delimited()
//				.names(new String[] {"firstName",
//						"middleInitial",
//						"lastName",
//						"address",
//						"city",
//						"state",
//						"zip"})
//				.targetType(Customer.class)
//				.resource(inputFile)
//				.build();
//	}
//
//	@Bean
//	public ItemWriter<Customer> itemWriter() {
//		return (items) -> items.forEach(System.out::println);
//	}
//
//	@Bean
//	@StepScope
//	public ScriptItemProcessor<Customer, Customer> itemProcessor(@Value("#{jobParameters['script']}") Resource script) {
//		ScriptItemProcessor<Customer, Customer> itemProcessor = new ScriptItemProcessor<>();
//
//		itemProcessor.setScript(script);
//
//		return itemProcessor;
//	}
//
//	@Bean
//	public Step copyFileStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
//
//		return new StepBuilder("copyFileStep", jobRepository)
//    			.<Customer, Customer>chunk(5, platformTransactionManager)
//				.reader(customerItemReader(null))
//				.processor(itemProcessor(null))
//				.writer(itemWriter())
//				.build();
//	}
//
//	@Bean
//	public Job job(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager)  {
//
//		return new JobBuilder("job", jobRepository)
//                .incrementer(new RunIdIncrementer())
//                .start(copyFileStep(jobRepository, platformTransactionManager))
//				.build();
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(ScriptItemProcessorJob.class, "customerFile=/input/customer.csv", "script=/upperCase.js");
//	}
}

