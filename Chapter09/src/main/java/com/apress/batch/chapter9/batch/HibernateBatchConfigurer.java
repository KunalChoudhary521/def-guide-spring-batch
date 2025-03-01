/*
 * Copyright 2018 the original author or authors.
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
package com.apress.batch.chapter9.batch;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;

import org.springframework.batch.core.configuration.BatchConfigurationException;
import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.JobExplorerFactoryBean;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author Michael Minella
 */
//@Component
public class HibernateBatchConfigurer /*extends DefaultBatchConfiguration*/ {
//
//	private DataSource dataSource;
//	private SessionFactory sessionFactory;
//	private JobRepository jobRepository;
//	private PlatformTransactionManager transactionManager;
//	private JobLauncher jobLauncher;
//	private JobExplorer jobExplorer;
//
//	public HibernateBatchConfigurer(DataSource dataSource, EntityManagerFactory entityManagerFactory) {
//		this.dataSource = dataSource;
//		this.sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
//	}
//
//	@Override
//	public JobRepository jobRepository() {
//		return this.jobRepository;
//	}
//
//	@Override
//	public PlatformTransactionManager getTransactionManager() {
//		return this.transactionManager;
//	}
//
//	@Override
//	public JobLauncher jobLauncher(JobRepository jobRepository) {
//		return this.jobLauncher;
//	}
//
//	@Override
//	public JobExplorer jobExplorer() {
//		return this.jobExplorer;
//	}
//
//	@PostConstruct
//	public void initialize() {
//
//		try {
//			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
//			this.transactionManager = transactionManager;
//			transactionManager.afterPropertiesSet();
//
//			this.jobRepository = createJobRepository();
//			this.jobExplorer = createJobExplorer();
//			this.jobLauncher = createJobLauncher();
//
//		}
//		catch (Exception e) {
//			throw new BatchConfigurationException(e);
//		}
//	}
//
//	private JobLauncher createJobLauncher() throws Exception {
//        TaskExecutorJobLauncher jobLauncher = new TaskExecutorJobLauncher();
//
//		jobLauncher.setJobRepository(this.jobRepository);
//		//jobLauncher.setTaskExecutor(new SimpleAsyncTaskExecutor());
//		jobLauncher.afterPropertiesSet();
//
//		return null;
//	}
//
//	private JobExplorer createJobExplorer() throws Exception {
//		JobExplorerFactoryBean jobExplorerFactoryBean = new JobExplorerFactoryBean();
//
//		jobExplorerFactoryBean.setDataSource(this.dataSource);
//		jobExplorerFactoryBean.setTransactionManager(this.transactionManager);
//		jobExplorerFactoryBean.afterPropertiesSet();
//
//		return jobExplorerFactoryBean.getObject();
//	}
//
//	private JobRepository createJobRepository() throws Exception {
//		JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
//
//		jobRepositoryFactoryBean.setDataSource(this.dataSource);
//		jobRepositoryFactoryBean.setTransactionManager(this.transactionManager);
//		jobRepositoryFactoryBean.afterPropertiesSet();
//
//		return jobRepositoryFactoryBean.getObject();
//	}
}
