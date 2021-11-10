import java.util.*;
//Priority queue implementation using ArrayList utility where higher number == higher priority

public class PriorityQueue {
   protected ArrayList list;
   
   class Entry {
      String str;
      int priority;
      
      public Entry(String o, int p) {
         str = o;
         priority = p > 5 ? 5 : p; //if number given > 5, set to 5 (max) terniary operator
      }
      
      public String toString() {
         return this.str;
      }
   }
   
   public PriorityQueue() {
      list = new ArrayList();
   } //end constructor
   
   public String dequeue() {
      String go = "";
      
      int temphigh = ( (Entry)list.get(0) ).priority;
      int highindex = 0;
      for (int i = 0; i< list.size(); i++) {
         if( ( (Entry)list.get(i) ).priority > temphigh) {
            temphigh = ((Entry)list.get(i)).priority;
            highindex = i;   
         } //end if
      } //end for
      go = ((Entry)list.get(highindex)).str;
      list.remove(highindex);
      
      return go;
   } //end dequeue
   
   public void enqueue(String element, int priority) {
      Entry e = new Entry(element, priority);
      list.add(e);
   }
   
   public String peek() {
      return list.get(0).toString();
   } //end peek
   
   public int length() { return list.size(); }
   
   public void printList() {
      for(Object item : list) {
         System.out.println(item.toString());
      }
   }
   
   public void easyAppend(Object[] array) {
      for(Object item : array){
         list.add(item);
      }
   } //end easy append
}

class PrioQueueTest {
   public static void main(String[] args) {
      PriorityQueue q = new PriorityQueue();
      
      q.enqueue("cat", 4);
      q.enqueue("dog", 1);
      q.enqueue("wombat", 5);
      
      q.printList();
      
      System.out.println("First item: " + q.peek() + " List len: " + q.length());
      q.dequeue();
      q.printList();
      System.out.println("First item after dequeue: " + q.peek()  + ", List len: " + q.length());
      
      
   }
}