class ZeroDigits{
   public static void main(String[] args){
      System.out.println("The number of zero digits are: " + zeroDigits(40000001));
   }
   public static int zeroDigits(int num){
      int count = 0;
      if (num == 0)
         count++;
      while(num > 0){
         int sub = num % 10;
         num = num / 10;
         if (sub == 0)
            count++;
      }
      return count;
   }
}