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

import com.example.Chapter04.batch.DailyJobTimestamper;
import com.example.Chapter04.batch.JobLoggerListener;
import com.example.Chapter04.batch.ParameterValidator;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.CompositeJobParametersValidator;
import org.springframework.batch.core.job.DefaultJobParametersValidator;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.listener.JobListenerFactoryBean;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Arrays;

/**
 * @author Michael Minella
 */
@SpringBootApplication
public class HelloWorldJob {

	@Bean
	public CompositeJobParametersValidator validator() {
		CompositeJobParametersValidator validator =
				new CompositeJobParametersValidator();

		DefaultJobParametersValidator defaultJobParametersValidator =
				new DefaultJobParametersValidator(
						new String[] {"fileName"},
						new String[] {"name", "currentDate"});

		defaultJobParametersValidator.afterPropertiesSet();

		validator.setValidators(
				Arrays.asList(new ParameterValidator(),
					defaultJobParametersValidator));

		return validator;
	}

	@Bean
	public Job job(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {

		return new JobBuilder("basicJob", jobRepository)
				.start(step1(jobRepository, platformTransactionManager))
				.validator(validator())
				.incrementer(new DailyJobTimestamper())
//				.listener(new JobLoggerListener())
				.listener(JobListenerFactoryBean.getListener(new JobLoggerListener()))
				.build();
	}

//	@Bean
//	public Job job(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
//		return new JobBuilder("basicJob", jobRepository)
//				.start(step1(jobRepository, platformTransactionManager))
//				.build();
//	}

	@Bean
	public Step step1(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
		return new StepBuilder("step1", jobRepository)
				.tasklet(helloWorldTasklet(null, null), platformTransactionManager)
				.build();
	}

	@StepScope
	@Bean
	public Tasklet helloWorldTasklet(
			@Value("#{jobParameters['name']}") String name,
			@Value("#{jobParameters['fileName']}") String fileName) {

		return (contribution, chunkContext) -> {

				System.out.println(
						String.format("Hello, %s!", name));
				System.out.println(
						String.format("fileName = %s", fileName));

				return RepeatStatus.FINISHED;
			};
	}

//	@Bean
//	public Tasklet helloWorldTasklet() {
//
//		return (contribution, chunkContext) -> {
//				String name = (String) chunkContext.getStepContext()
//					.getJobParameters()
//					.get("name");
//
//				System.out.println(String.format("Hello, %s!", name));
//				return RepeatStatus.FINISHED;
//			};
//	}

//	public static void main(String[] args) {
//		SpringApplication.run(HelloWorldJob.class, args);
//	}
}
