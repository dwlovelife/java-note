package datastructures.linkedlist.code;

public class DoubleLinkedListDemo {
	
	
	public static void main(String[] args) {
		Nodes Nodes1 = new Nodes(2,"火神");
		Nodes Nodes2 = new Nodes(1,"雷神");
		Nodes Nodes3 = new Nodes(4,"花神");
		Nodes Nodes4 = new Nodes(3,"水神");
		
//		addByOrder(Nodes1);
//		addByOrder(Nodes2);
//		addByOrder(Nodes3);
//		addByOrder(Nodes4);
		add(Nodes1);
		add(Nodes2);
		add(Nodes3);
		add(Nodes4);
		printAll();
		
	}
	
	static Nodes head = new Nodes(-1, null);

	/**
	 * 添加一个节点
	 * 
	 * @param Nodes
	 */
	public static void add(Nodes Nodes) {
		Nodes temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = Nodes;
		Nodes.pre = temp;
	}

	/**
	 * 按顺序添加一个节点
	 * 
	 * @param Nodes
	 */
	public static void addByOrder(Nodes Nodes) {
		if (Nodes.id <= -1) {
			throw new IndexOutOfBoundsException("id越界了!");
		}
		Nodes temp = head;
		while (temp.next != null) {
			if (Nodes.id < temp.next.id) {
				break;
			}
			temp = temp.next;
		}

		if (temp.next == null) {
			temp.next = Nodes;
			Nodes.pre = temp;
		} else {
			temp.next.pre = Nodes;
			Nodes.next = temp.next;
			Nodes.pre = temp;
			temp.next = Nodes;
		}

	}
	
	public static boolean update(int id,Nodes Nodes){
		Nodes temp = head;
		while(temp.next != null){
			//if()
			temp = temp.next;
		}
		return true;
	}
	
	public static void printAll(){
		Nodes temp = head;
		System.out.println("-------打印之前-------");
		while(temp.next != null){
			temp = temp.next;
			System.out.println(temp);
		}
		System.out.println("-------打印之后-------");
	}

	
}

class Nodes {
	int id;
	String name;
	Nodes next;
	Nodes pre;

	public Nodes(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Nodes [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
