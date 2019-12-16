package com.newtouch.resursion;

/**
 * 迷宫回溯问题
 * 
 * @author Administrator
 *
 */
public class MiGong {
	public static void main(String[] args) {
		int map[][] = new int[8][7];
		for (int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}

		for (int i = 0; i < 8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		map[3][1] = 1;
		map[3][2] = 1;
//		map[1][2] = 1;
//		map[2][2] = 1;

		System.out.println("小球走之前的map");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

		// 方案
		setWay5(map, 1, 1);
		System.out.println("小球走之后的map");
		int count = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
				if (map[i][j] == 2) {
					count++;
				}
			}
			System.out.println();
		}
		System.out.println(count);
	}

	/**
	 * 
	 * @param map 表示地图
	 * @param i   起始位置行
	 * @param j   起始位置列
	 * @return
	 */
	public static boolean setWay(int[][] map, int i, int j) {
		if (map[6][5] == 2) {// 通路已找到
			return true;
		} else {
			if (map[i][j] == 0) {// 如果这个点还没走过
				map[i][j] = 2;// 假设该点可以走通
				if (setWay(map, i + 1, j)) {// 向下走
					return true;
				} else if (setWay(map, i, j + 1)) {// 向右走
					return true;
				} else if (setWay(map, i - 1, j)) {// 向上走
					return true;
				} else if (setWay(map, i, j - 1)) {// 向左走
					return true;
				} else {
					map[i][j] = 3;// 死路，走不通
					return false;
				}
			} else {
				return false;
			}
		}
	}

	public static boolean setWay2(int[][] map, int i, int j) {
		if (map[6][5] == 2) {// 通路已找到
			return true;
		} else {
			if (map[i][j] == 0) {// 如果这个点还没走过
				map[i][j] = 2;// 假设该点可以走通
				if (setWay2(map, i - 1, j)) {// 向上走
					return true;
				} else if (setWay2(map, i, j + 1)) {// 向右走
					return true;
				} else if (setWay2(map, i + 1, j)) {// 向下走
					return true;
				} else if (setWay2(map, i, j - 1)) {// 向左走
					return true;
				} else {
					map[i][j] = 3;// 死路，走不通
					return false;
				}
			} else {
				return false;
			}
		}
	}

	public static boolean setWay3(int[][] map, int i, int j) {
		if (map[6][5] == 2) {// 通路已找到
			return true;
		} else {
			if (map[i][j] == 0) {// 如果这个点还没走过
				map[i][j] = 2;// 假设该点可以走通
				if (setWay3(map, i - 1, j)) {// 向上走
					return true;
				} else if (setWay3(map, i, j + 1)) {// 向右走
					return true;
				} else if (setWay3(map, i, j - 1)) {// 向左走
					return true;
				} else if (setWay3(map, i + 1, j)) {// 向下走
					return true;
				} else {
					map[i][j] = 3;// 死路，走不通
					return false;
				}
			} else {
				return false;
			}
		}
	}

	public static boolean setWay4(int[][] map, int i, int j) {
		if (map[6][5] == 2) {// 通路已找到
			return true;
		} else {
			if (map[i][j] == 0) {// 如果这个点还没走过
				map[i][j] = 2;// 假设该点可以走通
				if (setWay4(map, i - 1, j)) {// 向上走
					return true;
				} else if (setWay4(map, i, j - 1)) {// 向左走
					return true;
				} else if (setWay4(map, i, j + 1)) {// 向右走
					return true;
				} else if (setWay4(map, i + 1, j)) {// 向下走
					return true;
				} else {
					map[i][j] = 3;// 死路，走不通
					return false;
				}
			} else {
				return false;
			}
		}
	}

	public static boolean setWay5(int[][] map, int i, int j) {
		if (map[6][5] == 2) {// 通路已找到
			return true;
		} else {
			if (map[i][j] == 0) {// 如果这个点还没走过
				map[i][j] = 2;// 假设该点可以走通
				if (setWay5(map, i + 1, j)) {// 向下走
					return true;
				} else if (setWay5(map, i, j - 1)) {// 向左走
					return true;
				} else if (setWay5(map, i - 1, j)) {// 向上走
					return true;
				} else if (setWay5(map, i, j + 1)) {// 向右走
					return true;
				} else {
					map[i][j] = 3;// 死路，走不通
					return false;
				}
			} else {
				return false;
			}
		}
	}
}
