package Problem2;

public class StackY {
	private int maxSize;
	private int[] stackArray;
	private int top;

	public StackY(int size) {
		maxSize = size;
		stackArray = new int[maxSize];
		top = -1;
	}

	public void push(int j) {
		stackArray[++top] = j;
	}

	public int pop() {
		return stackArray[top--];
	}
}
