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

	// ��дһ���������õ�n���ʺ�
	public void check(int n) {
		if (n == max) {
			print();
			return;
		}
		// ���ηŻʺ󣬲��ж��Ƿ��ͻ
		for (int i = 0; i < max; i++) {
			// �Ȱѵ�ǰ�ʺ�n���ŵ����еĵ�һ��
			array[n] = i;
			if (judge(n)) {
				check(n + 1);
			}
		}
	}

	// �����Ƿ��õ�n���ʺ󣬼���Ƿ���ǰ���Ѿ��ڷŹ��Ļʺ����λ�ó�ͻ
	/**
	 * 
	 * @param n ��ʾ��n���ʺ�
	 * @return
	 */
	public boolean judge(int n) {
		judgeCount++;
		for (int i = 0; i < n; i++) {
			// �Ƿ���ͬһ�У�ͬһб��
			if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}

	// ����ʺ�ڷŵ�λ��
	public void print() {
		count++;
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
