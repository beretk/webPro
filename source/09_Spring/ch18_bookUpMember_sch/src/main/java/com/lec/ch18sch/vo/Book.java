package com.lec.ch18sch.vo;
import java.sql.Date;
import lombok.Data;
@Data
public class Book {
	private int bnum;       // 책번호
	private String btitle;  // 책이름
	private String bwriter; // 책저자
	private Date brdate;    // 출판
	private String bimg1;   // 책이미지1(첨부안하면 noimg.jpg로 DB에 저장할 예정)
	private String bimg2;   // 책이미지2(첨부안하면 noimg.jpg로 DB에 저장할 예정)
	private String binfo;   // 책소개
	// top-N구문에서 필요한 필드
	private int startRow;   
	private int endRow;
	// 검색을 위한 필드
	private String schItem; // 검색하려고 선택되 항목(책이름으로 검색할 경우 schItem은 btitle, 저자일 경우 bwriter, 책이름+저자일 경우 all, null이거나 빈스트링)
	private String schWord; // 검색할 단어
}
