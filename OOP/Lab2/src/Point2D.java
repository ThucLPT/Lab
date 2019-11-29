import java.util.Scanner;

public class Point2D {
	private double x;
	private double y;

	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point2D{" + "x=" + x + ", y=" + y + '}';
	}

	public static boolean same(double xA, double yA, double xB, double yB) {
		return xA == xB && yA == yB;
	}

	public static double midX(double xA, double xB) {
		return (xA + xB) / 2;
	}

	public static double midY(double yA, double yB) {
		return (yA + yB) / 2;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("xA: ");
		double xA = sc.nextDouble();

		System.out.print("yA: ");
		double yA = sc.nextDouble();

		System.out.print("xB: ");
		double xB = sc.nextDouble();

		System.out.print("yB: ");
		double yB = sc.nextDouble();

		Point2D a = new Point2D(xA, yA);
		System.out.println(a);

		Point2D b = new Point2D(xB, yB);
		System.out.println(b);

		System.out.println(same(xA, yA, xB, yB));
		System.out.println("xI: " + midX(xA, xB) + ", yI: " + midY(yA, yB));
		sc.close();
	}
}
