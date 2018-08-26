package codingdojo.parkingboy;

import codingdojo.parkingboy.exceotion.ParkingLotFullException;

import java.util.List;

public class NormalParkingBoy extends ParkingBoy{
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

	public ParkingCard park(Car car) {
		return getFirstParkingLotIsNotFull().park(car);
	}

	private ParkingLot getFirstParkingLotIsNotFull() {
		for (ParkingLot parkingLot : parkingLots) {
			if(!parkingLot.isParkingLotFull()) {
				return parkingLot;
			}
		}
		throw new ParkingLotFullException();
	}

}
