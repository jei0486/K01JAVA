package ex21jdbc.shopping;

import ex21jdbc.connect.IConnectimpl;

public class InsertShop extends IConnectimpl{
	
	public InsertShop() {
		super("kosmo","1234");
	}
	//prepareStatement 객체 사용
	@Override
	public void execute() {
		
		try {
			//쿼리 작성
			String query = "INSERT INTO sh_goods VALUES (goods_seq.nextval , ? , ?, sysdate ,?)";
			
			//prepare 객체 생성
			psmt = con.prepareStatement(query);
			
			//인파라미터 설정
			psmt.setString(1, scanValue("상품명:"));
			psmt.setString(2, scanValue("상품가격:"));
			
			// ORA-02291: 무결성 제약조건(KOSMO.SYS_C0012313)이 위배되었습니다- 부모 키가 없습니다 
			//상품코드는 sh_product_code 테이블을 참조 하고 있으므로 부모키에 입력되지않은 상품코드를 입력할 경우 에러가 발생한다.
			psmt.setString(3, scanValue("상품코드:"));
			
			//쿼리 실행
			int affected = psmt.executeUpdate();
			//결과확인
			System.out.println(affected + "행이 입력되었습니다.");
		} catch (Exception e) {
			System.out.println("insert중 에러발생");
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	public static void main(String[] args) {
		
		new InsertShop().execute();
	}
}
