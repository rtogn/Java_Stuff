
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
class geomObjX implements Serializable {
   private String name;
   private int area;
   
   public geomObjX(){
      this.name = "no name";
      this.area = 0;
   }
   
   public geomObjX(String name, int area) {
      this.name = name;
      this.area = area;
   }
   
   public String getName() {
      return name;
   }
   
   public int getArea() {
      return area;
   }
   
   public String toString() {
      return ( "Name: " + this.getName() + " Area: " + this.getArea() );
   }
} //end geomObjX

class CircleX extends geomObjX {
   private double radius;
   private String color;
   
   public CircleX(){
      super();
      this.radius = 1.0;
      this.color = "colorless";
   }
   
   public CircleX(String name, int area, double radius, String color){
      super(name, area);
      this.radius = radius;
      this.color = color;
   }
   
   public String getColor() {
      return color;
   }
   
   public double getRadius() {
      return radius;
   }   
   
   public String toString() {
      return ( super.toString() + " radius: " + this.radius + " color " + this.color );
   }
   
} //end CircleX

class testGeomObjX{
   public static void main (String[] args){
      CircleX q = new CircleX();
      System.out.println(q);
      
      CircleX c = new CircleX("Cirquel", 55, 2, "red");
      System.out.println(c);
      
      try{
         String nameGen = c.getName() + "_" + c.getColor() + ".dat";
         ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(nameGen));
         outStream.writeObject(c);
         
      } catch (IOException e) {
         System.out.println("cant do");
      }
   }
}