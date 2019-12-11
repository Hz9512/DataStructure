package com.newtouch.stack;

import java.util.Scanner;

public class ArrayStackDemo {
	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(4);
		String key = "";
		boolean loop = true;
		Scanner sc = new Scanner(System.in);
		while (loop) {
			System.out.println("show:表示遍历栈");
			System.out.println("exit:退出程序");
			System.out.println("push:入栈");
			System.out.println("pop:出栈");
			System.out.println("请输入您的选择：");
			key = sc.next();
			switch (key) {
			case "show":
				stack.list();
				break;
			case "push":
				System.out.println("请输入第一个数：");
				int value = sc.nextInt();
				stack.push(value);
				break;
			case "pop":
				try {
					int res = stack.pop();
					System.out.printf("出栈的数据是：%d\n", res);
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
		System.out.println("程序退出");
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

	// 栈满
	public boolean isFull() {
		return top == maxSize - 1;
	}

	// 栈空
	public boolean isEmpty() {
		return top == -1;
	}

	// 入栈
	public void push(int value) {
		if (isFull()) {
			System.out.println("栈满......");
			return;
		}
		top++;
		stack[top] = value;
	}

	// 出栈
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("栈是空的.......");
		}
		int value = stack[top];
		top--;
		return value;
	}

	// 遍历栈
	public void list() {
		if (isEmpty()) {
			System.out.println("栈空，没数据");
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
		}
	}

}
