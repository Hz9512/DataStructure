package com.newtouch.resursion;

public class Queen8 {
	int max = 8;
	int[] array = new int[max];
	static int count = 0;
	static int judgeCount=0;

	public static void main(String[] args) {
		Queen8 quee = new Queen8();
		quee.check(0);
		System.out.println(count);
		System.out.println(judgeCount);
	}

	// 编写一个方法放置第n个皇后
	public void check(int n) {
		if (n == max) {
			print();
			return;
		}
		// 依次放皇后，并判断是否冲突
		for (int i = 0; i < max; i++) {
			// 先把当前皇后n，放到该行的第一列
			array[n] = i;
			if (judge(n)) {
				check(n + 1);
			}
		}
	}

	// 当我们放置第n个皇后，检测是否与前面已经摆放过的皇后产生位置冲突
	/**
	 * 
	 * @param n 表示第n个皇后
	 * @return
	 */
	public boolean judge(int n) {
		judgeCount++;
		for (int i = 0; i < n; i++) {
			// 是否在同一列，同一斜线
			if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}

	// 输出皇后摆放的位置
	public void print() {
		count++;
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
