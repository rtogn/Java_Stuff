import java.util.Scanner;
class Annoy{
   public static final int SENTINEL = 2;
   
   public static void main(String[] args){
      Scanner c = new Scanner (System.in);
      int sum = 0;
      int num = 0;
      do{
         System.out.println("Enter a number!(enter 2 to exit): ");
         sum = sum + num;
         num = c.nextInt();
         }while(!(num == SENTINEL));
      System.out.println("Your total is: " + sum);
   }
}