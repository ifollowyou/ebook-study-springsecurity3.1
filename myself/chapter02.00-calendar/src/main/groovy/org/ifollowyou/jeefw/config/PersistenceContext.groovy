package org.ifollowyou.jeefw.config

import com.zaxxer.hikari.HikariDataSource
import groovy.transform.CompileStatic
import org.ifollowyou.jeefw.config.model.EntityManagerSettings
import org.ifollowyou.jeefw.config.model.HikariSettings
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter

import javax.sql.DataSource

@CompileStatic
@Configuration
@EnableConfigurationProperties
class PersistenceContext {

    @Bean(destroyMethod = "close")
    DataSource dataSource(HikariSettings hikariSettings) {
        return new HikariDataSource(hikariSettings.getHikariConfig())
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DataSource dataSource,
            EntityManagerSettings entityManagerSettings) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean()

        em.setDataSource(dataSource)
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter())
        em.setPackagesToScan(entityManagerSettings.packagesToScan)
        em.setPersistenceUnitName(entityManagerSettings.persistenceUnitName)
        em.setJpaProperties(entityManagerSettings.jpaProperties)

        return em;
    }

}
