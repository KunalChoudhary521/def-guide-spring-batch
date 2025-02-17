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

import com.example.Chapter04.batch.RandomDecider;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
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
public class ConditionalJob {
//
//	@Bean
//	public Tasklet passTasklet() {
//		return (contribution, chunkContext) -> {
////			return RepeatStatus.FINISHED;
//			throw new RuntimeException("Causing a failure");
//		};
//	}
//
//	@Bean
//	public Tasklet successTasklet() {
//		return (contribution, context) -> {
//			System.out.println("Success!");
//			return RepeatStatus.FINISHED;
//		};
//	}
//
//	@Bean
//	public Tasklet failTasklet() {
//		return (contribution, context) -> {
//			System.out.println("Failure!");
//			return RepeatStatus.FINISHED;
//		};
//	}
//
//	@Bean
//	public Job job(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
//		return new JobBuilder("conditionalJob", jobRepository)
//				.start(firstStep(jobRepository, platformTransactionManager))
//				.on("FAILED").stopAndRestart(successStep(jobRepository, platformTransactionManager))
//				.from(firstStep(jobRepository, platformTransactionManager))
//					.on("*").to(successStep(jobRepository, platformTransactionManager))
//				.end()
//				.build();
//	}
//
//	@Bean
//	public Step firstStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
//		return new StepBuilder("firstStep", jobRepository)
//				.tasklet(passTasklet(), platformTransactionManager)
//				.build();
//	}
//
//	@Bean
//	public Step successStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
//		return new StepBuilder("successStep", jobRepository)
//				.tasklet(successTasklet(), platformTransactionManager)
//				.build();
//	}
//
//	@Bean
//	public Step failureStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
//		return new StepBuilder("failureStep", jobRepository)
//				.tasklet(failTasklet(), platformTransactionManager)
//				.build();
//	}
//
//	@Bean
//	public JobExecutionDecider decider() {
//		return new RandomDecider();
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(ConditionalJob.class, args);
//	}
}
