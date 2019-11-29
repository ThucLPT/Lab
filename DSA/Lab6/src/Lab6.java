public class Lab6 {
	static int puzzle(int base, int limit) {
		if (base > limit) {
			return -1;
		} else if (base == limit) {
			return 1;
		} else {
			return base * puzzle(base + 1, limit);
		}
	}

	static double sumd(int n) {
		if (n < 1) {
			return n;
		}
		return 1.0 / n + sumd(n - 1);
	}

	static int sum(int n) {
		if (n < 1) {
			return n;
		} else {
			return n + sum(n - 1);
		}
	}

	static int findmin(int a[], int n) {
		if (n == 1) {
			return a[0];
		} else {
			return Math.min(a[n - 1], findmin(a, n - 1));
		}
	}

	static int findsum(int a[], int n) {
		if (n == 0) {
			return 0;
		} else {
			return findsum(a, n - 1) + a[n - 1];
		}
	}

	static int gcd(int p, int q) {
		if (q == 0) {
			return p;
		} else {
			return gcd(q, p % q);
		}
	}

	public static void main(String[] args) {
		int a[] = { 2, 3, 4, 5, 6, 7 };
		int n = a.length;

		System.out.println(puzzle(4, 7));
		System.out.println(sumd(n));
		System.out.println(sum(n));
		System.out.println(findmin(a, n));
		System.out.println(findsum(a, n));
		System.out.println(gcd(2, 1));
	}
}
