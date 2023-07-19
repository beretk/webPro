package com.lec.quiz;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;
public class MemberTestMain_OutputStream {
	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<Member>();
		Scanner scanner = new Scanner(System.in);
		String name, tel, birthStr, address; // 사용자에게 받을 정보들
		Date birthday;
		while(true){
			System.out.print("회원가입하실래요 (Y/N) ?");
			if(scanner.next().equalsIgnoreCase("n")) break;
			System.out.print("이름 ?");
			name = scanner.next();
			System.out.print("전화 ?");
			tel = scanner.next();
			System.out.print("생일(yyyy-mm-dd) ?");
			birthStr = scanner.next(); // "1998-07-19-10-30"/"1998-07-19"/"1998"/빈스트링/19980719
			//birthday = toDate(birthStr);
			birthday = toDateTodayIsBirthDayChk(name, birthStr);
			System.out.print("주소 ?");
			scanner.nextLine(); // 버퍼 지우는 용도
			address = scanner.nextLine();
			members.add(new Member(name, tel, birthday, address));
		}
		// members의 내용을 콘솔출력 & 파일출력(OutputStream)
		OutputStream os = null;
		try {
			os = new FileOutputStream("src/com/lec/quiz/member.txt");
			for(Member member : members) {
				System.out.println(member);
				os.write(member.toString().getBytes());
			}
			String msg = "                      . . . . . 이하 "+members.size()+"명 가입";
			System.out.println(msg);
			os.write(msg.getBytes());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}//main
	private static Date toDate(String birthStr) { 
		// 매개변수로 들어온 "1995-01-01"을 Date형으로 변환하여 return
		Date result = null;
		StringTokenizer tokenizer = new StringTokenizer(birthStr, "-");
		if(tokenizer.countTokens() == 3) { 
			// 생년월일을 제대로 입력(토큰의 갯수가 3)
			int year  = Integer.parseInt(tokenizer.nextToken());
			int month = Integer.parseInt(tokenizer.nextToken()) - 1;
			int day   = Integer.parseInt(tokenizer.nextToken());
			//result = new Date(year-1900, month, day);
			result = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
		}else {
			System.out.println("생년월일 정보가 올바르지 않아 입력되지 않았습니다");
		}
		return result;
	} // toDate()함수
	private static Date toDateTodayIsBirthDayChk(String name, String birthStr) {//"1999-01-01"
		// 매개변수로 들어온 "1995-01-01"을 Date형으로 변환하고, 오늘이 생일인지 확인 후 return
		Date result = null;
		StringTokenizer tokenizer = new StringTokenizer(birthStr, "-");
		if(tokenizer.countTokens() == 3) { 
			// 생년월일을 제대로 입력(토큰의 갯수가 3)
			int year  = Integer.parseInt(tokenizer.nextToken());
			int month = Integer.parseInt(tokenizer.nextToken()) - 1;
			int day   = Integer.parseInt(tokenizer.nextToken());
			//result = new Date(year-1900, month, day);
			result = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
			// 생일 확인
			Date today = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
			String todayStr = sdf.format(today); // "07-19"
			String resultStr = sdf.format(result); // "01-01" 아래나 위방법 둘 중 하나
			resultStr = birthStr.substring(birthStr.indexOf("-") + 1);
			if(todayStr.equals(resultStr)) {
				System.out.println(name + "님 오늘이 생일이시군요 . 축하드려요 ★★★★★★");
			}
		}else {
			System.out.println("생년월일 정보가 올바르지 않아 입력되지 않았습니다");
		}
		return result;
	} // toDateTodayIsBirthDayChk()함수
}