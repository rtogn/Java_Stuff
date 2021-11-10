import java.util.Scanner;

class Annoy{
   public static void main (String[] args){
   Scanner console = new Scanner(System.in);
   String q;   
      do{
         System.out.println("She sells seashells by the seashore \n"
                          + "Do you want to hear it again? ");
         
         q = console.next();   
      }while(q.equalsIgnoreCase("y"));
   }
}
