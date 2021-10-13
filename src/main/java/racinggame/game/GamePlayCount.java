package racinggame.game;

import java.util.List;

import racinggame.car.Car;
import racinggame.car.CarGroup;
import racinggame.message.ErrorMessages;
import racinggame.message.Messages;

public class GamePlayCount {

	private final int tryCount;

	public GamePlayCount(int tryCount) {
		this.validateRange(tryCount);
		this.tryCount = tryCount;
	}

	public List<Car> play(CarGroup carGroup) {
		System.out.println(Messages.RESULT_TITLE.getMessage());

		for (int i = 0; i < tryCount; i++) {
			carGroup.moveCars();
			carGroup.print();
			System.out.println();
		}
		return carGroup.getCars();
	}

	private void validateRange(int tryCount) {
		if (tryCount < 1) {
			throw new IllegalArgumentException(ErrorMessages.VALIDATE_PLAY_COUNT_RANGE.getMessage());
		}
	}
}
