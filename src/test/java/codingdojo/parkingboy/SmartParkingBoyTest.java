package codingdojo.parkingboy;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SmartParkingBoyTest {

    //should park car to lot when lots have space
    @Test
    public void should_park_car_to_lot_when_lots_have_space(){
        ParkingLot p1 = new ParkingLot("1", 2);
        ParkingLot p2 = new ParkingLot("2", 2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        buildCompany(smartParkingBoy, Arrays.asList(p1,p2));
        Car car1 = new Car("1");

        ParkingCard parkingCard = smartParkingBoy.park(car1);

        assertEquals(car1,smartParkingBoy.pick(parkingCard));
    }

    //should park car to first lot when it is the most empty lot even others have space
    @Test
    public void should_park_car_to_first_lot_when_it_is_the_most_empty_lot_even_others_have_space(){
        ParkingLot p1 = new ParkingLot("1", 4);
        ParkingLot p2 = new ParkingLot("2",1 );
        ParkingLot p3 = new ParkingLot("3",2 );
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        buildCompany(smartParkingBoy,Arrays.asList(p1,p2,p3));
        Car car1 = new Car("1");
        Car car2 = new Car("2");
        Car car3 = new Car("3");
        Car car4 = new Car("4");

        smartParkingBoy.park(car1);
        smartParkingBoy.park(car2);
        smartParkingBoy.park(car3);
        smartParkingBoy.park(car4);

        assertEquals(3,p1.getParkingCarsNum());
        assertEquals(1,p3.getParkingCarsNum());
    }

    //should park car to second lot when it is the most empty lot even others have space
    @Test
    public void should_park_car_to_second_lot_when_it_is_the_most_empty_lot_even_others_have_space(){
        ParkingLot p1 = new ParkingLot("1", 2);
        ParkingLot p2 = new ParkingLot("2",4 );
        ParkingLot p3 = new ParkingLot("3",2 );
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        buildCompany(smartParkingBoy,Arrays.asList(p1,p2,p3));
        Car car1 = new Car("1");
        Car car2 = new Car("2");
        Car car3 = new Car("3");

        smartParkingBoy.park(car1);
        smartParkingBoy.park(car2);
        smartParkingBoy.park(car3);

        assertEquals(2,p2.getParkingCarsNum());
        assertEquals(1,p1.getParkingCarsNum());
    }

    //should park car to third lot when it is the most empty lot even others have space
    @Test
    public void should_park_car_to_third_lot_when_it_is_the_most_empty_lot_even_others_have_space(){
        ParkingLot p1 = new ParkingLot("1", 1);
        ParkingLot p2 = new ParkingLot("2", 1);
        ParkingLot p3 = new ParkingLot("3",3);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        buildCompany(smartParkingBoy, Arrays.asList(p1,p2,p3));
        Car car1 = new Car("1");
        Car car2 = new Car("2");
        Car car3 = new Car("3");

        smartParkingBoy.park(car1);
        smartParkingBoy.park(car2);
        smartParkingBoy.park(car3);

        assertEquals(2,p3.getParkingCarsNum());
        assertEquals(1,p1.getParkingCarsNum());
    }

    //should park car to first lot when lots have the same space
    @Test
    public void should_park_car_to_the_first_lot_when_lots_have_the_same_space(){
        ParkingLot p1 = new ParkingLot("1", 2);
        ParkingLot p2 = new ParkingLot("2",2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        buildCompany(smartParkingBoy, Arrays.asList(p1,p2));
        Car car1 = new Car("1");

        smartParkingBoy.park(car1);

        assertEquals(1,p1.getParkingCarsNum());
    }

    //should throw parkingLot full exception when lots have no any more space
    @Test(expected = ParkingLotFullException.class)
    public void should_throw_parkingLot_full_exception_when_lots_have_no_any_more_space(){
        ParkingLot p1 = new ParkingLot("1", 2);
        ParkingLot p2 = new ParkingLot("2",2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        buildCompany(smartParkingBoy,Arrays.asList(p1,p2));
        Car car1 = new Car("1");
        Car car2 = new Car("2");
        Car car3 = new Car("3");
        Car car4 = new Car("4");
        Car car5 = new Car("5");

        smartParkingBoy.park(car1);
        smartParkingBoy.park(car2);
        smartParkingBoy.park(car3);
        smartParkingBoy.park(car4);
        smartParkingBoy.park(car5);
    }

    private void buildCompany(SmartParkingBoy smartParkingBoy, List<ParkingLot> lots) {
        Company company = new Company();
        for(ParkingLot parkingLot : lots){
            company.add(parkingLot);
        }
        company.employ(smartParkingBoy);
    }
}