package datastructures.linkedlist.code;

/**
 * 单向链表的demo
 * 
 * @author Administrator
 *
 */
public class SingleLinkedListDemo {
	public static void main(String[] args) {
		SingleLinkedList<Integer> s = new SingleLinkedList<>();
		s.add(1);
		s.add(2);
		s.remove(2);
		s.printAll();
	}
}

class SingleLinkedList<E> {

	private final Node<E> head = new Node<>(null);
	private int size = 0;

	/**
	 * 添加一个元素
	 */
	public boolean add(E e) {
		Node<E> temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new Node<>(e);
		size++;
		return true;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> temp = head.next;
		int counter = 0;
		while (temp != null) {
			if (index == counter++) {
				return temp.item;
			}
			temp = temp.next;
		}
		return null;
	}
	//todo 不太对
	public boolean remove(E e) {
		Node<E> temp = head.next;
		boolean isRemove = false;
		while (temp != null) {
			boolean isAllEqual = e != null && e.equals(temp.next.item);
			boolean isAllNull = e == null && temp.next.item == null;
			if (isAllEqual || isAllNull) {
				temp.next = temp.next.next;
				isRemove = true;
			}
			temp = temp.next;
		}
		return isRemove;
	}

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
