package Problem2;

public class CircularLinkedList {
	private Link current;

	public void insert(int data) {
		Link link = new Link();
		if (isEmpty()) {
			link.data = data;
			current = link;
			current.next = current;
		} else {
			link.data = data;
			link.next = current.next;
			current.next = link;
			current = link;
		}
	}

	public void delete() {
		Link p = current;
		if (p.next == current) {
			current = null;
		} else {
			do {
				p = p.next;
			} while (p.next != current);
			p.next = current.next;
			current = p;
		}
	}

	public boolean isEmpty() {
		return current == null;
	}

	public void step() {
		if (!isEmpty())
			current = current.next;
	}

	public void display() {
		Link p = current;
		do {
			p = p.next;
			System.out.print(p.data + " ");
		} while (p != current);
		System.out.println();
	}
}
