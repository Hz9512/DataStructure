package com.newtouch.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
	public static void main(String[] args) {
		CircleArray queue=new CircleArray(4);
		char key=' ';
		Scanner sc = new Scanner(System.in);
		boolean loop=true;
		while(loop) {
			System.out.println("s(show):��ʾ����");
			System.out.println("e(exit):�˳�����");
			System.out.println("a(add):�������");
			System.out.println("g(get):ȡ����");
			System.out.println("h(head):�鿴����ͷ������");
			key=sc.next().charAt(0);
			switch(key) {
			case 's':
				queue.show();
				break;
			case 'a':
				System.out.println("���������ݣ�");
				int value=sc.nextInt();
				queue.add(value);
				break;
			case 'g':
				try {
					int res=queue.get();
					System.out.printf("��ȡ���������ǣ�%d\n",res);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res=queue.head();
					System.out.printf("��ͷ������%d\n",res);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				sc.close();
				loop=false;
				break;
			default:
				break;
			}
		}
		System.out.println("�����˳�");
	}

}

class CircleArray {
	private int maxSize;// �����������
	private int front;// ��ͷ ָ����еĵ�һ��Ԫ��
	private int rear;// ��β
	private int[] arr;// ������ݣ�ģ�����

	public CircleArray(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
	}

	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}

	public boolean isEmpty() {
		return rear == front;
	}

	public void add(int n) {
		if (isFull()) {
			System.out.println("����");
			return;
		}
		arr[rear] = n;
		rear = (rear + 1) % maxSize;
	}

	public int get() {
		if (isEmpty()) {
			throw new RuntimeException("�յ�");
		}
		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
	}

	// ��ЧԪ�ظ���
	public int size() {
		return (rear + maxSize - front) % maxSize;
	}

	public void show() {
		if (isEmpty()) {
			System.out.println("�յ�");
			return;
		}
		for (int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}
	
	public int head() {
		if (isEmpty()) {
			throw new RuntimeException("�յ�");
		}

		return arr[front];
	}
}
