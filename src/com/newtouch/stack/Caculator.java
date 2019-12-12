package com.newtouch.stack;

public class Caculator {
	public static void main(String[] args) {
		// ����һ�����ʽ
		String expression = "7*2*2-5+1-5+3-4";
		// ��������ջ
		ArrayStack2 numStack = new ArrayStack2(10);
		ArrayStack2 operStack = new ArrayStack2(10);
		int index = 0;// ����ɨ��
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';
		String keepNum = "";// ����ƴ�Ӷ�λ��
		// ��ʼɨ��expression
		while (true) {
			ch = expression.substring(index, index + 1).charAt(0);
			// �ж�ch��ʲô
			if (operStack.isOper(ch)) {
				if (!operStack.isEmpty()) {
					// �������ջ��Ϊ�գ�������ж����ȼ�
					if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.caculate(num1, num2, oper);
						// ��������ջ
						numStack.push(res);
						// Ȼ�󽫵�ǰ��������ջ
						index=index-1;
					} else {
						// �����ǰ����������ջ�����������ȼ�
						operStack.push(ch);
					}
				} else {
					operStack.push(ch);
				}
			} else {// ��������֣�ֱ����ջ
//				numStack.push(ch - 48);// ����Ascall��
				// �����λ��
				keepNum += ch;

				// ���ch�Ѿ���expression�����һλ����ֱ����ջ
				if (index == expression.length() - 1) {
					numStack.push(Integer.parseInt(keepNum));
				} else {
					// �ж���һ���ַ��ǲ������֣��������ּ���ɨ�裬����������ջ
					if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
						numStack.push(Integer.parseInt(keepNum));
						keepNum = "";// ���keepNum������һ��ɨ��
					}
				}
			}
			index++;// ����ɨ��
			if (index >= expression.length()) {
				break;
			}
		}

		// ���ʽɨ����Ϻ󣬿�ʼ����
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
		System.out.printf("���ʽ%s=%d", expression, result);
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

	// ջ��
	public boolean isFull() {
		return top == maxSize - 1;
	}

	// ջ��
	public boolean isEmpty() {
		return top == -1;
	}

	// ���ص�ǰջ��Ԫ��
	public int peek() {
		return stack[top];
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
		}
	}

	// �������ִ�С�ж����ȼ�
	public int priority(int oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else {
			return -1;
		}
	}

	// �ж��Ƿ��������
	public boolean isOper(char oper) {
		return oper == '+' || oper == '-' || oper == '*' || oper == '/';
	}

	// ����
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
