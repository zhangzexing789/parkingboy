package codingdojo.parkingboy;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertSame;

import org.junit.Test;

public class ParkingBoyTest {

	@Test
	public void should_park_when_parking_lot_is_empty() {
		Company company = new Company();
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		company.add(p1);
		company.add(p2);
		
		ParkingBoy parkingBoy = new ParkingBoy();
		company.employ(parkingBoy);
		parkingBoy.goToWork(company);

		parkingBoy.park(new Car("1"));
	}
	
	//should pick a car when the car is in the first parking lot
	@Test
	public void should_pick_a_park_when_the_car_is_in_first_parking_lot() {
		Company company = new Company();
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		company.add(p1);
		company.add(p2);
		ParkingBoy parkingBoy = new ParkingBoy();
		company.employ(parkingBoy);
		parkingBoy.goToWork(company);

		Car car = new Car("1");
		ParkingCard card1 = parkingBoy.park(car);
		
		Car carPicked = parkingBoy.pick(card1);
		
		assertEquals(carPicked, car);
	}

	//should park a car to the first parking lot when the first parking lot is not full
	@Test
	public void park_car_to_first_lot_when_first_lot_not_full(){
		Company company = new Company();
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		company.add(p1);
		company.add(p2);
		ParkingBoy parkingBoy = new ParkingBoy();
		company.employ(parkingBoy);
		parkingBoy.goToWork(company);

		Car car = new Car("1");
		ParkingLot parkingLot = parkingBoy.confirmParkingSpace();
		ParkingCard card1 = parkingBoy.park(car);

		assertEquals("1",card1.getCarNo());
		assertEquals("1",card1.getParkingName());

	}
	
	//should park to the second parking lot when the first is full
	@Test
	public void park_car_to_second_lot_when_first_lot_full(){
		Company company = new Company();
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		company.add(p1);
		company.add(p2);
		ParkingBoy parkingBoy = new ParkingBoy();
		company.employ(parkingBoy);
		parkingBoy.goToWork(company);
		Car car = new Car("1");

		p1.setParkingSpace(0);

		ParkingLot parkingLot = parkingBoy.confirmParkingSpace();
		ParkingCard card1 = parkingBoy.park(car);
		assertEquals("1",card1.getCarNo());
		assertEquals("2",card1.getParkingName());

	}

	//should park to the first parking lot when the first has space, even the second has car.
	@Test
	public void should_park_to_first_lot_has_space_even_second_has_space(){
		Company company = new Company();
		ParkingLot p1 = new ParkingLot("p1", 2);
		ParkingLot p2 = new ParkingLot("p2", 2);
		company.add(p1);
		company.add(p2);
		ParkingBoy parkingBoy = new ParkingBoy();
		company.employ(parkingBoy);
		parkingBoy.goToWork(company);
		Car car = new Car("1");

		p1.setParkingSpace(1);

		ParkingLot parkingLot = parkingBoy.confirmParkingSpace();
		ParkingCard card1 = parkingBoy.park(car);
		assertEquals("1",card1.getCarNo());
		assertEquals("p1",card1.getParkingName());

	}
	
	//should throw parking lot is full exception when trying to park but no space any more
	@Test(expected = ParkingLotIsFullException.class)
	public void  should_throw_lot_full_exception_when_park_but_no_space_any_more(){
		Company company = new Company();
		ParkingLot p1 = new ParkingLot("p1", 2);
		ParkingLot p2 = new ParkingLot("p2", 2);
		company.add(p1);
		company.add(p2);
		ParkingBoy parkingBoy = new ParkingBoy();
		company.employ(parkingBoy);
		parkingBoy.goToWork(company);
		Car car = new Car("1");

		p1.setParkingSpace(0);
		p2.setParkingSpace(0);

		ParkingLot parkingLot = parkingBoy.confirmParkingSpace();
		ParkingCard card1 = parkingBoy.park(car);
	}
	
	//should pick a car when the car is in the first parking lot
	@Test
	public void  should_pick_car_when_car_is_in_first_lot(){
		Company company = new Company();
		ParkingLot p1 = new ParkingLot("p1", 2);
		ParkingLot p2 = new ParkingLot("p2", 2);
		company.add(p1);
		company.add(p2);
		ParkingBoy parkingBoy = new ParkingBoy();
		company.employ(parkingBoy);
		parkingBoy.goToWork(company);
		Car car = new Car("1");

		ParkingLot parkingLot = parkingBoy.confirmParkingSpace();
		ParkingCard card1 = parkingBoy.park(car);

		Car pickCar = parkingBoy.pick(card1);

		assertEquals("p1",card1.getParkingName());
		assertEquals(car.getCarNo(),pickCar.getCarNo());
	}
	
	//should pick a car when the car is in the second parking lot
	@Test
	public void  should_pick_car_when_car_is_in_sceond_lot(){
		Company company = new Company();
		ParkingLot p1 = new ParkingLot("p1", 2);
		ParkingLot p2 = new ParkingLot("p2", 2);
		company.add(p1);
		company.add(p2);
		ParkingBoy parkingBoy = new ParkingBoy();
		company.employ(parkingBoy);
		parkingBoy.goToWork(company);
		Car car = new Car("1");

		p1.setParkingSpace(0);

		ParkingLot parkingLot = parkingBoy.confirmParkingSpace();
		ParkingCard card1 = parkingBoy.park(car);

		Car pickCar = parkingBoy.pick(card1);

		assertEquals("p2",card1.getParkingName());
		assertEquals(car.getCarNo(),pickCar.getCarNo());
	}
	
	//should throw car is not found exception when the parking card is not matched to any car
	@Test(expected = CarIsNotFoundException.class)
	public void  should_throw_car_is_not_found_exception_when_card_is_not_matched_to_any_car(){
		Company company = new Company();
		ParkingLot p1 = new ParkingLot("p1", 2);
		ParkingLot p2 = new ParkingLot("p2", 2);
		company.add(p1);
		company.add(p2);
		ParkingBoy parkingBoy = new ParkingBoy();
		company.employ(parkingBoy);
		parkingBoy.goToWork(company);
		Car car = new Car("1");

		ParkingLot parkingLot = parkingBoy.confirmParkingSpace();
		ParkingCard card1 = parkingBoy.park(car);
		ParkingCard cardNullCar = new ParkingCard("2","p1");

		parkingBoy.pick(cardNullCar);
	}

}
