package ex06array;

import java.util.Scanner;

/*
홀수/짝수 구분하여 배열채우기
길이가 10인 배열을 선언한후 총 10개의 정수를 입력받아 순서대로 저장한다. (첫번째배열)
그리고 순서대로 저장된 숫자들을 홀수는 배열의 앞에서 부터 채워나가고 짝수는 배열의 끝에서부터 
채워나간다.(두번째배열)
출력예시) 총 10개의 정수를 입력하시오.
1 2 3 4 5 6 7 8 9 10
순서대로입력된결과: 1 2 3 4 5 6 7 8 9 10
홀수/짝수 구분입력결과 : 1 3 5 7 9 10 8 6 4 2
 */
public class QuFillArray {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int[] arr1 = new int[10];//입력받은 정수를 순서대로 입력
		int[] arr2 = new int[10];//홀수,짝수 구분해서 입력
		
		int indexStart = 0;//arr2배열의 첫번째 인덱스 지정
		int indexEnd = arr1.length - 1;//arr2배열의 마지막 인덱스 지정
		
		for(int i=0; i<arr1.length;i++) {
			
			System.out.print("숫자를 입력:");
			int inputNum = scanner.nextInt();
			
			//첫번째 배열에는 입력한 순서대로 채운다.
			arr1[i] = inputNum;
			
			//홀수/짝수를 구분하여 홀수이면 앞에서부터, 짝수면 뒤에서부터 배열을 채움
			if(inputNum%2==1) {
				//홀수이면 앞에서부터 채우고, 인덱스 +1 증가
				arr2[indexStart++] = inputNum;
			}
			else {
				//짝수이면 뒤에서부터 채우고, 인덱스 -1 감소
				arr2[indexEnd--] = inputNum;
			}
		}
		
		System.out.println("arr1배열출력");
		for(int i=0; i<arr1.length;i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		System.out.println("arr2배열출력");
		for(int i=0; i<arr2.length;i++) {
			System.out.print(arr2[i]+" ");
		}
		
		
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.print("10개의 정수를 입력하시오.");
//		int[] su =  new int[] {scanner.nextInt()};
//		
//		int[] arr = new int[10];
//		
//		for(int j=0; j<arr.length; j++) {
//			if(su[j]%2==0) {
//				for(j=10; j>arr.length; j--) {
//					arr[j] = su[j];
//				}
//			}
//			else {
//				arr[j] = su[j];
//			}
//			System.out.print("홀수/짝수 구분입력결과:"+arr[j]);
//		}
//		System.out.println();
//		System.out.print("순서대로 입력한결과:"+su);
	}
}
