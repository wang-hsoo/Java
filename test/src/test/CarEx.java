package test;

public class CarEx {
	
	public static void main(String[] args) {
		
//		Car myCar = new Car();
//		System.out.println("제작회사: " + myCar.company);
//		System.out.println("모델명:" + myCar.model);
//		System.out.println("색깔: " + myCar.color );
//		myCar.maxSpeed = 200;
//		System.out.println("최고 속도:" + myCar.maxSpeed);
//		System.out.println("속도:" + myCar.speed);
		
		Car yourCar = new Car("흰색", 200);
		
		System.out.println("차량 색상: " +  yourCar.carColor);
		System.out.println("차량 배기량: " + yourCar.carCC );
		
	}

}
