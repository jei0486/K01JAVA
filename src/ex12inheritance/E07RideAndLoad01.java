package ex12inheritance;
/*
 상속관계에서 오버로딩 vs 오버라이딩
 
 오버로딩: 함수명은 같으나 매개변수의 갯수, 타입,순서가
 	다른경우를 말한다. 즉, 서로 다른 함수이므로 상속받은
 	하위클래스에는 오버로딩된 모든 메소드가 포함된다.
 	
 오버라이딩: 함수명,매개변수,반환형까지 모두 동일한 함수를
 	상속관계에 있는 하위클래스에서 재정의 한것을 말함.
 	이 경우 하위클래스에서 정의한 메소드가 상위클래스의 메소드를
 	가리게 되므로 항상 최하위 클래스의 메소드가 호출되게 된다.
 	※오버라이딩은 참조변수의 타입에 영향을 받지않음.
 */
class A {
	public void rideMethod() {
		System.out.println("A의 rideMethod");
	}
	public void loadMethod() {
		System.out.println("A의 loadMethod");
	}
}
class B extends A {
	public void rideMethod() {
		System.out.println("B의 rideMethod");
	}
	public void loadMethod(int num) {
		System.out.println("B의 loadMethod");
	}
	
}
class C extends B {
	public void rideMethod() {
		System.out.println("C의 rideMethod");
	}
	public void loadMethod(double num) {
		System.out.println("C의 loadMethod");
	}
	
}

public class E07RideAndLoad01 {

	public static void main(String[] args) {
		
		A ref1 = new C();
		B ref2 = new C();
		C ref3 = new C();
		
		/*
		 참조변수에 상관없이 항상 최하위에 오버라이딩 된 메소드가 호출됨.
		 즉 아래부분은 모두  c클래스에 생성된 메소드가
		  호출된다.
		 */
		System.out.println("오버라이딩 처리된 메소드");
		ref1.rideMethod();//C에
		ref2.rideMethod();//정의된
		ref3.rideMethod();//메소드 호출
		
		System.out.println("오버로딩 처리된 메소드");
		ref3.loadMethod();//각각의
		ref3.loadMethod(1);//메소드가
		ref3.loadMethod(1.1);//호출된다.
		
		//해당 객체를 B타입으로 간주하고 참조한다.
		ref2.loadMethod();
		ref2.loadMethod(1);//-> B클래스 영역까지 접근가능
		//ref2.loadMethod(1.1);//접근불가
		
		//해당 객체를 A타입으로 간주하고 참조한다.
		ref1.loadMethod();//-> A클래스 영역까지 접근가능
		//ref1.loadMethod(1);//접근불가
		//ref1.loadMethod(1.1);//접근불가
		
		///////////////////////////////////////////////////////////////////
		
		
		A refNum1 =new B();
		A refNum2 =new C();
		B refNum3 =new C();

		C refAdder1 =new C();
		B refAdder2 =refAdder1;
		A refAdder3 =refAdder1;
		
		A refId1 = new C();
		/*
		 refId1  은 A타입의 참조변수 이므로 B타입 혹은 C타입의
		 참조변수로 참조할 수 없다. 
		 자식 타입의 참조변수로 부모객체를 참조하는것은 불가능함
		 */
		//B refId2 = refId1;//에러발생
		//C refId3 = refId1;//에러발생
		
		
		//아래와 같이 다운캐스팅(강제형변환)하면 참조 가능하다.
		C refId3 = (C)refId1;
		////////////////////////////////////////////////////////////////////
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
