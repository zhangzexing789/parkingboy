package codingdojo.parkingboy;

import static org.junit.Assert.*;

import codingdojo.parkingboy.exceotion.CarDuplicationException;
import codingdojo.parkingboy.exceotion.ParkingCarIsNotFoundException;
import codingdojo.parkingboy.exceotion.ParkingLotFullException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class NormalParkingBoyTest {

	@Test
	public void should_park_when_parking_lot_is_empty() {
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		NormalParkingBoy normalParkingBoy = new NormalParkingBoy();
		buildCompany(normalParkingBoy, Arrays.asList(p1,p2));
		
		normalParkingBoy.park(new Car("1"));
	}
	
	@Test
	public void should_pick_a_park_when_the_car_is_in_first_parking_lot() {
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		NormalParkingBoy normalParkingBoy = new NormalParkingBoy();
		buildCompany(normalParkingBoy, Arrays.asList(p1,p2));
		Car car = new Car("1");
		ParkingCard card1 = normalParkingBoy.park(car);
		
		Car carPicked = normalParkingBoy.pick(card1);
		
		assertEquals(carPicked, car);
	}
	
	
	@Test
	public void should_park_car_to_first_lot_when_first_lot_not_full() {
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		NormalParkingBoy normalParkingBoy = new NormalParkingBoy();
		buildCompany(normalParkingBoy, Arrays.asList(p1,p2));
		Car car = new Car("1");
		
		ParkingCard card1 = normalParkingBoy.park(car);
		
		assertEquals(new Integer(1),p1.getParkingCarsNum());
	}
	
	@Test
	public void should_park_to_the_second_parking_lot_when_the_first_is_full() {
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		NormalParkingBoy normalParkingBoy = new NormalParkingBoy();
		buildCompany(normalParkingBoy, Arrays.asList(p1,p2));
		Car car = new Car("1");
		Car car2 = new Car("2");
		Car car3 = new Car("3");
		
		normalParkingBoy.park(car);
		normalParkingBoy.park(car2);
		normalParkingBoy.park(car3);
		
		assertEquals(new Integer(1),p2.getParkingCarsNum());
	}
	
	@Test(expected = CarDuplicationException.class)
	public void should_throw_car_duplicate_exception_when_try_to_park_the_same_car_twice(){
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		NormalParkingBoy normalParkingBoy = new NormalParkingBoy();
		buildCompany(normalParkingBoy, Arrays.asList(p1,p2));
		Car car1 = new Car("1");
		Car car2 = new Car("1");

		normalParkingBoy.park(car1);
		normalParkingBoy.park(car2);

	}

	
	@Test
	public void should_park_to_the_first_parking_lot_when_the_first_has_space_even_the_second_has_car(){
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		NormalParkingBoy normalParkingBoy = new NormalParkingBoy();
		buildCompany(normalParkingBoy, Arrays.asList(p1,p2));
		Car car = new Car("1");
		Car car2 = new Car("2");
		Car car3 = new Car("3");
		normalParkingBoy.park(car);
		ParkingCard card2 = normalParkingBoy.park(car2);
		normalParkingBoy.park(car3);
		normalParkingBoy.pick(card2);
		assertFalse(p1.isParkingLotFull());
		
		normalParkingBoy.park(car2);
		
		assertTrue(p1.isParkingLotFull());
	}
	@Test(expected = ParkingLotFullException.class)
	public void  should_throw_full_exception_when_trying_to_parking_but_no_space_any_more(){
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		NormalParkingBoy normalParkingBoy = new NormalParkingBoy();
		buildCompany(normalParkingBoy, Arrays.asList(p1,p2));
		Car car1 = new Car("1");
		Car car2 = new Car("2");
		Car car3 = new Car("3");
		Car car4 = new Car("4");
		Car car5 = new Car("5");

		normalParkingBoy.park(car1);
		normalParkingBoy.park(car2);
		normalParkingBoy.park(car3);
		normalParkingBoy.park(car4);
		normalParkingBoy.park(car5);

	}
	
	@Test
	public void should_pick_a_car_in_the_first_parking_lot_even_the_second_has_car(){
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		NormalParkingBoy normalParkingBoy = new NormalParkingBoy();
		buildCompany(normalParkingBoy, Arrays.asList(p1,p2));
		Car car = new Car("1");
		Car car2 = new Car("2");
		Car car3 = new Car("3");
		
		normalParkingBoy.park(car);
		ParkingCard card2 = normalParkingBoy.park(car2);
		normalParkingBoy.park(car3);
		
		Car carPicked = normalParkingBoy.pick(card2);
		assertEquals(car2, carPicked);
	}
	
	@Test(expected=ParkingCarIsNotFoundException.class)
	public void should_not_pick_a_car_with_the_same_card_twice() {
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		NormalParkingBoy normalParkingBoy = new NormalParkingBoy();
		buildCompany(normalParkingBoy, Arrays.asList(p1,p2));
		Car car = new Car("1");
		Car car2 = new Car("2");
		Car car3 = new Car("3");		
		normalParkingBoy.park(car);
		normalParkingBoy.park(car2);
		ParkingCard card3 = normalParkingBoy.park(car3);
		
		Car carPicked = normalParkingBoy.pick(card3);
	    normalParkingBoy.pick(card3);
	}
	
	@Test
	public void should_pick_a_car_when_the_car_is_in_the_second_parking_lot() {
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		NormalParkingBoy normalParkingBoy = new NormalParkingBoy();
		buildCompany(normalParkingBoy, Arrays.asList(p1,p2));
		Car car = new Car("1");
		Car car2 = new Car("2");
		Car car3 = new Car("3");
		
		normalParkingBoy.park(car);
		normalParkingBoy.park(car2);
		ParkingCard card3 = normalParkingBoy.park(car3);
		
		Car carPicked = normalParkingBoy.pick(card3);
		assertEquals(car3, carPicked);
	}
	@Test(expected = ParkingCarIsNotFoundException.class)
	public void should_throw_car_is_not_found_exception_when_the_parking_card_is_not_matched_to_any_car(){
		ParkingLot p1 = new ParkingLot("1", 2);
		ParkingLot p2 = new ParkingLot("2", 2);
		NormalParkingBoy normalParkingBoy = new NormalParkingBoy();
		buildCompany(normalParkingBoy, Arrays.asList(p1,p2));
		Car car = new Car("1");
		ParkingCard parkingCard = normalParkingBoy.park(car);
		ParkingCard card = new ParkingCard(parkingCard.getParkingLot());

		normalParkingBoy.pick(card);
	}

	public Company buildCompany(ParkingBoy boy, List<ParkingLot> lots) {
		Company company = new Company();
		for(ParkingLot parkingLot : lots){
			company.add(parkingLot);
		}
		company.employ(boy);
		company.registerBoyToLot(boy,lots);
		return company;
	}
}
