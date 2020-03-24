package ex10accessmodifier;
/*
 접근지정자(접근제어지시자)
 	:클래스와 클래스 사이에 멤버간의 접근을 제어하는 키워드를 말한다.
 	
 접근범위비교
 	private< default(생략형) <protected <public
 	
 접근지정자를 붙일 수 있는 곳
 	클래스,멤버변수,멤버메소드 모두 가능하나
 	Class명앞에는 public과 default만 붙일수 있다.
 */
class DefaltClass1 {
	
	void myFunc() {
		System.out.println("DefaultClass클래스의  myFunc()메소드 호춯");
	}
}
public class E01AccessModifier1 {

	//멤버변수를 각각의 접근지정자를 통해 선언
	private int privateVar;
	int defaultVar;
	public int publicVar;
	
	/*
	 동일 클래스 내에서는 private 멤버라 할지라도 접근이 가능함
	 즉 동일 클래스라면 접근지정자의 영향을 받지않음
	 */
	private void privateMethod() {
		privateVar = 100;
		System.out.println("privateMethod() 메소드 호출");
	}
	void defaultMethod() {
		privateVar = 200;
		System.out.println("defaultMethod() 메소드 호출");
	}
	/*
	 private으로 선언된 멤버(변수 혹은 메소드)를 외부클래스에서
	 접근하고 싶을떄는 public으로 선언된 멤버메소드를 이용해서 
	 간접적으로 접근을 허용함
	 */
	public void publicMethod() {
		privateVar = 300;
		System.out.println("publicMethod() 메소드 호출");
		privateMethod();
	}
	
	
}
