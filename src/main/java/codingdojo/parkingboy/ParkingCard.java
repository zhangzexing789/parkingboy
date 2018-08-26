package codingdojo.parkingboy;

public class ParkingCard {
    private ParkingLot parkingLot;

    public ParkingCard(ParkingLot parkingLot) {
        super();
        this.parkingLot = parkingLot;
    }
    public ParkingLot getParkingLot() {
        return parkingLot;
    }
}
