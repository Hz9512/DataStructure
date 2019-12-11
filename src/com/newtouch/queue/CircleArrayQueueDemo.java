package com.newtouch.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
	public static void main(String[] args) {
		CircleArray queue=new CircleArray(4);
		char key=' ';
		Scanner sc = new Scanner(System.in);
		boolean loop=true;
		while(loop) {
			System.out.println("s(show):显示队列");
			System.out.println("e(exit):退出程序");
			System.out.println("a(add):添加数据");
			System.out.println("g(get):取数据");
			System.out.println("h(head):查看队列头部数据");
			key=sc.next().charAt(0);
			switch(key) {
			case 's':
				queue.show();
				break;
			case 'a':
				System.out.println("请输入数据：");
				int value=sc.nextInt();
				queue.add(value);
				break;
			case 'g':
				try {
					int res=queue.get();
					System.out.printf("您取出的数据是：%d\n",res);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res=queue.head();
					System.out.printf("队头数据是%d\n",res);
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
		System.out.println("程序退出");
	}

}

class CircleArray {
	private int maxSize;// 数组最大容量
	private int front;// 队头 指向队列的第一个元素
	private int rear;// 队尾
	private int[] arr;// 存放数据，模拟队列

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
			System.out.println("满了");
			return;
		}
		arr[rear] = n;
		rear = (rear + 1) % maxSize;
	}

	public int get() {
		if (isEmpty()) {
			throw new RuntimeException("空的");
		}
		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
	}

	// 有效元素个数
	public int size() {
		return (rear + maxSize - front) % maxSize;
	}

	public void show() {
		if (isEmpty()) {
			System.out.println("空的");
			return;
		}
		for (int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}
	
	public int head() {
		if (isEmpty()) {
			throw new RuntimeException("空的");
		}

		return arr[front];
	}
}
