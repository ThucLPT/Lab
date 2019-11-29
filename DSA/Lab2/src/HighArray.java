public class HighArray {
	private long[] a;
	private int nElems;

	public HighArray(int max) {
		a = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}

	public boolean delete(long value) {
		int j;
		for (j = 0; j < nElems; j++)
			if (value == a[j])
				break;
		if (j == nElems)
			return false;
		else {
			for (int k = j; k < nElems; k++)
				a[k] = a[k + 1];
			nElems--;
			return true;
		}
	}

	public void display() {
		for (int j = 0; j < nElems; j++)
			System.out.print(a[j] + " ");
		System.out.println();
	}

	public long getMax() {
		if (a.length == 0) {
			return -1;
		}
		long max = a[0];
		for (int j = 0; j < nElems; j++) {
			if (a[j] > max) {
				max = a[j];
			}
		}
		return max;
	}

	public void removeMax() {
		long max = getMax();
		delete(max);
	}

	public void noDups() {
		int numOfEmptyCells = 0;
		for (int i = 0; i < nElems; i++) {
			for (int j = i + 1; j < nElems; j++) {
				if (a[i] == a[j]) {
					a[j] = -1;
					numOfEmptyCells++;
				}
			}
		}
		for (int i = 0; i < numOfEmptyCells; i++) {
			delete(-1);
		}
	}

	public static void main(String[] args) {
		HighArray arr = new HighArray(100);
		arr.insert(1);
		arr.insert(3);
		arr.insert(5);
		arr.insert(7);
		arr.insert(7);
		arr.insert(9);
		arr.display();

		arr.noDups();
		arr.display();

		arr.removeMax();
		arr.display();
	}
}
