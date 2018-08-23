package codingdojo.parkingboy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Manager implements Employee{

    private List<ParkingLot> lots;

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.lots = parkingLots;
    }

    public void assign(ParkingBoy parkingBoy, List<ParkingLot> lots) {
        List<ParkingLot> saveLots = new ArrayList<ParkingLot>();
        for (ParkingLot lot : lots){
            if (lot.getParkingBoy() == null){
                saveLots.add(lot);
                lot.setParkingBoy(parkingBoy);
            }else {
                throw new DuplicationAssignmentException();
            }
        }
        parkingBoy.setParkingLots(saveLots);

    }

    public void park(Car car) {
        for (ParkingLot lot : lots){
            if (!lot.isParkingLotFull()){
                lot.park(car);
            }else {
                throw new ParkingLotFullException();
            }
        }
    }

    public Car pick(ParkingCard card) {
        Car car = null;
        for(ParkingLot lot: lots) {
            car = lot.pick(card);
            if(car != null) {
                return car;
            }
        }
        throw new ParkingCarIsNotFoundException();
     }
}
