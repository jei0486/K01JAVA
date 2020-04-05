import java.util.Random;
import java.util.Scanner;
public class Qu02 {
	/* 정렬알고리즘 - 선택정렬(selection sort)
	 1. 1~100 사이의 중복되지 않는 정수 10개의 난수를 생성한다.
	 2.생성한 난수는 크기 10인 배열에 저장한다.
	 3.위 그림을 참조하여 선택정렬로 오름차순 정렬한다.
	 4.정렬한 결과를 출력한다. 5.단 정렬되는 과정을 모두 출력해야 한다.*/
	public static void min(int[] arr) {

		int count = 0;
		int index = 0;

		for (int j = 0; j < 9; j++) {
			// 최소값 설정
			int min = 100;
			for (int i = count; i < arr.length; i++) {
				if (arr[i] < min) {
					min = arr[i];
					index = i;
				}
			}
			arr[index] = arr[count];
			arr[count] = min;
			count++;

			System.out.printf("Sort %d번 진행 :", j + 1);

			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}

	public static void max(int[] arr) {

		int count = 0;
		int index = 0;

		for (int j = 0; j < 9; j++) {
			// 최대값 설정
			int max = 0;
			for (int i = count; i < arr.length; i++) {
				if (arr[i] > max) {
					max = arr[i];
					index = i;
				}
			}
			arr[index] = arr[count];
			arr[count] = max;
			count++;

			System.out.printf("Sort %d번 진행 :", j + 1);

			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		Random ran = new Random();
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[10];
		System.out.print("배열보기 : ");

		boolean flag = true;

		for (int i = 0; i < arr.length;) {
			int num = ran.nextInt(100) + 1;

			for (int j = 0; j < arr.length; j++) {
				if (num == arr[j]) {
					flag = false;
					break;
				}
				flag = true;
			}
			if (flag) {
				arr[i] = num;
				i++;
			}

		}
		for (int j = 0; j < arr.length; j++) {

			System.out.print(arr[j] + " ");
		}

		System.out.println();

		System.out.println("정렬방식을 선택하세요");
		System.out.println("1.오름차순");
		System.out.println("2.내림차순");
		System.out.print("선택 :");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			min(arr);
			break;
		case 2:
			max(arr);
			break;

		}
	}
}
