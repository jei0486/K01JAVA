package ex05method;
/*
Method(메소드)
	: 객체지향 프로그램에서 행동 또는 동작을 의미한다.
	즉어떤 하나의 업무 처리하는 모듈(부속품)이라 정의할수있다.
규칙
	-메소드는 반드시 class안에 정의해야한다.
	-메소드안에 다른 메소드를 정의할 수없다.
	-반환타입이 없더라도 반드시 void를 명시해야한다.
	-이름의 규칙은 변수명과 동일하다.(Ex : addCalculate())

JAVA에서의 Naming Rule(이름규칙)
	-클래스명 : SimpleFunc -> 대문자로 시작하는  Camel Case
	-메소드명 혹은 변수명 : simpleFunc(), simpleFunc
		->소문자로 시작하는 변형된 Camel Case
	-상수 : SIMPLE_FUNC -> 전체를 대문자로 표현하고. 연결된 
		단어가 있는 경우_(언더바)를 사용한다.
	-패키지명 : simplefunc -> 전체를 소문자로 표현한다. 연결된
		단어가 있더라도 언더바를 사용하지 않는다. 언더바 대신 .(닷)
		으로 표현한다.
 */

/*
[메소드형식1]매개변수도 없고 반환값도 없는경우
	: 해당 형식은 주로 출력을 담당하는 기능으로 사용된다.
	반환타입은 반드시 void로 기술해야한다.
 */
public class E02MethodType01 {

	static void noParamNpReturn() {
		System.out.println("==메뉴를 선택하세요==");
		System.out.println("1.열기, 2.계속하기, 3.종료");
		System.out.println("================");
	}	
	
	static void noParamNpReturn2()	{
		//경우에 따라 함수의 몸체가 없는 경우도 있음
	}
	static void noParamNpReturn2(int a) {
		//동일한 이름의 함수가 선언되었음. 단 매개변수의 갯수가 다름.
	}
	static void noParamNpReturn3() {
		int returnValue = 89;
		System.out.println("[Return문 이전]");
		
		//return;
		/*
		위와같이 함수 중간에 return을 쓰게되면 함수가 종료되므로
		아래문장은 실행되지 않는 쓰레기 코드가 된다.
		따라서 return을 사용할때는 반드시 조건문과 같이 사용해야한다.
		단 함수의 마지막부분에 있는경우는 상관없다.
		 */
		
		if(returnValue%2==0) {
			System.out.println(returnValue+ "는 짝수");
			return;
		}
		
		System.out.println(returnValue+"는 홀수");
		System.out.println("[Return문 이후]");
	}
	
	public  static void main(String[] args) {
		noParamNpReturn();
		noParamNpReturn2();
		noParamNpReturn3();
		
	}

}////
