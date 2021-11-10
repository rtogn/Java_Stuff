class RevNum{
   public static void main(String[] args){
      System.out.println(revNum(2432433));
   }
   public static int revNum(int num){
      int result = 0;
      num = Math.abs(num);
      while(num > 0){ 
         result = (result* 10) + num % 10; 
         num = num / 10;                           
      }
      return result;
   }
}