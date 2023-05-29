package com.commerce.config

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
import javax.sql.DataSource

@Configuration
class DBConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.master")
    fun masterDataSource(): DataSource {
        return DataSourceBuilder.create().build()
    }

    @Bean
    @ConfigurationProperties("spring.datasource.slave")
    fun slaveDataSource(): DataSource {
        return DataSourceBuilder.create().build()
    }

    @Bean
    @Primary
    fun routingDataSource(
        @Qualifier("masterDataSource") masterDataSource: DataSource,
        @Qualifier("slaveDataSource") slaveDataSource: DataSource
    ): DataSource {
        val routingDataSource = object : AbstractRoutingDataSource() {
            override fun determineCurrentLookupKey(): Any? {
                return RoutingDataSourceContext.get()
            }
        }

        val dataSourceMap = mapOf<Any, Any>(
            "master" to masterDataSource,
            "slave" to slaveDataSource
        )
        routingDataSource.setTargetDataSources(dataSourceMap)
        routingDataSource.setDefaultTargetDataSource(masterDataSource)

        return routingDataSource
    }
}

object RoutingDataSourceContext {
    private val contextHolder: ThreadLocal<String> = ThreadLocal()

    fun set(dataSourceType: String) {
        contextHolder.set(dataSourceType)
    }

    fun get(): String {
        return contextHolder.get() ?: "master"
    }

    fun clear() {
        contextHolder.remove()
    }
}