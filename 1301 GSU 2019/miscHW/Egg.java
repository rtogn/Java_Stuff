class Egg{
	public static void main (String[] wombats){
	    hardboiled();

	}
    public static void top(){

	System.out.println("   _______ \n "
			  + " /       \\\n"
			  +" /         \\"
			   );
    }
    public static void bottom(){

	System.out.println(" \\         /\n"
			  +"  \\_______/\n"
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
}
