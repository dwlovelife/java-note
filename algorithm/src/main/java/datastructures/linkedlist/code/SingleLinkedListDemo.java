package datastructures.linkedlist.code;

/**
 * 单向链表的demo
 */
public class SingleLinkedListDemo {
	public static void main(String[] args) {
		SingleLinkedList<Integer> s = new SingleLinkedList<>();
		s.add(1);
		s.add(2);
		s.remove(1);
		System.out.println(s.get(0));
		s.set(0,9);
		System.out.println(s.get(0));
		s.printAll();
		System.out.println(s.get(1));

	}
}

class SingleLinkedList<E> {

	private final Node<E> head = new Node<>(null);
	private int size = 0;

	/**
	 * 添加一个元素
	 */
	public void add(E e) {
		Node<E> temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new Node<>(e);
		size++;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 获取某个index上的元素
	 */
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> temp = head.next;
		int counter = 0;
		while (temp != null) {
			if (index == counter++) {
				break;
			}
			temp = temp.next;
		}
		return temp == null ? null: temp.item;
	}

	/**
	 * 移除一个元素
	 */
	public boolean remove(E e) {
		Node<E> temp = head;
		while(temp.next != null){
			if(temp.next.item.equals(e)){
				temp.next = temp.next.next;
				size--;
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public boolean set(int index,E e){
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> temp = head.next;
		int counter = 0;
		while (temp != null) {
			if (index == counter++) {
				temp.item = e;
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	/**
	 * 打印所有元素
	 */
	public void printAll() {
		Node temp = head.next;
		System.out.println("---------start-----------");
		while (temp != null) {
			System.out.println(temp.item);
			temp = temp.next;
		}
		System.out.println("---------end-----------");
	}

	/**
	 * 内部类节点
	 */
	private static class Node<E> {
		E item;
		Node next;

		public Node(E item) {
			super();
			this.item = item;
		}

		@Override
		public String toString() {
			return "Node [item=" + item + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((item == null) ? 0 : item.hashCode());
			result = prime * result + ((next == null) ? 0 : next.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (item == null) {
				if (other.item != null)
					return false;
			} else if (!item.equals(other.item))
				return false;
			if (next == null) {
				if (other.next != null)
					return false;
			} else if (!next.equals(other.next))
				return false;
			return true;
		}

	}

}
