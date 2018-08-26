package codingdojo.parkingboy;

import codingdojo.parkingboy.exceotion.ParkingLotNameDuplication;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Company {

	private List<ParkingBoy> employedParkingBoys;
	private List<ParkingLot> parkingLots = new LinkedList<ParkingLot>();

	public List<ParkingLot> getParkingLots() {
		return parkingLots;
	}

	private Map<ParkingBoy,List<ParkingLot>> boyToLotMap = new HashMap<ParkingBoy, List<ParkingLot>>();
	
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

	public void employ(Employee employee) {
		employee.setCompany(this);
		if(employee instanceof ParkingBoy){
			ParkingBoy parkingBoy = (ParkingBoy)employee;
			employedParkingBoys.add(parkingBoy);
		}
	}

	public void registerBoyToLot(ParkingBoy parkingBoy,List<ParkingLot> parkingLots){
//		parkingBoy.setParkingLots(parkingLots);
		boyToLotMap.put(parkingBoy,parkingLots);
		for(ParkingLot parkingLot:parkingLots){
			parkingLot.setParkingBoy(parkingBoy);
		}
	}
}
