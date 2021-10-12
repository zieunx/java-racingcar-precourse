package racinggame.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GameRanking {
	Map<Integer, List<String>> ranking;

	public GameRanking(List<Car> cars) {
		mappingCars(cars);
	}

	public List<String> getWinnerNames() {
		return ranking.get(Collections.max(ranking.keySet()));
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
