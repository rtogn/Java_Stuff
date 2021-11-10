import java.awt.*;
public class MaxDemo {
   public static <E extends Comparable<E>> E max(E[] a) {
      E largest = a[0];
      for (int i = 1; i < a.length; i++) {
         if (a[i].compareTo(largest) > 0)
            largest = a[i];
      }
      return largest;
   }
}

class MaxTest {
   public static void main(String[] args) {
      String[] words = {"Tom", "Dono", "Harry"};
      Color[] c = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
      Integer[] squares = {1,4,9,16,25,36};
      System.out.println(MaxDemo.max(words));
      System.out.println(MaxDemo.max(squares));
      //System.out.println(MaxDemo.max(c));
   }
   }