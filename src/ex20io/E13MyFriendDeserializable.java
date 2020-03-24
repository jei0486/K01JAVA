package ex20io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class E13MyFriendDeserializable {

	public static void main(String[] args) {
	try {
		//역직렬화 (복원)을 위한 스트림 생성
		ObjectInputStream in =
		new ObjectInputStream(
				new FileInputStream("src/ex20io/friendinfo.obj"));
		
		while (true) {
			//저장된 파일에서 정보1개 읽어오기
			Friend friend = (Friend)in.readObject();
			//만약 읽어올 정보(객체)가 더이상 없다면 루프탈출
			if(friend==null) break;
			//읽어온 객체를 통해 정보출력
			friend.showAllData();
		}
	}
	catch (Exception e) {
		e.printStackTrace();
	}

	}

}
