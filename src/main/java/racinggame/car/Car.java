package racinggame.car;

public class Car {

	private final String name;
	private int moveCount = 0;

	public Car(String name) {
		this.name = name;
	}

	public int move(int randomNo) {
		if (randomNo >= 4) {
			moveCount++;
		}
		return moveCount;
	}

	public boolean isMoreThanOrEquals(Car car) {
		return this.moveCount >= car.getMoveCount();
	}

	public String getName() {
		return name;
	}

	public int getMoveCount() {
		return moveCount;
	}
}
