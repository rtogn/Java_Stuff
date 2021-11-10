class AllDigitsOdd{
   public static void main(String[] args){
      System.out.println(allDigitsOdd(12111));
   }
   public static boolean allDigitsOdd(int num){
      int sub = 0;
      num = Math.abs(num);
      do{
         sub = num % 10;
         num = num / 10;
      }while( num > 0 && sub % 2 == 1);
      
      return (sub % 2 == 1);
      
   }
}