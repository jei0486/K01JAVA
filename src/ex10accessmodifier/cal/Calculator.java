package ex10accessmodifier.cal;
/*
 Calculator 클래스는 해당 자바파일에서 외부에 가장 의미있는 클래스로서
 퍼블릭으로 선언되었다
 자바에서는 하나의 클래스만 퍼블릭으로 선언하는것이 가능하다.
 퍼브릵으로 선언된 클래스에서 디폴트 클래스를 사용하는 형태로 제작되어야한다.
 */
public class Calculator {

	//[멤버변수]
	private Adder adder;
	private Subtractor subtractor;
	
	/*
	 생성자메소드 
	 :해당 클래스의 객체가 생성될때 덧셈,뺼셈을 위한 클래스의 객체도
	 동시에 생성된다.
	 */
	public Calculator() {
		adder = new Adder();
		subtractor = new Subtractor();
	}
	/*
	 멤버메소드
	 	: 덧셈혹은 뺄셈 연산후 결과를 반환하는 메소드로,
	 	각 연산을 위해 해당 default클래스의 멤버메소드를
	 	호출한후 결과를 반환 받는다.
	 */
	public int addTwoNumber(int n1, int n2) {
		return adder.addTwoNumber(n1,n2);
	}
	public int subTwoNumber(int n1, int n2) {
		return subtractor.subTwoNumber(n1,n2);
	}
	/*
	 연산의 횟수를 디스플레이 해주는 메소드
	 정보은닉되어있는 멤버변수의 출력을 위해 getter() 메소드를 호출하고 있음
	 */
	public void showOpratingTimes() {
		System.out.println("덧셈횟수:"+adder.getCntAdd());
		System.out.println("뺼셈횟수:"+subtractor.getCntSub());
	}
}
//덧셈연산
class Adder{
	private int cntAdd;
	
	Adder() {
		cntAdd=0;
	}
	public int getCntAdd() {
		return cntAdd;
	}
	int addTwoNumber(int n1, int n2) {
		cntAdd++;
		return n1+n2;
	}
}
//뺄셈연산
class Subtractor{
	private int cntSub;
	
	public Subtractor() {
		cntSub=0;
	}
	public int getCntSub() {
		return cntSub;
	}
	int subTwoNumber(int num1, int num2) {
		cntSub++;
		return num1-num2;
	}
}
