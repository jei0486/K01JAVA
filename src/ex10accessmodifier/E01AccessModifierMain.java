package ex10accessmodifier;

import ex10accessmodifier.sub.E01AccessModifier2;
/*
 class 를 정의 할떄는 반드시 public과 default(생략)만 가능함
 아래는 에러발생
 
private class PrivateClass1 {
	
	void myFunc() {
		System.out.println("나는 정의할 수 없는 Class");
	}
}*/

/*
 접근지정자를 생략했르므로 default클래스로 지정된다.
 해당클래스는 동일 패키지 내에서만 접근 가능함
 */
class DefaultClass1 {
	
	void myFunc() {
		System.out.println("DefaultClass 클래스의 myFunc()메소드 호출");
	}
}


public class E01AccessModifierMain {

	public static void main(String[] args) {
		
		System.out.println("E01AccessModifier1 객체생성 및 접근");
		
		/*
		 private으로 선언된 멤버는 동일한 패키지라 할지라도 접근이 불가능하다.
		 해당 멤버는 동일 클래스내에서만 접근을 허용함.
		 
		 ※private으로 선언된 멤버를 외부클래스에서 접근할때는 주로 
		 public으로 선언된 멤버메소드를 통해 간접적으로 접근함.
		 */
		E01AccessModifier1 one = new E01AccessModifier1();

		//System.out.println("one.privateVar"+one.privateVar);[에러발생]
		System.out.println("one.defaultVar"+one.defaultVar);
		System.out.println("one.publicVar"+one.publicVar);
		
		//one.privateMethod();[에러발생]
		one.defaultMethod();
		one.publicMethod();
		
		/*
		 동일한 패키지에 선언된 클래스이므로  import 없이 객체생성및
		 접근이 가능함
		 
		 */
		System.out.println("DefaultClass 객체 생성 및 접근");
		new DefaultClass1().myFunc();//객체생성과 동시에 멤버메소드 호출
		
		///////////////////////////////////////////////////////////////
		System.out.println("E01AccessModifier2 객체생성 및 접근");
		
		/*
		 다른 패키지에 선언된 클래스이므로 객체생성을 위해서는 import가 필요함.
		 패키지가 다른경우 private,default 멤버에 접근을 허용하지않음.
		 */
		E01AccessModifier2 two = new E01AccessModifier2();
		
//		System.out.println("two.privateVar"+two.privateVar);//에러발생
//		System.out.println("two.defaultVar"+two.defaultVar);//에러발생
		System.out.println("two.publicVar"+two.publicVar);
		
//		two.privateMethod();//에러발생
//		two.defaultMethod();//에러발생
		two.publicMethod();
		
		/*
		 다른 패키지에 정의된 디폴트 클래스이므로 객체생성이 불가능한다.
		 import도 불가능하므로 아예 사용불가한 클래스
		 */
		System.out.println("DefaultClass 객체 생성 및 접근");
	//	new DefaultClass2().myFunc();

	}

}
