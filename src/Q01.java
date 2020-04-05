import java.util.Random;
import java.util.Scanner;

public class Q01 {
/*정렬알고리즘 - 버블정렬(Bubble Sort) 
1. 중복되지 않는 난수 10개(1~99)를 생성하여 크기가 10인 배열에 담는다.
2.오름차순으로 버블정렬한다.(1, 2, 3 …… 10)
3.버블정렬이란 모든 배열요소를 순차적으로 비교하여 스왑(교환)하는 알고리즘이다.
4.단, 정렬되는 과정을 모두 출력해야 한다.
5.위 그림은 버블정렬을 이용하여 오름차순으로 정렬하는 과정이다.
 */
	public static void bubble(int[] arr) {
		
		int index = 0;

		for (int j = 0; j < arr.length; j++) {
			System.out.print("Sort"+ (j+1) + "번 진행 : ");
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] < arr[i + 1]) {
				} else if (arr[i] > arr[i + 1]) {
					index = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = index;
				}
			}
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]+ " ");
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
			int num = ran.nextInt(11) + 1;

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
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		bubble(arr);
		
	}
}
