/**
 * @tawalisa@163.com
 */
package com.lijia.code;

import java.util.ArrayList;
import java.util.List;

public class Test4 {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(new Point(1,2));
		list.add(new Point(1,3));
		list.add(new Point(5,3));
		list.add(new Point(5,2));
		//1, 2-1, 3-5, 3-5, 2
		kEqual(list,5);
	}
	/**
		有一个n边形（P0,P1,P2...Pn），每一边皆为垂直或者水平，现在给定数值k，
		以P0为起点，将n边形的周长分成k段，每一段等长，请打印出所有的k等分点的坐标。
	 * @param points
	 * @return
	 */
	static class Point{
		Point(int x,int y){
			this.x = x;
			this.y = y;
		}
		int x;
		int y;
	}
	static void kEqual(List<Point> points ,int k) {
		points.add(points.get(0));
		int length = calLength(points);
		int printlength = length/k;
		printPointK(points, printlength);
	}
	private static void printPointK(List<Point> points, int printlength) {
		int length = 0;
		int currentX = points.get(0).x;
		int currentY = points.get(0).y;
		int delta = printlength;
		for(int i=1;i<points.size();i++) {
			Point currentPoint = points.get(i);
			if(currentPoint.x == currentX) {
				length = currentY>currentPoint.y?currentY-currentPoint.y:currentPoint.y-currentY;
				while(length>=delta) {
					if(currentY>currentPoint.y) {
						System.out.println(currentX+":"+(currentY-delta));
					}else {
						System.out.println(currentX+":"+(currentY+delta));
					}
					delta += printlength;
				}
				delta = delta - length;
			}else {
				length = currentX>currentPoint.x?currentX-currentPoint.x:currentPoint.x-currentX;
				while(length>=delta) {
					if(currentX>currentPoint.x) {
						System.out.println((currentX-delta)+":"+currentY);
					}else {
						System.out.println((currentX+delta)+":"+currentY);
					}
					delta += printlength;
				}
				delta = delta - length;
			}
			currentX = points.get(i).x;
			currentY = points.get(i).y;
		}
	}
	private static int calLength(List<Point> points) {
		int length = 0;
		int currentX = points.get(0).x;
		int currentY = points.get(0).y;
		for(int i=1;i<points.size();i++) {
			Point currentPoint = points.get(i);
			if(currentPoint.x == currentX) {
				length += currentY>currentPoint.y?currentY-currentPoint.y:currentPoint.y-currentY;
			}else if(currentPoint.y == currentY) {
				length += currentX>currentPoint.x?currentX-currentPoint.x:currentPoint.x-currentX;
			}else {
				throw new RuntimeException("invalite  input");
			}
			currentX = points.get(i).x;
			currentY = points.get(i).y;
		}
		return length;
	}

}
