package com.newtouch.linklist;

/**
 * Josephu ����Ϊ������Ϊ1��2���� n��n����Χ��һȦ��Լ�����Ϊk��1<=k<=n�����˴�1��ʼ������ ����m
 * ���Ǹ��˳��У�������һλ�ִ�1��ʼ����������m���Ǹ����ֳ��У��������ƣ�ֱ�������˳���Ϊֹ���ɴ˲���һ�����ӱ�ŵ����С�
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

	// ���
	public void addBoy(int nums) {
		if (nums < 1) {
			System.out.println("nums��ֵ����ȷ");
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

	// ����
	public void showBoy() {
		if (first == null) {
			System.out.println("�����ǿյ�");
			return;
		}

		Boy curBoy = first;
		while (true) {
			System.out.printf("С�����Ϊ��%d\n", curBoy.getNo());
			if (curBoy.getNext() == first) {
				break;
			}
			curBoy = curBoy.getNext();
		}
	}

	// ��Ȧ
	public void countBoy(int startNo, int countNum, int nums) {
		if (first == null || startNo < 1 || startNo > nums) {
			System.out.println("�������󣡣�");
			return;
		}
		Boy helper = first;
		// ��λhelperָ��
		while (true) {
			if (helper.getNext() == first) {
				break;
			}
			helper = helper.getNext();
		}
		// ��λfirst��helper����ָ�룬��λ����ʼλ����
		for (int j = 0; j < startNo - 1; j++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		// ��ʼ����
		while (true) {
			if (helper == first) {
				break;
			}
			for (int i = 0; i < countNum; i++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			System.out.printf("С��%d��Ȧ\n", first.getNo());
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.printf("���һ��С��%d��Ȧ\n", first.getNo());
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
