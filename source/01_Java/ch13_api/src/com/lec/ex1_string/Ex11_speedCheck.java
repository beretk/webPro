package com.lec.ex1_string;

import javax.sound.midi.SysexMessage;

//
public class Ex11_speedCheck {
	public static void main(String[] args) {
		// System.currentTimeMillis() : 1970.1.1 0시부터 현재까지의 밀리세컨
				long start = System.currentTimeMillis();
				String str = "a";
				for(int i=0 ; i<100000 ; i++) {
					str += "a";
				}
				long end = System.currentTimeMillis();
				System.out.println("스트링 10만번 변경 시간 : " + (end-start));
				
				start = System.currentTimeMillis(); // 시작시점
				StringBuffer strBuf = new StringBuffer("a");
				for(int i=0 ; i<100000 ; i++) {
					strBuf.append("a");
				}
				end = System.currentTimeMillis(); // 끝나는 시점
				System.out.println("스트링버퍼 10만번 변경 시간 : " + (end-start));
				
				start = System.currentTimeMillis(); // 시작시점
				StringBuilder strbuil = new StringBuilder("a");
				for(int i=0 ; i<100000 ; i++) {
					strbuil.append("a");
				}
				end = System.currentTimeMillis(); // 끝나는 시점
				System.out.println("스트링빌더 10만번 변경 시간 : " + (end-start));
			}
		}