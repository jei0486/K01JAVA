package ex21jdbc.callable;

import java.sql.Types;

import ex21jdbc.connect.IConnectimpl;
/*
 JAVA에서 Oracle 함수 호출하기
 
   1] 오라클애서 정의한 함수를 실행하기 위한 CallableStatement 객체 생성
	-Connection 객체의 PrepareCall() 메소드로 생성한다.
-형식]]
 	prepareCAll("{? = call 함수명 (매개변수1,매개변수2...)}");
 	-첫번째 물음표는 반환값을 의미함
    	반환값은 파라미터 설정시 java.sql.Types 클래스의 자료형으로 설정
    
    2] 아웃파라미터 설정
    -함수는 반환값이 1개 이므로 인덱스는 무조건 1이다.
    3] 매개변수는 인파라미터 즉 setXXX() 계열의 메소드를 이용한다.
    4] 함수실행은 execute() 메소드를 이용한다.
    5] 반환값은 무조건 1개이므로 인덱스는 1이고 ,getXXX()계열의 함수로 읽어온다.  
 */
public class FunctionCall extends IConnectimpl{
	
	//기본생성자를 통한 DB연결
	public FunctionCall() {
		super("kosmo","1234");
	}
	 
	@Override
	public void execute() {
		try {
			//1.callable 객체 생성
			
			/*
			  	? = call 함수명
			  	첫번째 인자 : 함수 실행후 반환값 처리
			  	두번째 인자 : 함수 호출시 전달할 파라미터
			 */
			csmt = con.prepareCall("{? = call fillAsterik(?)}");
			//2.반환값의 자료형 설정
			csmt.registerOutParameter(1, Types.VARCHAR);
			
			//3.in 파라미터 설정
			csmt.setString(2, scanValue("아이디"));
			
			//4.실행
			csmt.execute();
			
			//5.반환값을 콘솔에 출력
			System.out.println("함수의 반환값:"+ csmt.getString(1));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		
	}
	
	public static void main(String[] args) {
		new FunctionCall().execute();
	}

}


