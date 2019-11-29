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
			bubbleSort();
			break;
		case 2:
			selectionSort();
			break;
		case 3:
			insertionSort();
			break;
		}
	}

	public void randomInit(int numElements) {
		Random aRandom = new Random();
		nElems = numElements;
		for (int i = 0; i < nElems; i++) {
			a[i] = aRandom.nextLong() % 100000000;
		}
	}

	public void bubbleSort() {
		int out, in;
		for (out = nElems - 1; out > 1; out--)
			for (in = 0; in < out; in++)
				if (a[in] > a[in + 1])
					swap(in, in + 1);
	}

	public void selectionSort() {
		int out, in, min;
		for (out = 0; out < nElems - 1; out++) {
			min = out;
			for (in = out + 1; in < nElems; in++)
				if (a[in] < a[min])
					min = in;
			swap(out, min);
		}
	}

	public void insertionSort() {
		int in, out;
		for (out = 1; out < nElems; out++) {
			long temp = a[out];
			in = out;
			while (in > 0 && a[in - 1] >= temp) {
				a[in] = a[in - 1];
				--in;
			}
			a[in] = temp;
		}
	}

	private void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
}
