package racinggame.car;

import java.util.Collections;

public class Car {
	private final String PRINT_DISTANCE = "-";
	private final int MOVING_FORWARD = 4;
	private final CarName name;
	private final Distance distance;

	public Car(String name) {
		this.name = new CarName(name);
		this.distance = new Distance();
	}

	public Distance move(int randomNo) {
		if (isForward(randomNo)) {
			distance.forward();
		}
		return distance;
	}

	public boolean isMoreThanOrEquals(Car car) {
		return distance.isMoreThanOrEquals(car.getDistance());
	}

	public Distance getDistance() {
		return distance;
	}

	public CarName getName() {
		return name;
	}

	public void print() {
		System.out.println(name.getName() + " : " + String.join("", Collections.nCopies(distance.getDistance(), PRINT_DISTANCE)));
	}

	private boolean isForward(int randomNo) {
		return randomNo >= MOVING_FORWARD;
	}
}
