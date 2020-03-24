package ex13interface;

/*
 인터페이스(Interface)
-클래스가 객체의 설계도라면 인터페이스는 클래스의 설계도라 할수 있다.
-자바는 단일 상속을 원칙으로 하나 인터페이스를 통해 다중상속을
	구현할 수 있다.
-추상클래스와 동일하게 상속을 목적으로 제작되므로 구현받은 
	하위클래스에서 반드시 오버라이딩(하나로 통합관리) 해야한다.
-멤버로는 추상메소드와 상수로만 구성된다.
	메소드-> public abstract
	변수-> public static final
-인터페이스는 생성자가 없다
(객체 생성을 목적으로 만들어진것이 아니기때문(오직 상속을 목적으로)=> abstract도 같음!)
 */
interface MyInterface1 {
	
	//생성자는 사용불가
	//public MyInterface1() {} //에러발생
	
	//public static final 생략가능
	//멤버상수
	public static final int MAX_INT = Integer.MAX_VALUE;//2100000000;
	double MAX_DBL = Double.MAX_VALUE;//1.99999999;
	
	//멤버 추상메소드
	public abstract void absFunc1();
	void absFunc2();
}
/*
 인터페이스에 동일한 이름의 추상메소드가 존재하는 경우 
 하나만 오버라이딩 된다.
 */
interface MyInterface2 {
	void absFunc2();
}
class simpleClass {
	int simple = 1;
	
	void mySimple() {
		System.out.println("simple="+simple);
	}
}
//다중상속은  불가능하지만 ,,다중인터페이스는 가능
/*
 컴마를 이용하여 여러개의 인터페이스를 '구현'하는 것이 가능하다.
 그리고 '상속'과 '구현'을 동시에 할 수도 있다.
 */
class MyClass extends simpleClass implements MyInterface1,MyInterface2 {
	
	@Override
	public void absFunc1() {
		System.out.println("absFunc1() 호출됨");		
	}
	@Override
	public void absFunc2() {
		System.out.println("absFunc2() 호출됨");
	}
}

public class E03InterfaceBasic {
	public static void main(String[]args) {
		
		MyInterface1 my1 = new MyClass();
		my1.absFunc1();
		my1.absFunc2();
	}
}
