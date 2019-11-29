import java.util.Scanner;

public class Ex1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("N: ");
		int n = sc.nextInt();
		sc.close();
		for (int i = 1; i < n * 2; i += 2) {
			for (int j = 0; j < 4 - i / 2; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
