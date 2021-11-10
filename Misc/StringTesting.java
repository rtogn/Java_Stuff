class StringTesting{
   public static void main (String[] args){

   String statement = "da is the inventor of t_Thomas Edison_ he lightbulb";
   String Answer = "";
   int start = statement.indexOf('_');
   int end = statement.indexOf('_', (start + 1));
        
   for (int i = (start + 1); i < end; i++){
      Answer += statement.charAt(i);
   }
   
   

   }
}