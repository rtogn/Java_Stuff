class IsPrime{
   public static void main(String[] args){
      int num = 7;
      if (isPrime(num))
      System.out.println("It is a prime number!");
      else
      System.out.println("It is NOT a prime number!");
   }
   public static boolean isPrime(int num){
      int count = 0;
      for (int i=1; i<=num; i++){
         if (num % i == 0)
            count++;
      }
      return(count == 2);
   }
}