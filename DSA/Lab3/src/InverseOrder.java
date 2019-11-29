public class InverseOrder {
	public static void main(String[] args) {
		Array arr = new Array(10000);
		arr.randomInit(10000);
		arr.sort();
		arr.reverse();

		Array arr1 = new Array(arr);
		Array arr2 = new Array(arr);
		Array arr3 = new Array(arr);

		long startTime1 = TimeUtils.now();
		arr1.bubbleSort();
		long endTime1 = TimeUtils.now();
		System.out.println("Time of bubble sort: " + (endTime1 - startTime1) + "ms");

		long startTime2 = TimeUtils.now();
		arr2.selectionSort();
		long endTime2 = TimeUtils.now();
		System.out.println("Time of selection sort: " + (endTime2 - startTime2) + "ms");

		long startTime3 = TimeUtils.now();
		arr3.insertionSort();
		long endTime3 = TimeUtils.now();
		System.out.println("Time of insertion sort: " + (endTime3 - startTime3) + "ms");
	}
}
