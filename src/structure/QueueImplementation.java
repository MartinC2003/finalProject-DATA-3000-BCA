package structure;

public class QueueImplementation<T> implements QueueInterface<T> {
	Node<T> front;
    Node<T> rear;
    int length = 0;

	@Override
	public void enqueue(T newEntry) {
		Node<T> newNode = new Node<>(newEntry);
		if (isEmpty()) {
			front = newNode;
			rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
		length++;
	}

	@Override
	public T dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty.");
		}
		T data = front.data;
		front = front.next;
		if (front == null) {
			rear = null;
		}
		length--;
		return data;
	}

	@Override
	public T getFront() {
		// TODO Auto-generated method stub
		if (front != null)
            return front.data;
		else {
			throw new IllegalStateException("Queue is empty.");
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (length == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		front = null;
	    rear = null;
		length = 0;
	}

}

//I used this resource to create the implementation.
//https://www.geeksforgeeks.org/java/queue-implementation-using-linked-list-in-java/
//This code was made with help from Microsoft Copilot AI to correct errors and apply the coding resource to this project.
//https://copilot.microsoft.com/
