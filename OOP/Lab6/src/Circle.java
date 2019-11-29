public class Circle extends Shape {
	protected double radius;

	public Circle() {
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public Circle(double radius, String color, boolean filled) {
		super(color, filled);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	double getArea() {
		return radius * radius * Math.PI;
	}

	@Override
	double getPerimeter() {
		return radius * 2 * Math.PI;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
}
