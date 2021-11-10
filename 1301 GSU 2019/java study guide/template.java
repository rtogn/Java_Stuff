import java.util.*;
class Weather{
   public static void main(String[] args){
      Scanner c = new Scanner(System.in);
      double[] temps = new double[10]; 
      double avrgSum = 0;
      int aboveCount = 0;
      
      for (int i = 0; i < 10; i++){
         System.out.println("Please enter temperature number " + (i+1) + " of 10: "); 
         //double input = c.nextDouble();
         temps[i] = c.nextDouble();
         avrgSum = avrgSum + temps[i];
      }
      double averageTemp = avrgSum/10;
      System.out.println("The average temperature is " + averageTemp);
      
      
      for (int i = 0; i < 10; i++){
         if (temps[i] > averageTemp)
            aboveCount++;  
      }
      System.out.println("There were " + aboveCount + " days above average temp");
   
   }
}