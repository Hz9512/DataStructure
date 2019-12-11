package com.newtouch.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
	public static void main(String[] args) {
		ArrayQueue queue=new ArrayQueue(3);
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

//ʹ������ģ����б�дһ��ArrayQueue��
class ArrayQueue {
	private int maxSize;// �����������
	private int front;// ��ͷ
	private int rear;// ��β
	private int[] arr;// ������ݣ�ģ�����

	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		front = -1;// ָ���ͷǰһ��λ��
		rear = -1;// ָ���β�����������һ��Ԫ�أ�
		arr = new int[maxSize];
	}

	// �ж϶����Ƿ���
	public boolean isFull() {
		return rear == maxSize - 1;
	}

	// �ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return rear == front;
	}

	// ������ݵ�����
	public void add(int n) {
		if (isFull()) {
			System.out.println("����");
			return;
		}
		rear++;
		arr[rear] = n;
	}

	// �Ӷ��л�ȡ����
	public int get() {
		if (isEmpty()) {
			throw new RuntimeException("�յ�");
		}
		front++;
		return arr[front];
	}

	// ��������
	public void show() {
		if (isEmpty()) {
			System.out.println("�յ�");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
	}

	// ��ʾͷ������
	public int head() {
		if (isEmpty()) {
			throw new RuntimeException("�յ�");
		}

		return arr[front + 1];
	}

}
