public class SodaCan implements Measurable{
	private double height;
	private double radius;
	
	public SodaCan(double height, double radius){
		this.height = height;
		this.radius = radius;
	}
	
	public double getSurfaceArea(){
		return ( (2 * Math.PI * radius) * (height + radius) );
	}
	
	public double getVolume(){
		return ( (Math.PI * (radius * radius)) * height) ;
	}
	
	public double getMeasure(){
		return getSurfaceArea();
	}
}

class SodaCanTest{
	public static void main (String[] args){
		SodaCan can1 = new SodaCan(3, 2);
		SodaCan can2 = new SodaCan(3, 2);
		SodaCan can3 = new SodaCan(3, 2);
		SodaCan can4 = new SodaCan(3, 2);
		
		Measurable[] surfaceAverage = {can1, can2, can3, can4};
		
		double average = 0;
		for (Measurable can : surfaceAverage){
			average += can.getMeasure();
		}
		average /= surfaceAverage.length;
		System.out.println("Average can surface area: " + String.format("%.3f", average));
	}
}
