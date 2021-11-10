class langCheck {
   public static void main(String[] args) {
      ADTstack chars = new ADTstack();
      String toCheck = "ACDC$ACDC"; //w$w'
      int i = 0;
      char ch = toCheck.charAt(0);   
      while(ch != '$') {
         chars.push(ch);
         ch = toCheck.charAt(++i);
      }
      i++; //skip $
      boolean inLang = true; 
      while(inLang && i < toCheck.length()) {
         ch = toCheck.charAt(i);
         
         try {
            if ((char)chars.pop() == ch) {
                i++;
                //chars.pop();
            }
         }  catch (StackException e) {
               inLang = false;        
         }  
      }
      System.out.println( inLang ? "The string is in the language" : "The string is not in the language");
   }
}