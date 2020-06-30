package ex21jdbc.shopping;


import ex21jdbc.connect.IConnectimpl;

//상품조회
public class SelectShop extends IConnectimpl{
	
	public SelectShop() {
		super("kosmo","1234");
	}
	
	@Override
	public void execute() {
		try {
			
			String name = scanValue("상품명");
			stmt = con.createStatement();
			String sql = " SELECT g_idx, goods_name, to_char(regidate, 'yyyy-mm-dd hh24:mi') format1 ,"
					+ " ltrim( to_char(goods_price , '999,999,999')) format2 , p_code FROM sh_goods  "
					+ " WHERE goods_name LIKE '%'|| '" + name + "' ||'%' ";
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String idx = rs.getString("g_idx");
				String p_name = rs.getString("goods_name");
				String price = rs.getString("format2");
				String date = rs.getString("format1");
				String code = rs.getString("p_code");
				
				System.out.printf("일련번호 : %s ,상품명  : %s ,상품가격 : %s ,등록일 : %s ,상품코드 : %s \n",
						idx,p_name,price,date,code);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insert 실패");
		}
		finally {
			close();
		}
	}
	public static void main(String[] args) {
		new SelectShop().execute();
	}
	
}
