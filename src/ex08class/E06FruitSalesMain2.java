package ex08class;

//과일 판매자를 추상화한 클래스
class FruitSeller2 {
	
	int numOfApple;//판매자의 사과 보유갯수
	int myMoney;//판매수익
	int apple_price;/*
	사과의 단가-> 일반변수로 변경함
	클래스의 멤버상수로 정의하는 경우 선언과 동시에
	초기화 해야하므로 상수는 초기값이 없는 형태로는  사용불가
	*/
	
	/*
	 apple_price를 상수에서 변수로 변경한 이유는 
	 상수는 단 한번만 초기화되는 특성 때문에 일반적인 멤버 메소드
	 내에서는 초기화할수 없다. 멤버메소드는 개발자가 원할때
	 언제든지 호출할 수 있기 떄문에 상수의 특성과는 맞지않기 때문이다.
	 */
	public void initMembers(int money,int appleNum, int price) {
		apple_price = price;
		numOfApple= appleNum;
		myMoney= money;
		
	}
	
	public int saleApple(int money) {
		int num = money / apple_price;
		numOfApple -= num;
		myMoney += money;
		return num;
	}
	public void showSaleResult() {
		System.out.println("[판매자]남은 사과 갯수:"+numOfApple);
		System.out.println("[판매자]판매수익:"+myMoney);
	}
	
}
//구매자를 표현한 클래스
class FruitBuyer2 {
	
	int myMoney;//보유한 금액
	int numOfApple;//구매한 사과의 갯수
	
	/*
	 초기화 메소드,
	 :멤버변수를 초기화 할때 사용함
	 2차버전에서는 생성자 대신 사용되고 있으며, 객체 초기화시 여러줄에 걸쳐
	 코딩해야하는 번거로움을 간편하게 해결할수 있다.
	 */
	public void initMembers(int _mymoney, int _numOfApple)
	{
		myMoney=_mymoney;
		numOfApple = _numOfApple;
	}
	
	
	
	public void buyApple(FruitSeller2 seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	
	public void showBuyResult() {
		System.out.println("[구매자]현재잔액:"+myMoney);
		System.out.println("[구매자]사과갯수:"+numOfApple);
	}
}

public class E06FruitSalesMain2 {

	public static void main(String[] args) {
		/*
		 초기화 메소드에 의해 서로 다른 초기값을 가진는
		 객체를 생성할수 있게 됐음
		 아래에서는 판매단가와 재고가 서로 다른 2개의 판매자 객체를 생성함.
		 */
		
		//판매자1
		FruitSeller2 seller1 = new FruitSeller2();
		seller1.initMembers(0, 100, 1000);
		
		//판매자2
		FruitSeller2 seller2 = new FruitSeller2();
		seller2.initMembers(0, 85, 500);
		
		FruitBuyer2 buyer = new FruitBuyer2();
		buyer.initMembers(10000,0);
		
		System.out.println("구매행위가 일어나기 전의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
		
		//판매자1,핀매지2 에게 각각 5000원을 지불하고 구매
		buyer.buyApple(seller1, 5000);
		buyer.buyApple(seller2, 5000);
		
		System.out.println("구매행위가 이어난 후의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
	}
}
