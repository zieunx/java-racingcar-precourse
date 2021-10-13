package racinggame.car;

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
}
