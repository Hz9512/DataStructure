package com.newtouch.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
	public static void main(String[] args) {

		// ����׺���ʽת�ɺ�׺���ʽ
		String expression = "1+((2+3)*4)-5";
		List<String> list = toInfixExpressionList(expression);
		System.out.println(list);
		List<String> parseSuffixExpression = parseSuffixExpression(list);
		System.out.println(parseSuffixExpression);

		// (3+4)*5-6
//		String suffixExpression = "3 4 + 5 * 6 - ";
//		List<String> list = getListString(suffixExpression);
//		System.out.println(list);
//		int res = caculate(list);
//		System.out.println("������Ϊ��" + res);

	}

	// ����׺���ʽת�ɶ�Ӧ��List
	public static List<String> toInfixExpressionList(String s) {
		List<String> ls = new ArrayList<>();
		int i = 0;// ָ��
		String str;// ����ƴ�Ӷ�λ��
		char c;
		do {
			// ����Ƿ�����
			if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
				ls.add("" + c);
				i++;
			} else {
				// ���������
				str = "";
				while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
					str += c;
					i++;
				}
				ls.add(str);
			}
		} while (i < s.length());
		return ls;
	}

	// ��׺���ʽ��Ӧ��Listת�ɺ�׺���ʽ
	public static List<String> parseSuffixExpression(List<String> ls) {
		// ����һ������ջ
		Stack<String> stack = new Stack<>();
		// ����һ���洢�м�����List
		List<String> list = new ArrayList<>();
		// ����ls
		for (String item : ls) {
			if (item.matches("\\d+")) {
				list.add(item);
			} else if (item.equals("(")) {
				stack.push(item);
			} else if (item.equals(")")) {
				while (!stack.peek().equals("(")) {
					list.add(stack.pop());
				}
				stack.pop();// ��"("����
			} else {
				while (stack.size() != 0 && !stack.peek().equals("(")
						&& Operation.getValue(stack.peek()) >= Operation.getValue(item)) {
					list.add(stack.pop());
				}
				// �ٽ�itemѹ��ջ
				stack.push(item);
			}
		}
		while (stack.size() != 0) {
			list.add(stack.pop());
		}
		return list;
	}

	public static List<String> getListString(String suffixExpression) {
		String[] split = suffixExpression.split(" ");
		List<String> list = new ArrayList<>();
		for (String ele : split) {
			list.add(ele);
		}
		return list;
	}

	// ��ɶ��沨�����ʽ������
	public static int caculate(List<String> ls) {
		Stack<String> stack = new Stack();
		// ����ls����ջ��
		for (String item : ls) {
			if (item.matches("\\d+")) {
				// �����һ����λ����ֱ����ջ
				stack.push(item);
			} else {
				int num1 = Integer.parseInt(stack.pop());
				int num2 = Integer.parseInt(stack.pop());
				int res = 0;
				if (item.equals("+")) {
					res = num1 + num2;
				} else if (item.equals("-")) {
					res = num2 - num1;
				} else if (item.equals("*")) {
					res = num1 * num2;
				} else if (item.equals("/")) {
					res = num2 / num1;
				} else {
					throw new RuntimeException("��������󣡣�");
				}
				stack.push("" + res);
			}
		}
		return Integer.parseInt(stack.pop());
	}
}

//�������ȼ�
class Operation {
	private static int ADD = 1;
	private static int SUB = 1;
	private static int MUL = 2;
	private static int DIV = 2;

	public static int getValue(String operation) {
		int result = 0;
		switch (operation) {
		case "+":
			result = ADD;
			break;
		case "-":
			result = SUB;
			break;
		case "*":
			result = MUL;
			break;
		case "/":
			result = DIV;
			break;
		default:
			System.out.println("û��");
			break;
		}
		return result;
	}
}
