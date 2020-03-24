package ex19thread;

/*쓰레드로 구현하지 않은 클래스*/
/*
	: 하나의 클래스가 작업을 끝내야 다음 클래스의
	작업을 진행할수 있다. 즉 동시에 작업을 진행할 수 없다.
 */
class NotThread{
	
	String title;
	public NotThread(String title) {
		this.title = title;
	}
	void notThreadMethod() {
		for (int i = 1; i < 10; i++) {
			System.out.println(
					String.format("%s]i=%d", title,i));
		}
	}
}
/*
 독립쓰레드(Non Daemon Thread)
 	: 메인쓰레드와 working쓰레드 (개발자가 정의한 쓰레드)를
 	일컫는 것으로 메인 쓰레드가 종료되어도 계속 실행되며,
 	Dead상태가 되어야 실행이 종료되는 쓰레드를 말한다.
 	해당 쓰레드를 실행하게되면 main메소드가 종료된 이후에도 실행되는것을 볼수있다.
 */
class YesThread extends Thread{
	
	public YesThread() {}
	/*
	Tread클래스의 생성자를 호출할때 전달하는 매개변수를 통해
	해당 쓰레드의 이름을 지정할 수 있다.
	지정된 이름은 getName()메소드를 통해 반환할 수 있다.
	 */
	public YesThread(String threadName) {
		super(threadName);//쓰레드 이름 지정 첫번째방법
	}
	
	void threadMethod() throws InterruptedException{//try~catch문으로 직접처리 가능(동일기능)
		//호출했던 지점에서 예외처리
		for (int i = 1; i < 10; i++) {
			System.out.println(
					String.format("%s]i=%d", getName(),i));
			sleep(2000);//2초에 한번씩 Block상태가 된다.
		}
	}
	@Override
	public void run() {
		try {
			threadMethod();
		} catch (InterruptedException e) {}
	}
}

/*
 종속쓰레드(DaemonThread)
 : 모든 독립 쓰레드(main쓰레드 포함)가 종료되면 자동으로 종료되는 쓰레드를 말한다.
 주로 프로그램의 보조역할로 배경음악,로그자동저장 등의 업무를 처리한다.
 프로그램이 종료될때 자동으로 종료되므로 주로 무한루프로 구성한다.
 setDemmon(true) 메소드로 설정할 수 있다.
 */
//지금 프로그램에서는 독립쓰레드 2개 
class DaemonThread extends Thread{
	
	@Override
	public void run() {
		while (true) {//true로 무한루프 처리
			System.out.println(String.format("[쓰레드명:%s]Jazz가 흘러요~",
					getName() ));
			try {
				sleep(3000);
				System.out.println("3초마다 자동저장");
			} catch (InterruptedException e) {
				System.out.println("자동저장시 오류발생");
			}
		}
		
	}
}
public class Ex03DaemonThread {

	public static void main(String[] args) {
		
		/*
		 쓰레드로 구현하지 않은 클래스의 작업
		 */
		NotThread nt1 = new NotThread("첫번째 클래스");
		nt1.notThreadMethod();
		
		NotThread nt2 = new NotThread("두번째 클래스");
		nt2.notThreadMethod();
		
		/*
		 독립쓰레드 (Non DaemonThread) 실행
		 */
		YesThread yt1 = new YesThread("1st 쓰레드");
		yt1.setName("첫번째 쓰레드");//쓰레드의 이름을 지정하는 두번째 방법
		yt1.start();//쓰레드 객체를 Runnable 상태로 만들어줌
		
		//yt2는 사용자가 이름지정을 하지않은 쓰레드임
		// Thread-0]i : JVM이 자동으로 지정한 이름
		YesThread yt2 = new YesThread();/*
						쓰레드 생성시 이름을 지정하지 않으면 JVM이
						자동으로 이름을 부여한다.
		*/
		yt2.setPriority(Thread.MAX_PRIORITY);
		yt2.start();
		
		/*
		 데몬쓰레드 (DaemonThread)실행
		 */
		DaemonThread dt = new DaemonThread();
		dt.setName("난 데몬쓰레드");
		dt.setDaemon(true);//독립쓰레드를 데몬쓰레드로 만들어줌
		dt.start();
		
		System.out.println("현재활성화된 상태의 쓰레드수"+
				Thread.activeCount());
		System.out.println("현재 실행중인 쓰레드수"+
				Thread.currentThread().getName());
		System.out.println("메인함수의 우선순위"+
				Thread.currentThread().getPriority());

		System.out.println("메인함수 (Main Thread)종료");

	}

}
