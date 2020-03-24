package ex10accessmodifier;
/*
 DAO(Data Access Object)
 	:데이터베이스의 data접근을 위한 객체
 	주로 DB접근을 하기위한 로직과 비즈니스로직을 분리하기위해
 	사용함. MVC패턴에서는 M(Mode1)에 해당한다.
 	
 	해당예제에서는 DB접속을 위한 목적은 아니고 DTO클래스에
 	저장된 데이터를 가공/처리 하는 로직을 구현하기 위한
 	목적으로 제작되었다.
 */
public class AccountDAO {

	private AccountDTO capsule = new AccountDTO();
	
	public void init(String name, String accNumber, int balance) {
		
		capsule.setName(name);
		capsule.setAccountNumber(accNumber);
		capsule.setBalance(balance);
	}
	
	public void deposit(int money) {
		capsule.setBalance(capsule.getBalance() +money);
		System.out.println(money +"원이 입금되었습니다.");
		printAccount();
		
	}
	public void withdraw(int money) {
		if(capsule.getBalance()< money) {
			System.out.println("잔액 부족합니다.");
			return;
		}
		capsule.setBalance(capsule.getBalance()-money);
		System.out.println(money+"원이 출금되었습니다.");
		printAccount();
	}
	public void printAccount() {
		System.out.printf("[%s님의 계좌정보]\n",capsule.getName());
		System.out.printf("계좌번호:%s\n",capsule.getAccountNumber());
		System.out.printf("[%s님의 계좌정보]\n",capsule.getBalance());
	}
}
