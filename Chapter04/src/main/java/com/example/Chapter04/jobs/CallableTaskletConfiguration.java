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
import org.springframework.batch.core.step.tasklet.CallableTaskletAdapter;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.concurrent.Callable;

/**
 * @author Michael Minella
 */
@SpringBootApplication
public class CallableTaskletConfiguration {

//	@Bean
//	public Job callableJob(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
//		return new JobBuilder("callableJob", jobRepository)
//				.start(callableStep(jobRepository, platformTransactionManager))
//				.build();
//	}

//	@Bean
//	public Step callableStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
//		return new StepBuilder("callableStep", jobRepository)
//				.tasklet(tasklet(), platformTransactionManager)
//				.build();
//	}

	@Bean
	public Callable<RepeatStatus> callableObject() {
		return () -> {
			System.out.println("This was executed in another thread");

			return RepeatStatus.FINISHED;
		};
	}

//	@Bean
//	public CallableTaskletAdapter tasklet() {
//		CallableTaskletAdapter callableTaskletAdapter =
//				new CallableTaskletAdapter();
//
//		callableTaskletAdapter.setCallable(callableObject());
//
//		return callableTaskletAdapter;
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(CallableTaskletConfiguration.class, args);
//	}
}
