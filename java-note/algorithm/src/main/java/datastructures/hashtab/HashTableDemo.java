package datastructures.hashtab;


import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {
        //创建哈希表
        HashTable hashTable = new HashTable(7);

        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:查询雇员");
            System.out.println("remove:删除雇员");
            System.out.println("exit:退出系统");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int addId = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp = new Emp(addId, name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("输入id");
                    int findId = scanner.nextInt();
                    hashTable.find(findId);
                    break;
                case "remove":
                    System.out.println("输入id");
                    int removeId = scanner.nextInt();
                    hashTable.remove(removeId);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }

    }
}

//表示一个雇员
class Emp {
    int id;
    String name;
    Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Emp(Emp next) {
        this.next = next;
    }
}

//创建hashTable 管理多条链表
class HashTable {
    private EmpLinkedList[] empLinkedLists;
    private int size;

    public HashTable(int size) {
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp) {
        //根据员工的id,得到该员工应该添加到哪条链表
        int empLinkedListNo = hashFun(emp.id);
        empLinkedLists[empLinkedListNo].add(emp);
    }

    //遍历所有的链表,遍历hashtab
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }

    //根据id查找雇员
    public void find(int id) {
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedLists[empLinkedListNo].find(id);
        if (emp == null) {
            System.out.println("在该哈希表中,未找到雇员");
        } else {
            System.out.println("在第" + empLinkedListNo + "中找到雇员:" + emp.name);
        }
    }

    //根据id雇员
    public void remove(int id) {
        int empLinkedListNo = hashFun(id);
        boolean isRemove = empLinkedLists[empLinkedListNo].remove(id);
        if (isRemove) {
            System.out.println("删除成功!");
        } else {
            System.out.println("删除失败!");
        }
    }


    //编写散列函数,使用一个简单取模法
    public int hashFun(int id) {
        return id % size;
    }

}

//创建EmpLinkedList,表示链表
class EmpLinkedList {
    //头指针,执行第一个Emp,因此我们这个链表的head 是直接指向第一个Emp
    private Emp head; //默认为null

    /**
     * 添加雇员到链表
     * 说明
     * 1. 假定添加雇员时,id是自增长,即id的分配从小到大
     * 因此我们将该雇员直接加入到本链表的最后即可
     */
    public void add(Emp emp) {
        //如果是添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是第一个雇员,则使用一个辅助的指针,帮助定位到最后
        Emp curEmp = head;
        while (curEmp != null) {
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    //遍历雇员的信息
    public void list(int i) {
        Emp curEmp = head;
        while (curEmp != null) {
            System.out.printf("%d:[id=%d,name=%s]\n", i, curEmp.id, curEmp.name);
            curEmp = curEmp.next;
        }
    }

    public Emp find(int id) {
        //辅助指针
        Emp curEmp = head;
        while (curEmp != null) {
            if (curEmp.id == id) {
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }

    public boolean remove(int id) {
        Emp curEmp = new Emp(head);
        while (curEmp.next != null) {
            if (curEmp.next.id == id) {
                curEmp.next = curEmp.next.next;
                head = curEmp.next;
                return true;
            }
            curEmp = curEmp.next;
        }
        return false;
    }

}