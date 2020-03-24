package ex02variable;

/*
국어,영어,수학 점수를 99, 80, 96점으로 입력하고 
평균점수를 구해서 출력하는 프로그램을 작성하시오.
출력결과]
	99점,80점,96점의 평균점수는 XXX.XX점입니다.(실수형태)
	99점,80점,96점의 평균점수는 XXX점입니다.(정수형태)
 */
public class Qu_02 {

	public static void main(String[] args) {
		
				int kor=99, eng=80, math=96;
				
				//double avg = (double)(kor+eng+math)/3;
				double avg= (kor+eng+math) / 3.0;/*3이 아니라 3.0으로 나누는 이유는 정수랑 정수를 연산하면 
													정수값이 나오므로 실수를 구하기 위해서는 총합이 정수이므로 
													3.0으로 실수로 나눠줘야한다. 아니면 계산후 형변환
													Ex)double avg= (double)(kor+eng+math) / 3;
												*/
				
				System.out.printf("99점,80점,96점의 평균점수는 %-3.2f점 입니다. %n"	,avg);
				System.out.printf("99점,80점,96점의 평균점수는 %d점 입니다.%n"	, (int)avg);
				//System.out.printf("99점,80점,96점의 평균점수는 %3.0f점 입니다.%n"	, avg);
				//정수를 표현하는 프린트문은 %f가 아니라 %d이므로 정수를 구하는 프린트문으로는 옳지 않다.
				//제대로 정수값을 구하려면 %d와 (int)avg로 변경하여 구해야 된다.
				
				System.out.println("99점,80점,96점의 평균점수는 "+(int)avg+"점 입니다.");
	}

}
