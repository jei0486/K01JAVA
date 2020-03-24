package ex19thread;

/*
 Thread(쓰레드)
 -쓰레드 생성은 Thread클래스를 상속받는것부터 시작된다.
 -해당방법은 쓰레드로 생성할 클래스가 다른 클래스를 상속받지않아도 
 될때 사용하는 방식이다.
 -만약 다른 클래스를 상속받아야 한다면 JAVA는 다중상속이 불가능하므로
 Runnable 인터페이스를 구현하는 방법을 사용해야한다.
 */
class ShowThread extends Thread{
	String threadName;
	public ShowThread(String name) {
		threadName = name;
	}
	
	/*
	 run()메소드는 쓰레드의 main()메소드에 해당한다.
	 Thread클래스의 run()메소드를 오버라이딩 한것으로, 해당
	 메소드는 직접 호출하면 안되고, start()메소드를 통해 간접적으로 호출해야한다.
	 만약 직접 호출하면 단순한 실행만 될뿐 쓰레드가 생성되지 않으므로 주의해야한다.
	 */
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("안녕하세요.["+threadName+"]입니다.");
			try {
				/*
				 Tread 클래스의 static메소드로 실행의 흐름을 
				 주어진 시간만큼 Block상태로 전환시켜 준다.
				 1000이 1초이므로 아래는 0.01초 만큼 Block해준다.
				 */
				sleep(10);//이탤릭체~.~ sleep()=> static 메소드 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Ex01ThreadStart {

	public static void main(String[] args) {
		
		ShowThread st1 = new ShowThread("쓰레드1st");
		ShowThread st2 = new ShowThread("Thread2nd");
		//쓰레드 객체를 통한 쓰레드 생성(실행)
		st1.start();
		st2.start();
		
		//run()을 통한 호출은 가능하나 쓰레드가 생성되지않는다.
//		st1.run();//쓰레드와 쓰레드가 아닌것:동시 실행여부
//		st2.run();//주석 풀고 run()으로 실행해보면 st1 st2가 번갈아 나오지않고 1이 모두 실행된후 2가나옴

	}

}
