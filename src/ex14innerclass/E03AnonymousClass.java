package ex14innerclass;
/*
 익명클래스(AnonymousClass)
 -이름이 없는 클래스를 말한다.
 -내부클래스처럼 GUI프로그램에서 많이 사용된다.
 -부모클래스의 메소드를 오버라이딩하는것이 목적이다.
 -클래스를 정의하는 것이 마치 메소드로 정의하는것과 비슷하다.
 -마지막에 세미콜론을 반드시 써줘야함
 
 형식]
 	부모클래스명 참조변수 = new 부모클래스명() {
 		익명클래스의 실행부;
 		부모클래스의 메소드 오버라이딩;
 	};
 	※부모클래스를 상속받아 이름없는 자식클래스를 생성하는 
 	개념으로 이해하면 된다.
 	상속되기 때문에 오버라이딩이 가능해짐.
 */
class Person {
	String name;
	public Person(String n) {
		name = n;
	}
	void printInfo() {
		System.out.println(String.format("이름:%s", name));
	}
}
class Student extends Person {
	String stNumber;
	public Student(String n,String stNum) {
		super(n);
		stNumber = stNum;
	}
	String getInfo() {
		return String.format("학번:%s", stNumber);
	}
	//부모클래스의 메소드를 오버라이딩 정의 
	@Override
	void printInfo() {
		super.printInfo();
		System.out.println(getInfo());
	}
}
abstract class AbstractClass {
	abstract void abstractMrthod();
}

interface Interface{
	void abstractMethod();
}

public class E03AnonymousClass {
	
	public static void main(String[] args) {

		/*
		 Student라는 이름을 가진 자식클래스를 통해 객체를 생성하고
		 부모클래스의 참조변수로 참조함.
		 참조변수가 부모타입이므로 자식객체에 직접접근하는것이 불가능함
		 반드시 다운캐스팅 후 접근해야함.
		 */
		Person person = new Student("문사람", "2016");
		person.printInfo();
		//person.stNumber = "2015";//에러발생
		((Student)person).stNumber = "2015";//다운캐스팅
		System.out.println(((Student)person).getInfo());
		
		/*
		 Person클래스를 상속받은 익명클래스 정의 및 생성
		 :Person타입의 인스턴스 변수에 Person을 상속받은 익명클래스를
		 생성해서 그 주소를 할당한다.
		 개념적으로 new Person(){}; ==> 익명 extends Person{};
		 형태라 생각하면 된다.
		 -이름이 없는 객체이므로 부모클래스의 이름을 빌려서 생성했다고 생각하자
		 */
		Person anonyPerson = new Person("이말년") {
			//익명클래스(자식객체)에서 새롭게 확장한 멤버 
			/*
			 	익명클래스 내에서만 접근가능함.
			 */
			int newVar;
			void newMethod() {
				System.out.println("익명클래스에서 새롭게 확장한 메소드");
			}
			/*
			 오버라이딩하여 재정의한 메소드
			 */
			void printInfo() {
				System.out.println("newVar="+newVar);
				newMethod();
				System.out.println("익명클래스에서 오버라이딩");
			}
		};
		anonyPerson.printInfo();//호출가능
		//anonyPerson.newMethod();//에러발생
		/*
		 부모타입의 참조변수로 하위객체에서 확장한 멤버에 접근할 수 없으므로 
		 위부분은 에러가 발생한다.
		 */
		
		//Student클래스를 상속받아 정의한 익명클래스(즉,Student의 하위익명객체)
		Student anonyStudent = new Student("김사랑", "2017") {
			//익명클래스에서 확장한 멤버변수
			int age=1;
			
			@Override
			String getInfo() {
				return super.getInfo()+ " , 나이:" + age;
			}
			@Override
			void printInfo() {
				System.out.println("이름:"+name+","+getInfo());
			}
		};
		
		System.out.println("[Student클래스를 상속받은 익명클래스]");
		anonyStudent.printInfo();
		/*
		 하위 익명클래스에서 확장한 변수이므로 익명객체를 통해서는
		 접근불가.
		 */
		//anonyStudent.age=100;//에러발생-접근불가
		//((Student)annonyTest).jumin = "181105";//에러발생-다운캐스팅불가
		
		/*
		 다운캐스팅은 "(자식클래스명)부모타입의 참조변수" 형태로
		 형변환하여 하위클래스의 멤버에 접근하기 위한 수단인다.
		 그러나 익명클래스는 클래스명이 없기 때문에 위와같이 다운캐스팅이 불가능하다.
		 즉,익명클래스에서는 새롭게 정의한 멤버변수를 접근할 수 없다.
		 따라서 익명클래스는 오버라이딩의 목적으로만 사용해야한다.
		 */
		
//		Person anonyTest = new Student("다운캐스팅","안되욤") {
//			String jumin= "001024";
//		};
//		
//		((Student)anonyTest).jumin = "181105";
		
		
		//추상클래스를 상속받은 익명클래스
		AbstractClass ac = new AbstractClass() {
			String abStr = "확장변수";
			@Override
			void abstractMrthod() {

				System.out.println("추상메소드 오버라이딩");
				System.out.println("abStr="+abStr);
			}
		};
		
		ac.abstractMrthod();
		
		//인터페이스를 구현한 익명클래스
		Interface in = new Interface() {
			int interVar = 100;
			@Override
			public void abstractMethod() {

				System.out.println("인터페이스의 추상메소드 오버라이딩");
				System.out.println("interVar="+interVar);
			}
		};
		in.abstractMethod();
	}
}
