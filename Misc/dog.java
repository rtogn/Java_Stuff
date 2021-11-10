class Vehicle{

   public int numAxles;

   public Vehicle(int axles) {
      numAxles = axles;
   }

   public Vehicle(){
      this(3);
   }
   
   public int getAxles(){
      return numAxles;
   }
}

class dog extends Vehicle{

   public static void main(String[] args){
   
   Vehicle f = new Vehicle();
   
   System.out.println(f.getAxles());
}
}