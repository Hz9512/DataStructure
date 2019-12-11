package com.newtouch.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
	public static void main(String[] args) {

		// 将中缀表达式转成后缀表达式
		String expression = "1+((2+3)*4)-5";
		List<String> list = toInfixExpressionList(expression);
		System.out.println(list);

		// (3+4)*5-6
//		String suffixExpression = "3 4 + 5 * 6 - ";
//		List<String> list = getListString(suffixExpression);
//		System.out.println(list);
//		int res = caculate(list);
//		System.out.println("计算结果为：" + res);

	}

	// 将中缀表达式转成对应的List
	public static List<String> toInfixExpressionList(String s) {
		List<String> ls = new ArrayList<>();
		int i = 0;// 指针
		String str;// 用于拼接多位数
		char c;
		do {
			// 如果是非数字
			if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
				ls.add("" + c);
				i++;
			} else {
				// 如果是数字
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

	public static List<String> getListString(String suffixExpression) {
		String[] split = suffixExpression.split(" ");
		List<String> list = new ArrayList<>();
		for (String ele : split) {
			list.add(ele);
		}
		return list;
	}

	// 完成对逆波兰表达式的运算
	public static int caculate(List<String> ls) {
		Stack<String> stack = new Stack();
		// 遍历ls放入栈中
		for (String item : ls) {
			if (item.matches("\\d+")) {
				// 如果是一到多位数字直接入栈
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
					throw new RuntimeException("运算符有误！！");
				}
				stack.push("" + res);
			}
		}
		return Integer.parseInt(stack.pop());
	}
}
