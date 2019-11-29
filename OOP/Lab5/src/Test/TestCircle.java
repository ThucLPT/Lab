package Test;

import Class.Circle;

public class TestCircle {
	public static void main(String[] args) {
		Circle circle = new Circle(5);
		System.out.println("Parameter: " + circle.getPerimeter());
		System.out.println("Area: " + circle.getArea());
	}
}
