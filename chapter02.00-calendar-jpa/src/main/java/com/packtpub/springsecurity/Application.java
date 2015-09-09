
package com.packtpub.springsecurity;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private Environment environment;

	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(environment.getProperty("hikari.url"));
		config.setUsername(environment.getProperty("hikari.name"));
		config.setPassword(environment.getProperty("hikari.password"));
		config.addDataSourceProperty("cachePrepStmts", environment.getProperty("hikari.cachePrepStmts"));
		config.addDataSourceProperty("prepStmtCacheSize", environment.getProperty("hikari.prepStmtCacheSize"));
		config.addDataSourceProperty("prepStmtCacheSqlLimit", environment.getProperty("hikari.prepStmtCacheSqlLimit"));

		return new HikariDataSource(config);
	}

}
