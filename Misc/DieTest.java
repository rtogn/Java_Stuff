import java.util.Scanner;
class DieTest{
	public static void main(String[] args){
		Dice D20 = new Dice(20);
		//System.out.println(D20.returnDice());
		//D20.rollMulti(3);
		System.out.println(fact(4));
		System.out.println(fib(13));
		
	}

	public static int fact(int n){
		Scanner c = new Scanner(System.in);
		if (n < 0){
			System.out.println("Invalid number, enter a non-negative integer: ");
			return ( fact(c.nextInt()) );
		}

		if (n == 0){
			return 1;
		}

		else
			return ( n * fact(n-1) );
			

	}
	
	public static int fib(int n){
		if (n <= 2) {
			return 1;
		}
		else{
			return fact(n-1) + fact(n-2);
		}
	}
}
