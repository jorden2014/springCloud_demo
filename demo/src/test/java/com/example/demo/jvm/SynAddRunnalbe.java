package com.example.demo.jvm;

/**
 * @Auther: jorden
 * @Date: 2019/1/29 18:22
 * @Description:
 */
public class SynAddRunnalbe implements Runnable {
    int a,b;
    public SynAddRunnalbe(int a, int b){
        this.a = a;
        this.b = b;
    }
    @Override
    public void run() {
        synchronized(Integer.valueOf(a)){
            synchronized (Integer.valueOf(b)){
                System.out.println(a+b);
            }
        }
    }

    public static void main(String[] args){
        for(int i=0;i<100;i++){
            new Thread(new SynAddRunnalbe(1,2));
            new Thread(new SynAddRunnalbe(2,1));
        }
    }
}
