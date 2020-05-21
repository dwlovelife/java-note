package datastructures.linkedlist.code;

/**
 * 单向链表的demo
 * @author Administrator
 *
 */
public class SingleLinkedListDemo {
	public static void main(String[] args) {
		SingleLinkedList linkedList = new SingleLinkedList();
		Node nodeA = new Node(1,"宋江","及时雨");
		Node nodeB = new Node(3,"吴用","智多星");
		Node nodeC = new Node(2,"林冲","豹子头");
		linkedList.list();
		linkedList.addByOrder(nodeA);
		linkedList.addByOrder(nodeB);
		linkedList.addByOrder(nodeC);
		linkedList.list();
		linkedList.remove(nodeA);
		linkedList.list();
		linkedList.update(new Node(2,"时迁","鼓上蚤"));
		linkedList.list();
		linkedList.remove(nodeB);
		linkedList.remove(nodeC);
		linkedList.list();


	}
}

class SingleLinkedList {
	
	//定义一个头节点,不存放任何数据
	private Node head = new Node(0);
	
	/**
	 * 添加一个节点
	 * @param node
	 */
	public void add(Node node){
		Node temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = node;
	}
	
	/**
	 * 按序添加一个节点
	 * @param node
	 */
	public void addByOrder(Node node){
		Node temp = head;
		while(temp.next != null){
			if(temp.next.id > node.id){
				node.next = temp.next;
				break;
			}
			temp = temp.next;
		}
		temp.next = node;
	}
	
	/**
	 * 修改一个节点
	 * @param node
	 * @return boolean
	 */
	public boolean update(Node node){
		Node findedNode = findNode(node);
		//是否被修改
		boolean flag = false;
		if(findedNode != null){
			findedNode.name = node.name;
			findedNode.nickName = node.nickName;
			flag = true;
		}
			
		return flag;
	}
	
	/**
	 * 是否移除一个节点
	 * @param node
	 * @return boolean
	 */
	public boolean remove(Node node){
		Node temp = head;
		boolean flag = false;
		while(temp.next != null){
			if(temp.next.id == node.id){
				temp.next = temp.next.next;
				flag = true;
				break;
			}
			temp = temp.next;
		}
		return flag;
	}
	
	/**
	 * 遍历所有节点
	 */
	public void list(){
		System.out.println("--------START--------");
		Node temp = head.next;
		while(temp != null){
			System.out.println(temp);
			temp = temp.next;
		}
		System.out.println("--------END----------");
	}
	
	/**
	 * 查询当前节点
	 * @param node
	 * @return node
	 */
	public Node findNode(Node node){
		Node temp = head;
		while(temp.next != null){
			if(temp.id == node.id){
				break;
			}
			temp = temp.next;
		}
		return temp;
	}
	
}

class Node {
	
	int id;
	String name;
	String nickName;
	Node next;
	
	public Node(int id, String name, String nickName) {
		super();
		this.id = id;
		this.name = name;
		this.nickName = nickName;
	}

	public Node(int id) {
		super();
		this.id = id;
	}


	@Override
	public String toString() {
		return "Node [id=" + id + ", name=" + name + ", nickName=" + nickName + "]";
	}
	
}
