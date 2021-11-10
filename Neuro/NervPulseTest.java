class NervPulseTest {
   public static void main (String[] args) {
      TimeThresh set = new TimeThresh();
      test(set);
      System.out.println(set.thresh);
   
      
   }
   
   public static void test (TimeThresh set) {
      set.thresh += 2;
   }
   
   public static void update (TimeThresh set, int loss) {
      set.time += 1;
      if(set.thresh > 0) {
         
      }
   }
}


class TimeThresh {
   int thresh;
   int time;
   public TimeThresh() {
      thresh = 0;
      time = 0;
   }
}