class Pair <T, S>{
   private T first;
   private S second;
   
   public Pair(T firstElement, S secondElement) {
      first = firstElement;
      second = secondElement;
   }
   public T getFirst() {return first;}
   public S getSecond() {return second;}
   public String toString() {
      return "(" + first + "," + second + ")";
   }
}

class PairDemo {
   public static void main(String[] ags) {
      String[] names = {"Tom", "Dono", "Harry"};
      Pair<String, Integer> result = firstContaining(names, "a");
      System.out.println(result.getFirst());
      System.out.println("Expected: Diana");
      System.out.println(result.getSecond());
      System.out.println("Expected 1");
      
   } 
   
   public static Pair<String, Integer> firstContaining ( String[] strings, String sub) {
      for (int i= 0; i < strings.length;i++) {
         if(strings[i].contains(sub)) {
            return new Pair<String, Integer>(strings[i], i);
         }
      }
      return new Pair<String, Integer>(null, -1);
   }  
}
