package ex06array;
/*
 이 메소드는 배열에 저장된 값을 add 만큼 증가시킨다.
이 메소드를 기반으로 int형 2차원 배열에 저장된 값을 증가시키는 프로그램을 작성하시오. 
단 2차원 배열의 가로, 세로길이에 상관없이 동작해야 하고, 반드시 addOneArr() 메소드를 사용하여 구현해야 한다. 
그리고 증가되기전의 값과 증가되고난후의 값을 모두 출력해야 한다.
구현할 프로그램의 포맷은 다음과 같다. 
 */
public class QuTwoDimArray
{
	//문제에서 제시한 내용
	public static void addOneArr(int[] arr, int add)
	{
		//가로에 대한 반복
		for(int i=0; i<arr.length; i++){	
			arr[i] += add;
		}
	}
	//addOneArr() 메소드를 기반으로 2차원 배열을 증가시키는 메소드
	public static void addTwoArr(int[][] arr, int add)
	{
		/** 코드 삽입 **/
		for(int i=0; i<arr.length; i++){	
			for(int j=0 ; j<arr[i].length ; j++) {
				arr[i][j] += add;
			}
		}
	}
	
	public static void main(String[] args){		
		//배열선언
		int[][] arr = {
			{1, 2, 3, 4},
			{5, 6, 7},
			{8, 9}
		};
		//값 증가전 출력
		arrPrint(arr);		
		//2만큼 증가시키는 메소드 호출
		addTwoArr(arr, 2);
		//증가후 출력
		arrPrint(arr);
	}
	
	//2차원 배열을 출력하기 위한 메소드
	static void arrPrint(int[][] arr) {
		/** 코드 삽입 **/
		for(int[] i : arr) {
			for(int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
	}
}

