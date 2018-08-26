package codingdojo.parkingboy;

import codingdojo.parkingboy.exceotion.DuplicationAssignmentException;
import codingdojo.parkingboy.exceotion.ParkingLotFullException;
import codingdojo.parkingboy.exceotion.PickCarWrongBoyException;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ManagerTest extends NormalParkingBoyTest{
    @Test
    public void car_should_park_first_lot_when_manager_assign_it_to_normal_boy(){
        //given
        Manager manager = new Manager();
        NormalParkingBoy normalParkingBoy = new NormalParkingBoy();
        ParkingLot p1 = new ParkingLot("A",3);
        ParkingLot p2 = new ParkingLot("B",3);
        Company company = buildCompany(manager, Arrays.asList(p1,p2));
        company.employ(normalParkingBoy);

        //when
        manager.assign(normalParkingBoy,Arrays.asList(p1,p2));
        Car car = new Car("1");
        normalParkingBoy.park(car);

        //then
        Assert.assertEquals(new Integer(1),p1.getParkingCarsNum());
    }

    @Test
    public void car_should_park_first_lot_when_it_is_most_space_in_smartBoy_lots(){
        //given
        Manager manager = new Manager();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        ParkingLot p1 = new ParkingLot("A",3);
        ParkingLot p2 = new ParkingLot("B",3);
        Company company = buildCompany(manager, Arrays.asList(p1,p2));
        company.employ(smartParkingBoy);
        Car car1 = new Car("1");
        Car car2 = new Car("2");

        //when
        manager.assign(smartParkingBoy,Arrays.asList(p1,p2));
        p1.park(car1);
        smartParkingBoy.park(car2);

        //then
        Assert.assertEquals(new Integer(1),p2.getParkingCarsNum());
    }

    @Test
    public void car_should_park_first_lot_when_it_is_high_vacancy_rate_in_superBoy_lots(){
        //given
        Manager manager = new Manager();
        SuperParkingBoy superParkingBoy = new SuperParkingBoy();
        ParkingLot p1 = new ParkingLot("A",5);
        ParkingLot p2 = new ParkingLot("B",3);
        Company company = buildCompany(manager, Arrays.asList(p1,p2));
        company.employ(superParkingBoy);
        Car car1 = new Car("1");
        Car car2 = new Car("2");

        //when
        manager.assign(superParkingBoy,Arrays.asList(p1,p2));
        p1.park(car1);
        superParkingBoy.park(car2);

        //then
        Assert.assertEquals(new Integer(1),p2.getParkingCarsNum());
    }
    @Test
    public void car_should_picked_by_superBoy_when_car_is_parked_by_him(){
        //given
        Manager manager = new Manager();
        SuperParkingBoy superParkingBoy = new SuperParkingBoy();
        ParkingLot p1 = new ParkingLot("A",5);
        ParkingLot p2 = new ParkingLot("B",3);
        Company company = buildCompany(manager, Arrays.asList(p1,p2));
        company.employ(superParkingBoy);
        Car car1 = new Car("1");

        //when
        manager.assign(superParkingBoy,Arrays.asList(p1,p2));
        ParkingCard card = superParkingBoy.park(car1);
        Car pickedCar = superParkingBoy.pick(card);

        //then
        Assert.assertEquals(car1,pickedCar);
    }
    @Test(expected = PickCarWrongBoyException.class)
    public void car_should_picked_by_superBoy_when_car_is_parked_by_other(){
        //given
        Manager manager = new Manager();
        SuperParkingBoy superParkingBoy1 = new SuperParkingBoy();
        SuperParkingBoy superParkingBoy2 = new SuperParkingBoy();
        ParkingLot p1 = new ParkingLot("A",5);
        ParkingLot p2 = new ParkingLot("B",3);
        Company company = buildCompany(manager, Arrays.asList(p1,p2));
        company.employ(superParkingBoy1);
        company.employ(superParkingBoy2);
        Car car1 = new Car("1");

        //when
        manager.assign(superParkingBoy1,Arrays.asList(p1));
        manager.assign(superParkingBoy2,Arrays.asList(p2));
        ParkingCard card = superParkingBoy1.park(car1);
        superParkingBoy2.pick(card);

    }

    @Test
    public void manager_should_pick_the_car_when_the_car_is_in_first_parking_lot(){
        //given
        Manager manager = new Manager();
        SuperParkingBoy superParkingBoy = new SuperParkingBoy();
        ParkingLot p1 = new ParkingLot("A",5);
        ParkingLot p2 = new ParkingLot("B",3);
        Company company = buildCompany(manager, Arrays.asList(p1,p2));
        company.employ(superParkingBoy);
        Car car1 = new Car("1");

        //when
        manager.assign(superParkingBoy,Arrays.asList(p1,p2));
        ParkingCard card = superParkingBoy.park(car1);
        Car pickedCar = manager.pick(card);

        //then
        Assert.assertEquals(car1,pickedCar);
    }

    @Test(expected = DuplicationAssignmentException.class)
    public void should_throw_exception_when_manager_assign_same_lot_to_diff_boy(){
        //given
        Manager manager = new Manager();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        SuperParkingBoy superParkingBoy = new SuperParkingBoy();
        ParkingLot p1 = new ParkingLot("A",5);
        ParkingLot p2 = new ParkingLot("B",3);
        Company company = buildCompany(manager, Arrays.asList(p1,p2));
        company.employ(smartParkingBoy);
        company.employ(superParkingBoy);

        //when
        manager.assign(superParkingBoy,Arrays.asList(p1,p2));
        manager.assign(smartParkingBoy,Arrays.asList(p1));
    }


    @Test
    public void manager_should_park_car_to_lot_when_it_has_space(){
        //given
        Manager manager = new Manager();
        ParkingLot p1 = new ParkingLot("A",2);
        ParkingLot p2 = new ParkingLot("B",3);
        Company company = buildCompany(manager, Arrays.asList(p1,p2));
        Car car1 = new Car("1");
        Car car2 = new Car("2");

        //when
        manager.park(car1);
        manager.park(car2);

        //then
        Assert.assertEquals(new Integer(2),p1.getParkingCarsNum());
    }

    @Test(expected = ParkingLotFullException.class)
    public void  should_throw_full_exception_when_trying_to_parking_but_no_space_any_more(){
        ParkingLot p1 = new ParkingLot("1", 2);
        ParkingLot p2 = new ParkingLot("2", 2);
        Manager manager = new Manager();
        buildCompany(manager, Arrays.asList(p1,p2));
        Car car1 = new Car("1");
        Car car2 = new Car("2");
        Car car3 = new Car("3");
        Car car4 = new Car("4");
        Car car5 = new Car("5");

        manager.park(car1);
        manager.park(car2);
        manager.park(car3);
        manager.park(car4);
        manager.park(car5);

    }


    private Company buildCompany(Manager manager, List<ParkingLot> lots) {
        return super.buildCompany(manager,lots);
    }

}
