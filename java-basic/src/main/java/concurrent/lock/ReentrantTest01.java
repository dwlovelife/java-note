package concurrent.lock;


import org.openjdk.jol.info.ClassLayout;

public class ReentrantTest01 {
    final static Object o = new Object();

    public static void main(String[] args) {
        System.out.println("--------第一次获取锁之前--------");
        System.out.println( ClassLayout.parseInstance(o).toPrintable() );
        synchronized (o){
            System.out.println("第一次获取锁");
            System.out.println( ClassLayout.parseInstance(o).toPrintable() );
            synchronized (o){
                System.out.println("第二次获取锁");
                System.out.println( ClassLayout.parseInstance(o).toPrintable() );
            }
        }
        System.out.println("--------第三次获取锁之前--------");
        System.out.println( ClassLayout.parseInstance(o).toPrintable() );
        synchronized (o){
            System.out.println("第三次获取锁");
            System.out.println( ClassLayout.parseInstance(o).toPrintable() );
        }
        System.out.println("-----全部释放锁------");
        System.out.println( ClassLayout.parseInstance(o).toPrintable() );
    }
}
