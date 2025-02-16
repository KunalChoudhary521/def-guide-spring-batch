package io.spring.batch.helloworld;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
public class HelloWorldApplication {

	@Bean
	public Step step(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
		return new StepBuilder("step1", jobRepository)
				.tasklet((contribution, chunkContext) -> {
                    System.out.println("Hello, World!");
                    return RepeatStatus.FINISHED;
                }, platformTransactionManager).build();
	}

	@Bean
	public Job job(JobRepository jobRepository, Step step) {
		return new JobBuilder("job", jobRepository)
				.start(step)
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}
}
