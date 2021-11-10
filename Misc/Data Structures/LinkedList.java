public class LinkedList {
   private Node first;
      
    static class Node {
      public Object data;     
      public Node next;
      public Node last;
      int index;
      public Node( Object val, int index) {
         data = val;
         this.index = index;
      }
    } //end Node
     
    
   public void append(Object new_data) {
              
      if (first == null) {
         first = new Node(new_data, 0);
         return;
      }
      Node new_node = new Node(new_data, getSize());
      new_node.next = null;
      
      Node last = first;
      while(last.next != null) {
         last = last.next;
      }
      last.next = new_node;
      new_node.last = last;
      return;
   } //end append
      
      public Node getNode(int index) {
         return getNode(first, index);
      } //end helper getNode
      
      public Node getNode(Node current, int index) {
         if (current.index == index) {
            return current;
         }
         return getNode(current.next, index);
      } //end getNode
      
      public int getSize() {
         return getSize(1, first);
      } //end helper getSize
      
      public int getSize(int currentSize, Node current) {
        
         if (current.next == null) {
            return currentSize;
         } return getSize(++currentSize, current.next);

      } //end getSize
           
      public void printAll() {
         System.out.println("All nodes in the linked list: ");
         Node current = first;
         
         while (current.next != null) {
            System.out.println(current.data + " @Index: " + current.index);
            current = current.next;           
         }
         System.out.println(current.data + " @Index: " + current.index + "\n");

      }//end printAll
      
      public void remove(int index) {
         Node toRemove = getNode(index);
         Node prev;
         Node current = toRemove.next;
                  
         if (index == 0) {
         //check if toRemove is the first of the list (index 0)
            first = current;
            current.last = null;
         } else { 
         //else set current as previous' next and previous as currents last
            prev = toRemove.last;
            prev.next = current;
            current.last = prev;
         }
         while (current.next != null) {
         //update the index for the rest of the nodes
            current.index = index;
            current = current.next;
            index++;
         } current.index = index;       
      }  
      
      public void insert(Object data, int index) {
         //if the desired index is more than the number of entries, append data to the end instead.
         if (index >= this.getSize()){
            this.append(data);
            return;
         }  
         Node insert = new Node(data, index);       
         Node moveDown = getNode(index);
         Node moveUp;  
   
         if (index == 0) {
         //set insert to first if inserting at 0
            first = insert;
         } else {
         //if not inserting @first Node the node above has its .next mapped to the new node (insert)
            moveUp =  moveDown.last;
            moveUp.next = insert;
            insert.last = moveUp; 
         } 
         moveDown.last = insert;
         insert.next = moveDown;
            
         while (moveDown.next != null) {
         //update the index for the rest of the nodes
            moveDown.index = ++index;
            moveDown = moveDown.next;
            
         } moveDown.index = ++index;          
      }//end insert
      
      public void clearAll() {
         first = null;
      }
      
      public void easyAppend(Object[] array) {
         for(Object item : array){
            append(item);
         }
      }
      
      public Object removeFirst() {
         if (first == null) { 
           // throw new NoSuchElementException(); 
         } 
         Object element = first.data;
         first = first.next;
         return element;   
      }
}
class LinkedTest {
   public static void main(String[] args) {
      LinkedList q = new LinkedList();
      q.easyAppend(new Object[] {"dog", "cat", "wombat", "bigman", "apples"});

      q.printAll();
      System.out.println("Size of Original list: " + q.getSize() +"\n");
      
      q.remove(0);
      
      q.append("hurp");
      q.printAll();
      
      q.removeFirst();
      q.printAll();

   }
}