class recRevString{
   public static void main(String[] args){
      String n = "Hello cat dog wombat123";
     // n = revString( n, "", n.length()-1);
      n = revStringB(n, 0, n.length()-1);
      System.out.println(n);
   }
   public static String revString(String n, String m, int i){
      
      if ( m.length() == n.length() ){
         return (m);
      } 
      return( revString( n, m + n.charAt(i), (i-1) ) );
   } 
   
   
   public static String revStringB(String n, int i, int j){
      
      char[] c = n.toCharArray();
      
      if ( i == j ){
         return(n);
      }
      else{
         char temp = c[i];
         c[i] = c[j];
         c[j] = temp;
         n = "";
         for (char aChar : c)
            n += aChar;
         
         return (revStringB(n, ++i, --j));    
      }
      
   }
}