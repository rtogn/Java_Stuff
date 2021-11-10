import java.util.*;
class PassCheck{
   public static void main(String[] args){
      Scanner c = new Scanner(System.in);
      String pass = "abadaba";     
      int count = 0;
      String enterPass;
      
      do{
         System.out.println("Enter your password: ");
         enterPass = c.next();
         count++;
      }while(!enterPass.equals(pass) && (count < 3));
      
      if (enterPass.equals(pass))
         System.out.println("Your password is correct.");
      else
         System.out.println("You exceeded 3 attempts. Try again later.");
   }
}