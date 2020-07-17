package behavior.observer;

/**
 * 主题
 */
public interface Subject {


    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver(Observer observer);

}
