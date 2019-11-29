import java.util.Scanner;

public class Ex4 {
	public static void main(String[] args) {
		System.out.print("Input n: ");
		Scanner sc = new Scanner(System.in);
		double n = sc.nextDouble();
		sc.close();
		double guess = n / 2;
		double percent = Double.MAX_VALUE;
		double lastGuess = guess;
		while (Math.abs(percent) >= 0.01) {
			double r = n / guess;
			guess = (guess + r) / 2;
			percent = (guess - lastGuess) / lastGuess;
			lastGuess = guess;
			System.out.println(guess);
		}
	}
}
