package com.newtouch.stack;

public class Caculator {
	public static void main(String[] args) {
		// 创建一个表达式
		String expression = "7*2*2-5+1-5+3-4";
		// 创建两个栈
		ArrayStack2 numStack = new ArrayStack2(10);
		ArrayStack2 operStack = new ArrayStack2(10);
		int index = 0;// 用于扫描
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';
		String keepNum = "";// 用于拼接多位数
		// 开始扫描expression
		while (true) {
			ch = expression.substring(index, index + 1).charAt(0);
			// 判断ch是什么
			if (operStack.isOper(ch)) {
				if (!operStack.isEmpty()) {
					// 如果符号栈不为空，则进行判断优先级
					if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.caculate(num1, num2, oper);
						// 运算结果入栈
						numStack.push(res);
						// 然后将当前操作符入栈
						index=index-1;
					} else {
						// 如果当前操作符大于栈顶操作符优先级
						operStack.push(ch);
					}
				} else {
					operStack.push(ch);
				}
			} else {// 如果是数字，直接入栈
//				numStack.push(ch - 48);// 参照Ascall表
				// 处理多位数
				keepNum += ch;

				// 如果ch已经是expression的最后一位，就直接入栈
				if (index == expression.length() - 1) {
					numStack.push(Integer.parseInt(keepNum));
				} else {
					// 判断下一个字符是不是数字，若是数字继续扫描，若不是则入栈
					if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
						numStack.push(Integer.parseInt(keepNum));
						keepNum = "";// 清空keepNum进行下一次扫描
					}
				}
			}
			index++;// 继续扫描
			if (index >= expression.length()) {
				break;
			}
		}

		// 表达式扫描完毕后，开始计算
		while (true) {
			if (operStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.caculate(num1, num2, oper);
			numStack.push(res);
		}
		int result = numStack.pop();
		System.out.printf("表达式%s=%d", expression, result);
	}
}

class ArrayStack2 {
	private int maxSize;
	private int[] stack;
	private int top = -1;

	public ArrayStack2(int maxSize) {
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

	// 返回当前栈顶元素
	public int peek() {
		return stack[top];
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
		}
	}

	// 根据数字大小判断优先级
	public int priority(int oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else {
			return -1;
		}
	}

	// 判断是否是运算符
	public boolean isOper(char oper) {
		return oper == '+' || oper == '-' || oper == '*' || oper == '/';
	}

	// 计算
	public int caculate(int num1, int num2, int oper) {
		int res = 0;
		switch (oper) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1;
			break;
		default:
			break;
		}
		return res;
	}

}
