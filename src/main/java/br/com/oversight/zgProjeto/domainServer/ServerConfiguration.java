package br.com.oversight.zgProjeto.domainServer;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "postgresServerEntityManagerFactory", transactionManagerRef = "postgresServerTransactionManager", basePackages = {
		"br.com.oversight.zgProjeto.domainServer.repository" })
public class ServerConfiguration {
	@Primary
	@Bean(name = "ServerDataSource")
	@ConfigurationProperties(prefix = "spring.server.datasource")
	public HikariDataSource serverDataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).driverClassName("org.postgresql.Driver").build();
	}

	@Primary
	@Bean(name = "postgresServerEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("ServerDataSource") DataSource dataSource) {
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		return builder.dataSource(dataSource).packages("br.com.oversight.zgProjeto.domainServer.entity")
				.persistenceUnit("serverPU").properties(properties).build();
	}

	@Primary
	@Bean(name = "postgresServerTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("postgresServerEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
