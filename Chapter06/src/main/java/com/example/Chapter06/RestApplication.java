package com.example.Chapter06;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

//@SpringBootApplication
public class RestApplication {
//
//	@Bean
//	public Job job(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
//		return new JobBuilder("job", jobRepository)
//				.incrementer(new RunIdIncrementer())
//				.start(step1(jobRepository, platformTransactionManager))
//				.build();
//	}
//
//	@Bean
//	public Step step1(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
//		return new StepBuilder("step1", jobRepository)
//				.tasklet((stepContribution, chunkContext) -> {
//					System.out.println("step 1 ran today!");
//					return RepeatStatus.FINISHED;
//				}, platformTransactionManager).build();
//	}
//
//	@RestController
//	public static class JobLaunchingController {
//
//		@Autowired
//		private JobLauncher jobLauncher;
//
//		@Autowired
//		private ApplicationContext context;
//
//		@Autowired
//		private JobExplorer jobExplorer;
//
//		@PostMapping(path = "/run")
//		public ExitStatus runJob(@RequestBody JobLaunchRequest request) throws Exception {
//			Job job = this.context.getBean(request.getName(), Job.class);
//
//			JobParameters jobParameters =
//					new JobParametersBuilder(request.getJobParameters(),
//								this.jobExplorer)
//							.getNextJobParameters(job)
//							.toJobParameters();
//
//			return this.jobLauncher.run(job, jobParameters).getExitStatus();
////			Job job = this.context.getBean(request.getName(), Job.class);
////
////			return this.jobLauncher.run(job, request.getJobParameters()).getExitStatus();
//		}
//	}
//
//	public static class JobLaunchRequest {
//		private String name;
//
//		private Properties jobParameters;
//
//		public String getName() {
//			return name;
//		}
//
//		public void setName(String name) {
//			this.name = name;
//		}
//
//		public Properties getJobParamsProperties() {
//			return jobParameters;
//		}
//
//		public void setJobParamsProperties(Properties jobParameters) {
//			this.jobParameters = jobParameters;
//		}
//
//		public JobParameters getJobParameters() {
//			Properties properties = new Properties();
//			properties.putAll(this.jobParameters);
//			Map<String, JobParameter<?>> jParam = new HashMap<>();
//			Map<String, String> params = properties.entrySet()
//					.stream()
//					.collect(Collectors.toMap(e -> (String) e.getKey(), e -> (String) e.getValue()));
//
//			params.forEach((key, value) -> jParam.put(key, new JobParameter<>(value, String.class)));
//			return new JobParameters(jParam);
//		}
//	}
//
//	public static void main(String[] args) {
//		new SpringApplication(RestApplication.class).run(args);
//	}
}
