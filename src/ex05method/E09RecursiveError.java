package ex05method;

public class E09RecursiveError {

	public static void main(String[] args) {
		showHi(3);

	}
	
	
	/*
	오류코드
	1. 감소연산자로 인해 의 값은 차감되지만..
	2. 조건식의 위치가 잘못되었다.
	3. 재귀호출을 하기전 종료체크를 할수있도록 수정해야한다.
	
	StackOverflow(스택오버플로우)
	: 스택은 함수가 종료되기 전까지의 모든정보를 저장하는 메모리로
	유한한 공간이므로 무한루프에 빠지게 되면 저장능력을 초과하여
	해당에러가 발생하게 된다.
	 */
	public static void showHi(int cnt) {
		System.out.println("Hi~!");
		System.out.println("cnt="+cnt);
		
		//재귀호출번 종료체크를 하므로 정상 종료된다.
		//showHi(--cnt);
		if(cnt==1) {
			return;
		
		}
		showHi(--cnt);
		
		/*public static void showHi(int cnt) {
			System.out.println("Hi~!");
			System.out.println("cnt="+cnt);
			
			showHi(--cnt);
			//함수 종료를 체크하는 부분의 위치가 잘못되어 에러발생됨.
			if(cnt==1) {
				return;
			
			}
			*/
	}	
}

	
