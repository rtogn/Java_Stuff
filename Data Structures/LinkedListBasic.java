public class LinkedListBasic {
   public Node head;
   public int currentSize;
   
   static class Node {
      public String data;     
      public Node next;
      public Node last;
      int place;
      public Node( String val, int place) {
         data = val;
         this.place = place;
      }
    }
      
      public LinkedListBasic (String data) {
         this.append(data);
         this.currentSize = 0;
      }
      public void append(String new_data) {
              
         if (head == null) {
            head = new Node(new_data, currentSize);
            this.currentSize++;
            return;
         }
         Node new_node = new Node(new_data, currentSize);
         new_node.next = null;
         this.currentSize++;
         
         Node last = this.head;
         while(last.next != null) {
            last = last.next;
         }
         last.next = new_node;
         return;
      } 
      
      public String getNodeData(Node current, int index) {
         if (current.place == index) {
            return current.data;
         }
         return getNodeData(current.next, index);
      }
      
      public static void printAll(Node head) {
         System.out.println("All nodes in the linked list: ");
         Node current = head;
         
         while (current.next != null) {
            System.out.println(current.data);
            current = current.next;           
         }
         System.out.println(current.data +"\n");

      }  
   }

//    public static void main(String[] args) {
//   
//       
//       Node o1, o2, o3, o4;
//       
//       o1 = new Node("Tom");
//       o2 = new Node("John");
//       o3 = new Node("Dan");
//       o4 = new Node("Fan");
//       
//      
//       o1.next = o2;
//       o2.next = o3;
//       o3.next = o4;
//       Node head = o1;
//       
//       o4.append(head, "Dog");
// 
//       o1.printAll(head);
//       o1.append(head, "Wombats");
//       o1.printAll(head);
//       
//    }
// }