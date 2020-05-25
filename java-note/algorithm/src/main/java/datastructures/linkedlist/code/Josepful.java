package datastructures.linkedlist.code;

public class Josepful {
	public static void main(String[] args) {
		// 测试一把看看构建环形链表和遍历是否OK
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(5);
		circleSingleLinkedList.countBoy(1, 2, 5);
		}
}

// 创建一个环形单向链表
class CircleSingleLinkedList {
	
	// 创建一个first节点,当前没有编号
	private Boy first = new Boy(-1);

	// 添加小孩节点,构建成一个环形的链表
	public void addBoy(int nums) {
		// nums 做一个数据校验
		if (nums < 1) {
			System.out.println("nums的值不正确");
		}
		Boy curBoy = null;
		// 使用for来创建我们的环形链表
		for (int i = 1; i <= nums; i++) {
			// 根据编号,创建小孩节点
			Boy boy = new Boy(i);
			// 如果是第一个小孩
			if (i == 1) {
				first = boy;
				first.next = first;
				curBoy = first; // 让curBoy指向第一个小孩
			} else {
				curBoy.next = boy;
				boy.next = first;
				curBoy = boy;
			}
		}
	}

	// 遍历当前的环形链表
	public void showBoy() {
		// 判断链表是否为空
		if (first == null) {
			System.out.println("没有任何小孩~");
			return;
		}
		// 因为first不能动,因此我们仍然使用一辅助指针完成遍历
		Boy curBoy = first;
		while (true) {
			System.out.printf("小孩的编号 %d \n", curBoy.no);
			if (curBoy.next == first) {
				break;// 因为是环形链表
			}
			curBoy = curBoy.next;
		}
	}

	// 根据用户的输入,计算小孩出圈的顺序
	/**
	 * 
	 * @param startNo
	 *            表示第几个小孩开始数
	 * @param countNum
	 *            表示数几下
	 * @param nums
	 *            表示最初有多少小孩在圈中
	 */
	public void countBoy(int startNo, int countNum, int nums) {
		// 先对数据进行校验
		if (first == null || startNo < 1 || startNo > nums) {
			System.out.println("您输入的参数有误");
		}
		// 创建要给辅助指针,帮助完成小孩出圈
		Boy helper = first;
		// 需求创建一个辅助指针变量Helper，事先应该指向环形链表的最后这个节点
		while (true) {
			if (helper.next == first) {
				break;
			}
			helper = helper.next;
		}
		// 小孩报数前先,先让first 和 helper 移动K-1次
		for (int j = 0; j < startNo - 1; j++) {
			first = first.next;
			helper = helper.next;
		}
		//当小孩报数时,让first和helper指针同时移动m-1次,然后出题
		while(true){
			if(helper == first){//表明圈中只有一个节点
				break; 
			}
			for(int j = 0; j < countNum - 1; j++){
				first = first.next;
				helper = helper.next;
			}
			//这是first指向的节点，就是要出圈的小孩节点
			System.out.printf("小孩%d出圈\n",first.no);
			//这时将first指向的小孩节点出圈
			first = first.next;
			helper.next = first;
		}
		System.out.printf("最后留在圈中的小孩编号%d \n", first.no);
	}

}

// 创建一个Boy类
class Boy {
	int no;// 编号
	Boy next;// 指向下一个节点,默认null

	public Boy(int no) {
		this.no = no;
	}
}