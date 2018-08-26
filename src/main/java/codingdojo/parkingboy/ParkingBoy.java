package codingdojo.parkingboy;

import codingdojo.parkingboy.exceotion.ParkingCarIsNotFoundException;
import codingdojo.parkingboy.exceotion.PickCarWrongBoyException;

import java.util.List;

public abstract class ParkingBoy implements Employee{
    private List<ParkingLot> parkingLots;

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public abstract ParkingCard park(Car car);

    public Car pick(ParkingCard card) {
        Car car = null;
        ParkingLot carParkedLot = card.getParkingLot();
        if (!(this instanceof Manager)) {
                if (this != carParkedLot.getParkingBoy()) {
                    throw new PickCarWrongBoyException();
                }
        }
        car = carParkedLot.pick(card);
        if (car != null) {
            return car;
        }else {
            throw new ParkingCarIsNotFoundException();
        }
    }


}
