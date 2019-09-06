package com.lijia.code;

/**
 * 有一组不同高度的台阶，有一个整数数组表示，数组中每个数是台阶的高度，\ 当开始下雨了（雨水足够多）台阶之间的水坑会积水多少呢？
 * 如下图，可以表示为数组[0,1,0,2,1,0,1,3,2,1,2,1]，返回水体积等于6
 * 
 * @link <img src="water_volume.jpg" />
 * @author tawalisa@163.com
 *
 */
public class WaterVolume {

	public static void main(String[] args) {
		int v = waterVolumecal(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
		System.out.println("sum:" + v);
		v = waterVolumecal(new int[] { 0, 1, 2, 3, 3, 4, 5, 6, 6, 5, 4, 0 });
		System.out.println("sum:" + v);
		v = waterVolumecal(new int[] { 10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0 });
		System.out.println("sum:" + v);
	}

	private static int waterVolumecal(int[] is) {
		int sum = 0;
		int highL = 0;
		int highR = 0;
		for (int i = 1; i < is.length; i++) {
			if (highL >= highR || i >= highR) {
				highR = findRightHigh(i,highL, is);
				if (highR < 0) {
					return sum;
				}
			}
			if (is[i] < is[highL]) {
				if (highR > i) {
					sum = sum + Math.max(Math.min(is[highL], is[highR]) - is[i], 0);
				} else {
					if (is[highR] >= is[highL]) {
						highL = highR;
					}
					highR = findRightHigh(i,highL, is);
					if (highR < 0) {
						return sum;
					}
				}
			} else {
				highL = i;
			}
		}
		return sum;
	}

	/**
	 * 
	 * @param start
	 * @param highL
	 * @param is
	 * @return
	 */
	private static int findRightHigh(int start, int highL,int[] is) {
		int ret = -1;
		int currentMax = -1;
		for (int i = start + 1; i < is.length; i++) {
			if (is[i] >= is[highL]) {
				return i;
			}
			if (is[i] > currentMax) {
				ret = i;
				currentMax = is[i];
			}
		}
		return ret;
	}

}
