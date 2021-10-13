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

public class GameRanking {
	Map<Integer, List<CarName>> ranking;

	public GameRanking(List<Car> cars) {
		mappingCars(cars);
	}

	public String getWinnerNames() {
		StringBuilder winnersBuilder = new StringBuilder();
		for (CarName carName : ranking.get(Collections.max(ranking.keySet()))) {
			winnersBuilder.append(carName.getName()).append(",");
		}
		return winnersBuilder.substring(0, winnersBuilder.length() - 1);
	}

	private void mappingCars(List<Car> cars) {
		ranking = new TreeMap<>(Comparator.reverseOrder());

		for (Car car : cars) {
			checkRankingKey(car.getDistance());
			ranking.get(car.getDistance()).add(car.getName());
		}
	}

	private void checkRankingKey(int key) {
		if (!ranking.containsKey(key)) {
			ranking.put(key, new ArrayList<>());
		}
	}
}
