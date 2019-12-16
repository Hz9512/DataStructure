package com.newtouch.resursion;

public class RecursionTest {
	public static void main(String[] args) {
		int res = factorial(5);
		System.out.println(res);
	}

	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return factorial(n - 1) * n;
		}
	}
}
