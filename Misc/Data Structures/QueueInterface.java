public interface QueueInterface {
	public boolean isEmpty();
	public void enqueue(Object newItem) throws QueueException;
	public Object dequeue() throws QueueException;
	public void dequeueAll();
	public Object peek() throws QueueException;
} 

public class QueueException extends RuntimeException {
	public QueueException(String s) {
		super(s);
	}
}
