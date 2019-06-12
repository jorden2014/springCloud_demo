package com.example.demo;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @Auther: jorden
 * @Date: 2019/2/26 18:08
 * @Description:
 */
@Service
public class ElasticJobService {
    @Resource
    private ElasticJobHandler jobHandler;

    /**
     * 扫描db，并添加任务
     */
    public void scanAddJob() {
        jobHandler.addJob("jobName", "0 0/2 * * * ? ", 1, "001");
    }
}
