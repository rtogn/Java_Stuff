class TimeTest{
   public static void main (String[] args){
      Time24Hr clock = new Time24Hr();
      
      clock.setTime(1344);
      System.out.println(clock.getTime());
   }
}
