package ex21jdbc.statement;

import java.sql.SQLException;

public class UpdateSQL extends ConnectDB{

	public UpdateSQL(String user, String pass) {
		super(user,pass);
	}
	@Override
	void execute() {
		try {
			stmt = con.createStatement();
			
			String sql = "UPDATE member "
					+" SET "
					+"	pass='7888' , "
					+"  name='진스리',	"
					+"  regidate=sysdate    "
					+"WHERE id='test4'  ";
			
			System.out.println("sql="+sql);
			
			int afected = stmt.executeUpdate(sql);
			System.out.println(afected+"행이 업데이트 됨");
			
		} catch (SQLException e) {
			System.out.println("쿼리오류");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("알수 없는 예외발생");
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	public static void main(String[] args) {
		new UpdateSQL("kosmo", "1234").execute();
	}
}
