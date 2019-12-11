package com.newtouch.linklist;

/**
 * Josephu 问题为：设编号为1，2，… n的n个人围坐一圈，约定编号为k（1<=k<=n）的人从1开始报数， 数到m
 * 的那个人出列，它的下一位又从1开始报数，数到m的那个人又出列，依次类推，直到所有人出列为止，由此产生一个出队编号的序列。
 * 
 * @author Administrator
 *
 */
public class Josephu {
	public static void main(String[] args) {
		CircleSingleLinkedList circle = new CircleSingleLinkedList();
		circle.addBoy(5);
//		circle.showBoy();
		circle.countBoy(1, 2, 5);
	}
}

class CircleSingleLinkedList {
	private Boy first = null;

	// 添加
	public void addBoy(int nums) {
		if (nums < 1) {
			System.out.println("nums的值不正确");
			return;
		}
		Boy curBoy = null;
		for (int i = 1; i <= nums; i++) {
			Boy boy = new Boy(i);
			if (i == 1) {
				first = boy;
				first.setNext(boy);
				curBoy = first;
			} else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
			}
		}
	}

	// 遍历
	public void showBoy() {
		if (first == null) {
			System.out.println("链表是空的");
			return;
		}

		Boy curBoy = first;
		while (true) {
			System.out.printf("小孩编号为：%d\n", curBoy.getNo());
			if (curBoy.getNext() == first) {
				break;
			}
			curBoy = curBoy.getNext();
		}
	}

	// 出圈
	public void countBoy(int startNo, int countNum, int nums) {
		if (first == null || startNo < 1 || startNo > nums) {
			System.out.println("输入有误！！");
			return;
		}
		Boy helper = first;
		// 定位helper指针
		while (true) {
			if (helper.getNext() == first) {
				break;
			}
			helper = helper.getNext();
		}
		// 定位first和helper两个指针，定位到开始位置上
		for (int j = 0; j < startNo - 1; j++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		// 开始报数
		while (true) {
			if (helper == first) {
				break;
			}
			for (int i = 0; i < countNum; i++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			System.out.printf("小孩%d出圈\n", first.getNo());
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.printf("最后一个小孩%d出圈\n", first.getNo());
	}
}

class Boy {
	private int no;
	private Boy next;

	public Boy(int no) {
		super();
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}
}
