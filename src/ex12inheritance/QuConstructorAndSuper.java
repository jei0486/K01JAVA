package ex12inheritance;
/*
 문제1) 파일명 :  QuConstructorAndSuper.java
상속관계에 놓여있는 클래스의 생성자 정의 및 호출방식을 기본으로 다음 클래스의 적절한 생성자를 삽입해보자. 그리고 이의 확인을 위한 main 메소드도 적절히 정의해보자.
 */
class Car{
       	int gasoline;
       	
       	//생성자
       	public Car(int gas) {
       		gasoline = gas;
       		System.out.println("Car 생성자 호출");
       	}
}
class HybridCar extends Car{
       	int electric;
       	
       	//생성자
       	public HybridCar(int gas, int ele) {
       		super(gas);
       		electric = ele;
       		System.out.println("HybridCar 생성자 호출");
       	}
}
class HybridWaterCar extends HybridCar{
       	int water;
 
       		//생성자
       	public HybridWaterCar(int gas, int ele, int wat) {
       		//부모클래스로  gas, ele를 전달하여 생성자 호출
       		super(gas,ele);
       		water = wat;
       		System.out.println("HybridWaterCar 생성자 호출");
       	}
       	public void showNowGauge(){
                 	System.out.println("남은가솔린:"+gasoline);
                 	System.out.println("남은전기량:"+electric);
                 	System.out.println("남은워터량:"+water);
       	}
}

public class QuConstructorAndSuper {
	public static void main(String[] args){
		HybridWaterCar hcar = new HybridWaterCar (10,20,30);
		hcar.showNowGauge();
	}
}
