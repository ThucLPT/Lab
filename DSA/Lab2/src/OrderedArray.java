public class OrderedArray {
	private long[] a;
	private int nElems;

	public OrderedArray(int max) {
		a = new long[max];
		nElems = 0;
	}

	public int size() {
		return nElems;
	}

	public void insert(long value) {
		int j;
		for (j = 0; j < nElems; j++)
			if (a[j] > value)
				break;
		for (int k = nElems; k > j; k--)
			a[k] = a[k - 1];
		a[j] = value;
		nElems++;
	}

	public void display() {
		for (int j = 0; j < nElems; j++)
			System.out.print(a[j] + " ");
	}

	public long getValueAt(int index) {
		return a[index];
	}

	public void setValueAt(int index, long value) {
		a[index] = value;
	}

	public static OrderedArray merge(OrderedArray a1, OrderedArray a2) {
		int i = 0, j = 0, k = 0;
		OrderedArray a3 = new OrderedArray(a1.size() + a2.size());
		while (i < a1.size() && j < a2.size()) {
			if (a1.getValueAt(i) < a2.getValueAt(j)) {
				a3.setValueAt(k, a1.getValueAt(i));
				i++;
			} else {
				a3.setValueAt(k, a2.getValueAt(j));
				j++;
			}
			a3.nElems++;
			k++;
		}
		while (i < a1.size()) {
			a3.setValueAt(k, a1.getValueAt(i));
			a3.nElems++;
			k++;
			i++;
		}
		while (j < a2.size()) {
			a3.setValueAt(k, a2.getValueAt(j));
			a3.nElems++;
			k++;
			j++;
		}
		return a3;
	}

	public static void main(String[] args) {
		OrderedArray arr1 = new OrderedArray(100);
		arr1.insert(1);
		arr1.insert(9);
		arr1.insert(3);
		arr1.insert(7);
		arr1.insert(5);

		OrderedArray arr2 = new OrderedArray(100);
		arr2.insert(2);
		arr2.insert(8);
		arr2.insert(4);
		arr2.insert(6);

		OrderedArray arr3 = merge(arr1, arr2);
		arr3.display();
	}
}
