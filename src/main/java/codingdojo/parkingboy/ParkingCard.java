package codingdojo.parkingboy;

public class ParkingCard {
    String carNo;
    String parkingName;

    public ParkingCard(String carNo,String parkingName){
        this.carNo = carNo;
        this.parkingName = parkingName;
    }

    public String getCarNo() {
        return carNo;
    }

    public String getParkingName() {
        return parkingName;
    }
}
