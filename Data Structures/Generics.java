import java.awt.Color;

class Generics {
   public static <E> void print(E[] a) {
      for(E e : a) {
         System.out.print(e + " ");
      } System.out.println();
   }
//    public static void print(int[] a) {
//       for(int e : a) {
//          System.out.print(e + " ");
//       } System.out.println();
//    }
}   

class GenericsTest{   
   public static void main(String[] ags) {
      String[] x = {"Cat", "dog", "wombat"};
      Integer[] y = {1, 2, 3};
     // Color c = Color.RED;
      Color[] c = {Color.RED, Color.BLUE, Color.GREEN};
      
      Generics.print(x);
      Generics.print(y);  
      Generics.print(c);   
   }
}