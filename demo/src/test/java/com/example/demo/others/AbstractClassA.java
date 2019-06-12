package com.example.demo.others;

import java.util.ArrayList;
import java.util.Vector;

/**
 * @Auther: jorden
 * @Date: 2019/3/6 14:20
 * @Description:
 */
public abstract class AbstractClassA {

    ArrayList arrayList;
    Vector vector;
    abstract void methodA();

    void methodB(){
        System.out.println("methodB");
    }
}
