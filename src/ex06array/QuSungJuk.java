package ex06array;
/*
 다음 조건에 맞는 프로그램을 작성하시오.
1] 학생수를 사용자로부터 입력받는다.
	-Scanner클래스 사용
2] 입력받은 학생수만큼 국영수 점수를 저장할 수 있는 int형 배열을 선언한다.
3] 다시 학생수만큼 각 학생의 국영수 점수를 입력받아 2]에서 생성한 배열에 저장한다.
	-Scanner클래스 사용
4] 각 학생의 국영수 점수 및 총점 그리고 평균을 출력하여라. 
5] 이 문제는 2차원 배열을 활용하는 문제이다.
 */
import java.util.Scanner;

public class QuSungJuk {
	
	public static int aa(String s) {
		Scanner sc = new Scanner(System.in);
		System.out.print(s + "점수 입력:");
		int num = sc.nextInt();
		return num;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("학생수를 입력하세요:");
		int stuNum = scanner.nextInt();
		System.out.println("학생수:" + stuNum);
		int[][] kem = new int[stuNum][6];
		for(int i=0 ; i<kem.length ; i++) {
			System.out.println("[" + (i+1) + "]번쨰학생");
			kem[i][0] = i+1;
			kem[i][1] = aa("국어");
			kem[i][2] = aa("영어");
			kem[i][3] = aa("수학");
			for(int j=1 ; j<=3 ; j++) {
				kem[i][4] += kem[i][j];
			}
			kem[i][5] = kem[i][4] / 3;
			
			
			
			
//			kem[i][0] = i;
//			System.out.println("[" + (i+1) + "]번쨰 학생의 점수 입력");
//			
//			System.out.print("국어점수 입력:");
//			kem[i][1] = scanner.nextInt();
//			
//			System.out.print("영어점수 입력:");
//			kem[i][2] = scanner.nextInt();
//			
//			System.out.print("수학점수 입력:");
//			kem[i][3] = scanner.nextInt();
//			
//			for(int j=1 ; j<=3 ; j++) {
//				kem[i][4] += kem[i][j];
//			}
//			kem[i][5] = kem[i][4] / 3;
		}
		
		for(int[] i : kem) {
			for(int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

}


