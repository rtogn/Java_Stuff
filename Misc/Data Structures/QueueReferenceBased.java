public class QueueReferenceBased implements QueueInterface {
	//circular
	public Node lastNode;
	
	public boolean isEmpty() {
		return lastNode == null;
	}
	public void enqueue(Object newItem) throws QueueException {
		Node newNode = new Node(newItem);
		
		if (isEmpty()) {
			newNode.next = newNode;
		}
		else {
			newNode.next = lastNode.next;
			lastNode.next = newNode;			
		}
		lastNode = newNode;
		
	}	
	public Object dequeue() throws QueueException {
		if(!isEmpty()){
			Node firstNode = lastNode.next;
			if (firstNode == lastNode) {
				lastNode = null;
			}
			else {
				lastNode.next = firstNode.next;
			}
			return firstNode.item;			
		} 
		else {
			throw new QueueException("QueueException on dequeue: Queue is empty");
		}
	}	
	public void dequeueAll() {
		lastNode = null;
	}	
	public Object peek() throws QueueException {
		if(!isEmpty()) {
			Node firstNode = lastNode.next;
			return firstNode.item;
		}
		else {	
			throw new QueueException("QueueException on peek: Queue is empty");			
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
