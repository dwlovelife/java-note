package datastructures.linkedlist.code;


public class DoubleLinkedListDemo {
    public static void main(String[] args) {
		DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		System.out.println("size:" + linkedList.size());
		linkedList.printAll();
		System.out.println(linkedList.remove(1));
		System.out.println(linkedList.remove(0));
		System.out.println(linkedList.remove(0));
    }

}

class DoubleLinkedList<E> {
    private Node<E> head = new Node<>(null);

    /**
     * 添加一个元素
     */
    public void add(E element) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node<E> node = new Node<>(element);
        temp.next = node;
        node.pre = temp;
		head.size++;
    }

    public E remove(int index){
		checkIndexIsIllegal(index);
		Node<E> temp = head;
		for (int i = -1; temp.next != null; i++, temp = temp.next) {
			if (index == i + 1) { //找到前一个元素
				break;
			}
		}
		//因为已经前置了指针 所以removeNode必不等于空
		Node<E> removeNode = temp.next;
		if(removeNode.next == null){
			temp.next = null;
		}else{
			temp.next = removeNode.next;
			removeNode.next.pre = temp;
		}
		head.size--;
		return removeNode.element;
	}

    /**
     * 修改一个元素
     */
    public E update(int index, Node<E> node) {
        checkIndexIsIllegal(index);
        Node<E> temp = head.next;
        for (int i = 0; temp.next != null; i++, temp = temp.next) {
            if (index == i) {
                break;
            }
        }
        E oldVal = temp.element;
        temp.element = node.element;
        return oldVal;
    }

    public E get(int index){
		checkIndexIsIllegal(index);
		Node<E> temp = head.next;
		for (int i = 0; temp.next != null; i++, temp = temp.next) {
			if (index == i) {
				break;
			}
		}
		return temp.element;
	}

	public int size(){
    	return head.size;
	}

    public void printAll() {
        Node temp = head.next;
        System.out.println("-------打印之前-------");
        while (temp != null) {
			System.out.println(temp);
			temp = temp.next;
        }
        System.out.println("-------打印之后-------");
    }

    private void checkIndexIsIllegal(int index) {
        if (index < 0 || index >= head.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    static class Node<E> {
        int size;
        E element;
        Node<E> next;
        Node<E> pre;


        public Node(E element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return "Node [element=" + element + "]";
        }
    }
}


