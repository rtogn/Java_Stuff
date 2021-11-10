import java.awt.*;
import java.util.Random;
class CarTest{
	public static void main(String[] args){
		Car myCar = new Car(25, "001XYZ", Color.BLUE, true);
		Car wombat = new Car();
		RaceCar tman = new RaceCar();
		
		//tman.changePaintColor(Color.RED);

		
		Random r = new Random();
		int dice = r.nextInt(600);
		System.out.println(dice);
		
	}
}
