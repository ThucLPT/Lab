package Problem1;

public class CircularLinkedList {
	private Link last;

	public void insertEmpty(int data) {
		Link temp = new Link();
		temp.data = data;
		last = temp;
		last.next = last;
	}

	public void insertFirst(int data) {
		if (last == null)
			insertEmpty(data);
		else {
			Link temp = new Link();
			temp.data = data;
			temp.next = last.next;
			last.next = temp;
		}
	}

	public void insertLast(int data) {
		if (last == null)
			insertEmpty(data);
		else {
			Link temp = new Link();
			temp.data = data;
			temp.next = last.next;
			last.next = temp;
			last = temp;
		}
	}

	public void display() {
		if (last == null)
			System.out.println("List is empty.");
		Link p = last.next;
		do {
			System.out.print(p.data + " ");
			p = p.next;
		} while (p != last.next);
		System.out.println();
	}

	public boolean search(int key) {
		Link current = last;
		while (current.data != key) {
			if (current.next == last)
				return false;
			else
				current = current.next;
		}
		return true;
	}

	public void delete(int key) {
		Link curr = last, prev = new Link();
		while (curr.data != key) {
			prev = curr;
			curr = curr.next;
		}
		if (curr.next == last) {
			last = null;
		}
		if (curr == last) {
			prev = last;
			while (prev.next != last)
				prev = prev.next;
			last = curr.next;
			prev.next = last;
		} else if (curr.next == last) {
			prev.next = last;
		} else {
			prev.next = curr.next;
		}
	}
}
