package codingdojo.parkingboy;

import codingdojo.parkingboy.exceotion.DuplicationAssignmentException;
import codingdojo.parkingboy.exceotion.ParkingCarIsNotFoundException;
import codingdojo.parkingboy.exceotion.ParkingLotFullException;

import java.util.ArrayList;
import java.util.List;

public class Manager extends ParkingBoy implements Employee{

    private Company company;

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
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

    public ParkingCard park(Car car) {
        ParkingCard card = null;
        for (ParkingLot lot : company.getParkingLots()){
            if (!lot.isParkingLotFull()){
                card = lot.park(car);
                return card;
            }else {
                throw new ParkingLotFullException();
            }
        }
        return card;
    }

    public Car pick(ParkingCard card) {
        Car car = null;
        for(ParkingLot lot: company.getParkingLots()) {
            car = lot.pick(card);
            if(car != null) {
                return car;
            }
        }
        throw new ParkingCarIsNotFoundException();
     }
}
