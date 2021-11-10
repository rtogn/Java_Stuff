import java.util.*;
class quads{
   public static void main(String[] args){
      Scanner c = new Scanner(System.in);
      System.out.println("Enter X: ");
      int x = c.nextInt();
      System.out.println("Enter Y: ");
      int y = c.nextInt();
      System.out.println(quadrant(x, y)); 
   }
   public static int quadrant(int x, int y){
      
      if (x > 0 && y > 0)
         return(1);
      else if (x < 0 && y > 0)
         return(2);
      else if (x < 0 && y < 0)
         return(3);
      else if (x > 0 && y < 0)
         return(4);
      else
         return(0);
   }
}