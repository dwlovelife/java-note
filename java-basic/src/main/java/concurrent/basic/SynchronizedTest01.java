package concurrent.basic;


public class SynchronizedTest01 {
    public static void main(String[] args) throws InterruptedException {

        SynchronizedTest01 t1 = new SynchronizedTest01();
        SynchronizedTest01 t2 = new SynchronizedTest01();
        new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        }).start();
        Thread.sleep(2000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                decrement();
            }
        }).start();
    }


    public static synchronized void increment() {
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("出来了");
    }
    public static synchronized void decrement(){
        System.out.println("进入了方法");
    }

}
