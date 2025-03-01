/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.apress.batch.chapter9.configuration;

import com.apress.batch.chapter9.domain.Customer;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author Michael Minella
 */
@Configuration
public class HibernateImportJob {
//
//	@Bean
//	@StepScope
//	public FlatFileItemReader<Customer> customerFileReader(
//			@Value("#{jobParameters['customerFile']}") Resource inputFile) {
//
//		return new FlatFileItemReaderBuilder<Customer>()
//				.name("customerFileReader")
//				.resource(inputFile)
//				.delimited()
//				.names(new String[] {"firstName",
//						"middleInitial",
//						"lastName",
//						"address",
//						"city",
//						"state",
//						"zip"})
//				.targetType(Customer.class)
//				.build();
//	}
//
//	@Bean
//	public HibernateItemWriter<Customer> hibernateItemWriter(EntityManagerFactory entityManager) {
//		return new HibernateItemWriterBuilder<Customer>()
//				.sessionFactory(entityManager.unwrap(SessionFactory.class))
//				.build();
//	}
//
//	@Bean
//	public Step hibernateFormatStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
//		return new StepBuilder("hibernateFormatStep", jobRepository)
//				.<Customer, Customer>chunk(10, platformTransactionManager)
//				.reader(customerFileReader(null))
//				.writer(hibernateItemWriter(null))
//				.build();
//	}
//
//	@Bean
//	public Job hibernateFormatJob(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
//		return new JobBuilder("hibernateFormatJob", jobRepository)
//				.start(hibernateFormatStep(jobRepository, platformTransactionManager))
//				.build();
//	}
}
