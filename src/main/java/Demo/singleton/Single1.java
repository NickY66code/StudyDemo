package Demo.singleton;

//饿汉模式（线程安全）
public class Single1 {
    private static Single1 instance =new Single1();

    private Single1(){
        System.out.println("single1"+System.nanoTime());

    }

    public static Single1 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        Single1.getInstance();
    }
}
