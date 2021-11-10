class Time{
      private int minutes;
    //1440
      public void setTime(int mins){
         minutes = mins;
      }
      
      public String getTime(){
         int h = minutes / 60;
         int m = minutes % 60;
         String amPm = " am";
	 
         if (minutes >= 720){
            h = h - 12;
            amPm = " pm";
         }
	 if (h == 0)
	     h = 12;
         return(h + ":" + String.format("%02d",m) + amPm);
      }

}
