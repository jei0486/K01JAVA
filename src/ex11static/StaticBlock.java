package ex11static;
/*
 static블럭
 	:동일 클래스안의 main메소드 보다 먼저 실행되는 블럭으로 main메소드의 실행코드가 
 	없어도 먼저 실행된다.
 	단, 다른 클래스에 main이 있는경우에는 main이 순차적으로 실행되다가
 	 static블럭이 있는 클래스가 객체화 될때 실행되게 된다.
 	이때 생성자 보다 Static블럭이 먼저 실행된다.
 */
public class StaticBlock {
	//인스턴스형 멤버
	int instanceVar;
	void instanceMethod() {}

	//정적멤버
	static int staticVar;
	static void staticMethod() {
		int localVar;
		System.out.println("정적메소드");
	}
	
	//static블럭
	static {
		//static 블럭안에서는 정적멤버인 staticVar에 접근가능
		staticVar = 1000;
		
		/*
		 static 블럭안에서만 사용할 수 있는 지역변수 선언
		 블럭내에서는 제한적으로 사용가능함
		 */
		int localVar;
		localVar = 1000;
		System.out.println("localVar="+localVar);//[허용됨]
		
		/*
		 static블럭내에서는 인스턴스형 멤버를 사용할수 없다.
		 */
		//System.out.println("instanceVar="+instanceVar);//에러발생
		//instanceMethod();//에러발생
		
		/*
		 정적멤버만 접근이 가능하다.
		 */
		System.out.println("staticVar="+staticVar);
		staticMethod();
		
		//main메소드보다 먼저 실행되는지 확인용 출력문
		System.out.println("===static block===");
	}
	
	//생성자 메소드
	/*
	 외부파일의 main메소드에서 실행되는 경우 해당 클래스의 객첵가
	 생성자를 통해 생성되기전에 static블럭이 먼저 실행된다.
	 */
	public StaticBlock() {
		staticVar = -1;
		System.out.println("==StaticBlock의 생성자==");
		}
	
	public static void main(String[] args) {
		
		/*
		 E02StaticBlockMain.java 에서 실행할때는 주석처리후 실행하세요.
		 main메소드가 외부파일에 있을떄 실행을 테스트 하기 위함.
		 */
		//System.out.println("==메인 메소드==");
		
		//static블럭내에서만 선언된 지역변수이므로  main에서 사용불가
		//System.out.println("localVar="+localVar);
	
	}
}
