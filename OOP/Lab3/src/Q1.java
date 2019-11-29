import java.util.Scanner;

public class Q1 {
	public static void main(String[] args) {
		System.out.print("Array: ");
		Scanner sc = new Scanner(System.in);
		String[] arr = sc.nextLine().split(" ");
		sc.close();
		int count = 0;
		System.out.printf("%s\t%s\t%s\n", "Element", "Value", "Histogram");
		for (String s : arr) {
			System.out.printf("%d\t%s\t", count, s);
			for (int i = 0; i < Integer.parseInt(s); i++)
				System.out.print("*");
			System.out.println();
			count++;
		}
	}
}
