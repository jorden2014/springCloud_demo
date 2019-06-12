package com.example.demo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: jorden
 * @Date: 2019/1/25 17:26
 * @Description: -XX:PermSize=2M -XX:MaxPermSize=2M
 */
public class RuntimeConstantsOOM {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        int i=0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
