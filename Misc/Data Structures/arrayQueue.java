import java.util.*;

class arrayQueue {
   private ArrayList list;
   
   public arrayQueue() {
      list = new ArrayList();
   }
   public arrayQueue(int capacity) {
      list = new ArrayList(capacity);
   }
   
   public Object dequeue() {
      return list.isEmpty() ? null : list.remove(0);
   }
   
   public Object peek() {
      return list.isEmpty() ? null : list.get(0);
   }
   
   public void enqueue(Object toAdd) {
      list.add(toAdd);
   }
   
   public int size() {
      return list.size();
   }
}

class testArrayQueue {
   public static void main(String[] args){
      arrayQueue q = new arrayQueue();
      q.enqueue("cat");
      q.enqueue("dog");
      q.enqueue("wombat");
      System.out.println("First element is: " + q.peek() + " size: " + q.size() );
      q.dequeue();
      System.out.println("First element is: " + q.peek() + " size: " + q.size());
      
   }
}