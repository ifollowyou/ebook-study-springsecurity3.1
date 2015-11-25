package org.ifollowyou.jeefw.config.model

import com.zaxxer.hikari.HikariConfig
import groovy.transform.ToString
import groovy.util.logging.Slf4j
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

@Component
@ConfigurationProperties(prefix = 'hikari')
@ToString(excludes = ['password'])
@Slf4j
class HikariSettings {
    String driverClassName
    String jdbcUrl
    String username
    String password
    Properties dataSourceProperties

    HikariConfig getHikariConfig() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driverClassName);
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(username);
        config.setPassword(password);
        config.setDataSourceProperties(dataSourceProperties)

        return config
    }

    @PostConstruct
    void postConstruct() {
        log.info(toString())
    }
}
