package ex21jdbc.shopping;

import java.sql.Types;

import ex21jdbc.connect.IConnectimpl;

public class DeleteShop extends IConnectimpl{

	public DeleteShop() {
		super("kosmo","1234");
	}
	
	@Override
	public void execute() {
		
		try {
			csmt = con.prepareCall("{call ShopDeleteGoods(?,?)}");
			csmt.setString(1, scanValue("삭제할 상품의 일련번호"));
			csmt.registerOutParameter(2, Types.NUMERIC);
			csmt.execute();
			int outParamResult = csmt.getInt(2);
			if(outParamResult==1) {
				System.out.println("삭제되었습니다.");
			}
			else {
				System.out.println("삭제할 제품의 일련번호가 없어용");
			}
			
		} catch (Exception e) {
			System.out.println("삭제중 예외발생");
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	public static void main(String[] args) {
		new DeleteShop().execute();
	}

}
