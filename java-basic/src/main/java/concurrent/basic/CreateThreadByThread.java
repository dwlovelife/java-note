package concurrent.basic;

/**
 * 通过Thread创建线程
 */
public class CreateThreadByThread {


    public static void main(String[] args) {
        Thread ticketThread = new MyThread();
        Thread t1 = new Thread(ticketThread);
        Thread t2 = new Thread(ticketThread);
        t1.start();
        t2.start();
    }


    static class MyThread extends Thread {

        private static int ticket = 100;

        @Override
        public void run() {
            while (ticket > 0) {
                System.out.println("当前余票:" + --ticket);
            }
        }
    }

}
