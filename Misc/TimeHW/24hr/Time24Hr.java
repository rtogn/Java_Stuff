class Time24Hr
{
      int minutes;
      
      public void setTime(int mins)
      {
         minutes = mins;
      }
      
      public String getTime()
      {
         int h = minutes / 60;
         int m = minutes % 60;
         return(h + ":" + String.format("%02d",m));
      }

}
