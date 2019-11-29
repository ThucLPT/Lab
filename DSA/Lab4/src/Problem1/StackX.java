package Problem1;

public class StackX {
	private int maxSize;
	private long[] stackArray;
	private int top;

	public StackX(int s) {
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;
	}

	public void push(long j) {
		stackArray[++top] = j;
	}

	public long pop() {
		return stackArray[top--];
	}

	public long peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}

	public int size() {
		return top + 1;
	}

	public void display() {
		for (int i = 0; i < stackArray.length; i++) {
			System.out.print(stackArray[i] + " ");
		}
		System.out.println();
	}

	public static StackX concat(StackX s1, StackX s2) {
		StackX s3 = new StackX(s1.size() + s2.size());
		while (!s1.isEmpty())
			s3.push(s1.pop());
		while (!s2.isEmpty())
			s3.push(s2.pop());
		return s3;
	}

	public static boolean areIdentical(StackX s1, StackX s2) {
		if (s1.size() != s2.size())
			return false;
		if (s1.isEmpty() || s2.isEmpty())
			return false;
		if (s1.peek() != s2.peek())
			return false;
		return true;
	}

	public static void main(String[] args) {
		StackX s1 = new StackX(5);
		s1.push(1);
		s1.push(3);
		s1.push(5);
		s1.push(7);
		s1.push(9);

		StackX s2 = new StackX(4);
		s2.push(2);
		s2.push(4);
		s2.push(6);
		s2.push(8);

		StackX s3 = concat(s1, s2);
		s3.display();
		if (areIdentical(s1, s2))
			System.out.println("Identical");
		else
			System.out.println("Not identical");
	}
}
