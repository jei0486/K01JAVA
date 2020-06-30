package ex21jdbc.shopping;

import java.sql.Types;

import ex21jdbc.connect.IConnectimpl;

public class UpdateShop extends IConnectimpl{

	public UpdateShop() {
		super("kosmo","1234");
	}
	
	@Override
	public void execute() {
		
		try {
			csmt = con.prepareCall("{call ShopUpdateGoods(?,?,?,?,?)}");
			csmt.setString(1, scanValue("상품명"));
			csmt.setString(2, scanValue("가격"));
			csmt.setString(3, scanValue("제품코드"));
			csmt.setString(4, scanValue("수정할 상품의 일련번호"));
			csmt.registerOutParameter(5, Types.NUMERIC);
			csmt.execute();
			
			int outParamResult = csmt.getInt(5);
			if(outParamResult==1) {
				System.out.println("수정되었습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	public static void main(String[] args) {
		new UpdateShop().execute(); 
	}

}
