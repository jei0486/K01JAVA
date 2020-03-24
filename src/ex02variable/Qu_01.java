package ex02variable;

/*
1.국어, 영어, 수학점수 및 과목의 총점을 저장할수 있는 변수를 선언하시오.
2.국어 89점, 영어 99점, 수학 78점을 대입한다.
3.국영수 총합을 구해서 총점을 저장할 변수에 대입한다.
4.총합점수를 출력한다.
실행결과  	국어점수:XX점, 수학점수:XX점, 영어
점수:XX점
 	3과목의 총점은 : XXX점
 */
public class Qu_01 {

	public static void main(String[] args) {
		
		int kor=89, eng=99, math=78;
		
		//int total;
		//total = kor+eng+math;
		
		int total= kor+eng+math;
		
		System.out.printf("국어점수:%d점, 영어점수:%d점, 수학점수:%d점 %n"	,kor,eng,math);
		System.out.printf("3과목의 총점은 : %-3d점%n" , total);
		
		System.out.println("3과목의 총점은 : " +total+ "점");
		
	}
}
