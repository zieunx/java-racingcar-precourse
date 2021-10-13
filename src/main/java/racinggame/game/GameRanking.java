package racinggame.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import racinggame.car.Car;
import racinggame.car.CarName;
import racinggame.car.Distance;

public class GameRanking {
	Map<Distance, List<CarName>> ranking;

	public GameRanking(List<Car> cars) {
		mappingCars(cars);
	}

	public String getWinnerNames() {
		StringBuilder winnersBuilder = new StringBuilder();
		Distance maxDistance = Collections.max(ranking.keySet(), Comparator.comparingInt(Distance::getDistance));

		for (CarName carName : ranking.get(maxDistance)) {
			winnersBuilder.append(carName.getName()).append(",");
		}
		return winnersBuilder.substring(0, winnersBuilder.length() - 1);
	}

	private void mappingCars(List<Car> cars) {
		ranking = new HashMap<>();

		for (Car car : cars) {
			checkRankingKey(car.getDistance());
			ranking.get(car.getDistance()).add(car.getName());
		}
	}

	private void checkRankingKey(Distance key) {
		if (!ranking.containsKey(key)) {
			ranking.put(key, new ArrayList<>());
		}
	}
}
