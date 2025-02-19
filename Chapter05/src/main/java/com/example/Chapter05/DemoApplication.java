package com.example.Chapter05;

import com.example.Chapter05.batch.ExploringTasklet;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private JobExplorer jobExplorer;

	@Bean
	public Tasklet explorerTasklet() {
		return new ExploringTasklet(this.jobExplorer);
	}

	@Bean
	public Step explorerStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
		return new StepBuilder("explorerStep", jobRepository)
				.tasklet(explorerTasklet(), platformTransactionManager)
				.build();
	}

	@Bean
	public Job explorerJob(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
		return new JobBuilder("explorerJob", jobRepository)
				.start(explorerStep(jobRepository, platformTransactionManager))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

