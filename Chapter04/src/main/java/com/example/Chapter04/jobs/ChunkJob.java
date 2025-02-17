/**
 * Copyright 2019 the original author or authors.
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
package com.example.Chapter04.jobs;

import com.example.Chapter04.batch.LoggingStepStartStopListener;
import com.example.Chapter04.batch.RandomChunkSizePolicy;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.repeat.CompletionPolicy;
import org.springframework.batch.repeat.policy.CompositeCompletionPolicy;
import org.springframework.batch.repeat.policy.SimpleCompletionPolicy;
import org.springframework.batch.repeat.policy.TimeoutTerminationPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Michael Minella
 */
@SpringBootApplication
public class ChunkJob {
//
//	@Bean
//	public Job chunkBasedJob(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
//		return new JobBuilder("chunkBasedJob", jobRepository)
//				.start(chunkStep(jobRepository, platformTransactionManager))
//				.build();
//	}
//
//	@Bean
//	public Step chunkStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
//		return new StepBuilder("chunkStep", jobRepository)
////				.<String, String>chunk(1000, platformTransactionManager)
//				.<String, String>chunk(randomCompletionPolicy(), platformTransactionManager)
//				.reader(itemReader())
//				.writer(itemWriter())
//				.listener(new LoggingStepStartStopListener())
//				.build();
//	}
//
//	@Bean
//	public ListItemReader<String> itemReader() {
//		List<String> items = new ArrayList<>(100000);
//
//		for (int i = 0; i < 100000; i++) {
//			items.add(UUID.randomUUID().toString());
//		}
//
//		return new ListItemReader<>(items);
//	}
//
//	@Bean
//	public ItemWriter<String> itemWriter() {
//		return items -> {
//			for (String item : items) {
//				System.out.println(">> current item = " + item);
//			}
//		};
//	}
//
//	@Bean
//	public CompletionPolicy completionPolicy() {
//		CompositeCompletionPolicy policy =
//				new CompositeCompletionPolicy();
//
//		policy.setPolicies(
//				new CompletionPolicy[] {
//						new TimeoutTerminationPolicy(3),
//						new SimpleCompletionPolicy(1000)});
//
//		return policy;
//	}
//
//	@Bean
//	public CompletionPolicy randomCompletionPolicy() {
//		return new RandomChunkSizePolicy();
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(ChunkJob.class, args);
//	}
}
