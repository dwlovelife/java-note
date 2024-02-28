package concurrent.basic;

public class CreatThreadByRunnable {

    public static void main(String[] args) {
        MyRunnable ticketRunnable = new MyRunnable();
        Thread t1 = new Thread(ticketRunnable);
        Thread t2 = new Thread(ticketRunnable);
        t1.start();
        t2.start();
    }

    static class MyRunnable implements Runnable {

        private static int ticket = 100;

        @Override
        public void run() {
            while (ticket > 0) {
                System.out.println("当前余票:" + --ticket);
            }
        }
    }

}
