package org.ifollowyou.jeefw.config.model

import groovy.util.logging.Slf4j
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

@Component
@ConfigurationProperties(prefix = "em")
@Slf4j
class EntityManagerSettings {
    String packagesToScan
    String persistenceUnitName
    Properties jpaProperties

    @PostConstruct
    void postConstruct() {
        Properties newJpaProperties = [:]
        def keys = jpaProperties.keySet()
        for (String key in keys) {
            def newKey = key.replaceAll(~/\-/, ".")
            newJpaProperties.put(newKey, jpaProperties.get(key))
        }

        jpaProperties = newJpaProperties
        log.info(jpaProperties.toString())
    }
}
