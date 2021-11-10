public abstract class GeometricObjects{
	protected String color;
	protected boolean filled;
	protected java.util.Date dateCreated;
   public static final double check = 1.0;
	
	public GeometricObjects(){
		dateCreated = new java.util.Date();
	}
	
	public GeometricObjects(String color, boolean filled){
		this.color = color;
		this.filled = filled;
		dateCreated = new java.util.Date();
	}
	
	abstract String getColor();
	abstract void setColor(String color);
	
	abstract boolean isFilled();
	abstract void setFilled(boolean filled);
	
	abstract java.util.Date getDateCreated();
	
	public abstract String toString();
	
	abstract double getArea();
	abstract double getPerimeter();

} //end geomobj

class Circle extends GeometricObjects{
	
	private double radius;
	
	public Circle(){
      this.color = "Unknown";
	}
	
	public Circle(double radius){
		this.radius = radius;
	}
	
	public Circle(double radius, String color, boolean filled){
		super(color, filled);
		this.radius = radius;
	}
		
	public String getColor(){
		return this.color;
	}	
	public void setColor(String color){
		this.color = color;
	}
	
	public boolean isFilled(){
		return this.filled;
	}
	public void setFilled(boolean filled){
		this.filled = filled;
	}
	
	public java.util.Date getDateCreated(){
		return this.dateCreated;
	}
	
	public String toString(){
		return ("This is a " + this.color +  " circle of radius " 
		+ this.radius + " area, perimeter, Diameter of: " + String.format("%.2f", getArea()) + ", " 
		+ String.format("%.2f", getPerimeter()) + ", " +  String.format("%.2f", getDiameter()) + " created on " + this.dateCreated);
	}
	
	public double getArea(){
		return (Math.PI * (this.radius * this.radius));
	}
	public double getPerimeter(){
		return (2 * Math.PI * this.radius);
	}
	
	public double getDiameter(){
		return (2 * this.radius);
	}
   
   public double getRadius(){
      return this.radius;
   }
   
   public boolean equals(Object comparedObj) {
      return ( (comparedObj instanceof Circle) && 
               (radius == ((Circle)comparedObj).getRadius()) );   
   } //end equals
} //end circle

class Rectangle extends GeometricObjects{
	private double width;
	private double height;
	
	
   
	public Rectangle(){
      this.color = "Unknown";      
	}
	
	public Rectangle(double width, double height){
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(double width, double height, String color, boolean filled){
		super(color, filled);
		this.width = width;
		this.height = height;
	}
		
	public String getColor(){
		return this.color;
	}	
	public void setColor(String color){
		this.color = color;
	}
	
	public boolean isFilled(){
		return this.filled;
	}
	public void setFilled(boolean filled){
		this.filled = filled;
	}
	
	public java.util.Date getDateCreated(){
		return this.dateCreated;
	}
	
	public double getWidth(){
		return this.width;
	}
	public void setWidth(double width){
		this.width = width;
	}
	
	public double getHeight(){
		return this.height;
	}
	public void setHeight(double height){
		this.height = height;
	}	
	
	public String toString(){
		return ("This is a " + color +  " rectangle of area " 
		+ String.format("%.2f",getArea()) +  " perimeter of " + String.format("%.2f", getPerimeter()) + " created on " 
		+ this.dateCreated);
	}
	
	public double getArea(){
		return ( this.width * this.height );
	}
	public double getPerimeter(){
		return ( (2*this.width) + (2*this.height) );
	}
}

class GeoFigTest{
	public static void main (String[] args){
		GeometricObjects circle1 = new Circle(2, "red", true);
		GeometricObjects rectangle1 = new Rectangle();
		GeometricObjects circle2 = new Circle(2, "red", true);
		GeometricObjects rectangle2 = new Rectangle(6, 4.5, "blue", true);
		
		System.out.println(circle1 + "\n");
		System.out.println(rectangle1 + "\n");
		System.out.println(circle2 + "\n");
		System.out.println(rectangle2 + "\n");
      if( (4.6-2.0+3.2-1.1*2) == (double)3.6 )
         System.out.println(1);
      
      if (circle1.equals(circle2)){
         System.out.println(1111);
      }else{
         System.out.println(2222);
      }
	}
}
