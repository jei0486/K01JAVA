import java.util.Random;
import java.util.Scanner;

public class Qu02 {
	/*정렬알고리즘 - 선택정렬(selection sort)
	 1. 1~100 사이의 중복되지 않는 정수 10개의 난수를 생성한다.
	 2.생성한 난수는 크기 10인 배열에 저장한다.
	 3.위 그림을 참조하여 선택정렬로 오름차순 정렬한다. 
	 4.정렬한 결과를 출력한다. 
	 5.단 정렬되는 과정을 모두 출력해야 한다.
	 */
	public static void main(String[] args) {

		int[] arr = new int[10];

		Random ran = new Random();
		Scanner sc = new Scanner(System.in);

		System.out.print("배열보기 : ");
		
		for(int i=0; i<arr.length;i++) {
			int num = ran.nextInt(100)+1;
			arr[i]=num;
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		
		System.out.println("정렬방식을 선택하세요");
		System.out.println("1.오름차순");
		System.out.println("2.내림차순");
		System.out.print("선택 :");
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("Sort1번 진행 :");
			System.out.println("Sort2번 진행 :");
			System.out.println("Sort3번 진행 :");
			System.out.println("Sort4번 진행 :");
			System.out.println("Sort5번 진행 :");
			System.out.println("Sort6번 진행 :");
			System.out.println("Sort7번 진행 :");
			System.out.println("Sort8번 진행 :");
			System.out.println("Sort9번 진행 :");
			
			break;
		case 2:
			break;

		}
		
		
		
		

	}
}
