
public class QueueLinkedList<ObjectType>{
/*MEOTHOD SUMMARY (pretty much no error handling at this time)
 *Class Node - simple node class that contains a data object and NEXT
 *enQueue() - enQueues a node to the bottom of the list
 *deQueue() - removes first node of list and returns it 
 *size() - recursive method, returns current size of the list
 *printAll() - void method that prints all object along with their index number
 *clearAll() - clears all nodes from the list
 *easyAppend() - enQueue multiple strings at once (use "new ObjectType[] {item,item,item...}" as the argument)
 *peak() - returns first node of list
 *isEmpty() - checks if empty
 *minSize() - static method, comparse size of two queues
*/
   private Node first;
   private Node last;   
      
   static class Node<ObjectType> {
      public Object data;     
      public Node next;

      public Node( ObjectType val) {
         data = val;
      }
    } //end Node
     
    
   public void enQueue(ObjectType new_data) {
      Node<ObjectType> new_node = new Node<ObjectType>(new_data);
        
      if (first == null) {
		   first = new_node;
         last = new_node;
		   return;
      }
      last.next = new_node;
      last = new_node;
      return;
    } //end enQueue
      
      
    public int size() {
      if(isEmpty()){
         return 0;
      }return size(1, first);
    } //end helper size      
   public int size(int currentSize, Node current) {  
      if (current.next == null) {
         return currentSize;
      } return size(++currentSize, current.next);
    } //end size
      
      public Node deQueue() {
         Node ret = first;
         first = first.next;
         return ret;              
      }//end deQueue
      
      public void clearAll() {
         first = null;
      }
      
      public void easyQueue(ObjectType[] array) {
         for(ObjectType item : array){
            enQueue(item);
         }
      }
      
      public void printAll() {
         System.out.println("All nodes in the linked list: ");
         Node current = first;
         
         while (current.next != null) {
            System.out.println(current.data);
            current = current.next;           
         }
         System.out.println(current.data);
      }//end printAll
      
      public Node peak() {
         return first;
      }
      
      public boolean isEmpty() {
         return first == null;
      }
      
      public static QueueLinkedList minSize(QueueLinkedList a, QueueLinkedList b) {
         if (a.size() > b.size())
            return b;
         return a;
      }     
}
class LinkedObjectTypeest {
   public static void main(String[] args) {
      QueueLinkedList q = new QueueLinkedList();
      QueueLinkedList f = q;
     
//             System.out.println(q.size());
       q.easyQueue(new String[] {"dog", "cat", "wombat", "bigman", "apples"});
//       q.printAll();
//       q.deQueue();
//       q.printAll();
//       q.enQueue("jam");
//       q.printAll();
//       System.out.println( "great" + QueueLinkedList.minSize(q,f).size() );
  

   }
}
