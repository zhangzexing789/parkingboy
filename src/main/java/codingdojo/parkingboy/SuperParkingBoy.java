package codingdojo.parkingboy;

import java.util.List;

public class SuperParkingBoy extends ParkingBoy{

    private List<ParkingLot> parkingLots;

    public void setParkingLots(List<ParkingLot> parkingLots) {
        super.setParkingLots(parkingLots);
        this.parkingLots = parkingLots;
    }

    public ParkingCard park(Car car) {

        return this.findHightVacancyRateParkingLot().park(car);
    }

    private ParkingLot findHightVacancyRateParkingLot(){
        ParkingLot compareLot = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            if(!parkingLot.isParkingLotFull() && parkingLot != compareLot) {
                compareLot = this.compareToParkingLot(compareLot,parkingLot);
                if(parkingLot == parkingLots.get(parkingLots.size()-1)){
                    return compareLot;
                }
            }
        }
        throw new ParkingLotFullException();
    }

    private ParkingLot compareToParkingLot(ParkingLot p1, ParkingLot p2){
        if(p1.getParkingLotSpaceVacancyRate() > p2.getParkingLotSpaceVacancyRate()){
            return p1;
        }else if(p1.getParkingLotSpaceVacancyRate() < p2.getParkingLotSpaceVacancyRate()){
            return p2;
        }else{
            return p1;
        }
    }
}
