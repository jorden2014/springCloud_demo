package com.example.demo.jvm;

/**
 * @Auther: jorden
 * @Date: 2019/1/26 17:25
 * @Description:
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("alive!");
    }

    @Override
    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable{
        SAVE_HOOK = new FinalizeEscapeGC();

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if(SAVE_HOOK !=null ){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("dead");
        }

        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if(SAVE_HOOK !=null ){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("dead");
        }
    }
}
