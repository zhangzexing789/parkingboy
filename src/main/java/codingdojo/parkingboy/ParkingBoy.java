package codingdojo.parkingboy;

import java.util.List;

public abstract class ParkingBoy implements Employee{
    private List<ParkingLot> parkingLots;

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public abstract ParkingCard park(Car car);

    public Car pick(ParkingCard card) {
        Car car = null;
        for(ParkingLot lot: parkingLots) {
//            if(!(this == lot.getParkingBoy())){
//                throw new PickCarWrongBoyException();
//            }
            car = lot.pick(card);
            if(car != null) {
                return car;
            }
        }
        throw new ParkingCarIsNotFoundException();
    }


}
