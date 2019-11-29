import java.util.*;

public class Ex2 {
	public static void a(int n) {
		int mid = (n - 1) / 2;
		for (int i = 0; i < n; i++) {
			if (i == 0)
				System.out.println(String.join("", Collections.nCopies(n - 1, " ")) + "*");
			else if (i == mid)
				System.out.println(String.join("", Collections.nCopies(mid, " ")) + String.join("", Collections.nCopies(n, "*")));
			else if ((i > 0 && i < mid) || (i > mid && i < n))
				System.out.println(String.join("", Collections.nCopies(n - i - 1, " ")) + "*" + String.join("", Collections.nCopies(i * 2 - 1, " ")) + "*");
		}
	}

	public static void main(String[] args) {
		System.out.print("N: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		if (n % 2 == 1)
			a(n);
		else
			System.out.println("Odd number only");
	}
}
