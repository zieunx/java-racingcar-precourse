package racinggame.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

	private Car car;

	@BeforeEach
	void setUp() {
		car = new Car("테슬라");
	}

	@Test
	public void 자동차_4이상_전진() {
		assertThat(car.move(4)).isEqualTo(1);
	}

	@Test
	public void 자동차_3이하_정지() {
		assertThat(car.move(3)).isEqualTo(0);
	}


	@Test
	public void 자동차_전진과_정지() {
		assertThat(car.move(3)).isEqualTo(0);
		assertThat(car.move(4)).isEqualTo(1);
		assertThat(car.move(9)).isEqualTo(2);
		assertThat(car.move(0)).isEqualTo(2);
		assertThat(car.move(3)).isEqualTo(2);
	}

	@Test
	public void 자동차_거리_비교() {
		car.move(3);
		car.move(4);

		Car otherCar = new Car("쉐보레");

		otherCar.move(2);
		otherCar.move(3);

		assertThat(car.isMoreThanOrEquals(otherCar)).isTrue();
		assertThat(otherCar.isMoreThanOrEquals(car)).isFalse();
	}
}
