package codingdojo.parkingboy;

import codingdojo.parkingboy.exceotion.ParkingLotFullException;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

    private Company company;
    private List<ParkingLot> parkingLots;

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setParkingLots(List<ParkingLot> parkingLots) {
        super.setParkingLots(parkingLots);
        this.parkingLots = parkingLots;
    }

    private ParkingLot findTheMostRemainSpaceLot(){
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

    @Override
    public ParkingCard park(Car car) {
        return this.findTheMostRemainSpaceLot().park(car);
    }

    private ParkingLot compareToParkingLot(ParkingLot p1, ParkingLot p2){
        if(p1.getParkingLotRemainSpace() > p2.getParkingLotRemainSpace()){
            return p1;
        }else if(p1.getParkingLotRemainSpace() < p2.getParkingLotRemainSpace()){
            return p2;
        }else{
            return p1;
        }
    }
}
