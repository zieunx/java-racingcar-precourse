package racinggame.car;

import java.util.List;

import nextstep.utils.Randoms;

public class CarGroup {

	private final List<Car> cars;

	public CarGroup(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> play(int tryCount) {
		for (int i = 0; i < tryCount; i++) {
			moveCars();
		}
		return cars;
	}

	private void moveCars() {
		for (Car car : cars) {
			car.move(Randoms.pickNumberInRange(0, 9));
		}
	}
}
