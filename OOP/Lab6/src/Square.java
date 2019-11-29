public class Square extends Rectangle {
	public Square() {
	}

	public Square(double side) {
		super(side, side);
	}

	public Square(String color, boolean filled, double side) {
		super(side, side, color, filled);
	}

	public double getSide() {
		return getWidth();
	}

	public void setSide(double side) {
		setWidth(side);
		setLength(side);
	}

	@Override
	public void setWidth(double side) {
		super.setWidth(side);
		super.setLength(side);
	}

	@Override
	public void setLength(double side) {
		super.setWidth(side);
		super.setLength(side);
	}

	@Override
	public String toString() {
		return String.format("A Square with side = %f , which is a subclass of %s", width, super.toString());
	}
}
