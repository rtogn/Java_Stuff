public class QueueArrayBased implements QueueInterface {
	//circular
	public final int MAX_QUEUE = 50;
	private Object[] items;
	private int front, back, count;
	
	public QueueArrayBased() {
		items = new Object[MAX_QUEUE];
		front = 0;
		back = MAX_QUEUE-1;
		count = 0;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}	
	public boolean isFull() {
		return count == MAX_QUEUE;
	}	
	public void enqueue(Object newItem) throws QueueException {
		if(!isFull()) {
			back = (back+1) % MAX_QUEUE;
			items[back] = newItem;
			++count;
		}
		else {
			throw new QueueException("Queue is full");
		}	
	}	
	public Object dequeue() throws QueueException {
		if(!isEmpty()) {
			Object queueFront = items[front];
			front = (front+1) % MAX_QUEUE;
			--count;
			return queueFront;
		}
		else {
			throw new QueueException("Queue is empty");
		}			
	}	
	public void dequeueAll() {
			items = new Object[MAX_QUEUE];
			front = 0;
			back = MAX_QUEUE-1;
			count = 0;
	}	
	public Object peek() throws QueueException {
		if(!isEmpty()) {
			return items[front];
		}
		else {
			throw new QueueException("Queue is empty");
		}	
	} //end methods
	
	public static void main (String[] args) {
		QueueReferenceBased aQueue = new QueueReferenceBased();
		for (int i = 0; i < 9; i++) {
			aQueue.enqueue(new Integer(i));			
		}
		for (int i = 0; i < 9; i++) {
			System.out.println(aQueue.dequeue());
		}		
	}	
}
