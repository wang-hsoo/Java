package test;

public class CarEx {
	
	public static void main(String[] args) {
		
//		Car myCar = new Car();
//		System.out.println("����ȸ��: " + myCar.company);
//		System.out.println("�𵨸�:" + myCar.model);
//		System.out.println("����: " + myCar.color );
//		myCar.maxSpeed = 200;
//		System.out.println("�ְ� �ӵ�:" + myCar.maxSpeed);
//		System.out.println("�ӵ�:" + myCar.speed);
		
		Car yourCar = new Car("���", 200);
		
		System.out.println("���� ����: " +  yourCar.carColor);
		System.out.println("���� ��ⷮ: " + yourCar.carCC );
		
	}

}
