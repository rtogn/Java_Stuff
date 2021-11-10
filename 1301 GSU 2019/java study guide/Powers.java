class Powers{
   public static void main(String[] args){
      System.out.println(pow(2,1));
   }
   public static int pow(int base, int exp){
      int result = base;
      for(int i = 1; i < exp; i++)
         result = result * base;
      return result;
   }
}