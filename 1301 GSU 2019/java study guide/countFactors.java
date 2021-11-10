class countFactors{
   public static void main(String[] args){
      System.out.println(countFactors(5));
   }
   public static int countFactors(int x){
      int count = 0;
      for (int i = 1; i <= x; i++){
         if (x % i == 0)
            count++;
      }
      return count;
   }
}