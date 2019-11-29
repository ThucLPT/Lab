public class SortingApp {
	public static void main(String[] args) {
		int[] maxSizes = { 10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000 };
		for (int maxSize : maxSizes) {
			System.out.println("Size " + maxSize);

			Array arr = new Array(maxSize);
			arr.randomInit(maxSize);

			Array arr1 = new Array(arr);
			Array arr2 = new Array(arr);
			Array arr3 = new Array(arr);

			long startTime1 = TimeUtils.now();
			arr1.shellSort();
			long endTime1 = TimeUtils.now();
			System.out.println("Time of shell sort: " + (endTime1 - startTime1) + "ms");

			long startTime2 = TimeUtils.now();
			arr2.quickSort();
			long endTime2 = TimeUtils.now();
			System.out.println("Time of quick sort: " + (endTime2 - startTime2) + "ms");

			long startTime3 = TimeUtils.now();
			arr3.quickSortMedOf3();
			long endTime3 = TimeUtils.now();
			System.out.println("Time of quick sort median-of-3: " + (endTime3 - startTime3) + "ms");

			System.out.println("--------------------------------------------------");
		}
	}
}
