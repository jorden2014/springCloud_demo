package com.example.demo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: jorden
 * @Date: 2019/1/29 14:49
 * @Description:  -Xms100m -Xmx100m -XX:+UseSerialGC
 */
public class OOMObject {
    public byte[] placeholder = new byte[64*1024];
    public static void fillHeap(int num) throws InterruptedException{
        List<OOMObject> list = new ArrayList<>();
        for(int i=0;i<num;i++){
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        fillHeap(1000);
    }
}
