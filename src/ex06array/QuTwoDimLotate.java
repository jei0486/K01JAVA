package ex06array;
/*
 다음의 형태로 표현된 2차원 배열이 있다. 
이렇게 전달되면 다음의 형태로 구조를 변경하는 메소드를 정의해보자.
즉 메소드를 호출하면 1행은 2행으로, 2행은 3행으로 마지막행은 1행으로 이동하게된다.
단 세로길이에 상관없이 동작하도록 메소드를 정의해야 한다.
 */
public class QuTwoDimLotate {
	
	public static void arr(int[][] arr){
		int[][] arr2 = new int[arr.length][arr[0].length];
		for(int i=0 ; i<arr[0].length ; i++) {
			arr2[0][i] = arr[arr.length-1][i];
		}
		
		System.out.println("======");
		
		for(int i=0 ; i<arr.length-1 ; i++) {
			for(int j=0 ; j<arr[0].length ; j++	) {
				arr2[i+1][j] = arr[i][j];
			}
				
		}
		for(int i=0 ; i<arr.length ; i++) {
			for(int j=0 ; j<arr[0].length ; j++) {
				arr[i][j] = arr2[i][j];
			}
		}
		
	}
	
	static void arrPrint(int[][] arr) {
		/** 코드 삽입 **/
		for(int[] i : arr) {
			for(int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		int[][] arr = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		arrPrint(arr);
		arr(arr);
		arrPrint(arr);

	}

}

