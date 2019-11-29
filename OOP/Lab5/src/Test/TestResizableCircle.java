package Test;

import Class.ResizableCircle;

public class TestResizableCircle {
	public static void main(String[] args) {
		ResizableCircle resizableCircle = new ResizableCircle(10);
		resizableCircle.resize(50);
		System.out.println("Parameter: " + resizableCircle.getPerimeter());
		System.out.println("Area: " + resizableCircle.getArea());
	}
}
