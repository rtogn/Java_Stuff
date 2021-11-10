import java.util.*;
class Colors{
   public static void main(String[] args){
      Scanner c = new Scanner(System.in);
      System.out.println("Enter your color leter: ");
      String color = c.next();
      
      if (color.equalsIgnoreCase("B"))
         System.out.println("Color is Blue!");
      else if (color.equalsIgnoreCase("G"))
         System.out.println("Color is Green!");
      else if (color.equalsIgnoreCase("R"))
         System.out.println("Color is Red!");
      else
         System.out.println("That is not an available color!");
   }
}