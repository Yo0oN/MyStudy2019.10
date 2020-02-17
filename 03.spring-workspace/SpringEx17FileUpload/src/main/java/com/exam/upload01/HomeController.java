package com.exam.upload01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	// 의존성 자동 주입 : 생성자주입
	@Autowired
	FileRenamePolicy fileRenamePolicy;

	@RequestMapping("/write.do")
	public ModelAndView write() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("write");

		return modelAndView;
	}

	@RequestMapping("/write_ok.do")
	public ModelAndView write_ok(@RequestParam("upload") MultipartFile multipartFile) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("write_ok");

		String uploadPath = "C:\\Users\\kitcoop\\Desktop\\Git\\MyStudy2019.10\\03.spring-workspace\\SpringEx17FileUpload\\src\\main\\webapp\\upload";

		// FileRenamePolicy fileRenamePolicy = new FileRenamePolicy();
		// 파일 이름을 변경시켜준다.
		String newFileName = fileRenamePolicy.renameFile(multipartFile.getOriginalFilename());

		// 실제 파일 이름
		System.out.println("파일 이름 : " + multipartFile.getOriginalFilename());
		// 업로드 해준 폼의 input type=file의 이름
		System.out.println("파일 이름 : " + multipartFile.getName());

		// MultipartFile은 MultipartRequest와는 다르게 파일을 읽음과 동시에 쓰기를 하지 않고,
		// 객체 자체에 파일을 그냥 담아둔다. 그렇기 때문에 파일을 따로 출력(저장)을 해주어야한다.
		FileOutputStream fos = null;

		try {
			// 업로드할 위치와 파일 이름 정해주기
			fos = new FileOutputStream(uploadPath + "/" + newFileName);
			// 파일 크기
			byte fileData[] = multipartFile.getBytes();

			fos.write(fileData);
		} catch (FileNotFoundException e) {
			System.out.println("error : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("error : " + e.getMessage());
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
				}
			}
		}
		return modelAndView;
	}
}
