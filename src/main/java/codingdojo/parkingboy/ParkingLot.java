package codingdojo.parkingboy;

import java.math.BigDecimal;
import java.util.HashMap;

public class ParkingLot implements Comparable<ParkingLot>{
	private static final int MIN_PARKING_SPACE = 0;
	private static final int MAX_PARKING_SPACE = 10000;
	private Integer parkingSpace;
	private ParkingBoy parkingBoy;
	String parkingName;
	private HashMap<ParkingCard, Car> parkedCars = new HashMap<ParkingCard,Car>();

	public ParkingBoy getParkingBoy() {
		return parkingBoy;
	}

	public void setParkingBoy(ParkingBoy parkingBoy) {
		this.parkingBoy = parkingBoy;
	}

	public ParkingLot(String name, Integer parkingSpace) {
		checkParameter(name, parkingSpace);
		this.parkingSpace = parkingSpace;
		this.parkingName = name;
	}

	public Integer getParkingSpace() {
		return parkingSpace;
	}

	public Integer getParkingCarsNum() {
		return parkedCars.size();
	}

	private void checkParameter(String name, Integer parkingSpace) {
		if(parkingSpaceIsValid(parkingSpace)) {
			throw new ParkingLotSizeInvalid();
		}
		checkParkingLotName(name);
	}

	private void checkParkingLotName(String name) {
		if(null==name) {
			throw new ParkingLotNameIsNull();
		}
		if(name.length() > 10) {
			throw new ParkingLotNameIsTooLong();
		}
	}

	private boolean parkingSpaceIsValid(Integer parkingSpace) {		
		return null==parkingSpace||parkingSpace <= MIN_PARKING_SPACE || parkingSpace >= MAX_PARKING_SPACE;
	}
	
	public ParkingCard park(Car car) {
		if(parkedCars.containsValue(car)){
			throw new CarDuplicationException();
		}else{
			ParkingCard card = new ParkingCard();
			parkedCars.put(card, car);
			return card;
		}
	}

	public Car pick(ParkingCard card) {
		return parkedCars.remove(card);
	}
	public boolean isParkingLotFull() {
		return parkedCars.size()==parkingSpace;
	}

	public int compareTo(ParkingLot o) {
		return (o.parkingSpace-o.getParkingCarsNum())-(this.parkingSpace-this.getParkingCarsNum());
	}

	public int getParkingLotRemainSpace() {
		return this.parkingSpace - this.getParkingCarsNum();
	}

	public double getParkingLotSpaceVacancyRate(){
			return new BigDecimal((float) this.getParkingLotRemainSpace() / this.parkingSpace).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
