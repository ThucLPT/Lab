import java.util.Scanner;

public class Ex3 {
	public static void main(String[] args) {
		System.out.print("String: ");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		System.out.println(s.toUpperCase());
		System.out.println(s.toLowerCase());
		String[] words = s.split(" ");
		for (String word : words)
			System.out.print(word.toUpperCase().charAt(0) + word.substring(1) + " ");
	}
}
