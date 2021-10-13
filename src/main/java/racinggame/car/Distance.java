package racinggame.car;

import java.util.Objects;

public class Distance {

	private int distance;

	public Distance() {
		this.distance = 0;
	}

	public void forward() {
		this.distance++;
	}

	public int getDistance() {
		return distance;
	}

	public boolean isMoreThanOrEquals(Distance distance) {
		return this.distance >= distance.getDistance();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Distance distance1 = (Distance)o;
		return distance == distance1.distance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(distance);
	}
}
