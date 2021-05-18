package concurrent;


import java.util.List;
import java.util.Vector;

public class SingleContainer {

    private static volatile SingleContainer instance;
    private SingleContainer(){}
    private volatile int number = 0;
    private List<String> list = new Vector<>();

    public static SingleContainer getInstance(){
        if(instance == null){
            synchronized (SingleContainer.class) {
                if(instance == null){
                    instance = new SingleContainer();
                }
            }
        }
        return instance;
    }

    public void offer(String str){
        while(number == 2){
            try {
                this.wait();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        list.add(str);
        number++;
        this.notifyAll();
    }

    public void poll(){
        while(number != 2){
            try {
                this.wait();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        String a = list.get(0);
        String b = list.get(1);
        for(int i = 0; i < Math.max(a.length(),b.length()); i++){
            if(i < a.length()){
                System.out.print(a.charAt(i));
            }
            if(i < b.length()){
                System.out.print(b.charAt(i));
            }
        }
        number = 0;
        this.notifyAll();
    }

    public int size(){
        return list.size();
    }


}
