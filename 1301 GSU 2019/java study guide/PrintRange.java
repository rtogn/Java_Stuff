class PrintRange{
   public static void main(String[] args){
      printRange('a', 'z');
   }
   public static void printRange(char start, char fin){
      System.out.print(start);
      for (int i = start; i < fin; i++){
         System.out.print(", " + (char)(i + 1));
      }
   }
}