package ex21jdbc.callable;

import java.sql.Types;

import ex21jdbc.connect.IConnectimpl;

public class IsMemberProcCall extends IConnectimpl{

	public IsMemberProcCall() {
		super("kosmo","1234");
	}
	
	@Override
	public void execute() {
		
		try {
			csmt = con.prepareCall("{call KosmoMemberAuth(?,?,?)}");
			csmt.setString(1, scanValue("회원 아이디"));
			csmt.setString(2, scanValue("회원 비밀번호"));
			csmt.registerOutParameter(3, Types.NUMERIC);
			csmt.execute();
			
			int outParamResult = csmt.getInt(3);
			switch (outParamResult) {
			case 0:
				System.out.println("회원아이디가 없어요");
				break;
			case 1:
				System.out.println("패스워드가 일치하지 않습니다.");
				break;
			case 2:
				System.out.println("회원님 반갑습니다.");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	public static void main(String[] args) {
		IsMemberProcCall mapc = new IsMemberProcCall();
		mapc.execute();
	}

}
