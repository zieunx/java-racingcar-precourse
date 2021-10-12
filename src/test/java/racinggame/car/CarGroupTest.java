package racinggame.car;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarGroupTest {

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
	public void test() {

	}


}
