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

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.job.DefaultJobParametersExtractor;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author Michael Minella
 */
@SpringBootApplication
public class JobJob {

	@Bean
	public Tasklet loadStockFile() {
		return (contribution, chunkContext) -> {
			System.out.println("The stock file has been loaded");
			return RepeatStatus.FINISHED;
		};
	}

	@Bean
	public Tasklet loadCustomerFile() {
		return (contribution, chunkContext) -> {
			System.out.println("The customer file has been loaded");
			return RepeatStatus.FINISHED;
		};
	}

	@Bean
	public Tasklet updateStart() {
		return (contribution, chunkContext) -> {
			System.out.println("The start has been updated");
			return RepeatStatus.FINISHED;
		};
	}

	@Bean
	public Tasklet runBatchTasklet() {
		return (contribution, chunkContext) -> {
			System.out.println("The batch has been run");
			return RepeatStatus.FINISHED;
		};
	}

	@Bean
	public Job preProcessingJob(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
		return new JobBuilder("preProcessingJob", jobRepository)
				.start(loadFileStep(jobRepository, platformTransactionManager))
				.next(loadCustomerStep(jobRepository, platformTransactionManager))
				.next(updateStartStep(jobRepository, platformTransactionManager))
				.build();
	}

	@Bean
	public Job conditionalStepLogicJob(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
		return new JobBuilder("conditionalStepLogicJob", jobRepository)
				.start(initializeBatch(jobRepository, platformTransactionManager))
				.next(runBatch(jobRepository, platformTransactionManager))
				.build();
	}

	@Bean
	public Step initializeBatch(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
		return new StepBuilder("initializeBatch", jobRepository)
				.job(preProcessingJob(jobRepository, platformTransactionManager))
				.parametersExtractor(new DefaultJobParametersExtractor())
				.build();
	}

	@Bean
	public Step loadFileStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
		return new StepBuilder("loadFileStep", jobRepository)
				.tasklet(loadStockFile(), platformTransactionManager)
				.build();
	}

	@Bean
	public Step loadCustomerStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
		return new StepBuilder("loadCustomerStep", jobRepository)
				.tasklet(loadCustomerFile(), platformTransactionManager)
				.build();
	}

	@Bean
	public Step updateStartStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
		return new StepBuilder("updateStartStep", jobRepository)
				.tasklet(updateStart(), platformTransactionManager)
				.build();
	}

	@Bean
	public Step runBatch(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
		return new StepBuilder("runBatch", jobRepository)
				.tasklet(runBatchTasklet(), platformTransactionManager)
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(JobJob.class, args);
	}
}
