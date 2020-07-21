package Demo.singleton;


//懒汉模式优良版（DCL双端检索机制）线程安全
public class Single3 {
    private static Single3 instance =null;

    private Single3(){
        System.out.println("Single3"+System.nanoTime());
    }

    public static synchronized Single3 getInstance(){
        if (instance ==null){
            synchronized (Single3.class){
                if (instance==null){
                    instance =new Single3();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Single3.getInstance();
    }

}
