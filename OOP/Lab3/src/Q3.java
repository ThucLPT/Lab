import java.util.Scanner;

public class Q3 {
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

		System.out.println("Original matrix");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}

		int[][] trans_arr = new int[col][row];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				trans_arr[j][i] = arr[i][j];
		}

		System.out.println("Transposed matrix");
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++)
				System.out.print(trans_arr[i][j] + " ");
			System.out.println();
		}
	}
}
