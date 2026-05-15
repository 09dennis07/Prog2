package decoratorPattern;

public class DecoratorTest {

	public static void main(String[] args) {
		Car myCar = new RegularCar();
		
		myCar.printSpeed();
		myCar.increaseSpeed();
		myCar.printSpeed();
		
		SportsModeCar mySportsCar = new SportsModeCar(myCar);
		
		System.out.println("--------   Now using mySportsCar: ");
		mySportsCar.increaseSpeed();
		mySportsCar.printSpeed();
		mySportsCar.turnOnSportsMode();
		mySportsCar.increaseSpeed();
		mySportsCar.printSpeed();
		
		System.out.println("--------   Speed for myCar: ");
		myCar.printSpeed();
	}

}
