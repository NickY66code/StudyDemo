package Demo.singleton;

public class Single4 {
    private Single4(){
        System.out.println("Single4"+System.nanoTime());
    }

    public static Single4 getInstance(){
        return SingletonFactory.singletonInstance;
    }

    private static class SingletonFactory{
        private static Single4 singletonInstance =new Single4();
    }

    public static void main(String[] args) {
        Single4.getInstance();
    }
}
