package racinggame.car;

import racinggame.message.ErrorMessages;

public class CarName {

	private final int NAME_MAX_SIZE = 5;

	private String name;

	CarName(String name) {
		validateIsEmpty(name);
		validateNameSize(name);

		this.name = name;
	}

	public String getName() {
		return name;
	}

	private void validateIsEmpty(String name) {
		if (isEmpty(name)) {
			throw new IllegalArgumentException(ErrorMessages.VALIDATE_CAR_NAME_EMPTY_ERROR.getMessage());
		}
	}

	private void validateNameSize(String name) {
		if (name.length() > NAME_MAX_SIZE) {
			throw new IllegalArgumentException(ErrorMessages.VALIDATE_CAR_NAME_LENGTH_ERROR.getMessage());
		}
	}

	private boolean isEmpty(String name) {
		return name == null || name.trim().equals("");
	}
}
