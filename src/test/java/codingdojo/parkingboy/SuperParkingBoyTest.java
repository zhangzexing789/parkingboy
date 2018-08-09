package codingdojo.parkingboy;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SuperParkingBoyTest {

    //should park car to lot when lots have space
    @Test
    public void should_park_car_to_lot_when_lots_have_space(){
        ParkingLot p1 = new ParkingLot("1", 2);
        ParkingLot p2 = new ParkingLot("2", 2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy();
        buildCompany(superParkingBoy, Arrays.asList(p1,p2));
        Car car1 = new Car("1");

        ParkingCard parkingCard = superParkingBoy.park(car1);

        assertEquals(car1,superParkingBoy.pick(parkingCard));
    }

    //should park car to first lot when it has high vacancy rate even others have space
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

    //should park car to second lot when it has high vacancy rate even others have space
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

    //should park car to third lot when it has high vacancy rate even others have space
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

    //should park car to first lot when lots have the same vacancy rate
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

    //should throw parkingLot full exception when lots have no any more space
    @Test(expected = ParkingLotFullException.class)
    public void should_throw_parkingLot_full_exception_when_lots_have_no_any_more_space(){
        ParkingLot p1 = new ParkingLot("1", 1);
        ParkingLot p2 = new ParkingLot("2",1);
        ParkingLot p3 = new ParkingLot("3",1);
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
    }

    private void buildCompany(SuperParkingBoy superParkingBoy, List<ParkingLot> lots) {
        Company company = new Company();
        for(ParkingLot parkingLot : lots){
            company.add(parkingLot);
        }
        company.employ(superParkingBoy);
    }
}

