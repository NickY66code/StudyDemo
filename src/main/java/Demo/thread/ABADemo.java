package Demo.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {
    static AtomicReference<Integer> atomicReference=new AtomicReference<>(100);
    static AtomicStampedReference atomicStampedReference=new AtomicStampedReference(100,1);

    public static void main(String[] args) {
        System.out.println("================以下为ABA问题的产生=======================");

        new Thread(() ->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"t1").start();

        new Thread(() ->{
            //暂停1s线程，让t1执行完`
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100,2019)+"\t"+atomicReference.get());
        },"t2").start();

        //暂停2s线程
        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("================以下是ABA问题的解决==================");
        new Thread(() ->{
            int stamp =atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t第一次版本号:"+stamp);
            //暂停1s线程
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t第二次版本号:"+atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t第三次版本号:"+atomicStampedReference.getStamp());
            },"t3").start();

        new Thread(() ->{
            int stamp =atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t第一次版本号:"+stamp);
            //暂停3s线程
            try{
                TimeUnit.SECONDS.sleep(3);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            boolean result=atomicStampedReference.compareAndSet(100,2020,stamp,stamp+1);

            System.out.println(Thread.currentThread().getName()+"\t修改是否成功："+result+"当前实际版本号"+atomicStampedReference.getStamp());
            System.out.println(Thread.currentThread().getName()+"\t当前实际最新值："+atomicStampedReference.getReference());
            },"t4").start();
    }
}
