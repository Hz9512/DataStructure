package com.newtouch.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
	public static void main(String[] args) {
		ArrayQueue queue=new ArrayQueue(3);
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

//使用数组模拟队列编写一个ArrayQueue类
class ArrayQueue {
	private int maxSize;// 数组最大容量
	private int front;// 队头
	private int rear;// 队尾
	private int[] arr;// 存放数据，模拟队列

	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		front = -1;// 指向队头前一个位置
		rear = -1;// 指向队尾（即队列最后一个元素）
		arr = new int[maxSize];
	}

	// 判断队列是否满
	public boolean isFull() {
		return rear == maxSize - 1;
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return rear == front;
	}

	// 添加数据到队列
	public void add(int n) {
		if (isFull()) {
			System.out.println("满了");
			return;
		}
		rear++;
		arr[rear] = n;
	}

	// 从队列获取数据
	public int get() {
		if (isEmpty()) {
			throw new RuntimeException("空的");
		}
		front++;
		return arr[front];
	}

	// 遍历队列
	public void show() {
		if (isEmpty()) {
			System.out.println("空的");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
	}

	// 显示头部数据
	public int head() {
		if (isEmpty()) {
			throw new RuntimeException("空的");
		}

		return arr[front + 1];
	}

}
