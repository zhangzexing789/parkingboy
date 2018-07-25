package codingdojo.parkingboy;

import java.util.LinkedList;
import java.util.List;

public class Company {

	public List<ParkingLot> getParkingLots() {
		return parkingLots;
	}

	private List<ParkingLot> parkingLots = new LinkedList<ParkingLot>();
	
	public Integer getParkingLotSize() {
		return parkingLots.size();
	}
	
	public void add(ParkingLot parkingLot) {
		for (ParkingLot parkLot : parkingLots) {
			if (parkLot.parkingName.equals(parkingLot.parkingName)) {
				throw new ParkingLotNameDuplication();
			}
		}
		parkingLots.add(parkingLot);
	}

	public void employ(ParkingBoy parkingBoy) {

	}

}
