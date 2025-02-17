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

import com.example.Chapter04.service.CustomService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.MethodInvokingTaskletAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author Michael Minella
 */
@SpringBootApplication
public class MethodInvokingTaskletConfiguration {

//	@Bean
//	public Job methodInvokingJob(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
//		return new JobBuilder("methodInvokingJob", jobRepository)
//				.start(methodInvokingStep(jobRepository, platformTransactionManager))
//				.build();
//	}
//
//	@Bean
//	public Step methodInvokingStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
//		return new StepBuilder("methodInvokingStep", jobRepository)
//				.tasklet(methodInvokingTasklet(null), platformTransactionManager)
//				.build();
//	}
//
//	@StepScope
//	@Bean
//	public MethodInvokingTaskletAdapter methodInvokingTasklet(
//			@Value("#{jobParameters['message']}") String message) {
//
//		MethodInvokingTaskletAdapter methodInvokingTaskletAdapter =
//				new MethodInvokingTaskletAdapter();
//
//		methodInvokingTaskletAdapter.setTargetObject(service());
//		methodInvokingTaskletAdapter.setTargetMethod("serviceMethod");
//		methodInvokingTaskletAdapter.setArguments(
//				new String[] {message});
//
//		return methodInvokingTaskletAdapter;
//	}

	@Bean
	public CustomService service() {
		return new CustomService();
	}

//	public static void main(String[] args) {
//		SpringApplication.run(MethodInvokingTaskletConfiguration.class, args);
//	}
}
