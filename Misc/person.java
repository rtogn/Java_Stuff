class person{
   private String name;
   
   public person(){
   }
   public person (String name){
      this.name = name;
   }
   public String getName(){
      return name;
   }
    void setName(String name){
      this.name = name;
   }
}

class dude extends person implements dog{
   private int cats;
   
   public dude (String name){
   }
   
   public void fuck(String wow){
      System.out.println(wow + cats);
 
   }
        
   public String getNamez(){
      return super.getName();
   }
   public void setName(String name){
      
   }
}