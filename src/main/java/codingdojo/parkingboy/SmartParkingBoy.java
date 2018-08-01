package codingdojo.parkingboy;

import java.util.Collections;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    private List<ParkingLot> parkingLots;

    public void setParkingLots(List<ParkingLot> parkingLots) {
        super.setParkingLots(parkingLots);
        this.parkingLots = parkingLots;
    }

    public ParkingLot getTheMostEmptyParkingLot(){
        Collections.sort(parkingLots);
        for (ParkingLot parkingLot : parkingLots) {
            if(!parkingLot.isParkingLotFull()) {
                return parkingLot;
            }
        }
        throw new ParkingLotFullException();
    }

    @Override
    public ParkingCard park(Car car) {
        return getTheMostEmptyParkingLot().park(car);
    }
}
