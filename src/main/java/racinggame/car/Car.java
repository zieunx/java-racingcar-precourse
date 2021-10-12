package racinggame.car;

import racinggame.message.ErrorMessages;

public class Car {

	private final int MOVING_FORWARD = 4;
	private final int NAME_MAX_SIZE = 5;
	private final String name;
	private int distance = 0;

	public Car(String name) {
		validateName(name);
		this.name = name;
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

	private void validateName(String name) {
		if (name.length() > NAME_MAX_SIZE) {
			System.out.println(ErrorMessages.VALIDATE_CAR_NAME_ERROR.getMessage());
		}
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Car{" +
			"name='" + name + '\'' +
			", distance=" + distance +
			'}';
	}
}
