package com.example.demo;

import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Auther: jorden
 * @Date: 2019/2/26 18:05
 * @Description:
 */
@Component
public class ElasticJobHandler {
    @Resource
    private ZookeeperRegistryCenter registryCenter;
    @Resource
    private JobEventConfiguration jobEventConfiguration;
    @Resource
    private ElasticJobListener elasticJobListener;

    private static LiteJobConfiguration.Builder simpleJobConfigBuilder(String jobName, Class<? extends SimpleJob> jobClass, int shardingTotalCount, String cron, String id) {
        return LiteJobConfiguration.newBuilder(new SimpleJobConfiguration(JobCoreConfiguration.newBuilder(jobName, cron, shardingTotalCount).jobParameter(id).build(), jobClass.getCanonicalName()));
    }

    /**
     * 添加一个定时任务
     *
     * @param jobName            任务名
     * @param cron               表达式
     * @param shardingTotalCount 分片数
     */
    public void addJob(String jobName, String cron, Integer shardingTotalCount, String id) {
        LiteJobConfiguration jobConfig = simpleJobConfigBuilder(jobName, MyElasticJob.class, shardingTotalCount, cron, id).overwrite(true).build();
        new SpringJobScheduler(new MyElasticJob(), registryCenter, jobConfig, jobEventConfiguration, elasticJobListener).init();
    }
}
