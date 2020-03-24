package ex09package;

import java.util.Date;

import ex09package.kosmo.util.CommonUtil;

public class PackageMain {

	public static void main(String[] args) {

		/*
		 하나의 클래스안에서 패키지는 다르나 같은 이름의 클래스를
		 사용해야할때
		 	방법1: 클래스명 앞에 풀패키지 경로를 기술
		 	방법2: 하나의 클래스는 import 하고 다른 하나만 풀 경로를 사용함
		 */
		Date utilDate = new Date();//import후 사용
		System.out.println("utilDate="+utilDate);
		
		java.sql.Date sqlDate = 
				new java.sql.Date(utilDate.getTime());//패키지의 풀경로 사용
		System.out.println("sqlDate="+sqlDate);
		
		
		////////////////////////////////////////////////////////
		
		/*
		 ex09package 하위에 ex09package.kosmo.util 패키지가 생성되지만
		 이두개는 서로 다른 패키지 이다.
		 따라서 isNumber() 메소드를 호출하기 위해서는 해당 패키지를
		 import 해야한다.
		 */
		String strValue = "987654321";
		
		/*
		 static으로 선언되는 메소드는 new를 통한 객체생성없이
		 클래스명만으로 즉시 호출하는것이 가능함
		 */
		boolean isNum = CommonUtil.isNumber(strValue);
		if(isNum==true)
			System.out.println("문자열은 숫자입니다.");
		else
			System.out.println("숫자가 아닙니다.");
		
		System.out.println(
			ex09package.kosmo.util.CommonUtil.isNumber("백20"));
	}

}
