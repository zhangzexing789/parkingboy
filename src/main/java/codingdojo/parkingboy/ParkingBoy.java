package codingdojo.parkingboy;

public class ParkingBoy {
	
	private Car car;
	private Company company;

	public void goToWork(Company company){
		this.company = company;
	}
	public ParkingCard park(Car car) {
		this.car = car;
		ParkingCard parkingCard = new ParkingCard(car.getCarNo(),confirmParkingSpace().getParkingName());
		return parkingCard;
	}

	public Car pick(ParkingCard card) {
		if(!(card.getCarNo().equals(car.getCarNo())&card.getParkingName().equals(confirmParkingSpace().getParkingName()))){
			throw new CarIsNotFoundException();
		}
		return car;
	}

	public ParkingLot confirmParkingSpace() {
		for(ParkingLot parkingLot : company.getParkingLots()){
			if (parkingLot.parkingSpace != 0){
				return  parkingLot;
			}
		}
		throw new ParkingLotIsFullException();
	}
}
