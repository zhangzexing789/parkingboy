package codingdojo.parkingboy;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParkingBoyTest {

	@Test
	public void should_park_when_parking_lot_is_empty() {
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		ParkingBoy parkingBoy = new ParkingBoy();
		buildCompany(p1, p2, parkingBoy);
		
		parkingBoy.park(new Car("1"));	
	}
	
	@Test
	public void should_pick_a_park_when_the_car_is_in_first_parking_lot() {
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		ParkingBoy parkingBoy = new ParkingBoy();
		buildCompany(p1, p2, parkingBoy);
		Car car = new Car("1");
		ParkingCard card1 = parkingBoy.park(car);
		
		Car carPicked = parkingBoy.pick(card1);
		
		assertEquals(carPicked, car);
	}
	
	
	@Test
	public void should_park_car_to_first_lot_when_first_lot_not_full() {
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		ParkingBoy parkingBoy = new ParkingBoy();
		buildCompany(p1, p2, parkingBoy);
		Car car = new Car("1");
		
		ParkingCard card1 = parkingBoy.park(car);
		
		assertEquals(new Integer(1),p1.getParkingCarsNum());
	}
	
	@Test
	public void should_park_to_the_second_parking_lot_when_the_first_is_full() {
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		ParkingBoy parkingBoy = new ParkingBoy();
		buildCompany(p1, p2, parkingBoy);
		Car car = new Car("1");
		Car car2 = new Car("2");
		Car car3 = new Car("3");
		
		parkingBoy.park(car);
		parkingBoy.park(car2);
		parkingBoy.park(car3);
		
		assertEquals(new Integer(1),p2.getParkingCarsNum());
	}

	private void buildCompany(ParkingLot p1, ParkingLot p2, ParkingBoy parkingBoy) {
		Company company = new Company();
		company.add(p1);
		company.add(p2);
		company.employ(parkingBoy);
	}
	
	@Test(expected = CarDuplicationException.class)
	public void should_throw_car_duplicate_exception_when_try_to_park_the_same_car_twice(){
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		ParkingBoy parkingBoy = new ParkingBoy();
		buildCompany(p1, p2, parkingBoy);
		Car car1 = new Car("1");
		Car car2 = new Car("1");

		parkingBoy.park(car1);
		parkingBoy.park(car2);

	}

	
	@Test
	public void should_park_to_the_first_parking_lot_when_the_first_has_space_even_the_second_has_car(){
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		ParkingBoy parkingBoy = new ParkingBoy();
		buildCompany(p1, p2, parkingBoy);
		Car car = new Car("1");
		Car car2 = new Car("2");
		Car car3 = new Car("3");
		parkingBoy.park(car);
		ParkingCard card2 = parkingBoy.park(car2);
		parkingBoy.park(car3);
		parkingBoy.pick(card2);
		assertFalse(p1.isParkingLotFull());
		
		parkingBoy.park(car2);
		
		assertTrue(p1.isParkingLotFull());
	}
	@Test(expected = ParkingLotFullException.class)
	public void  should_throw_full_exception_when_trying_to_parking_but_no_space_any_more(){
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		ParkingBoy parkingBoy = new ParkingBoy();
		buildCompany(p1, p2, parkingBoy);
		Car car1 = new Car("1");
		Car car2 = new Car("2");
		Car car3 = new Car("3");
		Car car4 = new Car("4");
		Car car5 = new Car("5");

		parkingBoy.park(car1);
		parkingBoy.park(car2);
		parkingBoy.park(car3);
		parkingBoy.park(car4);
		parkingBoy.park(car5);

	}
	
	@Test
	public void should_pick_a_car_in_the_first_parking_lot_even_the_second_has_car(){
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		ParkingBoy parkingBoy = new ParkingBoy();
		buildCompany(p1, p2, parkingBoy);
		Car car = new Car("1");
		Car car2 = new Car("2");
		Car car3 = new Car("3");
		
		parkingBoy.park(car);
		ParkingCard card2 = parkingBoy.park(car2);
		parkingBoy.park(car3);
		
		Car carPicked = parkingBoy.pick(card2);
		assertEquals(car2, carPicked);
	}
	
	@Test(expected=ParkingCarIsNotFoundException.class)
	public void should_not_pick_a_car_with_the_same_card_twice() {
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		ParkingBoy parkingBoy = new ParkingBoy();
		buildCompany(p1, p2, parkingBoy);
		Car car = new Car("1");
		Car car2 = new Car("2");
		Car car3 = new Car("3");		
		parkingBoy.park(car);
		parkingBoy.park(car2);
		ParkingCard card3 = parkingBoy.park(car3);
		
		Car carPicked = parkingBoy.pick(card3);
	    parkingBoy.pick(card3);
	}
	
	@Test
	public void should_pick_a_car_when_the_car_is_in_the_second_parking_lot() {
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		ParkingBoy parkingBoy = new ParkingBoy();
		buildCompany(p1, p2, parkingBoy);
		Car car = new Car("1");
		Car car2 = new Car("2");
		Car car3 = new Car("3");
		
		parkingBoy.park(car);
		parkingBoy.park(car2);
		ParkingCard card3 = parkingBoy.park(car3);
		
		Car carPicked = parkingBoy.pick(card3);
		assertEquals(car3, carPicked);
	}
	//should throw car is not found exception when the parking card is not matched to any car
	@Test(expected = ParkingCarIsNotFoundException.class)
	public void should_throw_car_is_not_found_exception_when_the_parking_card_is_not_matched_to_any_car(){
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		ParkingBoy parkingBoy = new ParkingBoy();
		buildCompany(p1, p2, parkingBoy);
		Car car = new Car("1");
		parkingBoy.park(car);
		ParkingCard card = new ParkingCard();

		parkingBoy.pick(card);
	}
	@Test
	public void should_park_car_to_the_most_empty_lot(){
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 4);
		SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
		buildCompany(p1, p2, smartParkingBoy);
		Car car = new Car("1");
		smartParkingBoy.park(car);

		assertEquals(1,p2.getParkingCarsNum());
	}



}
