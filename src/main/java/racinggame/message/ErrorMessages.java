package racinggame.message;

public enum ErrorMessages {
	VALIDATE_CAR_NAME_LENGTH_ERROR("자동차 이름은 5자 이내로 입력해주세요."),
	VALIDATE_CAR_NAME_EMPTY_ERROR("자동차 이름 중 빈 값이 있습니다. 다시 입력해주세요."),
	TRY_COUNT_PARSING_ERROR("숫자를 입력해주세요."),
	VALIDATE_PLAY_COUNT_RANGE("시도 회수는 1 이상으로 입력해주세요.");

	private static final String ERROR_MESSAGE = "[ERROR]";
	private final String message;

	ErrorMessages(String message) {
		this.message = ERROR_MESSAGE + message;
	}

	public String getMessage() {
		return message;
	}
}
