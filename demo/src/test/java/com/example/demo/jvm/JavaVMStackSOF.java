package com.example.demo.jvm;

/**
 * @Auther: jorden
 * @Date: 2019/1/25 15:13
 * @Description: -Xss128k
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        }catch (Throwable throwable){
            System.out.println("stack length:"+ oom.stackLength);
            throw throwable;
        }
    }
}
