import java.util.Scanner;

public class Q2 {
	public static void display(int row, int col, int[][] arr) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Number of rows: ");
		int row = sc.nextInt();
		System.out.print("Number of cols: ");
		int col = sc.nextInt();

		int[][] arr = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				arr[i][j] = sc.nextInt();
			System.out.println();
		}
		sc.close();

		System.out.println("Before modification");
		display(row, col, arr);

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				arr[i][j] = arr[i][j] + i + j;
		}
		
		System.out.println("After modification");
		display(row, col, arr);
	}
}
