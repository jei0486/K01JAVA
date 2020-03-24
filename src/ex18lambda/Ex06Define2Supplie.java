package ex18lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Ex06Define2Supplie {
	
	public static List<Integer> makeRandomNum(Supplier<Integer> s,int cnt){
		
		List<Integer> li = new ArrayList<Integer>();
		//cnt의 크기만큼 반복하면서 난수를 생성후 List에 저장
		for (int i = 0; i < cnt; i++) {
			li.add(s.get());
		}
		return li;
	}

	public static void main(String[] args) {
		
		/*
		 Interface Supplier<T>{
		 		Object get();
		 }
		 */
		//get()메소드를 오버라이딩한 람다식. 난수를 생성해서 반환함.
		Supplier<Integer> sup = ()-> {
			Random random = new Random();
			return random.nextInt(100);
		};
		int rNum = sup.get();/*get()메소드가 반환하는 Integer 객체를 
								Auto Unboxing해서  int형 변수를 저장함
		*/
		System.out.println("생성된 난수="+rNum);
		
		//10개의 난수를 생성해서 List로 반환받음
		List<Integer> list = makeRandomNum(sup, 10);
		System.out.println("### print문으로 출력1");
		System.out.println(list);

		System.out.println("### for each문으로 출력2");
		for (Integer i : list) {
			System.out.printf("%d " , i);
		}
		System.out.println();

		System.out.println("### 이터레이터로 출력3");
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " "); 
		}
	}
}
