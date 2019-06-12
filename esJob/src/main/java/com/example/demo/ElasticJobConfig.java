package com.example.demo;

import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.event.rdb.JobEventRdbConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @Auther: jorden
 * @Date: 2019/2/26 17:56
 * @Description:
 */
@Configuration
@Data
@ConfigurationProperties(prefix = "elastic-job")
public class ElasticJobConfig {
    private String serverlists;
    private String namespace;
    @Resource
    private HikariDataSource dataSource;

    @Bean
    public ZookeeperConfiguration zkConfig() {
        return new ZookeeperConfiguration(serverlists, namespace);
    }

    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter regCenter(ZookeeperConfiguration config) {
        return new ZookeeperRegistryCenter(config);
    }

    /**
     * 将作业运行的痕迹进行持久化到DB
     *
     * @return
     */
    @Bean
    public JobEventConfiguration jobEventConfiguration() {
        return new JobEventRdbConfiguration(dataSource);
    }

    @Bean
    public ElasticJobListener elasticJobListener() {
        return new ElasticJobListener(100, 100);
    }
}
