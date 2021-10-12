package racinggame.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nextstep.utils.Console;
import racinggame.car.Car;
import racinggame.car.CarGroup;
import racinggame.car.GameRanking;
import racinggame.message.ErrorMessages;
import racinggame.message.Messages;

public class RacingCarGame {

	public void run() {
		List<Car> cars = getCars();
		int tryCount = getTryCount();

		CarGroup carGroup = new CarGroup(cars);

		GameRanking gameRanking = new GameRanking(play(carGroup, tryCount));

		System.out.println("최종 우승자는 " + gameRanking.getWinnerNames() + " 입니다.");
	}

	public List<Car> play(CarGroup carGroup, int tryCount) {
		System.out.println(Messages.PROCESSING_RESULT.getMessage());
		for (int i = 0; i < tryCount; i++) {
			carGroup.moveCars();
			carGroup.print();
			System.out.println();
		}
		return carGroup.getCars();
	}

	private int getTryCount() {
		while (true) {
			try {
				return Integer.parseInt(askTryCount());
			} catch (IllegalArgumentException iae) {
				System.out.println(iae.getMessage());
			}
		}
	}

	List<Car> getCars() {
		while (true) {
			List<String> names = Arrays.asList(askCarNames().split(","));
			try {
				return mappingCars(names);
			} catch (IllegalArgumentException iae) {
				System.out.println(iae.getMessage());
			}
		}
	}

	private List<Car> mappingCars(List<String> names) {
		List<Car> cars = new ArrayList<>();
		if (names.isEmpty()) {
			System.out.println(ErrorMessages.VALIDATE_CAR_NAME_EMPTY_ERROR.getMessage());
		}
		for (String name : names) {
			cars.add(new Car(name));
		}
		return cars;
	}

	private String askCarNames() {
		System.out.println(Messages.ASK_CAR_NAMES.getMessage());
		return Console.readLine();
	}

	private String askTryCount() {
		System.out.println(Messages.ASK_TRY_COUNT.getMessage());
		return Console.readLine();
	}
}
