// 주차장은 대형, 중형, 소형 3가지 종류의 주차 공간이 있고, 각 크기마다 고정 슬롯이 있음
// addCar 메소드를 통해 주차장에 들어오려는 자동차의 carType에 해당하는 주차공간이 있는지 확인해라

class ParkingSystem {

	private int bigSpace;
	private int mediumSpace;
	private int smallSpace;

	public ParkingSystem(int big, int medium, int small) {
		this.bigSpace = big;
		this.mediumSpace = medium;
		this.smallSpace = small;
	}

	public boolean addCar(int carType) {
		switch (carType) {
			case 1:
				if (bigSpace > 0) {
					bigSpace--;
					return true;
				} else {
					return false;
				}
			case 2:
				if (mediumSpace > 0) {
					mediumSpace--;
					return true;
				} else {
					return false;
				}
			case 3:
				if (smallSpace > 0) {
					smallSpace--;
					return true;
				} else {
					return false;
				}
			default:
				return false;
		}
	}

}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */