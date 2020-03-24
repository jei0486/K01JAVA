package ex21jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteSQL {

	private Connection con;
	private Statement stmt;

	//생성자에서는 드라이버에 대한 로드만 진행한다.
	public DeleteSQL() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	//Oracle DB에 대한 연결을 진행한다.
	public void connect() {
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin://@localhost:1521:orcl",
					"kosmo",
					"1234");
					
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 오류");
			e.printStackTrace();
		}
	}
	
	//DB연결 , 쿼리준비, 쿼리전송, 쿼리 실행을 위한 메소드
	private void execute() {
		
		//여기서 실제 연결을 진행한다.
		connect();
		
		try {
			stmt = con.createStatement();
			/*
			 test1 삭제시 제약 조건위배 예외발생
			 test99와 같이 DB에 입력되지않은 레코드 삭제시에는 예외없이 
			 		삭제되지않음
			 */
			String query = "DELETE FROM member WHERE id = 'test1'";
			//test1을 삭제하려고 하면 예외발생메세지 뜸
			//무결성 제약조건(KOSMO.BBS_MEM_FK)이 위배되었습니다- 자식 레코드가 발견되었습니다
			int affected = stmt.executeUpdate(query);
			
			System.out.println(affected + "행이 삭제됨");
		} catch (SQLException e) {
			System.out.println("쿼리실행 오류");
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	private void close() {
		try {
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
			System.out.println("자원 반납 완료");
		} catch (Exception e) {
			System.out.println("자원 반납시 오류발생");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {

		new DeleteSQL().execute();
		
	}
}
