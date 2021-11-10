import java.util.*;

public class CircularArrayQueue {
   private final int DEFAULT_CAPACITY = 24;
   private int front, rear, count;
   private String[] queue;
  
   public CircularArrayQueue() {
      front = rear = count = 0;
      queue = new String[DEFAULT_CAPACITY];
   } //end constructor
   
   public void enqueue (String element) {
      if (size() == queue.length) 
         expandCapacity();
      queue[rear] = element;
      rear = (rear+1) % queue.length;
      count++;
      
   }//end enqueue
   
   public String dequeue() {
      if(isEmpty()) 
         throw new NoSuchElementException ("queue");
         
      String result = queue[front];
      queue[front] = null;
      front = (front+1) % queue.length;
      count--;
      return result;    
   } //end dequeue
   
   public void expandCapacity() {
      String[] larger = new String[queue.length*2];
      for (int i = 0; i < queue.length-1; i++) {
         larger[i] = queue[i]; 
         front=(front+1) % queue.length;
      }
      front = 0;
      rear = count;
      queue = larger;      
   } //end expandCapacity
   
   public String peek() {
      if(isEmpty()) 
         throw new NoSuchElementException ("queue");
      return queue[front];      
   } //end first
   
   public boolean isEmpty() {
      return count == 0;
   } //end isEmpty
   
   public int size() {
      return count;
   } //end size
   
   public void print() {
      int ind = front;
      for (int i = 0; i < count; i++) {
         System.out.println(queue[ind]);
         ind = (ind+1) % queue.length;
      }
   } //end print
}

class CircularArrayQueueTest {
   public static void main(String[] args) {
      CircularArrayQueue q = new CircularArrayQueue();
      
      q.enqueue("cat");
      q.enqueue("dog");
      q.enqueue("wombat");
      q.enqueue("cat2");
      q.enqueue("dog2");
      q.enqueue("wombat2");
      
      q.print();
      
      System.out.println("First item: " + q.peek() + " List len: " + q.size() +"\n");
      q.dequeue();
      q.print();
      System.out.println("First item after dequeue: " + q.peek()  + ", List len: " + q.size() +"\n");
   }
}