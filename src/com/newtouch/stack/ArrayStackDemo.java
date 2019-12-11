package com.newtouch.stack;

import java.util.Scanner;

public class ArrayStackDemo {
	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(4);
		String key = "";
		boolean loop = true;
		Scanner sc = new Scanner(System.in);
		while (loop) {
			System.out.println("show:��ʾ����ջ");
			System.out.println("exit:�˳�����");
			System.out.println("push:��ջ");
			System.out.println("pop:��ջ");
			System.out.println("����������ѡ��");
			key = sc.next();
			switch (key) {
			case "show":
				stack.list();
				break;
			case "push":
				System.out.println("�������һ������");
				int value = sc.nextInt();
				stack.push(value);
				break;
			case "pop":
				try {
					int res = stack.pop();
					System.out.printf("��ջ�������ǣ�%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "exit":
				sc.close();
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("�����˳�");
	}
}

class ArrayStack {
	private int maxSize;
	private int[] stack;
	private int top = -1;

	public ArrayStack(int maxSize) {
		super();
		this.maxSize = maxSize;
		this.stack = new int[this.maxSize];
	}

	// ջ��
	public boolean isFull() {
		return top == maxSize - 1;
	}

	// ջ��
	public boolean isEmpty() {
		return top == -1;
	}

	// ��ջ
	public void push(int value) {
		if (isFull()) {
			System.out.println("ջ��......");
			return;
		}
		top++;
		stack[top] = value;
	}

	// ��ջ
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("ջ�ǿյ�.......");
		}
		int value = stack[top];
		top--;
		return value;
	}

	// ����ջ
	public void list() {
		if (isEmpty()) {
			System.out.println("ջ�գ�û����");
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
		}
	}

}
