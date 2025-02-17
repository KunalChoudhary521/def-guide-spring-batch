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
import org.springframework.batch.core.step.tasklet.SystemCommandTasklet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author Michael Minella
 */
@SpringBootApplication
public class SystemCommandJob {

//	@Bean
//	public Job job(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
//		return new JobBuilder("systemCommandJob", jobRepository)
//				.start(systemCommandStep(jobRepository, platformTransactionManager))
//				.build();
//	}
//
//	@Bean
//	public Step systemCommandStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
//		return new StepBuilder("systemCommandStep", jobRepository)
//				.tasklet(systemCommandTasklet(), platformTransactionManager)
//				.build();
//	}
//
//	@Bean
//	public SystemCommandTasklet systemCommandTasklet() {
//		SystemCommandTasklet systemCommandTasklet = new SystemCommandTasklet();
//
//		systemCommandTasklet.setCommand("rm -rf /tmp.txt");
//		systemCommandTasklet.setTimeout(5000);
//		systemCommandTasklet.setInterruptOnCancel(true);
//
//		return systemCommandTasklet;
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(SystemCommandJob.class, args);
//	}
}
