package decoratorPattern;

public class CarDecorator implements Car {
	public CarDecorator(Car car) {
		super();
		this.car = car;
	}

	private Car car;

	@Override
	public void increaseSpeed() {
		car.increaseSpeed();
	}

	@Override
	public void decreaseSpeed() {
		car.decreaseSpeed();
	}

	@Override
	public void turnLeft() {
		car.turnLeft();
	}

	@Override
	public void turnRight() {
		car.turnRight();
	}

	@Override
	public void printSpeed() {
		car.printSpeed();
	}
}
