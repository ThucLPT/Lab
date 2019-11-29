package Problem2;

public class Josephus {
	public static void main(String[] args) {
		int people = 7, start = 1, count = 3;
		CircularLinkedList list = new CircularLinkedList();
		for (int i = start; i <= people; i++) {
			list.insert(i);
		}
		while (!list.isEmpty()) {
			list.display();
			list.step();
			for (int i = start; i <= count; i++) {
				list.step();
			}
			list.delete();
		}
	}
}
