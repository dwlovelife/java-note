package structure.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO
 * @author: dingwei17@jd.com
 * @date : 2023/8/9 20:01
 */
public class Test {


    public static void main(String[] args) {
        Library library = Library.getInstance();
        List<Book> bookList = new ArrayList<>();
        bookList.add(library.libToBorrow("java编程思想"));
        bookList.add(library.libToBorrow("java核心思想"));
        bookList.add(library.libToBorrow("从入门到精通"));
        System.out.println("后两本没学会再借一次");
        bookList.add(library.libToBorrow("java核心思想"));
        bookList.add(library.libToBorrow("从入门到精通"));
        for (Book book: bookList) {
            book.borrow();
        }
        System.out.println("学生一共借了:" + bookList.size() + "次书");
        System.out.println("图书馆一共有:" + library.getAllBookSize() + "本书");
    }

}
