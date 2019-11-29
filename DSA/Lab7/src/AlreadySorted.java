public class AlreadySorted {
	public static void main(String[] args) {
		Array arr = new Array(50000);
		arr.randomInit(50000);
		arr.sort();

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

	}
}
