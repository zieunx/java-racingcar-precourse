package racinggame.car;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameRankingTest {

	private CarGroup carGroup;

	@BeforeEach
	void setUp() {
		carGroup = new CarGroup(Arrays.asList(
			new Car("테슬라"),
			new Car("쉐보레"),
			new Car("현대")
		));
	}

	@Test
	public void 순위매기기() {
		List<Car> playCars = carGroup.play(4);
		System.out.println("playCars = " + playCars);
		GameRanking gameRanking = new GameRanking(playCars);
		System.out.println(gameRanking.getWinnerNames());
	}
}
