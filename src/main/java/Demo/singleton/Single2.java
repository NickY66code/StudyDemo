package Demo.singleton;

//懒汉模式(线程不安全)
public class Single2 {
    private static Single2 instance =new Single2();

    private Single2(){
        System.out.println("Single2"+System.nanoTime());
    }

    public static Single2 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        if (instance==null){
            instance =new Single2();
        }

    }
}
