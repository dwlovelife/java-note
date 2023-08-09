package structure.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 图书馆
 * @author: dingwei17@jd.com
 * @date : 2023/8/9 19:54
 */
public class Library {

    private Map<String, Book> bookPoolMap = new HashMap<>();
    //图书馆只有一个
    private static Library factory = new Library();

    public static Library getInstance() {
        return factory;
    }

    public Book libToBorrow(String bookName) {
        Book order = null;
        if (bookPoolMap.containsKey(bookName)) {
            //有就从图书馆租借
            order = bookPoolMap.get(bookName);
        } else {
            //没有就新建一本
            order = new ConcreteBook(bookName);
            bookPoolMap.put(bookName, order);
        }
        return order;
    }

    /**
     * 获取图书馆的数量
     * @return
     */
    public int getAllBookSize() {
        return bookPoolMap.size();
    }


}
