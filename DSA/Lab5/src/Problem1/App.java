package Problem1;

public class App {
	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();
		list.insertFirst(1);
		list.insertLast(3);
		list.insertLast(5);
		list.insertLast(7);
		list.insertLast(9);
		list.display();
		if (list.search(3)) {
			list.delete(3);
			list.display();
		} else
			System.out.println("Not found");
	}
}
