package com.newtouch.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BubbleSort {

	public static void main(String[] args) {
//		int arr[] = { 3, 3, 3, 3, 3, 3 };
		int arr[] = new int[80];
		for (int i = 0; i < 80; i++) {
			arr[i] = (int) (Math.random() * 800000);
		}

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
		String d1 = format.format(date);
		System.out.println(d1);

//		long currentTimeMillis = System.currentTimeMillis();
		bubble(arr);
//		long currentTimeMillis2 = System.currentTimeMillis();
//		long cur = currentTimeMillis2 = currentTimeMillis;

		Date date2 = new Date();
		String d2 = format.format(date2);
		System.out.println(d2);
	}

	public static void bubble(int[] arr) {
		boolean flag = false;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					flag = true;
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if (!flag) {
				break;
			} else {
				flag = true;
			}
		}
	}
}
