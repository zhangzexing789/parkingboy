package codingdojo.parkingboy;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SuperParkingBoyTest extends NormalParkingBoyTest {

    @Test
    public void should_park_car_to_first_lot_when_it_has_high_vacancy_rate_even_others_have_space(){
        ParkingLot p1 = new ParkingLot("1", 4);
        ParkingLot p2 = new ParkingLot("2",2);
        ParkingLot p3 = new ParkingLot("3",2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy();
        buildCompany(superParkingBoy,Arrays.asList(p1,p2,p3));
        Car car1 = new Car("1");
        Car car2 = new Car("2");
        Car car3 = new Car("3");
        Car car4 = new Car("4");

        superParkingBoy.park(car1);
        superParkingBoy.park(car2);
        superParkingBoy.park(car3);
        superParkingBoy.park(car4);

        assertEquals(2,p1.getParkingCarsNum());
        assertEquals(1,p2.getParkingCarsNum());
        assertEquals(1,p3.getParkingCarsNum());
    }

    @Test
    public void should_park_car_to_second_lot_when_it_has_high_vacancy_rate_even_others_have_space(){
        ParkingLot p1 = new ParkingLot("1", 3);
        ParkingLot p2 = new ParkingLot("2",4 );
        ParkingLot p3 = new ParkingLot("3",3 );
        SuperParkingBoy superParkingBoy = new SuperParkingBoy();
        buildCompany(superParkingBoy,Arrays.asList(p1,p2,p3));
        Car car1 = new Car("1");
        Car car2 = new Car("2");
        Car car3 = new Car("3");
        Car car4 = new Car("4");

        superParkingBoy.park(car1);
        superParkingBoy.park(car2);
        superParkingBoy.park(car3);
        superParkingBoy.park(car4);

        assertEquals(1,p1.getParkingCarsNum());
        assertEquals(2,p2.getParkingCarsNum());
        assertEquals(1,p3.getParkingCarsNum());
    }

    @Test
    public void should_park_car_to_third_lot_when_it_has_high_vacancy_rate_even_others_have_space(){
        ParkingLot p1 = new ParkingLot("1",1 );
        ParkingLot p2 = new ParkingLot("2", 1);
        ParkingLot p3 = new ParkingLot("3",2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy();
        buildCompany(superParkingBoy, Arrays.asList(p1,p2,p3));
        Car car1 = new Car("1");
        Car car2 = new Car("2");
        Car car3 = new Car("3");
        Car car4 = new Car("4");

        superParkingBoy.park(car1);
        superParkingBoy.park(car2);
        superParkingBoy.park(car3);
        superParkingBoy.park(car4);

        assertEquals(1,p1.getParkingCarsNum());
        assertEquals(1,p2.getParkingCarsNum());
        assertEquals(2,p3.getParkingCarsNum());
    }

    @Test
    public void should_park_car_to_the_first_lot_when_lots_have_same_vacancy_rate(){
        ParkingLot p1 = new ParkingLot("1",2);
        ParkingLot p2 = new ParkingLot("2", 2);
        ParkingLot p3 = new ParkingLot("3",2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy();
        buildCompany(superParkingBoy, Arrays.asList(p1,p2,p3));
        Car car1 = new Car("1");

        superParkingBoy.park(car1);

        assertEquals(1,p1.getParkingCarsNum());
    }

    @Test
    public void should_park_when_parking_lot_is_empty(){
        super.should_park_when_parking_lot_is_empty();
    }

    @Test(expected = CarDuplicationException.class)
    public void should_throw_car_duplicate_exception_when_try_to_park_the_same_car_twice(){
        super.should_throw_car_duplicate_exception_when_try_to_park_the_same_car_twice();
    }

    @Test(expected = ParkingLotFullException.class)
    public void  should_throw_full_exception_when_trying_to_parking_but_no_space_any_more(){
        super.should_throw_full_exception_when_trying_to_parking_but_no_space_any_more();
    }

    @Test
    public void should_pick_a_car_in_the_first_parking_lot_even_the_second_has_car(){
        super.should_pick_a_car_in_the_first_parking_lot_even_the_second_has_car();
    }

    @Test(expected=ParkingCarIsNotFoundException.class)
    public void should_not_pick_a_car_with_the_same_card_twice() {
        super.should_not_pick_a_car_with_the_same_card_twice();
    }

    @Test(expected = ParkingCarIsNotFoundException.class)
    public void should_throw_car_is_not_found_exception_when_the_parking_card_is_not_matched_to_any_car(){
        super.should_throw_car_is_not_found_exception_when_the_parking_card_is_not_matched_to_any_car();
    }

    private void buildCompany(SuperParkingBoy superParkingBoy, List<ParkingLot> lots) {
        super.buildCompany(superParkingBoy,lots);
    }
}

