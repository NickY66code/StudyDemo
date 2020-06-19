import org.junit.Test;
import recursion.recursionDemo;

public class recursionTest {

    @Test
    public void recursionTest1(){
        recursionDemo demo1 =new recursionDemo();
        long startTime =System.nanoTime();//获取开始时间
        int a=demo1.solve1(50);
        System.out.println(a);
        long endTime =System.nanoTime();//获取结束时间
        System.out.println("程序共执行了"+(endTime-startTime)+"ms");
    }

    @Test
    public void recursionTest2(){
        recursionDemo demo2 =new recursionDemo();
        long startTime =System.nanoTime();//获取开始时间
        int a=demo2.solve2(10);
        System.out.println(a);
        long endTime =System.nanoTime();//获取结束时间
        System.out.println("程序共执行了"+(endTime-startTime)+"ms");
    }

    @Test
    public void recursionTest3(){
        recursionDemo demo3 =new recursionDemo();
        long startTime =System.nanoTime();//获取开始时间
        int a=demo3.solve3(10);
        System.out.println(a);
        long endTime =System.nanoTime();//获取结束时间
        System.out.println("程序共执行了"+(endTime-startTime)+"ms");
    }

}
