import java.util.Iterator;
import java.util.NoSuchElementException;

public class RangeIter implements Iterable<Integer> {
   private int start, end;
   
   public RangeIter(int start, int end) {
      this.start = start;
      this.end = end;
   }
   
   public Iterator<Integer> iterator() {
      return new RangeIterator();
   }
   
   //inner class example
   private class RangeIterator implements Iterator<Integer> {
      private int cursor;
      
      public RangeIterator() {
         this.cursor = RangeIter.this.start;
      }
      
      public boolean hasNext() {
         return this.cursor < RangeIter.this.end;      
      }
      
      public Integer next() {
         if(this.hasNext()) {
            int current = cursor;
            cursor++;
            return current;
         } 
         throw new NoSuchElementException();
      }
      
      public void remove() {
         throw new UnsupportedOperationException();
      }
   } //end RangeIterator
   
   public static void main (String[] args) {
     RangeIter range = new RangeIter(1,11);
     //long way
     Iterator<Integer> it = range.iterator();
     while(it.hasNext()) {
      int cur = it.next();
      System.out.println(cur);
     }
     System.out.println("\n");
     //shorter, nicer way
     for(Integer cur : range) {
      System.out.println(cur);
     }
   }
}

