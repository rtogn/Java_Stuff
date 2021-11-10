import java.util.Random;

class Dice{
	Random roll;
	int sides;
	
	public Dice(){
		this.roll = new Random();
		this.sides = 6;		
	}
	
	public Dice(int sides){
		this.roll = new Random();
		this.sides = sides;
	}
	
	public int returnDice(){
		return roll.nextInt(sides);
	}
	
	public void rollMulti(int howManyRolls){
		for (int i = 1; i <= howManyRolls; i++){
			System.out.println("Roll " + i + ": " + this.returnDice());
		}
	}
}


