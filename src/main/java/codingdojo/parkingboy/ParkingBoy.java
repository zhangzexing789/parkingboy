package codingdojo.parkingboy;

import java.util.List;

public abstract class ParkingBoy {
    private List<ParkingLot> parkingLots;

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public abstract ParkingCard park(Car car);

    public Car pick(ParkingCard card) {
        Car car = null;
        for(ParkingLot lot: parkingLots) {
            car = lot.pick(card);
            if(car != null) {
                return car;
            }
        }
        throw new ParkingCarIsNotFoundException();
    }


}
