package com.mastercard.findPath.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphManager {

	class Road {
		private String src;
		private String dest;

		public Road(String source, String dest) {
			this.src = source;
			this.dest = dest;
		}
	}

	private List<Road> roads;

	public GraphManager(List<List<String>> roads) {
		List<Road> roadVals = new ArrayList<>();
		for (List<String> road : roads) {
			roadVals.add(new Road(road.get(0), road.get(1)));
		}
		this.roads = roadVals;
	}

	private List<Road> getAdjCities(String city) {

		List<Road> adjCities = new ArrayList<>();
		for (Road road : roads) {
			if (road.src.endsWith(city) || road.dest.equals(city)) {
				adjCities.add(road);
			}
		}

		for (Road road : adjCities) {
			roads.remove(road);
		}

		return adjCities;

	}

	private boolean isCityPresent(String city, List<Road> roads) {
		for (Road road : roads) {
			if (road.src.equals(city) || road.dest.equals(city))
				return true;
		}
		return false;
	}

	public boolean isPathPresent(String source, String destination) {

		Queue<String> queue = new LinkedList<>();

		queue.add(source);

		while (!queue.isEmpty()) {

			String currentCity = queue.poll();
			List<Road> adjCities = getAdjCities(currentCity);

			if (isCityPresent(destination, adjCities))
				return true;
			else {
				for (Road road : roads) {
					if (road.src.equals(currentCity)) {
						queue.add(destination);
					}

					if (road.dest.equals(currentCity)) {
						queue.add(source);
					}
				}
			}
		}

		return false;

	}

}
