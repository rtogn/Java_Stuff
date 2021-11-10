class ManyEgg{
	public static void main (String[] wombats){
	    manyEggs();

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
    public static void middle(){

	System.out.println(" -\"-'-\"-'-\"-");
    }
    public static void hardboiled(){
	//combine methods into one magical egg
	top();
	middle();
	bottom();
    }
    public static void eggGrass(){
	//Create an egg ontop of some grass
	top();
	bottom();
	middle();
    }
    public static void manyEggs(){
	//Print full image for problem # 10
	eggGrass();
	eggGrass();
	bottom();
	hardboiled();
    }
}
