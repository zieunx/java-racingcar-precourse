package racinggame.message;

public enum Messages {

	ASK_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
	ASK_TRY_COUNT("시도할 회수는 몇회인가요?"),
	PROCESSING_RESULT("실행 결과"),
	PRINT_GAME_WINNER("최종 우승자은 %d 입니다.");

	private final String message;

	Messages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
