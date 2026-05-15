package decoratorPattern;

public class SportsModeCar extends CarDecorator {
    public SportsModeCar(Car component) {
        super(component);
    }
    
    private boolean sportsMode = false;

    @Override
    public void increaseSpeed() {
    	if (sportsMode) {
    		System.out.println("Quickly faster ...");
    		super.increaseSpeed();
    		super.increaseSpeed();
    	} else
    		super.increaseSpeed();
    }
    
    public void turnOnSportsMode() { sportsMode = true; }
    public void turnOffSportsMode() { sportsMode = false; }

}
