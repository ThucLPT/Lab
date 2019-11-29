package Question1;

public class Rectangle {
	protected double length = 1;
	protected double width = 1;

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		if (length > 0 && length < 20)
			this.length = length;
		else
			System.out.println("Set length to 1");
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		if (width > 0 && width < 20)
			this.width = width;
		else
			System.out.println("Set width to 1");
	}

	public double getPerimeter() {
		return (length + width) * 2;
	}

	public double getArea() {
		return length * width;
	}
}
