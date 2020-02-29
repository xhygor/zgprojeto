package br.com.oversight.zgProjeto.domainClient;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "postgresClientEntityManagerFactory", transactionManagerRef = "postgresClientTransactionManager", basePackages = {
		"br.com.oversight.zgProjeto.domainClient.repository" })
public class ClientConfiguration {

	@Bean(name = "ClientDataSource")
	@ConfigurationProperties(prefix = "spring.client.datasource")
	public HikariDataSource clientDataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).driverClassName("org.postgresql.Driver").build();
	}

	@Bean(name = "postgresClientEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("ClientDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("br.com.oversight.zgProjeto.domainClient.entity")
				.persistenceUnit("clientPU").build();
	}

	@Bean(name = "postgresClientTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("postgresClientEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
