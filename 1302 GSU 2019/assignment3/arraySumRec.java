class arraySumRec{
   public static void main(String[] args){
      int a[] = {4, 3, 2, 1};
      System.out.println( arrSum(a, 0, 0) );
   }
   public static int arrSum(int[] a, int i, int sum){
      if (i > a.length-1)
         return sum;
      return ( arrSum(a, i+1, (sum+a[i]) ) ); 
   
   }
}