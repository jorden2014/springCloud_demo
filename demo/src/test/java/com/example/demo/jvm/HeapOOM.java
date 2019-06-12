package com.example.demo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: jorden
 * @Date: 2019/1/25 15:55
 * @Description:   -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args){
        List<OOMObject> oomObjectList = new ArrayList<>();
        while (true){
            oomObjectList.add(new OOMObject());
        }
    }
}
