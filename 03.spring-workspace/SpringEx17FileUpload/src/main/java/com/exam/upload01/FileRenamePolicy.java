package com.exam.upload01;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class FileRenamePolicy {
	public String renameFile(String filename) {
		// 파일명.확장자 를 파일명_타임스탬프.확장자 로 만들어주는 메소드.
		/*
		 * 아래의 방법말고도 String[] arrFileName = fileName.split("\\.");
		 * arrFileName[arrFileName.length-2] = arrFileName[arrFileName.length - 2] + "_"
		 * + Claendar.getInstance().getTimeMillis(); fileName = String .join(".",
		 * arrFileName) 으로 만들어주어도 된다.
		 */

		int dot = filename.lastIndexOf(".");

		StringBuffer sbFilename = new StringBuffer();

		sbFilename.append(filename);

		// 타임스탬프는 Claendar.getInstance().getTimeInMillis() 를 이용해도 된다.
		sbFilename.insert(dot, "_" + new Date().getTime());

		System.out.println(sbFilename.toString());
		return sbFilename.toString();
	}
}
