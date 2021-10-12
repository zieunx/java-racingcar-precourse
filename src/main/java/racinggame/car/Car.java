package racinggame.car;

import java.util.Collections;

public class Car {
	private final String PRINT_DISTANCE = "-";
	private final int MOVING_FORWARD = 4;
	private final CarName name;
	private int distance = 0;

	public Car(String name) {
		this.name = new CarName(name);
	}

	public int move(int randomNo) {
		if (randomNo >= MOVING_FORWARD) {
			distance++;
		}
		return distance;
	}

	public boolean isMoreThanOrEquals(Car car) {
		return this.distance >= car.getDistance();
	}

	public int getDistance() {
		return distance;
	}

	public CarName getName() {
		return name;
	}

	public void print() {
		System.out.println(name.getName() + " : " + String.join("", Collections.nCopies(distance, PRINT_DISTANCE)));
	}
}
