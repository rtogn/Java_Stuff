//import java.io.Serializable;
//import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;

class UseDat{
   public static void main (String[] args){
      ObjectInputStream ioStream = null;
      CircleX importedCircle = null;
      
      try{
         ioStream = new ObjectInputStream(
                        new FileInputStream("Cirquel_red.dat"));
         importedCircle = (CircleX) ioStream.readObject();
         System.out.println(importedCircle);
         
      } catch (Exception e) {
         System.out.println("No DAT found");
      }
      double x = Math.PI;
      System.out.println(x);
      
   }
}