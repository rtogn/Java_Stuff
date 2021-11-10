class EggStop{
	public static void main (String[] wombats){
	    eggStop();

	}
    public static void top(){

	System.out.println("   _______ \n "
			  + " /       \\\n"
			  +" /         \\"
			   );
    }
    public static void bottom(){

	System.out.println(" \\         /\n"
			  +"  \\_______/"
			   );

    }    
    public static void eggInBasket(){
	//Create an egg in a basket
	top();
	bottom();
	bottom();
	System.out.println("  +-------+");
    }
    public static void stoppedEgg(){
	//Print image of STOP egg on a stand
	top();
	System.out.println(" |   STOP  |");
	bottom();
	top();
	System.out.println(" +---------+");
    }
    public static void eggStop(){
	//Combine both scenes
	eggInBasket();
	stoppedEgg();
    }
}
