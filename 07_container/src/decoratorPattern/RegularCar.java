package decoratorPattern;

public class RegularCar implements Car {
	private int speed = 0;
	
	@Override 
	public void printSpeed() {
		System.out.println("Now going " + speed + " km/h");
	}
	
	@Override
	public void increaseSpeed() {
		speed += 10;
	}

	@Override
	public void decreaseSpeed() {
		System.out.println("Slower ...");
	}

	@Override
	public void turnLeft() {
		System.out.println("Left ...");
	}

	@Override
	public void turnRight() {
		System.out.println("Right ...");
	}

}
