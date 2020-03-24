package ex10accessmodifier;
class Rectangle{
	//멤버변수
   	private int ulx, uly;//좌상단(upper left x, upper left y)
   	private int lrx, lry;//우하단(lower right x, lower right y)
   	
   	//좌표값이 정상인지 판단하기  위한 멤버변수 추가
   	private boolean isTrue = true;
   	
   	//기본생성자
   	public Rectangle() {
   		
	}
   	
   	//인자생성자
   	public Rectangle(int ulx, int uly, int lrx, int lry) {
   		/* 
		좌표값이 정상범위안에 있는지 판단하여 초기화한다.
		*/
   		if(isRange(ulx)==false||isRange(uly)==false) {
   			System.out.println("좌상단 좌표범위가 잘못되었습니다");
   			isTrue = false;
   		}
   		if(isRange(lrx)==false||isRange(lry)==false) {
   			System.out.println("우하단 좌표범위가 잘못되었습니다");
   			isTrue = false;
   		}
   		
   		//좌측좌표와 우측좌표가 뒤바뀐 경우 오류로 처리
   		if(ulx>=lrx || uly>=lry) {
   			System.out.println("좌/우측 좌표지정이 잘못되었습니다.");
   			isTrue = false;
   		}
   		
   		//멤버변수 초기화
   		this.ulx = ulx;
   		this.uly = uly;
   		this.lrx = lrx;
   		this.lry = lry;
   	}   	   
   	//인자로 전달된 좌표값이 정상범위 안에 있는지 판단
   	public boolean isRange(int point) {
   		if(point<0 || point>100)
   			return false;//0과 100의 범위를 벗어나면 좌표오류
   		else
   			return true;
   	}
   	public void showArea(){
   		/* 사각형의 넓이를 구하는 메소드 정의 */
   		if(isTrue==false) {
   			System.out.println("좌표값 오류로 넓이 계산이 불가합니다.");
   			return;
   		}
   		//좌표값을 구하여 넓이 계산
   		int xLength = lrx - ulx;
   		int Llength = lry - uly;
   		System.out.println("사각형의 넓이:"+(xLength*Llength));
   	}  	
}


public class QuRectangle {
	public static void main(String[] args){
		//여기부터
//     		Rectangle rec = new Rectangle();
//     		rec.ulx=22;
//     		rec.uly=22;
//     		rec.lrx=10;
//     		rec.lry=10;
		//여기까지는 정보은닉후 실행되지 않게 해야한다....

		//아래 생성자로만 객체생성후 초기화 되도록 처리한다...
		Rectangle rec1 = new Rectangle(1,1,10,10);
		rec1.showArea();
		
		Rectangle rec2 = new Rectangle(-2,-2,101,101);
		rec2.showArea();
		
		Rectangle rec3 = new Rectangle(10,10,1,1);
		rec3.showArea();
   	}

}
