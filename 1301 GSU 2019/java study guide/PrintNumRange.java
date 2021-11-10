class PrintNumRange{
   public static void main(String[] args){
      printRange(9, 2);
      System.out.println();
      printRange(2, 9);
      System.out.println();
      printRange(2, 2);
   }
   public static void printRange(int start, int fin){
      System.out.print(start);
     
     while (start < fin){
         start++;
         System.out.print(", " + start);
      }
     
      while (start > fin){
         start--;
         System.out.print(", " + start);
      }  
   }
}