package common;

public class Student extends Person {

	public String strNumber;

	public Student(String name, int age, String strNumber) {
		super(name, age);
		this.strNumber = strNumber;
	}
	@Override
	public String getInfo() {
		return super.getInfo()+",학번:"+strNumber;
	}
	@Override
	public void showInfo() {
		System.out.println("학생의 정보");
		System.out.println(getInfo());
	}
}
