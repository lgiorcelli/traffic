package com.lgiorcelli.traffic;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.google.common.collect.Lists;

public class XXXTest {

	@Test
	public void test1() throws Exception {
		//GIVEN
		Scenario scenario = new Scenario();
		Route route = new Route(2000);
		Car car = new Car();
		//WHENo
		Snapshot snapshot = scenario.takeSnapshot();
		//THEN
		List<Car> cars = snapshot.getCars();
		Assertions.assertThat(cars).hasSize(1);
		Route route1 = snapshot.getRoute();
		Assertions.assertThat(route1.getLengthInMeters()).isEqualTo(2000);
	}

	public class Snapshot {
		private List<Car> cars = Lists.newArrayList();
		private Route route;

		public Snapshot(Car car, Route route) {
			this.route = route;
			cars.add(car);
		}

		public List<Car> getCars() {
			return cars;
		}

		public Route getRoute() {
			return route;
		}
	}

	public class Scenario {

		public Snapshot takeSnapshot() {
			return new Snapshot(new Car(), new Route(2000));
		}

	}

	public class Route {
		private int lengthInMeters;

		public Route(int lengthInMeters) {
			this.lengthInMeters = lengthInMeters;
		}

		public int getLengthInMeters() {
			return lengthInMeters;
		}
	}

	public class Car {

	}

	@Test
	public void testName() throws Exception {
		//GIVEN
		// un escenario de un minuto
		// un semaforo con tiempos 5 seg rojo/5 seg verde
		// un auto q viaja a 40 kms/h
		// una ruta de 2 kms recta
		//
		//WHEN
		// se toma un snapshot antes de ss
		//THEN
		// el snapshot contiene solo un auto al inicio de la ruta
	}
}