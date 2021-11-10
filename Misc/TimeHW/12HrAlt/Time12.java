class Time12{
    private int hours;
    private int min;

    public void setTime(int h, int m){
	hours = h;
	min = m;
    }

    public String getTime(){
	String amPm =" am";

	if (hours >= 12){
	    hours  = hours - 12;
	    amPm = " pm";
	}
	if (hours == 0)
	    hours = 12;
	return(hours + ":" + String.format("%02d", min) + amPm);
    }   
}
