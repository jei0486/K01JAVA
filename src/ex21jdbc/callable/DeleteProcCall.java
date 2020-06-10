package ex21jdbc.callable;

import java.sql.Types;

import ex21jdbc.connect.IConnectimpl;

public class DeleteProcCall extends IConnectimpl{

	public DeleteProcCall() {
		super("kosmo","1234");
	}
	@Override
	public void execute() {
		try {
			csmt = con.prepareCall("{call KosmoMemberDelete(?,?)}");
			
			csmt.setString(1, scanValue("아이디"));
			csmt.registerOutParameter(2, Types.VARCHAR);
			csmt.execute();
			
			System.out.println("삭제 프로시저 실행결과");
			System.out.println(csmt.getString(2));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	public static void main(String[] args) {
		new DeleteProcCall().execute();
	}

}
