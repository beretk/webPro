package com.lec.ex1_InputStreamOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PersonalTest {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		InputStream is = null;
		OutputStream os = null;
		File file = new File("C:/webPro/lecNote/01_Java/bts_7.mp4");
		try {
			is = new FileInputStream(file);
			os = new FileOutputStream("C:/webPro/lecNote/01_Java/bts_copy.mp4");
			int cnt = 0;
			byte[] bs = new byte[(int)file.length()];
			while(true) {
				int readByteCount = is.read(bs);
				if(readByteCount ==-1) break;
				os.write(bs,0,readByteCount);
				cnt++;
			}
			System.out.println(cnt + "번 while을 실행하여 복사 성공");
//		} catch (FileNotFoundException e) {
//			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		
		}
		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000.0 + "초 걸림");
		
	}
}
