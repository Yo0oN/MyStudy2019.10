package com.exam.album01;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.exam.model1.Design_album01DAO;
import com.exam.model1.Design_album01ListTO;
import com.exam.model1.Design_album01TO;
import com.exam.model1.Design_albumMemberTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private String uploadPath="C:\\Users\\kitcoop\\Desktop\\Git\\MyStudy2019.10\\03.spring-workspace\\SpringEx16MVCAlbumBoard\\src\\main\\webapp\\upload";

	@RequestMapping("/list.do")
	public ModelAndView board_list1(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_list1");

		Design_album01DAO dao = new Design_album01DAO();
		Design_album01ListTO listTO = new Design_album01ListTO();

		String cpage = request.getParameter("cpage");

		if (cpage != null) {
			listTO.setCpage(Integer.parseInt(cpage));
		}

		listTO = dao.board_list1(listTO);

		modelAndView.addObject("listTO", listTO);

		return modelAndView;
	}

	@RequestMapping("/view.do")
	public ModelAndView board_view1(Design_album01TO to) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_view1");

		Design_album01DAO dao = new Design_album01DAO();

		ArrayList<Design_album01TO> toLists = dao.board_view1(to.getSeq());

		modelAndView.addObject("toLists", toLists);
		modelAndView.addObject("cpage", to.getCpage());

		return modelAndView;
	}

	@RequestMapping("/reply_ok.do")
	public ModelAndView board_reply_ok(Design_album01TO to) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_reply_ok");

		Design_album01DAO dao = new Design_album01DAO();
		String cpage = to.getCpage();
		String seq = to.getSeq();
		int flag = dao.board_reply_ok(to);

		modelAndView.addObject("flag", flag);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("cpage", cpage);

		return modelAndView;
	}

	@RequestMapping("reply_delete_ok.do")
	public ModelAndView board_reply_delete_ok(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_reply_delete_ok");
		Design_album01TO to = new Design_album01TO();

		String seq = request.getParameter("seq");
		String cpage = request.getParameter("cpage");
		String cseq = request.getParameter("cseq");
		String com_password = request.getParameter(cseq + "password");

		to.setSeq(seq);
		to.setCseq(cseq);
		to.setCpassword(com_password);

		Design_album01DAO dao = new Design_album01DAO();

		int flag = dao.board_reply_delete_ok(to);

		modelAndView.addObject("flag", flag);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("cpage", cpage);

		return modelAndView;
	}

	@RequestMapping("/write.do")
	public ModelAndView board_write1(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_write1");

		Design_albumMemberTO to = new Design_albumMemberTO();
		
		HttpSession session =  request.getSession();
		if (session.getAttribute("id") == null) {
			// 로그인 세션이 없으면 아무일없이 쓰기창을보여준다.
		} else if (session.getAttribute("id") != null) {
			// 로그인세션이 있다면 쓰기창에서 메일, 이름등을 채워준다.
			Design_album01DAO dao = new Design_album01DAO();
			to = dao.board_write1(to);
			to.setId((String)session.getAttribute("id"));
			
			to = dao.board_write1(to);
			
		}
		to.setCpage(request.getParameter("cpage"));
		modelAndView.addObject("to", to);
		
		return modelAndView;
	}

	@RequestMapping("/write_ok.do")
	public ModelAndView board_write1_ok(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("board_write1_ok");

		Design_album01TO to = new Design_album01TO();

		try {
			String path = uploadPath;
			int filesize = 1024 * 1024 * 2;

			MultipartRequest multi = new MultipartRequest(request, path, filesize, "utf-8",
					new DefaultFileRenamePolicy());

			if (multi.getFile("upload") != null) {
				to.setFilename_ori(multi.getOriginalFileName("upload"));
				to.setFilename_ch(multi.getFilesystemName("upload"));
			} else {
				to.setFilename_ch("");
				to.setFilename_ori("");
			}

			to.setSubject(multi.getParameter("subject"));

			to.setWriter(multi.getParameter("writer"));
			to.setPassword(multi.getParameter("password"));
			to.setContent(multi.getParameter("content"));
			if (!multi.getParameter("mail1").equals("") && !multi.getParameter("mail2").equals("")) {
				to.setMail(multi.getParameter("mail1") + "@" + multi.getParameter("mail2"));
			} else {
				to.setMail("");
			}
			to.setWip(request.getRemoteAddr());

			Design_album01DAO dao = new Design_album01DAO();

			int flag = dao.board_write1_ok(to);

			modelAndView.addObject("flag", flag);
		} catch (IOException e) {
		}

		return modelAndView;
	}

	@RequestMapping("/modify.do")
	public ModelAndView board_modify1(Design_album01TO to) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_modify1");

		Design_album01DAO dao = new Design_album01DAO();
		to = dao.board_modify1(to);

		modelAndView.addObject("to", to);
		return modelAndView;
	}

	@RequestMapping("/modify_ok.do")
	public ModelAndView board_modify1_ok(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_modify1_ok");

		Design_album01TO to = new Design_album01TO();

		try {
			String path = uploadPath;
			int filesize = 1024 * 1024 * 2;

			MultipartRequest multi = new MultipartRequest(request, path, filesize, "utf-8",
					new DefaultFileRenamePolicy());

			String cpage = multi.getParameter("cpage");
			String seq = multi.getParameter("seq");

			to.setSeq(seq);
			to.setPassword(multi.getParameter("password"));
			to.setSubject(multi.getParameter("subject"));
			to.setContent(multi.getParameter("content"));

			if (!multi.getParameter("mail1").trim().equals("") && !multi.getParameter("mail2").trim().equals("")) {
				to.setMail(multi.getParameter("mail1") + "@" + multi.getParameter("mail2"));
			} else {
				to.setMail("");
			}

			if (multi.getFile("upload") != null) {
				to.setFilename_ori(multi.getOriginalFileName("upload"));
				to.setFilename_ch(multi.getFilesystemName("upload"));
			} else {
				to.setFilename_ori("");
				to.setFilename_ch("");
			}

			Design_album01DAO dao = new Design_album01DAO();

			int flag = dao.board_modify1_ok(to);

			modelAndView.addObject("flag", flag);
			modelAndView.addObject("cpage", cpage);
			modelAndView.addObject("seq", seq);

		} catch (IOException e) {
		}

		return modelAndView;
	}

	@RequestMapping("/delete.do")
	public ModelAndView board_delete1(Design_album01TO to) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("board_delete1");

		Design_album01DAO dao = new Design_album01DAO();

		to = dao.board_delete1(to);

		modelAndView.addObject("to", to);

		return modelAndView;
	}

	@RequestMapping("/delete_ok.do")
	public ModelAndView board_delete1_ok(Design_album01TO to) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_delete1_ok");

		Design_album01DAO dao = new Design_album01DAO();

		int flag = dao.board_delete1_ok(to);

		modelAndView.addObject("flag", flag);

		return modelAndView;
	}
}
