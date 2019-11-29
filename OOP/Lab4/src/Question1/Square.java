package Question1;

public class Square extends Rectangle {
	@Override
	public double getPerimeter() {
		return length * 4;
	}

	@Override
	public double getArea() {
		return length * length;
	}
}
