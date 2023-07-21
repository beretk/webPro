package com.lec.ex4_object;
// 생일(MM-dd)검색
<<<<<<< HEAD
import java.util.Date;
import java.text.SimpleDateFormat;
=======
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.BitSet;
>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ex04_FriendMain {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("홍길동","010-9999-9999","서울 서대문구",
							new Date(new GregorianCalendar(1998,11,12).getTimeInMillis())),
				new Friend("신길동","010-8888-9999","안양 만안구",
						new Date(new GregorianCalendar(1996,6,22).getTimeInMillis())),
				new Friend("김길동","010-8888-7777","인천 중구",
						new Date(new GregorianCalendar(1996,6,2).getTimeInMillis())),
				new Friend("박성광","010-8888-6666","서울 용산구",
						new Date(new GregorianCalendar(1996,7,22).getTimeInMillis())),
				new Friend("윤동주","010-8888-5555","함북 청진시",
						new Date(new GregorianCalendar(1996,6,2).getTimeInMillis())) };
		Scanner scanner = new Scanner(System.in);
		//검색할 생일 입력(07-22) => 배열 검색(0번째 인덱스부터 생일중에 MM-dd만 추출한 정보를 비교후 같으면 출력)
		while(true) {
<<<<<<< HEAD
			// 못 찾았다를 초기화
			boolean searchOk = false;
=======
			boolean searchOk = false; // 못 찾았다를 초기화
>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470
			System.out.print("검색할 생일을 MM-dd로 입력 (단, 종료를 원하시면 x를 입력하시오) : ");
			String searchWord = scanner.next(); //07-22
			if(searchWord.equalsIgnoreCase("x")) break;
			for(Friend friend : friends	) {
				Date birth = (Date) friend.getBirthday();
				SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
				String birthStr = sdf.format(birth);//
				if( searchWord.equals(birthStr)) {
					System.out.println(friend);
					searchOk = true;
				}//if
			}//for ; 제어문 참조하기
			if(!searchOk) { //해당 생일의 친구를 못 찾음
				System.out.println("해당 생일의 친구는 없습니다");
			}//if
		} 
	}
<<<<<<< HEAD
 
}
=======
} 

>>>>>>> 0b47f9e84250083b42de6f891cc87299b01e7470







