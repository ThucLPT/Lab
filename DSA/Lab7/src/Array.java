import java.util.Random;

public class Array {
	private long[] a;
	private int nElems;

	public Array(int max) {
		a = new long[max];
		nElems = 0;
	}

	public Array(Array oriArray) {
		a = new long[oriArray.nElems];
		nElems = oriArray.nElems;
		for (int i = 0; i < oriArray.nElems; i++) {
			a[i] = oriArray.a[i];
		}
	}

	public void reverse() {
		for (int i = 0; i < a.length / 2; i++) {
			long temp = a[i];
			a[i] = a[a.length - 1 - i];
			a[a.length - 1 - i] = temp;
		}
	}

	public void sort() {
		Random random = new Random();
		int i = random.nextInt((3 - 1) + 1) + 1;
		switch (i) {
		case 1:
			shellSort();
			break;
		case 2:
			quickSort();
			break;
		case 3:
			quickSortMedOf3();
			break;
		}
	}

	public void randomInit(int numElements) {
		Random aRandom = new Random();
		nElems = numElements;
		for (int i = 0; i < numElements; i++) {
			a[i] = aRandom.nextLong() % 100000000;
		}
	}

	public void shellSort() {
		int inner, outer;
		long temp;
		int h = 1;
		while (h <= nElems / 3)
			h = h * 3 + 1;
		while (h > 0) {
			for (outer = h; outer < nElems; outer++) {
				temp = a[outer];
				inner = outer;
				while (inner > h - 1 && a[inner - h] >= temp) {
					a[inner] = a[inner - h];
					inner -= h;
				}
				a[inner] = temp;
			}
			h = (h - 1) / 3;
		}
	}

	public void swap(int dex1, int dex2) {
		long temp = a[dex1];
		a[dex1] = a[dex2];
		a[dex2] = temp;
	}

	public int partitionIt(int left, int right, long pivot) {
		int leftPtr = left - 1;
		int rightPtr = right;
		while (true) {
			while (a[++leftPtr] < pivot)
				;
			while (rightPtr > 0 && a[--rightPtr] > pivot)
				;
			if (leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right);
		return leftPtr;
	}

	public void recQuickSort(int left, int right) {
		if (right - left <= 0)
			return;
		else {
			long pivot = a[right];
			int partition = partitionIt(left, right, pivot);
			recQuickSort(left, partition - 1);
			recQuickSort(partition + 1, right);
		}
	}

	public void quickSort() {
		recQuickSort(0, nElems - 1);
	}

	public void manualSort(int left, int right) {
		int size = right - left + 1;
		if (size <= 1)
			return;
		if (size == 2) {
			if (a[left] > a[right])
				swap(left, right);
			return;
		} else {
			if (a[left] > a[right - 1])
				swap(left, right - 1);
			if (a[left] > a[right])
				swap(left, right);
			if (a[right - 1] > a[right])
				swap(right - 1, right);
		}
	}

	public long medianOf3(int left, int right) {
		int center = (left + right) / 2;
		if (a[left] > a[center])
			swap(left, center);
		if (a[left] > a[right])
			swap(left, right);
		if (a[center] > a[right])
			swap(center, right);
		swap(center, right - 1);
		return a[right - 1];
	}

	public int partitionIt3(int left, int right, long pivot) {
		int leftPtr = left;
		int rightPtr = right - 1;
		while (true) {
			while (a[++leftPtr] < pivot)
				;
			while (a[--rightPtr] > pivot)
				;
			if (leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right - 1);
		return leftPtr;
	}

	public void recQuickSortMedOf3(int left, int right) {
		int size = right - left + 1;
		if (size <= 3)
			manualSort(left, right);
		else {
			long median = medianOf3(left, right);
			int partition = partitionIt3(left, right, median);
			recQuickSortMedOf3(left, partition - 1);
			recQuickSortMedOf3(partition + 1, right);
		}
	}

	public void quickSortMedOf3() {
		recQuickSortMedOf3(0, nElems - 1);
	}
}
