package racinggame.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nextstep.utils.Console;
import racinggame.car.Car;
import racinggame.car.CarGroup;
import racinggame.message.ErrorMessages;
import racinggame.message.Messages;

public class RacingCarGame {

	public void run() {
		CarGroup carGroup = new CarGroup(getCars());
		GamePlayCount gamePlayCount = getPlayCount();

		GameRanking gameRanking = new GameRanking(gamePlayCount.play(carGroup));

		System.out.println("최종 우승자는 " + gameRanking.getWinnerNames() + " 입니다.");
	}

	private GamePlayCount getPlayCount() {
		while (true) {
			try {
				int playCount = parsingStringToInteger(askPlayCount());
				return new GamePlayCount(playCount);
			} catch (IllegalArgumentException iae) {
				System.out.println(iae.getMessage());
			}
		}
	}

	private int parsingStringToInteger(String input) {
		try {
			return Integer.parseInt(input);
		} catch (IllegalArgumentException iae) {
			throw new IllegalArgumentException(ErrorMessages.TRY_COUNT_PARSING_ERROR.getMessage());
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
		validateCarNames(names);

		List<Car> cars = new ArrayList<>();
		for (String name : names) {
			cars.add(new Car(name));
		}
		return cars;
	}

	private void validateCarNames(List<String> names) {
		if (names.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessages.VALIDATE_CAR_NAME_EMPTY_ERROR.getMessage());
		}
	}

	private String askCarNames() {
		System.out.println(Messages.ASK_CAR_NAMES.getMessage());
		return Console.readLine();
	}

	private String askPlayCount() {
		System.out.println(Messages.ASK_PLAY_COUNT.getMessage());
		return Console.readLine();
	}
}
